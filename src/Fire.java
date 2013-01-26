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
    float energy = 100;

    Fire(PApplet parent, PVector position) {
        p = parent;
        this.position = position;
    }

    public void draw() {
        p.fill(200, 200, 0, 150);
        p.ellipse(position.x, position.y, 20, 20);
    }

}
