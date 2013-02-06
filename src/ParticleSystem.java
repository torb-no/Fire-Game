import processing.core.*;

public class ParticleSystem {

    static final int InnerFire = 0;
    static final int OuterFire = 1;

    TApplet p;
    Particle[] particles;
    PVector origin;
    int newPerIteration = 1;

    int mode;
    PImage image;

    int energy = 255;

    ParticleSystem(TApplet parent, PVector origin, int type) {
        p = parent;
        this.origin = origin;
        Particle.p = parent;
        Particle.origin = origin;
        this.mode = type;

        int amount = 30; //default
        if (type == InnerFire) {
            amount = 10;
            image = p.loadImage(p.assetPath("/particles/inner.png"));
        }
        else if (type == OuterFire) {
            amount = 20;
            image = p.loadImage(p.assetPath("/particles/outer.png"));
        }

        particles = new Particle[amount];
    }

    public void iterate() {

        int newParticleCounter = 0;
        for (int i=0; i<particles.length; i++) {
            if (particles[i] != null && particles[i].dead()) {
                particles[i] = null;
            }

            if (particles[i] != null)
                particles[i].iterate();
            else if (newParticleCounter < newPerIteration) {
                particles[i] = newParticle();
                newParticleCounter++;
            }
        }
    }

    public void draw() {
        for (int i=0; i<particles.length; i++) {
            if (particles[i] != null)
                particles[i].draw();

        }
    }

    Particle newParticle() {

        Particle pa = new Particle();

        switch (mode){
            case InnerFire:
                pa.maxVelX = .3f;
                pa.minVelY = .6f; pa.maxVelY = 1f;
                pa.maxAccX = .03f;
                pa.minAccY = .05f; pa.maxAccY = .3f;
                pa.energyFadeSpeed = 30;
                break;
            case OuterFire:
                pa.maxVelX = .3f;
                pa.minVelY = .8f; pa.maxVelY = 2f;
                pa.maxAccX = .03f;
                pa.minAccY = .07f; pa.maxAccY = .6f;
                pa.energyFadeSpeed = 30;
                break;
        }

        pa.image = image;
        pa.energy = energy;
        pa.setup();
        return pa;

    }


}