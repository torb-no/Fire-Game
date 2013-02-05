import processing.core.*;

public class Particle {

    public static PApplet p;
    public static PVector origin;

    float maxVelX = .3f,
            minVelY = .3f, maxVelY = .6f,
            maxAccX = .03f,
            minAccY = .01f, maxAccY = .1f;

    PVector pos,
            velocity,
            acceleration;
    public float energy = 255,
            energyFadeSpeed = 5;
    public PImage image;

    public void setup() {
        pos = origin.get();
        float velX = p.random(-maxVelX, maxVelX),
                accX = p.random(-maxAccX, maxAccX),
                velY = -p.random(minVelY, maxVelY),
                accY = -p.random(minAccY, maxAccY);
        velocity = new PVector(velX, velY);
        acceleration = new PVector(accX, accY);
    }

    public void iterate() {
        velocity.add(acceleration);
        pos.add(velocity);
        energy -= energyFadeSpeed;
    }

    public void draw() {
        p.tint(255, energy);
        p.image(image, pos.x-image.width/2, pos.y-image.height/2);
        p.tint(255);
    }

    public boolean dead() {
        return energy <= 0.0f;
    }

}
