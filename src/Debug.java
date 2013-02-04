import processing.core.PVector;

public class Debug {

    TApplet p;
    Level level;

    PVector drawRect;
    float drawRectSize;
    int drawRectMode;
    int drawRectColor;

    PVector drawPoint;
    int drawPointColor;

    Debug(TApplet parent, Level level) {
        p = parent;
        this.level = level;

        drawRectColor = p.color(255, 0, 0, 150);
        drawRectMode = p.CENTER;
        drawPointColor = p.color(0, 255, 0);
    }

    public void iterate() {
        if (p.mousePressed) p.println("Mouse click at " + p.mouseX + ", " + p.mouseY);
    }

    public void draw() {
        /* Fire hitbox
        p.fill(255, 120);
        p.rectMode(p.CENTER);
        p.rect(level.fire.pos.x, level.fire.pos.y, level.fire.hitBox, level.fire.hitBox); // */

        // If we want to draw something somewhere
        if (drawRect != null) {
            p.fill(drawRectColor);
            p.rectMode(drawRectMode);
            p.rect(drawRect.x, drawRect.y, drawRectSize, drawRectSize);
        }
        if (drawPoint != null) {
            p.stroke(drawPointColor);
            p.point(drawPoint.x, drawPoint.y);
        }
    }
}
