#include <TinkerKit.h>
TKJoystick joystick(I0, I1);

void setup() {
  Serial.begin(9600);
}

void loop() {
  int j = joystick.getXAxis();
  
  if (j < 300) Serial.println('L');
  if (j > 650) Serial.println('R');
}

