package ak.moleculeviewer.render;

import processing.core.PApplet;

import java.awt.*;


/**
 * Created by Aleksander Kaminski {theinfamouspig@gmail.com} on 11/09/2015.
 */
public class RenderApplet extends PApplet{
    int w;
    int h;
    public RenderApplet(int width, int height, boolean looping){
        this.w = width;
        this.h = height;
        if(!looping){
            noLoop();
        }
    }

    public void setup() {
        size(w, h);
        background(0);
    }
    public void draw() {
        background(0);
        fill(200);
        ellipseMode(CENTER);
        ellipse(mouseX,mouseY,40,40);
    }

    public final Object methodReturningNull(){
        return null;
    }

}
