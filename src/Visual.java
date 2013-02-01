public class Visual extends Material {

    Visual(String filename) {
        loadMap(filename);
        canAffectFire = false;
    }

}
