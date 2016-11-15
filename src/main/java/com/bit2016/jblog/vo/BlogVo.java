package com.bit2016.jblog.vo;

public class BlogVo {
	private Long blogId;
	private String title;
	private String logo;

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "BlogDao [blogId=" + blogId + ", title=" + title + ", logo=" + logo + "]";
	}

}
