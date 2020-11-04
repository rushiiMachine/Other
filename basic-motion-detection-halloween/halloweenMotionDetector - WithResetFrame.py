# USAGE
# python motion_detector.py
# python motion_detector.py --video videos/example_01.mp4

from imutils.video import VideoStream
import argparse
from datetime import datetime
from datetime import timedelta
import time as t
import cv2
import imutils
import RPi.GPIO as GPIO
import threading

RelayPin = 11
RelayPin2 = 12
secsWithoutSmoke = 301
secsWithSmoke = 0
timeForRelay = datetime.now() - timedelta(minutes=1)
firstTime = datetime.now()

GPIO.setmode(GPIO.BOARD)
GPIO.setwarnings(False)
GPIO.setup(RelayPin, GPIO.OUT)
GPIO.output(RelayPin, GPIO.LOW)
GPIO.setup(RelayPin2,GPIO.OUT)
GPIO.output(RelayPin2,GPIO.LOW)

# Construct the argument parser and parse the arguments
ap = argparse.ArgumentParser()
ap.add_argument("-a", "--min-area", type=int, default=500, help="minimum area size")
args = vars(ap.parse_args())

# Start video stream from webcam
vs = VideoStream(src=0).start()
t.sleep(2)
firstFrame = None

# Cleanup GPIO
def destroy():
	GPIO.output(RelayPin, GPIO.LOW)
	GPIO.cleanup()

# Relay toggling
# class relayThread(threading.Thread):
# 	def __init__(self, threadID, name, state):
# 		threading.Thread.__init__(self)
# 		self.threadID = threadID
# 		self.name = name
# 		self.state = state
# 	def run(self):
# 		toggle(self.state)
def toggle(state):
	if state == 1:
		GPIO.output(RelayPin2,GPIO.HIGH)
		t.sleep(1)
		GPIO.output(RelayPin2,GPIO.LOW)
	if state == 0:
		GPIO.output(RelayPin,GPIO.HIGH)
		t.sleep(1)
		GPIO.output(RelayPin,GPIO.LOW)
# def on():
# 	threadOn = relayThread(1, "RelayToggle-On", 1)
# 	threadOn.start()
# 	print('on')
# def off():
# 	threadOn = relayThread(2, "RelayToggle-Off", 0)
# 	threadOn.start()
# 	print('off')
class relayThread2(threading.Thread):
	def __init__(self, threadID, name):
		threading.Thread.__init__(self)
		self.threadID = threadID
		self.name = name
	def run(self):
		toggle(1)
		t.sleep(4) # Change How long the smoke is left running for, that number + 1
		toggle(0)
def emitFor6Sec():
	thread = relayThread2(3, "EmitFor6Sec")
	thread.start()
	global timeForRelay
	timeForRelay = datetime.now()

# Loop over the frames of the video
while True:
	# Grab the current frame and initialize the occupied/unoccupied
	frame = vs.read()
	frame = frame if args.get("video", None) is None else frame[1]
	text = "Unoccupied"

	# If the frame could not be grabbed, then we have reached the endof the video
	if frame is None:
		break

	# Resize the frame, convert it to grayscale, and blur it
	frame = imutils.resize(frame, width=500)
	gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
	gray = cv2.GaussianBlur(gray, (21, 21), 0)

	# If the first frame is None, initialize it
	if firstFrame is None:
		firstFrame = gray
		continue

	# Compute the absolute difference between the current frame andfirst frame
	frameDelta = cv2.absdiff(firstFrame, gray)
	thresh = cv2.threshold(frameDelta, 25, 255, cv2.THRESH_BINARY)[1]

	# Dilate the thresholded image to fill in holes, then find contourson thresholded image
	thresh = cv2.dilate(thresh, None, iterations=2)
	cnts = cv2.findContours(thresh.copy(), cv2.RETR_EXTERNAL,
		cv2.CHAIN_APPROX_SIMPLE)
	cnts = imutils.grab_contours(cnts)

	# Loop over the contours
	for c in cnts:
		# If the contour is too small, ignore it
		if cv2.contourArea(c) < args["min_area"]:
			continue

		# Compute the bounding box for the contour, draw it on the frame,and update the text
		(x, y, w, h) = cv2.boundingRect(c)
		cv2.rectangle(frame, (x, y), (x + w, y + h), (0, 255, 0), 2)
		text = "Occupied"

	# Draw the text and timestamp on the frame
	cv2.putText(frame, "Room Status: {}".format(text), (10, 20),
		cv2.FONT_HERSHEY_SIMPLEX, 0.5, (0, 0, 255), 2)
	cv2.putText(frame, datetime.now().strftime("%A %d %B %Y %I:%M:%S%p"),
		(10, frame.shape[0] - 10), cv2.FONT_HERSHEY_SIMPLEX, 0.35, (0, 0, 255), 1)

	# Show the frame and record if the user presses a key
	cv2.imshow("Security Feed", frame)
	#cv2.imshow("Thresh", thresh)
	#cv2.imshow("Frame Delta", frameDelta)
	key = cv2.waitKey(1) & 0xFF
	
	if text=="Occupied":
		if datetime.now() > (timeForRelay + timedelta(seconds=30)):
			emitFor6Sec()
	else:
		if datetime.now() > firstTime  + timedelta(minutes=5):
			if True:
				firstFrame = gray
				print('Reset firstFrame')
				firstTime = datetime.now()
				
	t.sleep(0.05)

	# If the `q` key is pressed, break from the loop
	if key == ord("q"):
		destroy()
		break

# Cleanup the camera and close any open windows
vs.stop() if args.get("video", None) is None else vs.release()
cv2.destroyAllWindows()