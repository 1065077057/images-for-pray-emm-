package me.iwts;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main{
	//形参是原图片的路径
	public static void creat(String imagePath) throws IOException{
		//根据灰度划分的等级，从左到右从高灰度到低灰度
		String string = "M#X&$D*o!; ";
		BufferedImage image = ImageIO.read(new File(imagePath));
		/*
		 * 双重for循环从左到右从上到下扫描图像获取RGB数值
		 * for循环中x、y值的变化与生成字符图形的大小有关，
		 * 数值越大生成图像越大
		 */
		for(int y = 0;y < image.getHeight();y += 4){
			for(int x = 0;x < image.getWidth();x += 4){
				int rgb = image.getRGB(x,y);
				/*
				 * 以下是网上找的RGB值分别计算出来的算法，大概意思
				 * 是先转换然后与计算后进行位移，根据移动的位数来将
				 * 3个值分别算出来。
				 */
				int r = (rgb & 0xff0000) >> 16;
				int g = (rgb & 0xff00) >> 8;
				int b = rgb & 0xff;
				//grayValue用的算法是心理学灰度算法（选择这个算法私以为比较好用）
				float grayValue = 0.299f*r + 0.578f*g + 0.114f*b;
				//index是将灰度进行分级，由于灰度值的范围为0~255，所以乘字符串长度后除以255
				int index = Math.round((grayValue*string.length())/255);
				System.out.print(index >= string.length() ? " " : String.valueOf(string.charAt(index)));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException{
		Main.creat("src\\me\\iwts\\test.jpg");
	}
}