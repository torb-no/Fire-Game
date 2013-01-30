/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 27.01.13
 * Time: 17:29
 * To change this template use File | Settings | File Templates.
 */

import processing.core.*;

public class Level {

    TApplet p;
    Material[] materials = new Material[4];
    Fire fire;
    String name;

    Level(TApplet parent, String name) {
        p = parent;
        this.name = name;

        PImage fireImage = p.loadImage(name + "/fire_position.png");
        PVector firePosition = new PVector(0, 0);
        for (int x=0; x<fireImage.width; x++) {
            for (int y=0; y<fireImage.height; y++) {
                int c = fireImage.get(x, y);
                if (p.alpha(c) == 255 & p.brightness(c) == 255) {
                    firePosition = new PVector(x, y);
                }

            }
        }
        fire = new Fire(p, firePosition);

        Material.p = p;
        Material.level = this;
        Material.fire = fire;

        materials[0] = new Visual();
        materials[1] = new Burnable();
        materials[2] = new Meltable();
        materials[3] = new Stable();
    }

    public void iterate() {
        iterateMaterials();
    }

    public void draw() {
        drawMaterials();
        fire.draw();
    }

    void iterateMaterials() {
        boolean doFireIteration = true;
        for (int i=materials.length-1; i!=0; i--) { // In reverse because top most materials take precedence
            materials[i].iterate();
            if (doFireIteration && materials[i].materialExistsAtPosition(fire.pos))
                doFireIteration = materials[i].fireIteration();
        }
    }

    void drawMaterials() {
        for (int i=0; i<materials.length; i++) {
            materials[i].draw();
        }
    }

    boolean positionIsFlammable(float x, float y) {
        for (int i=materials.length-1; i!=0; i--) {
            if (materials[i].materialExistsAtPosition(x, y))
                return materials[i].flammable;
        }
        return false;
    }

}
