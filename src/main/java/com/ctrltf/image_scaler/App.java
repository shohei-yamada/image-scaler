package com.ctrltf.image_scaler;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
			bimage = ImageScaler.changeSize(bimage, 1000, 500);
			ImageIO.write(bimage, "jpg", new File("image/result.jpg"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(fis);
		}


	}
}
