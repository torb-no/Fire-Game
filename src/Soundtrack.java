/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 01.02.13
 * Time: 14:26
 * To change this template use File | Settings | File Templates.
 */
import processing.core.*;
import ddf.minim.*;

public class Soundtrack {

    static Minim minim;
    static AudioPlayer player;

    public static void play(TApplet parent) {
        minim = new Minim((PApplet)parent);
        String file = parent.assetPath("soundtrack.mp3");
        player = minim.loadFile(file);
        player.play();
    }

}
