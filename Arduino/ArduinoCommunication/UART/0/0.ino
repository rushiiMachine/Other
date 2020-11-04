char receivedChar;

void setup() {
  Serial.begin(115200);
  delay(10000);
  Serial.println('1');
}

void loop() {
  checkForIncomingData();
}

void checkForIncomingData() {
  if (Serial.available() > 0) {
    receivedChar = Serial.read();
    if (receivedChar == '0') {
      digitalWrite(13, HIGH);
      delay(1000);
      digitalWrite(13, LOW);
      Serial.println('1');
    }
  }
}
