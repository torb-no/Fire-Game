import processing.core.*;

public class FireSystem {

    TApplet p;
    Fire fire;
    ParticleSystem innerFire, outerFire;

    FireSystem(TApplet parent, Fire fire) {
        p = parent;
        this.fire = fire;

        innerFire = new ParticleSystem(p, fire.pos, ParticleSystem.InnerFire);
        outerFire = new ParticleSystem(p, fire.pos, ParticleSystem.OuterFire);
    }

    public void iterate() {
        outerFire.energy = (int) ((fire.energy / fire.energyMax) * 255);
        innerFire.energy = (int) ((fire.energy / fire.energyMax) * 255);

        outerFire.iterate();
        innerFire.iterate();
    }

    public void draw() {
        outerFire.draw();
        innerFire.draw();
    }

}