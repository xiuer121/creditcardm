package carss.vo;

public class CarInfoVo {

	private String title; // 登录名
	private String imagePath; // 一级密码

	private Integer id;

	private Double price;
	private Double originalPrice;

	
	private Long xianMil;		//限时时间
	
	private String condition; // 车况
	private String travel; // 行程
	
	
	private Integer yueNum;			//预约人数
	private Integer cangNum;		//收藏人数
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Long getXianMil() {
		return xianMil;
	}

	public void setXianMil(Long xianMil) {
		this.xianMil = xianMil;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getTravel() {
		return travel;
	}

	public void setTravel(String travel) {
		this.travel = travel;
	}

	public Integer getYueNum() {
		return yueNum;
	}

	public void setYueNum(Integer yueNum) {
		this.yueNum = yueNum;
	}

	public Integer getCangNum() {
		return cangNum;
	}

	public void setCangNum(Integer cangNum) {
		this.cangNum = cangNum;
	}
	
	
	
	

 
}
