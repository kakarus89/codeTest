package com.aside.model;

import java.util.Date;

public class BoardModel {
	private int seq;
	private String b_title;
	private String b_contents;
	private int b_views;
	private Date b_regdate;
	private String b_writename;
	private Date reg_date;
	private String use_yn;
	private String fileName;


	@Override
	public String toString() {
		return "BoardModel{" +
				"seq=" + seq +
				", b_title='" + b_title + '\'' +
				", b_contents='" + b_contents + '\'' +
				", b_views=" + b_views +
				", b_regdate=" + b_regdate +
				", b_writename='" + b_writename + '\'' +
				", reg_date=" + reg_date +
				", use_yn='" + use_yn + '\'' +
				", fileName='" + fileName + '\'' +
				'}';
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_contents() {
		return b_contents;
	}

	public void setB_contents(String b_contents) {
		this.b_contents = b_contents;
	}

	public int getB_views() {
		return b_views;
	}

	public void setB_views(int b_views) {
		this.b_views = b_views;
	}

	public Date getB_regdate() {
		return b_regdate;
	}

	public void setB_regdate(Date b_regdate) {
		this.b_regdate = b_regdate;
	}

	public String getB_writename() {
		return b_writename;
	}

	public void setB_writename(String b_writename) {
		this.b_writename = b_writename;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
}
