package member.model;

import java.sql.Date;

public class MemberInfo {
	
	private int idx = 0;
	private String userId;
	private String password;
	private String userName;
	private String userPhoto;
	private Date regDate;
	
	public MemberInfo() {
		
	}
	public MemberInfo(String userId, String password, String userName, String userPhoto) {
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.userPhoto = userPhoto;
	}
	
	public MemberInfo(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date date) {
		this.regDate = date;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	@Override
	public String toString() {
		return "MemberInfo [userId=" + userId + ", password=" + password + ", userName=" + userName + ", userPhoto="
				+ userPhoto + "]";
	}

}
