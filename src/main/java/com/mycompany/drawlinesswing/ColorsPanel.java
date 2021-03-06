package com.mycompany.drawlinesswing;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class ColorsPanel extends JPanel implements ActionListener {

    Color[] colors = {
        Color.black,
        Color.red,
        Color.decode("#FF595E"),
        Color.magenta,
        Color.decode("#FFCA3A"),
        Color.yellow,
        Color.green,
        Color.decode("#8AC926"),
        Color.cyan,
        Color.blue,
        Color.decode("#1982C4"),
        Color.decode("#6A4C93"),
    };
    
    Global global;
    
    public ColorsPanel(Global global) {
        
        super();
        
        this.global = global;
        
        setLayout(new GridLayout(3, 4));
        
        for (int i = 0; i < colors.length; i++) {
            Button b = new Button();
            b.setPreferredSize(new Dimension(30, 30));
            b.addActionListener(this);
            b.setActionCommand(Integer.toString(i));
            b.setBackground(colors[i]);
            add(b);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int colorIndex = Integer.valueOf(ae.getActionCommand());
        global.frame.changeColor(colors[colorIndex]);
    }
}
