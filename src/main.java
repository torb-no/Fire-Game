/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 25.01.13
 * Time: 21:40
 * To change this template use File | Settings | File Templates.
 */

import processing.core.*;


public class Main extends TApplet {

    Level level;
    GameInput gameInput;

    public static void main(String args[]) {
        PApplet.main(new String[] { "--present", "Main" });
    }

    public void setup() {
        println();
        noLoop(); // Half the loop ’til we are ready
        smooth();
        noStroke();
        gameInput = new GameInput(this);
        level = new Level(this, "level1b", gameInput);
        loop();
    }

    public void draw() {
        level.iterate();
        level.draw();
    }

}
