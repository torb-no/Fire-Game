import processing.core.*;

public class Material_Meta extends Material {

    Material_Meta(String filename) {
        loadMap(filename);
        canAffectFire = false;
    }

    public void iterate() {
        int black = p.color(0);
        if (materialIsColorAtPosition(black, fire.pos.x, fire.pos.y)) {
            p.exit();
        }
    }

    public PVector getStartFirePosition() {
        PVector startFirePosition = new PVector(0, 0);
        for (int x=0; x<materialImage.width; x++) {
            for (int y = 0; y < materialImage.height; y++) {
                int c = materialImage.get(x, y);
                if (p.alpha(c) == 255 & p.brightness(c) == 255)
                    startFirePosition = new PVector(x, y);
            }
        }
        return startFirePosition;
    }

    public void draw() {
        // Meta information should not be drawn
    }

    public boolean fireIteration() {
        return true;
        // Shouldn't affect the fire in game play
    }

}
