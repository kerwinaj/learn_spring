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
    private boolean living = true;
    private TankFrame tf = null;
    private Group group;

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics graphics) {
        if(!living) {
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
           living = false;
        }
    }

    public boolean isLiving() {
        return living;
    }

    public void die() {
        this.living = false;
    }

    public void collideWith(Tank tank) {
        if (this.group == tank.group) {
            return;
        }
        Rectangle rect1 = new Rectangle(this.x, this.y, Bullet.width, Bullet.height);
        Rectangle rect2 = new Rectangle(tank.x, tank.y, Tank.width, Tank.height);
        if (rect1.intersects(rect2)) {
            this.die();
            tank.die();

            tf.explodeList.add(new Explode(x, y, tf));
        }
    }
}
