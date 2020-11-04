#include <RGBmatrixPanel.h>
#include <Wire.h>

// Most of the signal pins are configurable, but the CLK pin has some
// special constraints.  On 8-bit AVR boards it must be on PORTB...
// Pin 8 works on the Arduino Uno & compatibles (e.g. Adafruit Metro),
// Pin 11 works on the Arduino Mega.  On 32-bit SAMD boards it must be
// on the same PORT as the RGB data pins (D2-D7)...
// Pin 8 works on the Adafruit Metro M0 or Arduino Zero,
// Pin A4 works on the Adafruit Metro M4 (if using the Adafruit RGB
// Matrix Shield, cut trace between CLK pads and run a wire to A4).

#define CLK  8
#define OE   9
#define LAT 10
#define A   A0
#define B   A1
#define C   A2
// Similar to F(), but for PROGMEM string pointers rather than literals
#define F2(progmem_ptr) (const __FlashStringHelper *)progmem_ptr
#define thisAddress = 11
#define nextPanelAddress = 12;

RGBmatrixPanel matrix(A, B, C, CLK, LAT, OE, true);
const char str[] PROGMEM = "OoOoOoOf";
int16_t    textX = matrix.width(), textMin = sizeof(str) * -12, hue = 0;
boolean newData = false;

void setup() {
  Wire.begin(thisAddress);
  Wire.onReceive(receiveEvent);
  matrix.begin();
  matrix.setTextWrap(false); // Allow text to run off right edge
  matrix.setTextSize(2);
}

void loop() {
  if
  // Clear background
  matrix.fillScreen(0);

  // Draw big scrolly text on top
  matrix.setTextColor(matrix.ColorHSV(hue, 255, 255, true));
  matrix.setCursor(textX, 1);
  matrix.print(F2(str));

  // Move text left (w/wrap), increase hue
  if((--textX) < textMin) textX = matrix.width();
  hue += 4;
  if(hue >= 1536) hue -= 1536;

#if !defined(__AVR__)
  // On non-AVR boards, delay slightly so screen updates aren't too quick.
  delay(20);
#endif

  // Update display
  matrix.swapBuffers(false);
  delay(10);
}

void receiveEvent(int howMany) {
  while (Wire.available() > 0) {
    newData = true;
  }
}















void setup() {
  Serial.begin(9600);
  Wire.begin(8);
  Wire.onReceive(receiveEvent);
  
  delay(1000);
  Wire.beginTransmission(9);
  Wire.write(9);
  Wire.endTransmission();
}

void loop() {
  if (newData = true) {
    digitalWrite(13, HIGH);
    delay(1000);
    digitalWrite(13, LOW);
    delay(1000);
    
    Wire.beginTransmission(9);
    Wire.write(9);
    Wire.endTransmission();
    Serial.println("sent");

    newData = false;
  }
}
