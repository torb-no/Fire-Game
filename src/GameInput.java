import processing.core.*;
import procontroll.*;
import processing.serial.*;

public class GameInput {

    PApplet p;

    GameInput(PApplet parent) {
        p = parent;
    }


    public boolean moveLeft() {
        return p.keyPressed && p.keyCode == p.LEFT;
    }

    public boolean moveRight() {
        return p.keyPressed && p.keyCode == p.RIGHT;
    }

}
