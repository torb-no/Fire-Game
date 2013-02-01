import processing.core.*;

public class Main extends TApplet {

    Level level;
    GameInput gameInput;

    public static void main(String args[]) {
        PApplet.main(new String[] { "--present", "Main" });
    }

    public void setup() {
        noLoop(); // Halt the loop ’til we are ready

        smooth();
        noStroke();
        gameInput = new GameInput(this);
        level = new Level(this, "Test2", gameInput);
        Soundtrack.play(this);

        loop(); // Stuff is loaded, let’s get going!
    }

    public void draw() {
        level.iterate();
        level.draw();
    }

}
