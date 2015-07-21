package carss.vo;

import java.util.Date;

public class BackupFile {

	private String name;		//文件名
	private Date date;			//时间
	private Long length;		//长度
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getLength() {
		return length;
	}
	public void setLength(Long length) {
		this.length = length;
	}
	
	
}
