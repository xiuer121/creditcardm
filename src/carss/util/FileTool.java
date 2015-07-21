package carss.util;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;


public class FileTool {

	/**
	 * @���� �����ƷͼƬ
	 */
	public String saveProductImg(File file,String fileFileName){

		String ext = fileFileName.substring(fileFileName.lastIndexOf('.')+1).toLowerCase();		//ͼƬ��׺��
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
        String dir=dateformat.format(new Date());
    	String originalFilename = UUID.randomUUID().toString();
		String fileName = originalFilename+"."+ext;						//���ļ���
		String pathdir = "/upload/"+ dir;				//�����ļ���
		
		//����
		String realpathdir = ServletActionContext.getServletContext().getRealPath(pathdir);	//����·��
		File savedir = new File(realpathdir);
		if(!savedir.exists()) savedir.mkdirs();		//���Ŀ¼�����ھ��½�
		File filePro=new File(realpathdir, fileName);
		try {
			FileUtils.copyFile(file,filePro);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pathdir+"/"+fileName;
	}
	/**
	 * @���� �������ͼƬ
	 */
	public String saveImg(String fileFileName , File file) throws IOException{
		
		//��׺��
		String ext = fileFileName.substring(fileFileName.lastIndexOf('.')+1).toLowerCase();

		String fileName = UUID.randomUUID().toString()+"."+ext;			//���ļ���
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
		String pathdir = "/data/"+ dateformat.format(new Date());//�����ļ���
		
		//����
		String realpathdir = ServletActionContext.getServletContext().getRealPath(pathdir);	//����·��
		File savedir = new File(realpathdir);
		if(!savedir.exists()) savedir.mkdirs();		//���Ŀ¼�����ھ��½�
		File filePro=new File(realpathdir, fileName);
		FileUtils.copyFile(file,filePro);
		
		return pathdir+"/"+fileName;
	}
	
	/**
	 * @���� ���湫�渽��
	 */
	public String saveNoticeFile(File file) throws IOException{

		String fileName = UUID.randomUUID().toString();							//���ļ���
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
		String pathdir = "/data/notice/"+ dateformat.format(new Date());		//�����ļ���
		
		//����
		String realpathdir = ServletActionContext.getServletContext().getRealPath(pathdir);	//����·��
		File savedir = new File(realpathdir);
		if(!savedir.exists()) savedir.mkdirs();		//���Ŀ¼�����ھ��½�
		File filePro=new File(realpathdir, fileName);
		FileUtils.copyFile(file,filePro);
		
		return pathdir+"/"+fileName;
	}
	
	/**
	 * @���� ��������
	 */
	public String saveData(File file) throws IOException{

		String fileName = UUID.randomUUID().toString();							//���ļ���
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
		String pathdir = "/data/data/"+ dateformat.format(new Date());			//�����ļ���
		
		//����
		String realpathdir = ServletActionContext.getServletContext().getRealPath(pathdir);	//����·��
		File savedir = new File(realpathdir);
		if(!savedir.exists()) savedir.mkdirs();		//���Ŀ¼�����ھ��½�
		File filePro=new File(realpathdir, fileName);
		FileUtils.copyFile(file,filePro);
		
		return pathdir+"/"+fileName;
	}
	
	/**
	 * @���� �������ͼƬ
	 */
	public String saveServiceFile(String fileFileName , File file) throws IOException{
		
		//��׺��
		String ext = fileFileName.substring(fileFileName.lastIndexOf('.')+1).toLowerCase();

		String fileName = UUID.randomUUID().toString()+"."+ext;			//���ļ���
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
		String pathdir = "/data/service/"+ dateformat.format(new Date());//�����ļ���
		
		//����
		String realpathdir = ServletActionContext.getServletContext().getRealPath(pathdir);	//����·��
		File savedir = new File(realpathdir);
		if(!savedir.exists()) savedir.mkdirs();		//���Ŀ¼�����ھ��½�
		File filePro=new File(realpathdir, fileName);
		FileUtils.copyFile(file,filePro);
		
		return pathdir+"/"+fileName;
	}
	
	/**
	 * @���� �������ͼƬ
	 */
	public String saveEditorFile(String fileFileName , File file) throws IOException{
		
		//��׺��
		String ext = fileFileName.substring(fileFileName.lastIndexOf('.')+1).toLowerCase();

		String fileName = UUID.randomUUID().toString()+"."+ext;			//���ļ���
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
		String pathdir = "/data/xhEditor/img/"+ dateformat.format(new Date());//�����ļ���
		
		//����
		String realpathdir = ServletActionContext.getServletContext().getRealPath(pathdir);	//����·��
		File savedir = new File(realpathdir);
		if(!savedir.exists()) savedir.mkdirs();		//���Ŀ¼�����ھ��½�
		File filePro=new File(realpathdir, fileName);
		FileUtils.copyFile(file,filePro);
		
		return pathdir+"/"+fileName;
	}

}
