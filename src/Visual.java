public class Visual extends Material {

    Visual(String filename) {
        loadMap(filename);
        p.size(materialImage.width, materialImage.height);
    }

}
