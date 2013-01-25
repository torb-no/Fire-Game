/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 25.01.13
 * Time: 21:53
 * To change this template use File | Settings | File Templates.
 */

import processing.core.*;

public class Wood extends Material {

    Wood(PApplet parent) {
        p = parent;
        map = p.loadImage("wood.png");
    }

    public void iterate(Fire fire) {

    }

}
