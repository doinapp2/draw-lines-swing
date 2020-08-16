package com.mycompany.drawlinesswing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

class DrawPanel extends JPanel {

    Color currentColor;
    List<Line> lines;
    int pointSize = 10;
    Global global;

    public DrawPanel(Global global) {
        lines = new ArrayList<>();
        lines.add(new Line());
        
        this.global =  global;
    }
    
    private Line getCurrentLine() {
        return lines.get(lines.size() - 1);
    }

    public void addPoint(Point p) {
        Line currentLine = getCurrentLine();
        currentLine.add(p);
    }
    
    public void newLine() {
        lines.add(new Line(currentColor));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));

        for (Line line : lines) {

            // draw the line
            g2d.setColor(line.color);
            for (int j = 1; j < line.size(); j++) {
                Point from = line.get(j - 1);
                Point to = line.get(j);
                g2d.drawLine(from.x, from.y, to.x, to.y);
            }
            
            // show points as squares
            // g2d.setColor(Color.BLUE);
            for (Point p : line.points) {
                //// square point
                //g2d.fillRect(p.x - pointSize / 2, p.y - pointSize / 2, pointSize, pointSize);
                
                // circle point
                g2d.fillOval(p.x - pointSize / 3, p.y - pointSize / 3, pointSize, pointSize);
            }
            
        }
    }

    void setColor(Color c) {
        currentColor = c;
        getCurrentLine().color = c;
    }

    void clear() {
        lines = new ArrayList<>();
        lines.add(new Line());
        repaint();
    }
    
}
