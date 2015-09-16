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

    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if(e.getID() == WindowEvent.WINDOW_CLOSING) {
            if (super.getDefaultCloseOperation() == WindowConstants.HIDE_ON_CLOSE) {
                System.out.println("Stopping rendering loop");
                Component c = this.getContentPane().getComponents()[0];
                if(c instanceof RenderApplet){
                    ((RenderApplet) c).noLoop();
                }
            }
        }
    }
}
