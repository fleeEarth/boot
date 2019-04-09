package com.springtest.boot.utils;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;
import java.util.Random;

/**
 * @Author: zh
 * @Date: 2019/4/8 11:34
 *
 * 验证码工具类
 */
public class CheckCodeUtil {

	//矩形宽
	private final static Integer WIDTH = 100;
	//矩形高
	private final static Integer HEIGHT = 30;
	//字体大小
	private final static Integer FONTSIZE  = 18;
	//干扰线数量
	private final static Integer LINENUMBER = 10;
	//sessoin中验证码对应Name
	private final static String CODE = "checkCode";

	public static BufferedImage drawCode(HttpServletRequest request){

		BufferedImage img = new BufferedImage(WIDTH, HEIGHT,  BufferedImage.TYPE_INT_RGB);
		Graphics g = img.createGraphics();
		g.setColor(Color.white);
		g.fillRect(0,0,WIDTH,HEIGHT);
		g.setFont(new Font("微软雅黑",Font.PLAIN,FONTSIZE));
		g.setColor(Color.RED);
		SecureRandom random = new SecureRandom();
		int r1 = random.nextInt(9);
		g.drawString(r1+"",10,22);
		int r2 = random.nextInt(9);
		g.setColor(Color.BLUE);
		g.drawString(r2+"",30,18);
		int r3 = random.nextInt(9);
		g.setColor(Color.GREEN);
		g.drawString(r3+"",50,21);
		int r4 = random.nextInt(9);
		g.setColor(Color.MAGENTA);
		g.drawString(r4+"",70,23);
		String  codeStr = "";
		codeStr+=r1;
		codeStr+=r2;
		codeStr+=r3;
		codeStr+=r4;
		request.getSession().setAttribute(CODE,codeStr);
		Random r = new Random();
		for (int i = 0; i < LINENUMBER; i++) {
			int x = r.nextInt(WIDTH);
			int x2 = r.nextInt(WIDTH);
			int y = r.nextInt(HEIGHT);
			int y2 = r.nextInt(HEIGHT);

			int c1 = r.nextInt(255);
			int c2 = r.nextInt(255);
			int c3 = r.nextInt(255);
			g.setColor(new Color(c1,c2,c3));
			g.drawLine(x,y,x2,y2);
		}
		return img;
	}


}
