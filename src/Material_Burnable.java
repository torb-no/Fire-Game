import processing.core.*;

public class Material_Burnable extends Material {

    public float upSpeed = 1f,
                 downSpeed = 0.5f;
    public int sideSpeed = 1;

    Material_Burnable(String filename) {
        loadMap(filename);
        flammable = true;
    }

    public boolean fireIteration() {
        PVector prevFirePos = new PVector(fire.pos.x, fire.pos.y);

        if (level.positionIsFlammable(fire.pos.x, fire.pos.y-upSpeed))
            fire.pos.y -= upSpeed;
        else if (level.areaIsFlammable(fire.pos.x, fire.pos.y+downSpeed, 3, 1))
            fire.pos.y += downSpeed;

        if      (gameInput.moveLeft())  moveFireX(-sideSpeed);
        else if (gameInput.moveRight()) moveFireX(sideSpeed);

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
        int yLimit = 15;

        // Check above
        for (int yOffset=0; yOffset>-yLimit; yOffset--) {
            int y = (int) fire.pos.y + yOffset;
            if (level.positionIsFlammable(x, y)) {
                fire.pos.x = x;
                fire.pos.y = y;
                return;
            }
        }

        // Check bellow
        for (int yOffset=0; yOffset<yLimit; yOffset++) {
            int y = (int) fire.pos.y + yOffset;
            if (level.positionIsFlammable(x, y)) {
                fire.pos.x = x;
                fire.pos.y = y;
                return;
            }
        }
    }

}
