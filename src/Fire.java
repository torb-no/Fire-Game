import processing.core.*;

public class Fire {

    TApplet p;
    PVector pos;
    float hitBox = 20;

    Fire(TApplet parent, PVector position) {
        p = parent;
        this.pos = position;
    }

    public void draw() {
        p.noStroke();
        p.fill(200, 200, 0, 150);
        p.ellipse(pos.x, pos.y, 20, 20);
    }


}
