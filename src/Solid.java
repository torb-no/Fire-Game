/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 27.01.13
 * Time: 18:43
 * To change this template use File | Settings | File Templates.
 */

import processing.core.*;

public class Solid extends Material {

    Solid() {
        loadMap("stone");
    }

    public boolean fireIteration() {
        return false;
    }

}