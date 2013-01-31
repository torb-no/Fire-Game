import processing.core.*;

public class Burnable extends Material {

    Burnable(String filename) {
        loadMap(filename);
        flammable = true;
    }

    public void iterate() {

    }

    public boolean fireIteration() {
        PVector prevFirePos = new PVector(fire.pos.x, fire.pos.y);

        if (gameInput.moveLeft()) moveFireX(-1);
        else if (gameInput.moveRight()) moveFireX(1);

        // move up on burning material
        float y = fire.pos.y - 1;
        if (level.positionIsFlammable(fire.pos.x, y))
            fire.pos.y = y;

        // burn between previous pos and current pos
        if (fire.pos.x != prevFirePos.x || fire.pos.y != prevFirePos.y) {
            materialMask.beginDraw();
            materialMask.stroke(0);
            materialMask.point(prevFirePos.x, prevFirePos.y);
            materialMask.endDraw();
        }

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
