/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 25.01.13
 * Time: 21:53
 * To change this template use File | Settings | File Templates.
 */

import processing.core.*;

public class Wood extends Material {

    Wood() {
        loadMap("wood");
        flammable = true;
    }

    public void iterate() {

    }

    public boolean fireIteration() {
        if (p.keyPressed) {
            if      (p.keyCode == p.LEFT) moveFireX(-1);
            else if (p.keyCode == p.RIGHT) moveFireX(1);
        }
        burnUp();
        return false;
    }

   void moveFireX(int xOffset) {
      int x = (int) fire.position.x + xOffset;
      for (int yOffset=0; yOffset<5; yOffset++) {
        int y = (int) fire.position.y + yOffset;
        if (level.positionIsFlammable(x, y)) {
            fire.position.x += xOffset;
            fire.position.y += yOffset;
            break;
        }
      }
   }

   void burnUp() {
       float y = fire.position.y - 1;
       if (level.positionIsFlammable(fire.position.x, y))
           fire.position.y = y;
   }

}
