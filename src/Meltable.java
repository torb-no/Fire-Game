/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 25.01.13
 * Time: 23:50
 * To change this template use File | Settings | File Templates.
 */

import processing.core.*;

public class Meltable extends Material {

    Meltable(String filename) {
        loadMap(filename);
    }

    public boolean fireIteration() {
        return false;
    }

}
