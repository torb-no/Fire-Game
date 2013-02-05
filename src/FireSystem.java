import processing.core.*;

public class FireSystem {

    TApplet p;
    PVector position;
    ParticleSystem innerFire, outerFire;

    FireSystem(TApplet parent, PVector position) {
        p = parent;
        this.position = position;

        innerFire = new ParticleSystem(p, position, ParticleSystem.InnerFire);
        outerFire = new ParticleSystem(p, position, ParticleSystem.OuterFire);
    }

    public void iterate() {
        outerFire.iterate();
        innerFire.iterate();
    }

    public void draw() {
        outerFire.draw();
        innerFire.draw();
    }

}