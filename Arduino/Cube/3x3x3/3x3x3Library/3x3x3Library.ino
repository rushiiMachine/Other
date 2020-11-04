class Cube3x3x3 {
  public:
    // Each variable is representing the x and y where x and z are flat and z is up/down
    Cube3x3x3(uint8_t x0y0,uint8_t zeroOne,uint8_t zeroTwo,uint8_t oneZero,uint8_t oneOne,uint8_t oneTwo,uint8_t twoZero,uint8_t twoOne,uint8_t twoTwo,uint8_t layer0,uint8_t layer1,uint8_t layer2);
 
    void drawPixel(int x,int y,int z) {
      turnOnLayer(z);
    };
    
  private:
    int layerActivated;
    
    turnOnLayer(int layer) {
      if (layerActivated != layer) {
        uint8_t layerPin = retrievePin(0,true);
      }
    };
    
    uint8_t retrievePin(int toDetermine,bool isALayer/*If not a layer then it's a column*/) {
      if (isALayer) {
        if (toDetermine == 0) return layer0;
        if (toDetermine == 1) return layer1;
        if (toDetermine == 2) return layer2;
      }
      if (!isALayer) {
        if (toDetermine == 00) return x0y0
      }
    };
};
void setup() {}
void loop() {}
