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

    public void setup() {
        smooth();
        noStroke();
        level = new Level(this, "level1");
    }

    public void draw() {
        level.iterate();
        level.draw();
    }

    public void mousePressed() {
        for (int i=0; i<level.materials.length; i++) {
            String s = level.materials[i].material + ": " + level.materials[i].materialMask.get(mouseX, mouseY);
            println(s);
        }
    }

}
