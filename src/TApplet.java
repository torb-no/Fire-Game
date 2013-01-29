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

    public void setMaskBasedOnAlpha(PImage target, PImage alphaImg) {
        target.loadPixels();
        alphaImg.loadPixels();

        for (int i=0; i<target.pixels.length; i++) {
            int grey = (int) alpha(alphaImg.pixels[i]);
            target.pixels[i] = color(grey);
        }

        target.updatePixels();
    }

    public void setAlphaBasedOnMask(PImage target, PImage maskImg) {
        target.loadPixels();
        maskImg.loadPixels();

        for (int i=0; i<target.pixels.length; i++) {
            float r = red(target.pixels[i]),
                  g = green(target.pixels[i]),
                  b = blue(target.pixels[i]);
            float ar = red(maskImg.pixels[i]),
                  ag = green(maskImg.pixels[i]),
                  ab = blue(maskImg.pixels[i]);
            float a = (ar + ag + ab) / 3;
            target.pixels[i] = color(r, g, b, a);
        }

        target.updatePixels();
    }

}
