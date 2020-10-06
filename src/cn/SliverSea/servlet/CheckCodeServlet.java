package cn.SliverSea.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;


public class CheckCodeServlet extends HttpServlet {

    private Font getFont(){
        Random random=new Random();
        Font font[]=new Font[5];
        font[0]=new Font("Ravie",Font.PLAIN,24);
        font[1]=new Font("Antique Olive Compact",Font.PLAIN,24);
        font[2]=new Font("Forte",Font.PLAIN,24);
        font[3]=new Font("Wide Latin",Font.PLAIN,24);
        font[4]=new Font("Gill Sans Ultra Bold",Font.PLAIN,24);
        return font[random.nextInt(5)];
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("image/jpeg");
        OutputStream os= response.getOutputStream();
        int width=83,height=30;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Color c=g.getColor();
        g.fillRect(0,0,width,height);
        char[] ch="abcdefghijklmnopqrstuvwxyz2345678901".toCharArray();
        int length=ch.length;
        String sRand="";
        Random random=new Random();
        for (int i =0;i<4;i++){
            g.setFont(getFont());
            String rand=new Character(ch[random.nextInt(length)]).toString();
            sRand +=rand;
            g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
            g.drawString(rand,20*i+6,25);
        }
        for (int i =0;i<20;i++){
            int x1=random.nextInt(width);
            int y1=random.nextInt(height);
            g.drawOval(x1,y1,2,2);
        }
        g.setColor(c);
        g.dispose();;
        request.getSession().setAttribute("safecode",sRand);
        ImageIO.write(image,"JPEG",os);
    }

}
