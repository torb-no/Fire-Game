import processing.core.*;

public class Fire {

    TApplet p;
    PVector pos;
    float hitBox = 10;

    private final float energyMax = 30;
    private float energy;

    Fire(TApplet parent, PVector position) {
        p = parent;
        this.pos = position;
        energy = energyMax / 2;
    }

    public void draw() {
        p.noStroke();
        p.fill(200, 200, 0, 150);
        p.ellipse(pos.x, pos.y, energy, energy);
    }

    public void addEnergy(float amount) {
        energy += amount;

        if (energy < 0) energy = 0;
        else if (energy > energyMax) energy = energyMax;
    }

}
