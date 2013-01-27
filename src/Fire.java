/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 25.01.13
 * Time: 21:48
 * To change this template use File | Settings | File Templates.
 */

import processing.core.*;

public class Fire {

    PApplet p;
    PVector position;
    PImage woodMap;

    Fire(PApplet parent, PVector position) {
        p = parent;
        this.position = position;
        p.fill(200, 200, 0, 150);
    }

    public void draw() {

        p.ellipse(position.x, position.y, 20, 20);
    }


}
