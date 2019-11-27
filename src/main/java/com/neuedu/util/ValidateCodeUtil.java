package com.neuedu.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class ValidateCodeUtil {
	static Random ran = new Random();
	/**
	 * 生成一张图片，写到指定的输出流位置
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static String getNewCode(OutputStream out) throws FileNotFoundException, IOException{
		int width = 120;
		int height = 50;
		//在内存中制作一张图片
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//绘画这张图片
		//拿到画笔
		Graphics g = image.getGraphics();
		//把底色变成灰色
		g.setColor(Color.GRAY);
		//设置图片位置
		g.fillRect(0, 0, width, height);
		//写字
		String number = "";
		for(int i = 1;i<5;i++){
			int k = ran.nextInt(10);
			number += k;
		}
		g.setColor(Color.BLACK);
		//字体
		g.setFont(new Font("黑体",Font.ITALIC,35));
		g.drawString(number, 20, 40);
		//写随机干扰线
		for(int i = 0;i<30;i++){
			int x1 = ran.nextInt(width);
			int x2 = ran.nextInt(width);
			int y1 = ran.nextInt(height);
			int y2 = ran.nextInt(height);
			Color color = getRandomColor();
			g.setColor(color);
			g.drawLine(x1, y1, x2, y2);
		}
		//把图片写到硬盘
		ImageIO.write(image, "png", out);
		return number;
	}
	private static Color getRandomColor() {
		// TODO Auto-generated method stub
		int b = ran.nextInt(256);
		int r = ran.nextInt(256);
		int g = ran.nextInt(256);
		Color color = new Color(r,g,b);
		return color;
	}
	

}
