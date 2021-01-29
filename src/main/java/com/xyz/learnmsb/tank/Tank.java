package com.xyz.learnmsb.tank;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Tank {
    int x=200, y=200;
    Dir dir = Dir.DOWN;
    private final static int SPEED = 2;
    private boolean moving = true;
    private TankFrame tf = null;
    public static int width= ResourceMgr.tankD.getWidth();
    public static int height= ResourceMgr.tankD.getHeight();
    private boolean living = true;
    private Random random = new Random();
    public Group group;

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
    }

    public void paint(Graphics graphics) {
        if (!living) {
            tf.tankList.remove(this);
        }
        Color color = graphics.getColor();
//        graphics.setColor(Color.YELLOW);
//        graphics.fillRect(x, y, 50, 50);

        BufferedImage bufferedImage = null;
        switch (dir) {
            case LEFT:
                bufferedImage = ResourceMgr.tankL;
                break;
            case UP:
                bufferedImage = ResourceMgr.tankU;
                break;
            case RIGHT:
                bufferedImage = ResourceMgr.tankR;
                break;
            case DOWN:
                bufferedImage = ResourceMgr.tankD;
                break;
            default:
                break;
        }

        if (null == bufferedImage) {
            System.out.println("[Tank.paint]bufferedImage is null");
        }
        graphics.drawImage(bufferedImage, x, y, null);

        graphics.setColor(color);

        move();
    }

    private void move() {
        if(!moving) {
            return;
        }
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

        if (random.nextInt(10) > 5) {
            this.fire();
        }
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void fire() {
        int bX = x + Tank.width/2 - Bullet.width/2;
        int bY = y + Tank.height/2 - Bullet.height/2;
        tf.bulletList.add(new Bullet(bX, bY, dir, this.group, tf));
    }

    public void die() {
        living = false;
    }
}
