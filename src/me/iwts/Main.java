package me.iwts;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main{
	//�β���ԭͼƬ��·��
	public static void creat(String imagePath) throws IOException{
		//���ݻҶȻ��ֵĵȼ��������ҴӸ߻Ҷȵ��ͻҶ�
		String string = "M#X&$D*o!; ";
		BufferedImage image = ImageIO.read(new File(imagePath));
		/*
		 * ˫��forѭ�������Ҵ��ϵ���ɨ��ͼ���ȡRGB��ֵ
		 * forѭ����x��yֵ�ı仯�������ַ�ͼ�εĴ�С�йأ�
		 * ��ֵԽ������ͼ��Խ��
		 */
		for(int y = 0;y < image.getHeight();y += 4){
			for(int x = 0;x < image.getWidth();x += 4){
				int rgb = image.getRGB(x,y);
				/*
				 * �����������ҵ�RGBֵ�ֱ����������㷨�������˼
				 * ����ת��Ȼ�����������λ�ƣ������ƶ���λ������
				 * 3��ֵ�ֱ��������
				 */
				int r = (rgb & 0xff0000) >> 16;
				int g = (rgb & 0xff00) >> 8;
				int b = rgb & 0xff;
				//grayValue�õ��㷨������ѧ�Ҷ��㷨��ѡ������㷨˽��Ϊ�ȽϺ��ã�
				float grayValue = 0.299f*r + 0.578f*g + 0.114f*b;
				//index�ǽ��ҶȽ��зּ������ڻҶ�ֵ�ķ�ΧΪ0~255�����Գ��ַ������Ⱥ����255
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