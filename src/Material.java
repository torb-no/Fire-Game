/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 25.01.13
 * Time: 21:43
 * To change this template use File | Settings | File Templates.
 */

import processing.core.*;

public class Material {

    public static PApplet p;
    public static Level level;
    public static Fire fire;

    PImage map;
    public boolean flammable = false;

    public void iterate() {
        // overload with appropriate if material should react to flame
    }

    public void draw() {
        p.image(map, 0, 0);
    }

    void loadMap(String material) {
        map = p.loadImage(level.name + "/" + material + ".png");
    }

    public boolean materialExistsAtPosition(PVector position) {
        return materialExistsAtPosition((int)position.x, (int)position.y);
    }

    public boolean materialExistsAtPosition(int x, int y) {
        int pixel = map.get(x, y);
        return p.alpha(pixel) != 0.0;
    }

    public boolean materialExistsAtPosition(float x, float y) {
        return materialExistsAtPosition((int)x, (int)y);
    }

    public boolean fireIteration() {
        return true;
        // Return false in order to prevent next material from affecting the flame
        // Only fires if flame is actually on the material
    }

}
