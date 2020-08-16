package com.mycompany.drawlinesswing;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

class ControlsPanel extends JPanel implements ActionListener {
    
    public ColorsPanel colorsPanel;
    private Glue glue;
    
    public ControlsPanel(Glue glue) {
        super();
        
        this.glue = glue;
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        colorsPanel = new ColorsPanel(glue);
        
        Button clearButton = new Button("Clear");
        clearButton.addActionListener(this);
        
        add(colorsPanel);
        add(clearButton);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        glue.frame.clearDrawing();
    }

}
