package com.xyz.learnmsb.tank;

public class Main01 {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        for (int i = 0; i < 5; i++) {
            tankFrame.tankList.add(new Tank(50 + 80*i, 200, Dir.DOWN, tankFrame));
        }

        while(true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
