public class Stable extends Material {

    Stable(String filename) {
        loadMap(filename);
    }

    public boolean fireIteration() {
        return false;
    }

}
