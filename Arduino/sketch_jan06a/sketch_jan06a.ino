const int a = A0;
const int b = A1;
const int c = A2;
const int d = A3;
const int e = A4;
const int f = A5;
const int g = A6;
const int dp = A7;
const int d1 = 2;
const int d2 = 3;
const int d3 = 4;
const int d4 = 5;
bool numberBeingDrawn = false;

void setup() {
  pinMode(a,OUTPUT);
  pinMode(b,OUTPUT);
  pinMode(c,OUTPUT);
  pinMode(d,OUTPUT);
  pinMode(e,OUTPUT);
  pinMode(f,OUTPUT);
  pinMode(g,OUTPUT);
  pinMode(dp,OUTPUT);
  pinMode(d1,OUTPUT);
  pinMode(d2,OUTPUT);
  pinMode(d3,OUTPUT);
  pinMode(d4,OUTPUT);
}

void loop() {
  drawChar('8',d1,true);
}
void drawNumber() {
  
}
//segment is either d1,d2,d3 or d4
void drawChar(char _char, int segment, bool dot) {
  if (dot==true) {
    allOff();
    digitalWrite(dp,HIGH);
  }
  else { allOff(); }
  digitalWrite(segment,HIGH);
  if (_char == '0') {
    on(a);
    on(b);
    on(c);
    on(d);
    on(e);
    on(f);
  }
  if (_char == '1') {
    on(b);
    on(c);
  }
  if (_char == '2') {
    on(a);
    on(b);
    on(b);
    on(e);
    on(d);
  }
  if (_char == '3') {
    on(a);
    on(b);
    on(g);
    on(c);
    on(d);
  }
  if (_char == '4') {
    on(f);
    on(g);
    on(b);
    on(c);
  }
  if (_char == '5') {
    on(a);
    on(f);
    on(g);
    on(c);
    on(d);
  }
  if (_char == '6') {
    on(a);
    on(f);
    on(e);
    on(d);
    on(c);
    on(g);
  }
  if (_char == '8') {
    on(a);
    on(b);
    on(c);
    on(d);
    on(e);
    on(f);
    on(g);
  }
  if (_char == 'F') {
    on(a);
    on(f);
    on(g);
    on(e);
  }
  if (_char == 'U') {
    on(b);
    on(c);
    on(d);
    on(e);
    on(f);
  }
  if (_char == 'u') {
    on(c);
    on(d);
    on(e);
  }
  if (_char == 'o') {
    on(c);
    on(d);
    on(e);
    on(g);
  }
}
void allOff(){
  digitalWrite(a,LOW);
  digitalWrite(b,LOW);
  digitalWrite(c,LOW);
  digitalWrite(d,LOW);
  digitalWrite(e,LOW);
  digitalWrite(f,LOW);
  digitalWrite(g,LOW);
  digitalWrite(dp,LOW);
  digitalWrite(d1,LOW);
  digitalWrite(d2,LOW);
  digitalWrite(d3,LOW);
  digitalWrite(d4,LOW);
}
void on(int part){
  digitalWrite(part,HIGH);
}
