package com.creditcard.tool.chart;

import java.util.List;

public class LineChartsObject {
	private Chart chart;
	private List<LineDatasetObject> dataset;
	private List<CategoryObject> categories;
	
	
	public Chart getChart() {
		return chart;
	}

	public void setChart(Chart chart) {
		this.chart = chart;
	}



	public List<LineDatasetObject> getDataset() {
		return dataset;
	}

	public void setDataset(List<LineDatasetObject> dataset) {
		this.dataset = dataset;
	}

	public List<CategoryObject> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryObject> categories) {
		this.categories = categories;
	}

	

	

	

}
