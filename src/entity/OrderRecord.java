package entity;

public class OrderRecord {
	/**
	 * 账户名
	 */
	private String userName;
	/**
	 * 订单号
	 */
	private int orderNumber;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Override
	public String toString() {
		return "OrderRecord [orderNumber=" + orderNumber + ", userName=" + userName + "]";
	}

}
