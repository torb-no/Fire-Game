public class Material_Air extends Material {

    public boolean materialExistsWithinArea(float posX, float posY, float size) { return true; }

    public void draw() { /* air is invisible! */ }

    public boolean fireIteration() {

        // Fall downwards…

        p.println("I AM ITERATING MOTHERFUCKER!");

        return false; //For consistency with the rest of the system, not really needed since air should always reside in the bottom stack
    }

}
