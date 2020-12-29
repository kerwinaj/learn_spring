package com.xyz.learnmsb.tank;

import java.awt.*;

public class Bullet {

    private int x=300;
    private int y=300;
    private int width=20;
    private int heigh=20;
    Dir dir = Dir.DOWN;
    private final static int SPEED = 1;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics graphics) {
        Color color = graphics.getColor();
        graphics.setColor(Color.RED);
        graphics.fillOval(x, y, width, heigh);
        graphics.setColor(color);

        move();
    }

    void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
    }
}