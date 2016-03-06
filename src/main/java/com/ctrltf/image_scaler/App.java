package com.ctrltf.image_scaler;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;

public class App 
{
    public static void main( String[] args )
    {
    	FileInputStream fis = null;
    	try {
			fis = new FileInputStream("image/sample.jpg");
			BufferedImage bimage = ImageIO.read(fis);
			bimage = ImageScaler.scalingWidth(bimage, 200);
			FileOutputStream fout = new FileOutputStream("image/result.jpg");
			ImageIO.write(bimage, "jpeg", fout);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(fis);
		}
    	
    	
    }
}
