import processing.core.PVector;

/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 04.02.13
 * Time: 11:51
 * To change this template use File | Settings | File Templates.
 */
public class Debug {

    TApplet p;
    Level level;

    public PVector lastFoundPosition;

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
        // First point that is flammable
        p.stroke(255, 0, 0);
        p.point(lastFoundPosition.x, lastFoundPosition.y);


    }
}
