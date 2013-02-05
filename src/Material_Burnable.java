import processing.core.*;

public class Material_Burnable extends Material {

    public float upSpeed = 1f,
                 downSpeed = 0.5f,
                 energyChange = 1f;
    public int sideSpeed = 1;

    Material_Burnable(String filename) {
        loadMap(filename);
        flammable = true;
    }

    public boolean fireIteration() {
        if (level.positionIsSpecificMaterial(fire.pos.x, fire.pos.y-upSpeed, Material_Burnable.class))
            fire.pos.y -= upSpeed;
        else if (!level.positionIsSpecificMaterial(fire.pos.x, fire.pos.y+downSpeed, Material_Stable.class))
            fire.pos.y += downSpeed;

        if      (gameInput.moveLeft())  moveFireX(-sideSpeed);
        else if (gameInput.moveRight()) moveFireX(sideSpeed);

        // burn baby!
        materialMask.beginDraw();
        materialMask.stroke(0);
        materialMask.point(fire.pos.x, fire.pos.y);
        materialMask.endDraw();

        fire.addEnergy(energyChange);

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
