package logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

class Validator {
    private static final int MINWIDTH=492;
    private static final int MINHEIGHT=610;
    private static final int MAXSIZE=2500; //kB

    boolean validate(String imagePath){
        try{
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            final double imageSize = convertToKB(imageFile.length());
            System.out.println("Width: " + image.getWidth());
            System.out.println("Height: " + image.getHeight());
            System.out.println("Size: " + imageSize + "kB");
            if(image.getWidth()<MINWIDTH || image.getHeight()<MINHEIGHT || imageSize>MAXSIZE) throw new RuntimeException("Invalid img");
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    private double convertToKB(long fileSize){
        return fileSize/1024;
    }
}
