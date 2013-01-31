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
            //Assume Xbox360-controller, only tested on OSX with this driver: http://tattiebogle.net/index.php/ProjectRoot/Xbox360Controller/OsxDriver
            if (controllIO.getDevice(i).getName().contentEquals("Controller")) {
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
