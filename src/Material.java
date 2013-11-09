import processing.core.*;

public class Material {

    public static TApplet p;
    public static Level level;
    public static Fire fire;
    public static GameInput gameInput;

    PImage materialImage;
    PGraphics materialMask;
    public boolean canAffectFire = true;
    public boolean flammable = false;

    public void iterate() {
        // overload if material should react to flame
    }

    public void draw() {
        materialImage.mask(materialMask);
        p.image(materialImage, 0, 0);
    }

    void loadMap(String filename) {
        materialImage = p.loadImage(filename);
        materialMask = p.createGraphics(materialImage.width, materialImage.height);
        p.setImageBasedOnAlpha(materialMask, materialImage);
    }

    public boolean fireIteration() {
        return true;
        // Overload to change how fire behaves when on this material
        // Return false to prevent material underneath at same position from affecting the flame
    }

    // Material color functions

    public boolean materialIsColorAtPosition(int color, int x, int y) {
        return materialImage.get(x, y) == color;
    }

    public boolean materialIsColorAtPosition(int color, float x, float y) {
        return materialIsColorAtPosition(color, (int)x, (int)y);
    }

    public boolean materialIsColorWithinArea(int color, float posX, float posY, float width, float height) {
        float w2 = width / 2, h2 = height / 2,
                sx = posX - w2, sy = posY - h2, // left top corner
                ex = posX + w2, ey = posY + h2; // right bottom corner
        for (float x=sx; x<ex; x++) {
            for (float y=sy; y<ey; y++) {
                if (materialExistsAtPosition(x, y))
                    return true;
            }
        }
        return false;
    }

    // Material presence/existence functions

    public boolean materialExistsAtPosition(int x, int y) {
        return materialMask.get(x, y) != -16777216;
    }

    public boolean materialExistsAtPosition(float x, float y) {
        return materialExistsAtPosition((int)x, (int)y);
    }

    public boolean materialExistsWithinArea(float posX, float posY, float width, float height) {
        float w2 = width / 2, h2 = height / 2,
                sx = posX - w2, sy = posY - h2, // left top corner
                ex = posX + w2, ey = posY + h2; // right bottom corner
        for (float x=sx; x<ex; x++) {
            for (float y=sy; y<ey; y++) {
                if (materialExistsAtPosition(x, y))
                    return true;
            }
        }
        return false;
    }

    public boolean materialExistsWithinArea(float posX, float posY, float size) {
        return materialExistsWithinArea(posX, posY, size, size);
    }

    public boolean materialExistsWithinArea(PVector pos, float size) {
        return materialExistsWithinArea(pos.x, pos.y, size);
    }

}
