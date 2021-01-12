package com.col.domein.chatting.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Chat {
	private int chatroomKey;
	private int writerKey;
	private String msgContent;
	private Date msgtime;
	private String adsOriginalFileName;
	private String adsRenamedFileName;
	private int msgStatusNo;
	private int msgTypeNo;
	private int receiverKey;
	private String nickName;
	
	
	public Chat() {
		// TODO Auto-generated constructor stub
	}


	public Chat(int chatroomKey, int writerKey, String msgContent, Date msgtime, String adsOriginalFileName,
			String adsRenamedFileName, int msgStatusNo, int msgTypeNo, int receiverKey, String nickName) {
		super();
		this.chatroomKey = chatroomKey;
		this.writerKey = writerKey;
		this.msgContent = msgContent;
		this.msgtime = msgtime;
		this.adsOriginalFileName = adsOriginalFileName;
		this.adsRenamedFileName = adsRenamedFileName;
		this.msgStatusNo = msgStatusNo;
		this.msgTypeNo = msgTypeNo;
		this.receiverKey = receiverKey;
		this.nickName = nickName;
	}


	public int getChatroomKey() {
		return chatroomKey;
	}


	public void setChatroomKey(int chatroomKey) {
		this.chatroomKey = chatroomKey;
	}


	public int getWriterKey() {
		return writerKey;
	}


	public void setWriterKey(int writerKey) {
		this.writerKey = writerKey;
	}


	public String getMsgContent() {
		return msgContent;
	}


	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}


	public Date getMsgtime() {
		return msgtime;
	}


	public void setMsgtime(Date msgtime) {
		this.msgtime = msgtime;
	}


	public String getAdsOriginalFileName() {
		return adsOriginalFileName;
	}


	public void setAdsOriginalFileName(String adsOriginalFileName) {
		this.adsOriginalFileName = adsOriginalFileName;
	}


	public String getAdsRenamedFileName() {
		return adsRenamedFileName;
	}


	public void setAdsRenamedFileName(String adsRenamedFileName) {
		this.adsRenamedFileName = adsRenamedFileName;
	}


	public int getMsgStatusNo() {
		return msgStatusNo;
	}


	public void setMsgStatusNo(int msgStatusNo) {
		this.msgStatusNo = msgStatusNo;
	}


	public int getMsgTypeNo() {
		return msgTypeNo;
	}


	public void setMsgTypeNo(int msgTypeNo) {
		this.msgTypeNo = msgTypeNo;
	}


	public int getReceiverKey() {
		return receiverKey;
	}


	public void setReceiverKey(int receiverKey) {
		this.receiverKey = receiverKey;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	@Override
	public String toString() {
		return "Chat [chatroomKey=" + chatroomKey + ", writerKey=" + writerKey + ", msgContent=" + msgContent
				+ ", msgtime=" + msgtime + ", adsOriginalFileName=" + adsOriginalFileName + ", adsRenamedFileName="
				+ adsRenamedFileName + ", msgStatusNo=" + msgStatusNo + ", msgTypeNo=" + msgTypeNo + ", receiverKey="
				+ receiverKey + ", nickName=" + nickName + "]";
	}


	
	
	
	
}
