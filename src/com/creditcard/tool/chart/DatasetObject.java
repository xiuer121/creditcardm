package com.creditcard.tool.chart;

import java.util.List;

public class DatasetObject {

	private String seriesname;
	private List<DataObject> data;

	public String getSeriesname() {
		return seriesname;
	}

	public void setSeriesname(String seriesname) {
		this.seriesname = seriesname;
	}

	public List<DataObject> getData() {
		return data;
	}

	public void setData(List<DataObject> data) {
		this.data = data;
	}

}
