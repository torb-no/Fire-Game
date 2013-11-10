import processing.core.*;
import java.io.*;

public class Level {

    TApplet p;
    Material[] materials;
    Fire fire;
    String name;
    GameInput gameInput;

    Level(TApplet parent, String name, GameInput gameInput) {
        p = parent;
        this.name = name;
        this.gameInput = gameInput;

        Material.p = p;
        Material.level = this;
        Material.gameInput = gameInput;

        // Load materials
        String levelPath = p.assetPath("levels/" + name);
        File levelFolder = new File(levelPath);
        String[] materialFiles = levelFolder.list(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                return s.startsWith("material");
            }
        });

        materials = new Material[materialFiles.length+1]; //+1 to accommodate hard coded air material and meta material
        materials[0] = new Material_Air();

        for (int i=1; i<materials.length; i++) {
            String type = materialFiles[i-1].substring(11).replace(".png", ""),
                   filePath = p.assetPath("levels/" + name + "/" + materialFiles[i-1]);
            if      (type.contentEquals("visual"))      materials[i] = new Material_Visual(filePath);
            else if (type.contentEquals("stable"))      materials[i] = new Material_Stable(filePath);
            else if (type.contentEquals("burnable"))    materials[i] = new Material_Burnable(filePath);
            else if (type.contentEquals("vaporizable")) materials[i] = new Material_Vaporizable(filePath);
            else if (type.contentEquals("meta"))        materials[i] = new Material_Meta(filePath);
            else throw new UnrecognizedMaterialException(type);
        }

        Material_Meta meta = (Material_Meta) materials[materials.length-1];
        p.size(meta.materialImage.width, meta.materialImage.height);
        fire = new Fire(p, meta.getStartFirePosition());

        Material.fire = fire;

    }

    public void iterate() {
        iterateMaterials();

    }

    public void draw() {
        drawMaterials();
        fire.draw();
    }

    void iterateMaterials() {
        boolean doFireIteration = true;
        for (int i=materials.length-1; i>=0; i--) { // In reverse because top most materials take precedence
            materials[i].iterate();
            for (int j=1; j<=fire.hitBox; j += 2) { // Wider and wider…
                if (doFireIteration && materials[i].materialExistsWithinArea(fire.pos, j)) {
                    doFireIteration = materials[i].fireIteration();
                    if (p.debug != null) p.println(materials[i].toString());
                }

            }
        }
    }

    void drawMaterials() {
        for (int i=0; i<materials.length; i++) {
            materials[i].draw();
        }
    }

    boolean positionIsSpecificMaterial(float x, float y, Class type) {
        for (int i=materials.length-1; i!=0; i--) {
            if (materials[i].canAffectFire && materials[i].materialExistsAtPosition(x, y))
                return materials[i].getClass() == type;
        }
        return false;
    }

    boolean positionIsFlammable(float x, float y) {
        for (int i=materials.length-1; i!=0; i--) {
            if (materials[i].flammable && materials[i].materialExistsAtPosition(x, y))
                return materials[i].flammable;
        }
        return false;
    }

    boolean areaIsFlammable(float x, float y, float width, float height) {
        for (int i=materials.length-1; i!=0; i--) {
            if (materials[i].flammable && materials[i].materialExistsWithinArea(x, y, width, height))
                return materials[i].flammable;
        }
        return false;
    }

    class UnrecognizedMaterialException extends RuntimeException {

        UnrecognizedMaterialException(String type) {
            super("Unrecognized material type: '" + type + "'");
        }

    }

}
