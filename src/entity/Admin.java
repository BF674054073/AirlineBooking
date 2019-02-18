package entity;

public class Admin {
	/**
	 * 身份证号
	 */
	private String id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 手机号
	 */
	private String phoneNumber;
	/**
	 * 真实姓名
	 */
	private String name;

	public Admin() {
	}

	public Admin(String id, String userName, String password, String phoneNumber, String name) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.name = name;
	}

}
