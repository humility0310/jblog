package com.bit2016.jblog.vo;

public class CategoryVo {
	Long no;
	Long blogId;
	String name;
	String description;
	String regDate;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", blogId=" + blogId + ", name=" + name + ", description=" + description
				+ ", regDate=" + regDate + "]";
	}

}
