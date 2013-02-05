import processing.core.*;

public class Fire {

    TApplet p;
    PVector pos;
    float hitBox = 10;
    FireSystem fireSystem;

    private final float energyMax = 30;
    private float energy;

    Fire(TApplet parent, PVector position) {
        p = parent;
        this.pos = position;
        energy = energyMax / 2;
        fireSystem = new FireSystem(p, pos);
    }

    public void draw() {
        // Setup fire

        fireSystem.iterate();
        fireSystem.draw();
    }

    public void addEnergy(float amount) {
        energy += amount;

        if (energy < 0) energy = 0;
        else if (energy > energyMax) energy = energyMax;
    }

}
