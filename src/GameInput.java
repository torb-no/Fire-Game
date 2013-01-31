import processing.core.*;
import procontroll.*;

public class GameInput {

    PApplet p;
    ControllIO controllIO;
    ControllDevice xboxController;
    ControllButton xboxLeft, xboxRight;

    GameInput(PApplet parent) {
        p = parent;
        controllIO = ControllIO.getInstance(p);

        for (int i=0; i<controllIO.getNumberOfDevices(); i++) {
            if (controllIO.getDevice(i).getName().contentEquals("Controller")) { //Assume Xbox360-controller
                xboxController = controllIO.getDevice(i);
                xboxLeft = xboxController.getButton(2);
                xboxRight = xboxController.getButton(3);
            }
        }
    }

    public boolean moveLeft() {
        return p.keyPressed && p.keyCode == p.LEFT ||
               xboxLeft != null && xboxLeft.pressed();
    }

    public boolean moveRight() {
        return p.keyPressed && p.keyCode == p.RIGHT ||
               xboxRight != null && xboxRight.pressed();
    }

    public void iterate() {

    }




}
