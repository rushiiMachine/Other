char receivedChar;

void setup() {
  Serial.begin(115200);
}

void loop() {
  checkForIncomingData();
}

void checkForIncomingData() {
  if (Serial.available() > 0) {
    receivedChar = Serial.read();
    if (receivedChar == '1') {
      digitalWrite(13, HIGH);
      delay(1000);
      digitalWrite(13, LOW);
      Serial.println('0');
    }
  }
}
