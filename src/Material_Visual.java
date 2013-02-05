public class Material_Visual extends Material {

    Material_Visual(String filename) {
        loadMap(filename);
        canAffectFire = false;
    }

}
