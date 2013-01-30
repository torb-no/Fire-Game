/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 29.01.13
 * Time: 11:49
 * To change this template use File | Settings | File Templates.
 */

import processing.core.*;

public class TApplet extends PApplet {

    // Extend PApplet with missing functionality

    public void setImageBasedOnAlpha(PImage target, PImage alphaSource) {
        target.loadPixels();
        alphaSource.loadPixels();

        for (int i=0; i<target.pixels.length; i++) {
            int grey = (int) alpha(alphaSource.pixels[i]);
            target.pixels[i] = color(grey);
        }

        target.updatePixels();
    }

    public void setAlphaBasedOnImage(PImage target, PImage imageSource) {
        // TODO: Fix this motherfucker

        target.loadPixels();
        imageSource.loadPixels();

        for (int i=0; i<target.pixels.length; i++) {
            float r = red(target.pixels[i]),
                  g = green(target.pixels[i]),
                  b = blue(target.pixels[i]),
                  a = brightness(imageSource.pixels[i]);
            target.pixels[i] = color(r, g, b, a);
        }

        target.updatePixels();
    }

}
