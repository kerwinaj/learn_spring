package com.xyz.learnmsb.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Main00 {
    public static void main(String[] args) {
        Frame f = new Frame();
        f.setSize(800, 600);
        f.setResizable(false);
        f.setTitle("tank war");
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println(e);
                System.exit(0);
            }
        });
    }
}