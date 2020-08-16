package com.mycompany.drawlinesswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.LineBorder;

public class JMouseActionFrame extends JFrame implements MouseListener {

    public static Font bigFont = new Font("Arial", Font.BOLD, 20);
    private int x, y;
    private final DrawPanel panel = new DrawPanel();
    private final JLabel label = new JLabel("Do something with the mouse");
    String msg = "";

    class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    class DrawPanel extends JPanel {

        ArrayList<Point> points;
        int pointSize = 10;

        public DrawPanel() {
            points = new ArrayList<>();
//            int w = 750;
//            int h = 300;
//            for (int i = 0; i < 300; i++) {
//                points.add(new Point((int) (Math.random() * w), (int) (Math.random() * h)));
//            }
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(2));
            for (int i = 1; i < points.size(); i++) {
                Point from = points.get(i - 1);
                Point to = points.get(i);
               g2d.drawLine(from.x, from.y, to.x, to.y);
               //g2d.drawOval(from.x, from.y, to.x, to.y);
            }
            g2d.setColor(Color.BLUE);
            for (Point p : points) {
                g2d.fillRect(p.x - pointSize / 2, p.y - pointSize / 2, pointSize, pointSize);
            }
        }
    }

    public JMouseActionFrame() {
        setTitle("Mouse Actions");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label.setFont(bigFont);

        setLayout(new BorderLayout());
        addMouseListener(this);

        add(label, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        panel.setBorder(new LineBorder(Color.BLACK));
        panel.setBackground(Color.WHITE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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

        msg += " You are at position "
                + e.getX() + ", " + e.getY() + ".";
        panel.points.add(new Point(e.getXOnScreen() - panel.getX() - getInsets().left, e.getYOnScreen() - panel.getY() - getInsets().top));
        panel.repaint();

        if (e.getClickCount() == 2) {
            msg += " You double-clicked.";
        } else {
            msg += " You single-clicked.";
        }
        label.setText(msg);
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
