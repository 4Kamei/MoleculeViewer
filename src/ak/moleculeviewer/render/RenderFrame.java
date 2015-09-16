package ak.moleculeviewer.render;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

/**
 * Created by Aleksander Kaminski {theinfamouspig@gmail.com} on 15/09/2015.
 */
public class RenderFrame extends JFrame {

    public RenderFrame(String string){
        super(string);
    }

    //Override the event so that when the applet rendering frame closes it doesn't get destroyed, but the animation stops in order to save CPU power.

    protected void processWindowEvent(WindowEvent e) {
        //call super method in order to hide the window.
        super.processWindowEvent(e);
        if(e.getID() == WindowEvent.WINDOW_CLOSING) {
            //If the close operation is 'Hide On Close' -> it will be for the rendering applet.
            if (super.getDefaultCloseOperation() == WindowConstants.HIDE_ON_CLOSE) {
                System.out.println("Stopping rendering loop");
                //Get the first (and only) component of the frame.
                Component c = this.getContentPane().getComponents()[0];
                //Is c a RenderApplet?
                if(c instanceof RenderApplet){
                    //Cast c to RenderApplet and stop the loop
                    ((RenderApplet) c).noLoop();
                }
            }
        }
    }
}
