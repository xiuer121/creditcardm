package com.creditcard.tool.chart;

import java.util.List;

public class LineDatasetObject {

	private String seriesname;
	private List<LineDataObject> data;

	public String getSeriesname() {
		return seriesname;
	}

	public void setSeriesname(String seriesname) {
		this.seriesname = seriesname;
	}

	public List<LineDataObject> getData() {
		return data;
	}

	public void setData(List<LineDataObject> data) {
		this.data = data;
	}


}
