import processing.core.*;
import procontroll.*;
import processing.serial.*;

public class GameInput {

    PApplet p;

    ControllIO controllIO;
    ControllDevice xboxController;
    ControllButton xboxLeft, xboxRight;

    Serial arduinoPort;
    char arduinoDirection;

    GameInput(PApplet parent) {
        p = parent;

        controllIO = ControllIO.getInstance(p);
        for (int i=0; i<controllIO.getNumberOfDevices(); i++) {
            // Assume Xbox360-controller, only tested on OSX with this driver: http://tattiebogle.net/index.php/ProjectRoot/Xbox360Controller/OsxDriver
            if (controllIO.getDevice(i).getName().contentEquals("Controller")) {
                xboxController = controllIO.getDevice(i);
                xboxLeft = xboxController.getButton(2);
                xboxRight = xboxController.getButton(3);
            }
        }   // */



    }

    public void setupArduino() {
        arduinoPort = new Serial(p, "/dev/tty.usbmodemfd121", 9600);
    }

    public void iterate() {
        if (arduinoPort.available() > 0) {
            arduinoDirection = arduinoPort.lastChar();
        }
    }

    public boolean moveLeft() {
        return p.keyPressed && p.keyCode == p.LEFT ||
               xboxLeft != null && xboxLeft.pressed() ||
               arduinoPort != null && arduinoDirection == 'L';
    }

    public boolean moveRight() {
        return p.keyPressed && p.keyCode == p.RIGHT ||
               xboxRight != null && xboxRight.pressed() ||
               arduinoPort != null && arduinoDirection == 'R';

    }

}
