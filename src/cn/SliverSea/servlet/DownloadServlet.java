package cn.SliverSea.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//        String path = request.getServletContext().getRealPath("files/wtu.docx");
//        String filename = path.substring(path.lastIndexOf("\\")+1);
//        response.setHeader("content-disposition","attachment;filename="+
//                URLEncoder.encode(filename,"UTF-8"));
//        InputStream inputStream = new FileInputStream(path);
//        int len = 0;
//        byte[] buffer = new byte[1024];
//        ServletOutputStream out = response.getOutputStream();
//        while ((len = inputStream.read(buffer)) != -1){
//            out.write(buffer,0,len);
//        }
//        inputStream.close();
//        out.close();



        //获取要下载文件的名称
        String filename=request.getParameter("filename");//web.xml
        //要下载的文件类型--客户端通过文件的MIME（web。xml）类型区分类型
        response.setContentType(this.getServletContext().getMimeType(filename));
        //告诉客户端改文件不是直接解析 而是以附件形式打开（下载）
        response.setHeader("Content-Disposition", "attachment;filename="+filename);
        //获取文件的绝对路径
        String path=this.getServletContext().getRealPath("files/"+filename);
        //获取该文件的输入流
        InputStream in=new FileInputStream(path);
        //获得输出流--通过response获得的输出流用于客户端写内容
        ServletOutputStream out=response.getOutputStream();
        //文件拷贝的末班代码
        int len=0;
        byte[] buffer=new byte[1024];
        while((len=in.read(buffer))!=-1){
            out.write(buffer,0,len);
        }

        in.close();
        out.close();
    }
}
