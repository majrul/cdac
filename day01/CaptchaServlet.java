package com.cdac.training.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CaptchaServlet
 */
@WebServlet("/captcha.jpg")
public class CaptchaServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		
		String captchaText = "";
		for(int i=0; i<5; i++) {
			int rno = (int) (Math.random() * str.length());
			captchaText += str.charAt(rno);
		}
		
		BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		
		g.setColor(Color.RED);
		g.fillRect(0, 0, 100, 100);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Harrington", Font.BOLD, 28));
		g.drawString(captchaText, 20, 50);
		
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		//FileOutputStream f = new FileOutputStream("abc.jpg");
		ImageIO.write(img, "jpeg", out);
		
		
	}

	

}
