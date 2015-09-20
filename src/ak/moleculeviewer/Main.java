package ak.moleculeviewer;

import ak.api.moleculeviewer.*;
import ak.moleculeviewer.render.RenderApplet;
import ak.moleculeviewer.render.RenderFrame;
import org.lwjgl.Sys;
import processing.core.PApplet;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aleksander Kaminski {theinfamouspig@gmail.com} on 11/09/2015.
 */
public class Main {

    private static JTextField textField;

    public static void main(String[] args) {
        Atom root = new Atom(AtomType.CARBON);
        Molecule molecule = new Molecule(root);
        ArrayList<Atom> chain = new ArrayList<>();
        chain.add(new Atom(AtomType.CARBON));
        molecule.addBond(root, chain.get(0), BondType.SINGLE);
        chain.add(new Atom(AtomType.CARBON));
        molecule.addBond(chain.get(0), chain.get(1), BondType.SINGLE);
        chain.add(new Atom(AtomType.CARBON));
        molecule.addBond(chain.get(1), chain.get(2), BondType.SINGLE);
    }

    public static void run() {

            //Create 'rendering' applet, using RenderFrame as I needed to override the action when the window closes to include stopping the applet

            RenderFrame appletFrame = new RenderFrame("Render Applet");
            appletFrame.setSize(800,200);
            appletFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            PApplet renderApplet = new RenderApplet(800, 200, false);
            appletFrame.setResizable(false);
            appletFrame.add(renderApplet);
            renderApplet.init();
            renderApplet.noLoop();
            appletFrame.setVisible(false);

            //Create 'main' applet.
            System.out.println("Hello World");
            JFrame mainFrame = new JFrame("Molecule Viewer");
            mainFrame.setSize(400,500);
            mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            mainFrame.setResizable(false);
            mainFrame.setVisible(true);
            mainFrame.setLayout(new GridLayout(2,2));

            JPanel contentPanel = new JPanel();
            JButton mainButton = new JButton("Display Chemical ");
            mainButton.addActionListener(e -> {
                        /*
                            renderApplet.loop();
                            appletFrame.setVisible(true);
                        */
                    }
            );

            textField = new JTextField("");
            textField.setToolTipText("Chemical Display Formula Here");
            textField.setPreferredSize(new Dimension(100, (int) textField.getPreferredSize().getHeight()));

            contentPanel.add(mainButton);
            contentPanel.add(textField);

            Border inset = BorderFactory.createEmptyBorder(10,10,10,10);
            contentPanel.setBorder(inset);


            mainFrame.add(contentPanel);
            mainFrame.pack();

        }

}

