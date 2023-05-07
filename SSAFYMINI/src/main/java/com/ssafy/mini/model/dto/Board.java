package com.ssafy.mini.model.dto;

import java.util.Date;

public class Board {
	
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private int likeCount;
	private int viewCount;
	private Date createDate;
	private Date modifyDate;

	public Board() {
		super();
	}

	public Board(int boardNo, String title, String content, String writer, int likeCount, int viewCount,
			Date createDate, Date modifyDate) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.likeCount = likeCount;
		this.viewCount = viewCount;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", likeCount=" + likeCount + ", viewCount=" + viewCount + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + "]";
	}
	
}
