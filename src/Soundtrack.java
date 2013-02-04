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
