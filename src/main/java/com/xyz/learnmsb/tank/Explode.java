package com.xyz.learnmsb.tank;

import java.awt.*;

public class Explode {

    int x, y;
    private TankFrame tf = null;
    public static int width= ResourceMgr.explodes[0].getWidth();
    public static int height= ResourceMgr.explodes[0].getHeight();
    private boolean living = true;

    private int step = 0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics graphics) {
        graphics.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length) {
            step=0;
        }
    }

}
