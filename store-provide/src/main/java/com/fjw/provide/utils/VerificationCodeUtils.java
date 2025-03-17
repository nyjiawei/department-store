package com.fjw.provide.utils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码图片生成工具
 * @author jiawei
 */

public class VerificationCodeUtils {
	private static final long serialVersionUID =  -479885884254942306L; 
	public static final char[] CHARS = { '0','1','2', '3', '4', '5', '6', '7', '8',  
            '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',  
            'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };  
	public static Random random = new Random();

    private VerificationCodeUtils(){

    }
	
	public static String getRandomString() {
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<5;i++) {
			buffer.append(CHARS[random.nextInt(CHARS.length)]);
		}
		return buffer.toString();
	}
	
	
	public static Color getRandomColor() {
		 return new Color(random.nextInt(255), random.nextInt(255), random  
	                .nextInt(255)); 
	}
	
	public static Color getReverseColor(Color c) {  
        return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c  
                .getBlue());  
    }

    /**
     * 输出验证码
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public static void write(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("image/jpeg");  
        String randomString = getRandomString(); 
        String ip = HttpUtils.getIpAddress(request);
        //以请求IP地址作为key存入session
        request.getSession().setAttribute(ip, randomString);
        int width = 90;  
        int height = 30;
        Color color = getRandomColor();  
        Color reverse = getReverseColor(color);
        BufferedImage bi = new BufferedImage(width, height,  
                BufferedImage.TYPE_INT_RGB);  
        Graphics2D g = bi.createGraphics();  
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));  
        g.setColor(color);  
        g.fillRect(0, 0, width, height);  
        g.setColor(reverse);  
        g.drawString(randomString, 18, 20);  
        for (int i = 0, n = random.nextInt(100); i < n; i++) {  
            g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);  
        }  
    
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi,"JPEG", out);
    }  

}
