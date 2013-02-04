import processing.core.PVector;

public class Debug {

    TApplet p;
    Level level;

    Debug(TApplet parent, Level level) {
        p = parent;
        this.level = level;
    }

    public void iterate() {
        if (p.mousePressed) p.println("Mouse click at " + p.mouseX + ", " + p.mouseY);
    }

    public void draw() {
        // Fire hitbox
        p.fill(255, 120);
        p.rectMode(p.CENTER);
        p.rect(level.fire.pos.x, level.fire.pos.y, level.fire.hitBox, level.fire.hitBox);

    }
}
