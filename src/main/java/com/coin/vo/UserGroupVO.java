package com.coin.vo;

public class UserGroupVO {
	/*
	 * 
CREATE TABLE USER_GROUPS(

		id                            		NUMBER(3)		 NOT NULL,

		name                          		VARCHAR2(50)		 NOT NULL,

		update_at                     		DATE		 DEFAULT sysdate		 NOT NULL,

		create_at                     		DATE		 DEFAULT sysdate		 NOT NULL,

		location_id                   		NUMBER(10)		 NOT NULL

);
	 */
	
	String id;
	String name;
	String update_at;
	String create_at;
	String location_id;
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
	public String getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(String update_at) {
		this.update_at = update_at;
	}
	public String getCreate_at() {
		return create_at;
	}
	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}
	public String getLocation_id() {
		return location_id;
	}
	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}
	
	
	
}
