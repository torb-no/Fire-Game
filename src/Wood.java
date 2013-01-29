/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 25.01.13
 * Time: 21:53
 * To change this template use File | Settings | File Templates.
 */

import processing.core.*;

public class Wood extends Material {

    PGraphics gMask;

    Wood() {
        loadMap("wood");
        flammable = true;
        gMask = p.createGraphics(p.width, p.height, p.JAVA2D);
        p.setMaskBasedOnAlpha(gMask, materialBuffer);
    }

    public void iterate() {

    }

    public void draw() {
        p.image(materialBuffer, 0, 0);
        p.image(gMask, 0, 0);

    }

    public boolean fireIteration() {
        PVector prevFirePos = new PVector(fire.pos.x, fire.pos.y);

        if (p.keyPressed) {
            if      (p.keyCode == p.LEFT) moveFireX(-1);
            else if (p.keyCode == p.RIGHT) moveFireX(1);
        }

        // move up on burning material
        float y = fire.pos.y - 1;
        if (level.positionIsFlammable(fire.pos.x, y))
            fire.pos.y = y;

        // burn between previous pos and current pos
        if (fire.pos.x != prevFirePos.x || fire.pos.y != prevFirePos.y) {
            gMask.beginDraw();
            gMask.stroke(0);
            gMask.point(prevFirePos.x, prevFirePos.y);
            gMask.endDraw();
        }

        p.setAlphaBasedOnMask(materialBuffer, gMask);

        return false;
    }

   void moveFireX(int xOffset) {
      int x = (int) fire.pos.x + xOffset;
      for (int yOffset=0; yOffset<5; yOffset++) {
        int y = (int) fire.pos.y + yOffset;
        if (level.positionIsFlammable(x, y)) {
            fire.pos.x = x;
            fire.pos.y = y;
            break;
        }
      }
   }

    void burnAway(int x, int y) {

    }

}
