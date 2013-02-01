public class Vaporizable extends Material {

    Vaporizable(String filename) {
        loadMap(filename);
    }

    public void iterate() {
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
