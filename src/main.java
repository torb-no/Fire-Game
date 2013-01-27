/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 25.01.13
 * Time: 21:40
 * To change this template use File | Settings | File Templates.
 */

import processing.core.*;

public class Main extends PApplet {

    Level level;

    public void setup() {
        smooth();
        noStroke();
        level = new Level(this, "test");
    }

    public void draw() {
        level.iterate();


        level.draw();
    }

}
