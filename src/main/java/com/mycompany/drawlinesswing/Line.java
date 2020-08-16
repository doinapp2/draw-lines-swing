package com.mycompany.drawlinesswing;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Line {

    ArrayList<Point> points;
    Color color;

    public Line() {
        this.points = new ArrayList<>();
        this.color = Color.BLACK;
    }

    public Line(Color color) {
        this.points = new ArrayList<>();
        this.color = color;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public void add(Point p) {
        points.add(p);
    }

    public Point get(int index) {
        return points.get(index);
    }
    
    public int size() {
        return points.size();
    }
}
