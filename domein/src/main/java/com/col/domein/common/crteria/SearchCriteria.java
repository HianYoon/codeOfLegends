package com.col.domein.common.crteria;

public class SearchCriteria extends Criteria{
	
	private String searchType= "";
	private String keyword= "";
	
	public SearchCriteria() {
		// TODO Auto-generated constructor stub
	}

	public SearchCriteria(String searchType, String keyword) {
		super();
		this.searchType = searchType;
		this.keyword = keyword;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "Search [searchType=" + searchType + ", keyword=" + keyword + "]";
	}
	

}
