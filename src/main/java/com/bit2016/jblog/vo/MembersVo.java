package com.bit2016.jblog.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class MembersVo {
	private Long no;
	
	@NotEmpty
	private String id;
	
	@NotEmpty
	private String name;

	@NotEmpty
	private String password;
	private String regDate;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "MembersVo [no=" + no + ", id=" + id + ", name=" + name + ", password=" + password + ", regDate="
				+ regDate + "]";
	}

}
