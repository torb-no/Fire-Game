/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 31.01.13
 * Time: 09:14
 * To change this template use File | Settings | File Templates.
 */

import processing.core.*;

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
