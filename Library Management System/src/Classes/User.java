package Classes;

public class User {
	private String userName;
	private String userId;
	private String userEmail;
	private String mobilenumber;
	private String type;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public User(String userName, String userId, String userEmail, String mobilenumber, String type) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userEmail = userEmail;
		this.mobilenumber = mobilenumber;
		this.type = type;
	}
	
	

}
