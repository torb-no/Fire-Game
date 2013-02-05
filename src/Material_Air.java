public class Material_Air extends Material {

    public float downSpeed = 3;

    public boolean materialExistsWithinArea(float posX, float posY, float size) { return true; }

    public void draw() { /* air is invisible! */ }

    public boolean fireIteration() {
        // Fall downwards…
        if (!level.positionIsSpecificMaterial(fire.pos.x, fire.pos.y+downSpeed, Material_Stable.class))
            fire.pos.y += downSpeed;
        return false; //For consistency with the rest of the system, not really needed since air should always reside in the bottom stack
    }

}
