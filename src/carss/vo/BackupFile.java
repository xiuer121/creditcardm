package carss.vo;

import java.util.Date;

public class BackupFile {

	private String name;		//�ļ���
	private Date date;			//ʱ��
	private Long length;		//����
	
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
