package com.creditcard.tool.chart;

public class Chart {
	private String caption;					//����
	private String showpercentvalues;		//�Ƿ���ʾֵ
	private String formatNumberScale;        //�Ƿ��ʽ������,Ĭ��Ϊ1(True),�Զ��ĸ�������ּ���K��ǧ����M�����򣩣���ȡ0,�򲻼�K��M
	private String decimalPrecision;          // ָ��С��λ��λ����[0-10]    ���磺='0' ȡ��
	private String xAxisName;                  // ����������(x��)����
	private String yAxisName;                  //  ����������(y��)����


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
