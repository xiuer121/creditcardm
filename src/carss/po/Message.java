/**
 * @���� ���Ա�
 */

package carss.po;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true,dynamicInsert=true)
@Table(name = "message")
public class Message implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String title;
	private String content;
	private Integer type;			//�鿴״̬(10Ϊδ�鿴��20Ϊ�Ѳ鿴)
	
	private Member fromPerson;		//����Ͷ����
	private Member toPerson;		//����Ͷ����
	
	private String operIp;
	private Date commitDate;

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "oper_ip", length = 50)
	public String getOperIp() {
		return this.operIp;
	}

	public void setOperIp(String operIp) {
		this.operIp = operIp;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="from_person_id")
	public Member getFromPerson() {
		return fromPerson;
	}
	public void setFromPerson(Member fromPerson) {
		this.fromPerson = fromPerson;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="to_person_id")
	public Member getToPerson() {
		return toPerson;
	}
	public void setToPerson(Member toPerson) {
		this.toPerson = toPerson;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "commit_date")
	public Date getCommitDate() {
		return commitDate;
	}
	public void setCommitDate(Date commitDate) {
		this.commitDate = commitDate;
	}
	
	

}