package com.mycompany.drawlinesswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class Frame extends JFrame implements MouseListener {

    private ControlsPanel controls;
    private DrawPanel drawPanel;
    private Global global;

    private final JLabel label = new JLabel("Do something with the mouse");
    String msg = "";

    public Frame() {
        setTitle("Mouse Actions");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label.setFont(Global.bigFont);

        setLayout(new BorderLayout());
        addMouseListener(this);

        global = new Global(this);
        controls = new ControlsPanel(global);
        drawPanel = new DrawPanel(global);

        add(label, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
        add(controls, BorderLayout.WEST);

        drawPanel.setBorder(new LineBorder(Color.BLACK));
        drawPanel.setBackground(Color.decode("#fdfcfc"));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int whichButton = e.getButton();
        msg = "You pressed the ";

        switch (whichButton) {
            case MouseEvent.BUTTON1:
                msg += "button 1.";
                break;
            case MouseEvent.BUTTON2:
                msg += "button 2.";
                break;
            case MouseEvent.BUTTON3:
                msg += "button 3.";
                break;
        }

        msg += " You are at position " + e.getX() + ", " + e.getY() + ".";

        if (whichButton == MouseEvent.BUTTON1) {
            /* left click => add a point */

            SwingUtilities.convertPointFromScreen(e.getPoint(), drawPanel);

            int pointX = e.getX() - getInsets().left - drawPanel.getX();
            int pointY = e.getY() - getInsets().top - drawPanel.getY();

            drawPanel.addPoint(new Point(pointX, pointY));
            drawPanel.repaint();

        } else if (whichButton == MouseEvent.BUTTON3) {
            /* right click -> start a new line */

            drawPanel.newLine();
        }

        if (e.getClickCount() == 2) {
            msg += " You double-clicked.";
        } else {
            msg += " You single-clicked.";
        }
        label.setText(msg);
    }
    
    public void changeColor(Color c) {
        drawPanel.setColor(c);
        drawPanel.repaint();
    }
    
    public void clearDrawing() {
        drawPanel.clear();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        msg = "You entered the frame.";
        label.setText(msg);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        label.setText("You exited the frame.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
    
}
