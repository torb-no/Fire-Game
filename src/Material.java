/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 25.01.13
 * Time: 21:43
 * To change this template use File | Settings | File Templates.
 */

import processing.core.*;

public class Material {

    PApplet p;
    PImage map;

    public void iterate(Fire fire) {
        // Overide with custom code
    }

    public void draw() {
        p.image(map, 0, 0);
    }

}
