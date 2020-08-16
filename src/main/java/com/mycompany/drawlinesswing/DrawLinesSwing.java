package com.mycompany.drawlinesswing;

public class DrawLinesSwing {

    public static void main(String[] args) {
        JMouseActionFrame mFrame = new JMouseActionFrame();
        final int WIDTH = 750;
        final int HEIGHT = 300;
        mFrame.setSize(WIDTH, HEIGHT);
        mFrame.setVisible(true);
        mFrame.setTitle("Draw Lines with Swing");
    }
}
