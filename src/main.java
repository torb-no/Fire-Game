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

        loadLevel("test");
    }

    public void draw() {
        iterateMaterials();

        drawMaterials();
        fire.draw();
    }

    void loadLevel(String levelName) {
        fire = new Fire(this, width-20, height-20);

        Material.fire = fire;
        Material.p = this;
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

}
