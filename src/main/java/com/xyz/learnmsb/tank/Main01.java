package com.xyz.learnmsb.tank;

public class Main01 {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        while(true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
