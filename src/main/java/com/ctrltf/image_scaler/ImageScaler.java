package com.ctrltf.image_scaler;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;

public class ImageScaler {

    public static BufferedImage scalingWidth(BufferedImage bimage, int resizeWidth) throws IOException {
    	BigDecimal width = new BigDecimal(bimage.getWidth());
    	BigDecimal height = new BigDecimal(bimage.getHeight());
    	BigDecimal resizeWidthB = new BigDecimal(resizeWidth);
    	BigDecimal resizeHeight = (resizeWidthB.divide(width, 2, BigDecimal.ROUND_HALF_UP)).multiply(height);
    	resizeHeight = resizeHeight.setScale(0, BigDecimal.ROUND_HALF_UP);
    	return scaling(bimage, resizeWidthB.intValue(), resizeHeight.intValue());
    }
    
    public static BufferedImage scalingHeight(BufferedImage bimage, int resizeHeight) throws IOException {
    	BigDecimal width = new BigDecimal(bimage.getWidth());
    	BigDecimal height = new BigDecimal(bimage.getHeight());
    	BigDecimal resizeHeightB = new BigDecimal(resizeHeight);
    	BigDecimal resizeWidth = resizeHeightB.divide(height, 2, BigDecimal.ROUND_HALF_UP).multiply(width);
    	resizeWidth = resizeWidth.setScale(0, BigDecimal.ROUND_HALF_UP);
    	return scaling(bimage, resizeWidth.intValue(), resizeHeightB.intValue());
    }
    
    private static BufferedImage scaling(BufferedImage bimage, int resizeWidth, int resizeHeight) throws IOException {
        BufferedImage buffImage = new BufferedImage(resizeWidth, resizeHeight, bimage.getType());
        buffImage.getGraphics().drawImage(
        		bimage.getScaledInstance(resizeWidth, resizeHeight, Image.SCALE_AREA_AVERAGING),
        		0, 0, resizeWidth, resizeHeight, null
        );
        return buffImage;
        
    }
	
}
