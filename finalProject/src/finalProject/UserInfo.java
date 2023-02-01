/**
 * 
 */
package finalProject;

/**
 * @author Harsh Bijukumar
 *This class holds fields for acquiring user/client information
 *Fields:  userID, userName, userAddress, userEmail, userPhoneNo
 *Methods: COnstrucotrs, Getter, Setter, toString(): returns all book info fields, OutPut(): outputs all book info fields
 */
public class UserInfo {
	private int userID;
	private String userName;
	private Address userAddress;
	private String userEmail;
	private String userPhoneNo;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	@Override
	public String toString() {
		return userID + "," + userName + "," + userAddress + ","
				+ userEmail + ", " + userPhoneNo ;
	}
	public String OutPut() {
			return "UserID:" + userID + ",Name: " + userName + ", " + userAddress + ", Email: "
					+ userEmail + ", PhoneNo: " + userPhoneNo + "]";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Address getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhoneNo() {
		return userPhoneNo;
	}
	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}
	
	public UserInfo(){
		/**
		 * No-args constructor
		 */
		userID = 0;
		userName = " ";
		userAddress = new Address();
		userEmail =  " ";
		userPhoneNo = " ";
		
	}
	
	/**
	 * Parametric constructor
	 * @param userID user id
	 * @param userName user's name
	 * @param userAddress user's address info
	 * @param userEmail user's email
	 * @param userPhoneNo user's phone number 
	 */
	public UserInfo(int userID, String userName, Address userAddress, String userEmail, String userPhoneNo) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userEmail = userEmail;
		this.userPhoneNo = userPhoneNo;
	}


}
