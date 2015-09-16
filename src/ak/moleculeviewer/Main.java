package ak.moleculeviewer;

import ak.moleculeviewer.chemistry.ChemHelper;
import ak.moleculeviewer.render.RenderApplet;
import ak.moleculeviewer.render.RenderFrame;
import processing.core.PApplet;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
/**
 * Created by Aleksander Kaminski {theinfamouspig@gmail.com} on 11/09/2015.
 */
public class Main {
    private static JTextField textField;
    public static void main(String[] args){

        RenderFrame appletFrame = new RenderFrame("Render Applet");
        appletFrame.setSize(600,600);
        appletFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        PApplet renderApplet = new RenderApplet(600, 600, false);
        appletFrame.add(renderApplet);
        renderApplet.init();
        renderApplet.noLoop();
        appletFrame.setVisible(false);



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
                        enderApplet.loop();
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

