import processing.core.*;

public class Main extends TApplet {

    Level level;
    GameInput gameInput;

    public static void main(String args[]) {
        PApplet.main(new String[] { "--present", "Main" });
    }

    public void setup() {
        noLoop(); // Half the loop ’til we are ready
        smooth();
        noStroke();
        gameInput = new GameInput(this);
        level = new Level(this, "level1b", gameInput);
        loop();
    }

    public void draw() {
        level.iterate();
        level.draw();
    }

}
