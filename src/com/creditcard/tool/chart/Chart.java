package com.creditcard.tool.chart;

public class Chart {
	private String caption;					//标题
	private String showpercentvalues;		//是否显示值
	private String formatNumberScale;        //是否格式化数字,默认为1(True),自动的给你的数字加上K（千）或M（百万）；若取0,则不加K或M
	private String decimalPrecision;          // 指定小数位的位数，[0-10]    例如：='0' 取整
	private String xAxisName;                  // 横向坐标轴(x轴)名称
	private String yAxisName;                  //  纵向坐标轴(y轴)名称


	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getShowpercentvalues() {
		return showpercentvalues;
	}

	public void setShowpercentvalues(String showpercentvalues) {
		this.showpercentvalues = showpercentvalues;
	}

	public String getFormatNumberScale() {
		return formatNumberScale;
	}

	public void setFormatNumberScale(String formatNumberScale) {
		this.formatNumberScale = formatNumberScale;
	}

	public String getDecimalPrecision() {
		return decimalPrecision;
	}

	public void setDecimalPrecision(String decimalPrecision) {
		this.decimalPrecision = decimalPrecision;
	}

	public String getXAxisName() {
		return xAxisName;
	}

	public void setXAxisName(String axisName) {
		xAxisName = axisName;
	}

	public String getYAxisName() {
		return yAxisName;
	}

	public void setYAxisName(String axisName) {
		yAxisName = axisName;
	}
	
	

}
