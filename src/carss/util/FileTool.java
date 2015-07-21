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
	 * @功能 保存产品图片
	 */
	public String saveProductImg(File file,String fileFileName){

		String ext = fileFileName.substring(fileFileName.lastIndexOf('.')+1).toLowerCase();		//图片后缀名
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
        String dir=dateformat.format(new Date());
    	String originalFilename = UUID.randomUUID().toString();
		String fileName = originalFilename+"."+ext;						//新文件名
		String pathdir = "/upload/"+ dir;				//保存文件夹
		
		//保存
		String realpathdir = ServletActionContext.getServletContext().getRealPath(pathdir);	//绝对路径
		File savedir = new File(realpathdir);
		if(!savedir.exists()) savedir.mkdirs();		//如果目录不存在就新建
		File filePro=new File(realpathdir, fileName);
		try {
			FileUtils.copyFile(file,filePro);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pathdir+"/"+fileName;
	}
	/**
	 * @功能 保存服务单图片
	 */
	public String saveImg(String fileFileName , File file) throws IOException{
		
		//后缀名
		String ext = fileFileName.substring(fileFileName.lastIndexOf('.')+1).toLowerCase();

		String fileName = UUID.randomUUID().toString()+"."+ext;			//新文件名
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
		String pathdir = "/data/"+ dateformat.format(new Date());//保存文件夹
		
		//保存
		String realpathdir = ServletActionContext.getServletContext().getRealPath(pathdir);	//绝对路径
		File savedir = new File(realpathdir);
		if(!savedir.exists()) savedir.mkdirs();		//如果目录不存在就新建
		File filePro=new File(realpathdir, fileName);
		FileUtils.copyFile(file,filePro);
		
		return pathdir+"/"+fileName;
	}
	
	/**
	 * @功能 保存公告附件
	 */
	public String saveNoticeFile(File file) throws IOException{

		String fileName = UUID.randomUUID().toString();							//新文件名
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
		String pathdir = "/data/notice/"+ dateformat.format(new Date());		//保存文件夹
		
		//保存
		String realpathdir = ServletActionContext.getServletContext().getRealPath(pathdir);	//绝对路径
		File savedir = new File(realpathdir);
		if(!savedir.exists()) savedir.mkdirs();		//如果目录不存在就新建
		File filePro=new File(realpathdir, fileName);
		FileUtils.copyFile(file,filePro);
		
		return pathdir+"/"+fileName;
	}
	
	/**
	 * @功能 保存资料
	 */
	public String saveData(File file) throws IOException{

		String fileName = UUID.randomUUID().toString();							//新文件名
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
		String pathdir = "/data/data/"+ dateformat.format(new Date());			//保存文件夹
		
		//保存
		String realpathdir = ServletActionContext.getServletContext().getRealPath(pathdir);	//绝对路径
		File savedir = new File(realpathdir);
		if(!savedir.exists()) savedir.mkdirs();		//如果目录不存在就新建
		File filePro=new File(realpathdir, fileName);
		FileUtils.copyFile(file,filePro);
		
		return pathdir+"/"+fileName;
	}
	
	/**
	 * @功能 保存服务单图片
	 */
	public String saveServiceFile(String fileFileName , File file) throws IOException{
		
		//后缀名
		String ext = fileFileName.substring(fileFileName.lastIndexOf('.')+1).toLowerCase();

		String fileName = UUID.randomUUID().toString()+"."+ext;			//新文件名
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
		String pathdir = "/data/service/"+ dateformat.format(new Date());//保存文件夹
		
		//保存
		String realpathdir = ServletActionContext.getServletContext().getRealPath(pathdir);	//绝对路径
		File savedir = new File(realpathdir);
		if(!savedir.exists()) savedir.mkdirs();		//如果目录不存在就新建
		File filePro=new File(realpathdir, fileName);
		FileUtils.copyFile(file,filePro);
		
		return pathdir+"/"+fileName;
	}
	
	/**
	 * @功能 保存服务单图片
	 */
	public String saveEditorFile(String fileFileName , File file) throws IOException{
		
		//后缀名
		String ext = fileFileName.substring(fileFileName.lastIndexOf('.')+1).toLowerCase();

		String fileName = UUID.randomUUID().toString()+"."+ext;			//新文件名
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
		String pathdir = "/data/xhEditor/img/"+ dateformat.format(new Date());//保存文件夹
		
		//保存
		String realpathdir = ServletActionContext.getServletContext().getRealPath(pathdir);	//绝对路径
		File savedir = new File(realpathdir);
		if(!savedir.exists()) savedir.mkdirs();		//如果目录不存在就新建
		File filePro=new File(realpathdir, fileName);
		FileUtils.copyFile(file,filePro);
		
		return pathdir+"/"+fileName;
	}

}
