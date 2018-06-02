package com.coin.vo;

public class PictureVO {
	/*
	 * 
CREATE TABLE PICTURES(

		id                            		NUMBER(12)		 NOT NULL,

		picname                       		VARCHAR2(50)		 NULL ,

		picture                       		BLOB		 NULL 

);
	 */
	
	
	String id;
	String picname;
	String pic_loc;
	public String getPic_loc() {
		return pic_loc;
	}
	public void setPic_loc(String pic_loc) {
		this.pic_loc = pic_loc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPicname() {
		return picname;
	}
	public void setPicname(String picname) {
		this.picname = picname;
	}
	@Override
	public String toString() {
		return "PictureVO [id=" + id + ", picname=" + picname + ", pic_loc=" + pic_loc + "]";
	}

	

}
