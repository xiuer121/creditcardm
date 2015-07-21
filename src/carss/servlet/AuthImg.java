/**
 * @功能 生成随机认证码
 * @作者 许微波
 * @時間 2007-08-06
 */

package carss.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthImg extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private Font mFont=new Font("Times New Roman",Font.BOLD,17);


	//生成圖片输出
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-Control", "no-cache");
		response.setHeader("Expires", "0");
		
		response.setContentType("image/jpeg");
		
		int width=40,height=15;
		
		BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		
		Graphics g=image.getGraphics();
		
		Random random=new Random();
		
		//填充边框
		g.setColor(new Color(16,65,107));
		g.fillRect(1, 1, width-1, height-1);

		//矩形背景色
		g.setColor(new Color(16,65,107));
		g.drawRect(0,0,width-1, height-1);
		
		g.setFont(mFont);
		
		String sRand="";
		
		//写字符
		for(int i=0;i<4;i++){
			int itmp=random.nextInt(10)+48;				//圖片出现的數字编码
			char ctmp=(char)itmp;
			sRand+=String.valueOf(ctmp);
			
			g.setColor(new Color(255,255,255));
			
			g.drawString(String.valueOf(ctmp), 9*i+3,13);
		}
		
		HttpSession session=request.getSession();
		session.setAttribute("validate", sRand);
		
		g.dispose();
		
		ImageIO.write(image,"JPEG",response.getOutputStream());
		
	}

	public void destroy() {
		super.destroy(); 
	}

}
