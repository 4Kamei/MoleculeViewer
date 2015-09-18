package ak.moleculeviewer.render;

import processing.core.PApplet;


/**
 * Created by Aleksander Kaminski {theinfamouspig@gmail.com} on 11/09/2015.
 */
public class RenderApplet extends PApplet {
    int w;
    int h;
    public RenderApplet(int width, int height, boolean looping) {
        this.w = width;
        this.h = height;
        if (!looping) {
            noLoop();
        }
    }

    public void setup() {
        size(w, h);
        background(0);
        noStroke();
    }

    public void mousePressed() {

    }

    public void mouseReleased() {
        noLoop();
    }

    public void draw() {
        int r, g, b, a;
        r = (int) (Math.random() * 255);
        g = (int) (Math.random() * 255);
        b = (int) (Math.random() * 255);
        a = 7;
        fill(a << 24 | r << 16 | g << 8 | b);
        ellipseMode(CENTER);
        for (int i = 0; i < 30; i++) {
            int rand = (int) (Math.random() * 10);
            ellipse((int) (Math.random() * width), (int) (Math.random() * height),1, 1000);
        }


    }

    public final Object methodReturningNull() {
        return null;
    }

}
