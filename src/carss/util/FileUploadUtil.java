package carss.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;
 

public class FileUploadUtil {

	public static String upload(MultipartFile[] myfiles, String fileSrc,String realPath,
			HttpServletRequest request) throws Exception {
		String message = "";
		for (MultipartFile myfile : myfiles) {
			if (myfile.isEmpty()) {
				message = "1`请选择文件后上传"; 
			} else {
			String fileName=myfile.getOriginalFilename();
			String extention = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase(); 
			String allowUpload = "jpg|gif|jpeg|png";  
			//文件上传格式校验
			if(allowUpload.indexOf(extention)>=0){
				String originalFilename = UUID.randomUUID().toString();
				if(myfile.getSize()<1024000){
					try {
						// 这里不必处理IO流关闭的问题,因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
						// 此处也可以使用Spring提供的MultipartFile.transferTo(File
						// dest)方法实现文件的上传
						FileUtils.copyInputStreamToFile(myfile.getInputStream(),
								new File(realPath, originalFilename));
						 //不推荐返回realPath + "\\"
						message = "0`" + request.getContextPath() + fileSrc +  originalFilename;  
	 
//						zipImageFile(realPath+"\\"+originalFilename, 360, 340, 1f, "2x"); 
					} catch (IOException e) { 
						//e.printStackTrace();
						message = "1`文件上传失败，请重试！！"; 
					} 
				}else{
					message = "1`文件上传失败，上传文件的大小不得超过1M"; 
					
				} 
			  }else{ 
				  message = "1`上传格式有误，允许的格式："+allowUpload;  
			  }
			} 
		}

		return message;

	}
	
	
	 /**   
     * 压缩图片文件<br>   
     * 先保存原文件，再压缩、上传   
     *    
     * @param oldFile   
     *            要进行压缩的文件全路径   
     * @param width   
     *            宽度   
     * @param height   
     *            高度   
     * @param quality   
     *            质量   
     * @param smallIcon   
     *            小图片的后缀   
     * @return 返回压缩后的文件的全路径   
     */    
    public static String zipImageFile(String oldFile, int width, int height,     
            float quality, String smallIcon) {     
        if (oldFile == null) {     
            return null;     
        }     
        String newImage = null;    
    
        try {     
       	
        	/** 对服务器上的临时文件进行处理 */    
            Image srcFile = ImageIO.read(new File(oldFile.replaceAll("\\\\", "/")));  
//            int w = srcFile.getWidth(null);  s
//            int h = srcFile.getHeight(null);  
            //width = w/4;  
            //height = h/4;  
              
            /** 宽,高设定 */    
            BufferedImage tag = new BufferedImage(width, height,     
                    BufferedImage.TYPE_INT_RGB);     
            tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);     
//            String filePrex = oldFile.substring(0, oldFile.indexOf('.'));     
            /** 压缩后的文件名 */    
            newImage = oldFile + smallIcon     
                    + oldFile.substring(oldFile.length());     
    
            /** 压缩之后临时存放位置 */    
            FileOutputStream out = new FileOutputStream(newImage);     
    
 
    
            out.close();     
    
        } catch (FileNotFoundException e) {     
            e.printStackTrace();     
        } catch (IIOException e) {
        	System.err.println("不能读取文件！");
        	e.printStackTrace();   
        } catch (IOException e) {     
            e.printStackTrace();     
        }     
        return newImage;     
    }     
    
    /**   
     * 保存文件到服务器临时路径   
     *    
     * @param fileName   
     * @param is   
     * @return 文件全路径   
     */    
    public static String writeFile(String fileName, InputStream is) {     
        if (fileName == null || fileName.trim().length() == 0) {     
            return null;     
        }     
        try {     
            /** 首先保存到临时文件 */    
            FileOutputStream fos = new FileOutputStream(fileName);     
            byte[] readBytes = new byte[512];// 缓冲大小     
            int readed = 0;     
            while ((readed = is.read(readBytes)) > 0) {     
                fos.write(readBytes, 0, readed);     
            }     
            fos.close();     
            is.close();     
        } catch (FileNotFoundException e) {     
            e.printStackTrace();     
        } catch (IOException e) {     
            e.printStackTrace();     
        }     
        return fileName;     
    }     
    
   
    

}
