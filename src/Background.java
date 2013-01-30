/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 26.01.13
 * Time: 00:36
 * To change this template use File | Settings | File Templates.
 */
public class Background extends Material {

    Background() {
        loadMap("background");
        p.size(materialImage.width, materialImage.height);
    }

}
