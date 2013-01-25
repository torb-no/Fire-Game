/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 25.01.13
 * Time: 21:40
 * To change this template use File | Settings | File Templates.
 */

import processing.core.*;

public class Main extends PApplet {

    Fire fire;
    PImage levelBackground;
    Material[] materials = new Material[2];

    public void setup() {
        smooth();
        noStroke();

        loadLevel();
    }

    public void draw() {
        iterateMaterials();

        image(levelBackground, 0, 0);
        drawMaterials();
        fire.draw();
    }

    void loadLevel() {
        levelBackground = loadImage("background.png");
        size(levelBackground.width, levelBackground.height);

        materials[0] = new Wood(this);

        fire = new Fire(this, width-20, height-20);
    }

    void iterateMaterials() {
        materials[0].iterate(fire);
    }

    void drawMaterials() {
        materials[0].draw();
    }

}
