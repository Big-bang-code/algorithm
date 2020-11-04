package MyTest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DrawPicture {

	public static void main(String[] args) {
		System.out.println("fd");
		DrawPicture.createAsciiPic("C:\\Users\\54167\\Desktop\\个人资料\\tu\\timg.jpg");
	}

	public static void createAsciiPic(final String path) {
		
		final String base = "@#&$%*o!;.";// 字符串由复杂到简单
		
		try {
			BufferedImage image = ImageIO.read(new File(path));
			for (int y = 0; y < image.getHeight(); y += 8) {           
				for (int x = 0; x < image.getWidth(); x+=4) {
					final int pixel = image.getRGB(x, y);
					final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
					final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
					final int index = Math.round(gray * (base.length() + 1) / 255);
					System.out.print(index >= base.length() ? " " : String.valueOf(base.charAt(index)));
				}
				System.out.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
