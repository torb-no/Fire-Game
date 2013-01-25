/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 25.01.13
 * Time: 21:43
 * To change this template use File | Settings | File Templates.
 */

import processing.core.*;

public class Material {

    PImage map;
    public static PApplet p;
    public static String levelName;
    public static Fire fire;


    public void iterate() {
        // overload with appropriate if material should react to flame
    }

    public void draw() {
        p.image(map, 0, 0);
    }

    void loadMap(String material) {
        map = p.loadImage(levelName + "/" + material + ".png");
    }

}
