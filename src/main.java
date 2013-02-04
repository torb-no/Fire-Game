import processing.core.*;

public class Main extends TApplet {

    Level level;
    GameInput gameInput;

    public void setup() {
        noLoop(); // Halt the loop ’til we are ready

        smooth();
        noStroke();
        gameInput = new GameInput(this);
        level = new Level(this, "Test4", gameInput);
        //Soundtrack.play(this);

        loop(); // Stuff is loaded, let’s get going!
    }

    public void draw() {
        level.iterate();
        level.draw();

        if (keyPressed && keyCode == UP) println(debugString);
        if (mousePressed) println("Mouse click at " + mouseX + ", " + mouseY);
    }

}
