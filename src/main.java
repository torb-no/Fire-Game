/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 25.01.13
 * Time: 21:40
 * To change this template use File | Settings | File Templates.
 */

import processing.core.*;
import sun.jkernel.BackgroundDownloader;

public class Main extends PApplet {

    Fire fire;
    PImage levelBackground;
    Material[] materials = new Material[3];

    public void setup() {
        smooth();
        noStroke();

        Material.p = this;
        loadLevel("test");
    }

    public void draw() {
        iterateMaterials();

        drawMaterials();
        fire.draw();
    }

    void loadLevel(String levelName) {
        fire = new Fire(this, getFirePosition(levelName));

        Material.fire = fire;
        Material.levelName = levelName;

        materials[0] = new Background();
        materials[1] = new Wood();
        materials[2] = new Ice();
    }

    void iterateMaterials() {
        for (int i=0; i<materials.length; i++) {
            materials[i].iterate();
        }
    }

    void drawMaterials() {
        for (int i=0; i<materials.length; i++) {
            materials[i].draw();
        }
    }

    PVector getFirePosition(String levelName) {
        PImage firePos = loadImage(levelName + "/fire_position.png");
        for (int x=0; x<firePos.width; x++) {
            for (int y=0; y<firePos.height; y++) {
                int c = firePos.get(x, y);
                if (alpha(c) == 255 & brightness(c) == 255) {
                    return new PVector(x, y);
                }

            }
        }
    }

}
