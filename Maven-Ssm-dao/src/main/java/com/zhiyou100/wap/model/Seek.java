package com.zhiyou100.wap.model;

public class Seek {
	private String KeyWord;
	private String SearchField;
	private Integer CurrentPage;
	private User user;
	public String getKeyWord() {
		return KeyWord;
	}
	public void setKeyWord(String keyWord) {
		KeyWord = keyWord;
	}
	public String getSearchField() {
		return SearchField;
	}
	public void setSearchField(String searchField) {
		SearchField = searchField;
	}
	public Integer getCurrentPage() {
		return CurrentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		CurrentPage = currentPage;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Seek [KeyWord=" + KeyWord + ", SearchField=" + SearchField + ", CurrentPage=" + CurrentPage + ", user="
				+ user + "]";
	}
	
	

}
