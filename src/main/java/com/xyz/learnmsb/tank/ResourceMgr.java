package com.xyz.learnmsb.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ResourceMgr {
    public static BufferedImage tankL, tankU, tankR, tankD;
    public static BufferedImage bulletL, bulletU, bulletR, bulletD;
    static {
        try {
            InputStream inputStream = ResourceMgr.class.getClassLoader().getResourceAsStream("tank/images/tankL.gif");
            assert inputStream != null;
            tankL = ImageIO.read(inputStream);

            inputStream = ResourceMgr.class.getClassLoader().getResourceAsStream("tank/images/tankU.gif");
            assert inputStream != null;
            tankU = ImageIO.read(inputStream);

            inputStream = ResourceMgr.class.getClassLoader().getResourceAsStream("tank/images/tankR.gif");
            assert inputStream != null;
            tankR = ImageIO.read(inputStream);

            inputStream = ResourceMgr.class.getClassLoader().getResourceAsStream("tank/images/tankD.gif");
            assert inputStream != null;
            tankD = ImageIO.read(inputStream);

            inputStream = ResourceMgr.class.getClassLoader().getResourceAsStream("tank/images/bulletL.gif");
            assert inputStream != null;
            bulletL = ImageIO.read(inputStream);

            inputStream = ResourceMgr.class.getClassLoader().getResourceAsStream("tank/images/bulletU.gif");
            assert inputStream != null;
            bulletU = ImageIO.read(inputStream);

            inputStream = ResourceMgr.class.getClassLoader().getResourceAsStream("tank/images/bulletR.gif");
            assert inputStream != null;
            bulletR = ImageIO.read(inputStream);

            inputStream = ResourceMgr.class.getClassLoader().getResourceAsStream("tank/images/bulletD.gif");
            assert inputStream != null;
            bulletD = ImageIO.read(inputStream);
        } catch (IOException e) {
            System.out.println("error in read gif");
            e.printStackTrace();
        }
    }
}
