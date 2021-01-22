package com.xyz.learnmsb.tank;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet {

    private int x=300;
    private int y=300;
    public static int width= ResourceMgr.bulletD.getWidth();
    public static int height= ResourceMgr.bulletD.getHeight();
    Dir dir = Dir.DOWN;
    private final static int SPEED = 10;
    private boolean live = true;
    private TankFrame tf = null;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics graphics) {
        if(!live) {
            tf.bulletList.remove(this);
        }

        Color color = graphics.getColor();
//        graphics.setColor(Color.RED);
//        graphics.fillOval(x, y, width, height);

        BufferedImage bufferedImage = null;
        switch (dir) {
            case LEFT:
                bufferedImage = ResourceMgr.bulletL;
                break;
            case UP:
                bufferedImage = ResourceMgr.bulletU;
                break;
            case RIGHT:
                bufferedImage = ResourceMgr.bulletR;
                break;
            case DOWN:
                bufferedImage = ResourceMgr.bulletD;
                break;
            default:
                break;
        }

        if (null == bufferedImage) {
            System.out.println("[Bullet.paint]bufferedImage is null");
        }
        graphics.drawImage(bufferedImage, x, y, null);

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

        if(x< 0 || y<0 || x> TankFrame.GAME_WIDTH  || y > TankFrame.GAME_HEIGHT) {
           live = false;
        }
    }

    public boolean isLive() {
        return live;
    }

}
