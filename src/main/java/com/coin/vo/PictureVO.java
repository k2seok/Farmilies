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
	String picloc;
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
	public String getPicloc() {
		return picloc;
	}
	public void setPicloc(String picloc) {
		this.picloc = picloc;
	}
	

}
