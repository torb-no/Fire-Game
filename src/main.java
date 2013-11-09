public class Main extends TApplet {

    Level level;
    GameInput gameInput;

    public void setup() {
        noLoop(); // Halt the loop ’til we are ready

        smooth();
        noStroke();
        gameInput = new GameInput(this);
        level = new Level(this, "Plattforms", gameInput);
        Soundtrack.play(this);
        //debug = new Debug(this, level);
        frame.setTitle("Fire");


        loop(); // Stuff is loaded, let’s get going!
    }

    public void draw() {
        level.iterate();
        if (debug != null) debug.iterate();

        level.draw();
        if (debug != null) debug.draw();
    }

}
