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
				message = "1`��ѡ���ļ����ϴ�"; 
			} else {
			String fileName=myfile.getOriginalFilename();
			String extention = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase(); 
			String allowUpload = "jpg|gif|jpeg|png";  
			//�ļ��ϴ���ʽУ��
			if(allowUpload.indexOf(extention)>=0){
				String originalFilename = UUID.randomUUID().toString();
				if(myfile.getSize()<1024000){
					try {
						// ���ﲻ�ش���IO���رյ�����,��ΪFileUtils.copyInputStreamToFile()�����ڲ����Զ����õ���IO���ص�
						// �˴�Ҳ����ʹ��Spring�ṩ��MultipartFile.transferTo(File
						// dest)����ʵ���ļ����ϴ�
						FileUtils.copyInputStreamToFile(myfile.getInputStream(),
								new File(realPath, originalFilename));
						 //���Ƽ�����realPath + "\\"
						message = "0`" + request.getContextPath() + fileSrc +  originalFilename;  
	 
//						zipImageFile(realPath+"\\"+originalFilename, 360, 340, 1f, "2x"); 
					} catch (IOException e) { 
						//e.printStackTrace();
						message = "1`�ļ��ϴ�ʧ�ܣ������ԣ���"; 
					} 
				}else{
					message = "1`�ļ��ϴ�ʧ�ܣ��ϴ��ļ��Ĵ�С���ó���1M"; 
					
				} 
			  }else{ 
				  message = "1`�ϴ���ʽ��������ĸ�ʽ��"+allowUpload;  
			  }
			} 
		}

		return message;

	}
	
	
	 /**   
     * ѹ��ͼƬ�ļ�<br>   
     * �ȱ���ԭ�ļ�����ѹ�����ϴ�   
     *    
     * @param oldFile   
     *            Ҫ����ѹ�����ļ�ȫ·��   
     * @param width   
     *            ���   
     * @param height   
     *            �߶�   
     * @param quality   
     *            ����   
     * @param smallIcon   
     *            СͼƬ�ĺ�׺   
     * @return ����ѹ������ļ���ȫ·��   
     */    
    public static String zipImageFile(String oldFile, int width, int height,     
            float quality, String smallIcon) {     
        if (oldFile == null) {     
            return null;     
        }     
        String newImage = null;    
    
        try {     
       	
        	/** �Է������ϵ���ʱ�ļ����д��� */    
            Image srcFile = ImageIO.read(new File(oldFile.replaceAll("\\\\", "/")));  
//            int w = srcFile.getWidth(null);  s
//            int h = srcFile.getHeight(null);  
            //width = w/4;  
            //height = h/4;  
              
            /** ��,���趨 */    
            BufferedImage tag = new BufferedImage(width, height,     
                    BufferedImage.TYPE_INT_RGB);     
            tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);     
//            String filePrex = oldFile.substring(0, oldFile.indexOf('.'));     
            /** ѹ������ļ��� */    
            newImage = oldFile + smallIcon     
                    + oldFile.substring(oldFile.length());     
    
            /** ѹ��֮����ʱ���λ�� */    
            FileOutputStream out = new FileOutputStream(newImage);     
    
 
    
            out.close();     
    
        } catch (FileNotFoundException e) {     
            e.printStackTrace();     
        } catch (IIOException e) {
        	System.err.println("���ܶ�ȡ�ļ���");
        	e.printStackTrace();   
        } catch (IOException e) {     
            e.printStackTrace();     
        }     
        return newImage;     
    }     
    
    /**   
     * �����ļ�����������ʱ·��   
     *    
     * @param fileName   
     * @param is   
     * @return �ļ�ȫ·��   
     */    
    public static String writeFile(String fileName, InputStream is) {     
        if (fileName == null || fileName.trim().length() == 0) {     
            return null;     
        }     
        try {     
            /** ���ȱ��浽��ʱ�ļ� */    
            FileOutputStream fos = new FileOutputStream(fileName);     
            byte[] readBytes = new byte[512];// �����С     
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
