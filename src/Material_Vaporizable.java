public class Material_Vaporizable extends Material {

    Material_Vaporizable(String filename) {
        loadMap(filename);
    }

    public void iterate() {
        // Melt away gradually
        materialMask.beginDraw();
        materialMask.fill(0, 1);
        materialMask.noStroke();
        materialMask.ellipse(fire.pos.x, fire.pos.y, 80, 80);
        materialMask.endDraw();
    }

    public boolean fireIteration() {
        return false;
    }

}
