package com.mycompany.drawlinesswing;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

class ControlsPanel extends JPanel implements ActionListener {
    
    public ColorsPanel colorsPanel;
    private Global global;
    
    public ControlsPanel(Global global) {
        super();
        
        this.global = global;
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        colorsPanel = new ColorsPanel(global);
        
        Button clearButton = new Button("Clear");
        clearButton.addActionListener(this);
        clearButton.setFont(Global.bigFont);
        
        add(colorsPanel);
        add(clearButton);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        global.frame.clearDrawing();
    }

}
