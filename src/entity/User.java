package entity;
/**
 * 用户
 * @author soft01
 *
 */
public class User {
	/**
	 * 身份证号
	 */
	private String id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 帐号  由数字、下划线或字母组成，长度为6—16位，
	 */
	private String userName;
	/**
	 * 密码  由字母、下划线或数字组成，长度为6—16位，并且两次输入的密码必须一致，
	 */
	private String password;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 手机号 11位
	 */
	private String phoneNum;
	/**
	 * 邮箱  可选择是否填写
	 */
	private String email;
	/**
	 * 地址  可选择是否填写
	 */
	private String address;

	public User() {

	}

	

	public User(String id, String name, String userName, String password, String sex, String phoneNum, String email, String address) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.phoneNum = phoneNum;
		this.email = email;
		this.address = address;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setIdentityNumber(String id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "User [address=" + address + ", email=" + email + ", id=" + id + ", name=" + name + ", password=" + password + ", phoneNum=" + phoneNum + ", sex=" + sex + ", userName=" + userName
				+ "]";
	}

	
}
