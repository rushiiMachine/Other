#include <RGBmatrixPanel.h>
#include <Wire.h>

#define CLK  8
#define OE   9
#define LAT 10
#define A   A0
#define B   A1
#define C   A2
// Similar to F(), but for PROGMEM string pointers rather than literals
#define F2(progmem_ptr) (const __FlashStringHelper *)progmem_ptr

RGBmatrixPanel matrix(A, B, C, CLK, LAT, OE, true);
const char str[] PROGMEM = "OoOoOoOf";
int16_t    textX = matrix.width(), textMin = sizeof(str) * -12, hue = 0;

void receiveEvent(int howMany) {}

void setup() {
  Wire.begin(1);
  Wire.onReceive(receiveEvent);
  matrix.begin();
  matrix.setTextWrap(false); // Allow text to run off right edge
  matrix.setTextSize(2);
}

void loop() {
  // Send to other Panels to start single movement
  Wire.beginTransmission(2);
  Wire.write(1);
  Wire.endTransmission();
  
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

  matrix.swapBuffers(false);
  delay(10);
}
