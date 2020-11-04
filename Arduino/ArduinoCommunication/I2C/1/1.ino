#include <Wire.h>

boolean newData = false;

void setup() {
  Serial.begin(9600);
  Wire.begin(9);
  Wire.onReceive(receiveEvent);
}

void loop() {
  if (newData = true) {
    Wire.beginTransmission(8);
    Wire.write(8);
    Wire.endTransmission();
    Serial.println("sent");
    newData = false;
  }
}

void receiveEvent(int howMany) {
  while (Wire.available() > 0) {
    char c = Wire.read();
    newData = true;
  }
}
