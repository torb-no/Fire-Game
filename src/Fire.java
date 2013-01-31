import processing.core.*;

public class Fire {

    PApplet p;
    PVector pos;

    Fire(PApplet parent, PVector position) {
        p = parent;
        this.pos = position;
    }

    public void draw() {
        p.fill(200, 200, 0, 150);
        p.ellipse(pos.x, pos.y, 20, 20);
    }


}
