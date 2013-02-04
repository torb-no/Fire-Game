import processing.core.*;
import java.io.File;

public class TApplet extends PApplet {

    // Extend PApplet with missing functionality

    public static Debug debug;

    public void setImageBasedOnAlpha(PImage target, PImage alphaSource) {
        target.loadPixels();
        alphaSource.loadPixels();

        for (int i=0; i<target.pixels.length; i++) {
            int grey = (int) alpha(alphaSource.pixels[i]);
            target.pixels[i] = color(grey);
        }

        target.updatePixels();
    }

    public String assetPath(String where) {
        String s = sketchPath + "/assets/" + where;
        return s.replace("/", File.separator);
    }

}
