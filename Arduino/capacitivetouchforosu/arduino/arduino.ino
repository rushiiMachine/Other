#include <CapacitiveSensor.h>
#include <Keyboard.h>

CapacitiveSensor sens1 = CapacitiveSensor(2,6);
CapacitiveSensor sens2 = CapacitiveSensor(3,7);
CapacitiveSensor sens3 = CapacitiveSensor(4,8);
CapacitiveSensor sens4 = CapacitiveSensor(5,9);
#define onOffSwitch 10

void setup() {
  sens1.set_CS_AutocaL_Millis(0xFFFFFFFF);
  sens2.set_CS_AutocaL_Millis(0xFFFFFFFF);
  sens3.set_CS_AutocaL_Millis(0xFFFFFFFF);
  sens4.set_CS_AutocaL_Millis(0xFFFFFFFF);
  pinMode(onOffSwitch, INPUT);
  Keyboard.begin();
}

bool clickKey1 = false;
bool clickKey2 = false;
bool clickKey3 = false;
bool clickKey4 = false;

void loop() {
    long totalKey1 =  sens1.capacitiveSensor(20);
    long totalKey2 =  sens2.capacitiveSensor(20);
    long totalKey3 =  sens3.capacitiveSensor(20);
    long totalKey4 =  sens4.capacitiveSensor(20);
    
      if(totalKey1 > 1000 && !clickKey1) {
        Keyboard.press('c');
        clickKey1 = true;
      }
      if(totalKey2 > 1000 && !clickKey2) {
        Keyboard.press('v');
        clickKey2 = true;
      }
      if(totalKey3 > 1000 && !clickKey3) {
        Keyboard.press(KEY_ESC);
        clickKey3 = true;
      }
      if(totalKey4 > 1000 && !clickKey4) {
        Keyboard.press('`');
        clickKey4 = true;
      }
      
      if (totalKey1 <= 1000 && clickKey1) {
        clickKey1 = false;
        Keyboard.release('c');
      }
      if (totalKey2 <= 1000 && clickKey2) {
        clickKey2 = false;
        Keyboard.release('v');
      }
      if (totalKey3 <= 1000 && clickKey3) {
        clickKey3 = false;
        Keyboard.release(KEY_ESC);
      }
      if (totalKey4 <= 1000 && clickKey4) {
        clickKey4 = false;
        Keyboard.release('`');
      }
}
