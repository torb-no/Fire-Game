/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 25.01.13
 * Time: 21:43
 * To change this template use File | Settings | File Templates.
 */

import processing.core.*;

public class Material {

    public static TApplet p;
    public static Level level;
    public static Fire fire;

    //PImage materialMap;
    PGraphics materialBuffer;
    public boolean flammable = false;

    public void iterate() {
        // overload with appropriate if material should react to flame
    }

    public void draw() {
        p.image(materialBuffer, 0, 0);
    }

    void loadMap(String material) {
        PImage materialMap = p.loadImage(level.name + "/" + material + ".png");
        materialBuffer = p.createGraphics(materialMap.width, materialMap.height, p.JAVA2D);
        materialBuffer.beginDraw();
        materialBuffer.image(materialMap, 0, 0);
        materialBuffer.endDraw();
    }

    public boolean materialExistsAtPosition(PVector position) {
        return materialExistsAtPosition((int)position.x, (int)position.y);
    }

    public boolean materialExistsAtPosition(int x, int y) {
        int pixel = materialBuffer.get(x, y);
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
