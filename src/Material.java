import processing.core.*;

public class Material {

    public static TApplet p;
    public static Level level;
    public static Fire fire;
    public static GameInput gameInput;

    PImage materialImage;
    PGraphics materialMask;
    public boolean flammable = false;

    public void iterate() {
        // overload with appropriate if material should react to flame
    }

    public void draw() {
        materialImage.mask(materialMask);
        p.image(materialImage, 0, 0);
    }

    void loadMap(String filename) {
        materialImage = p.loadImage(filename);
        materialMask = p.createGraphics(materialImage.width, materialImage.height, p.P2D);
        p.setImageBasedOnAlpha(materialMask, materialImage);
    }

    public boolean materialExistsAtPosition(int x, int y) {
        return materialMask.get(x, y) != -16777216;
    }

    public boolean materialExistsAtPosition(PVector position) {
        return materialExistsAtPosition((int)position.x, (int)position.y);
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
