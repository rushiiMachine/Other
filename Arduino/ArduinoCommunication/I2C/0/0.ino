#include <Wire.h>

boolean newData = false;

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

void receiveEvent(int howMany) {
  while (Wire.available() > 0) {
    char c = Wire.read();
    newData = true;
  }
}
