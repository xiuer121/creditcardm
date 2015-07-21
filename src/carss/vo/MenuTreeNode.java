package carss.vo;


public class MenuTreeNode {

	private static final long serialVersionUID = 1L;
	
	private Integer id;					//���
	private Integer pId;				//�����
	
	private String name;				//����
	private String url;					//ת��URL
	private String target;				//��ת��ʽ
	
	private Integer childNum;			//������
	
	public MenuTreeNode(){
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Integer getChildNum() {
		return childNum;
	}

	public void setChildNum(Integer childNum) {
		this.childNum = childNum;
	}

	
	
	
}
