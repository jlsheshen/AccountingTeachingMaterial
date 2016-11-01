package com.edu.accountingteachingmaterial.bean;

import java.util.List;


import com.edu.library.data.BaseData;

public class ClassChapterBean extends BaseData {
	
	int chapterId;
	String title;
	List<NodeBean> nodes;
	
	
	public int getChapterId() {
		return chapterId;
	}


	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public List<NodeBean> getNodes() {
		return nodes;
	}


	public void setNodes(List<NodeBean> nodes) {
		this.nodes = nodes;
	}



	

}
