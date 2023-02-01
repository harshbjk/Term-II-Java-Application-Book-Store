/**
 * 
 */
package finalProject;

/**
 * @author Harsh Bijukumar
 *class for address 
 *Fields: StreetName, City,  Province, PostalCode
 *Methods: Constructors,toString():Returns all value of Address info, Getter and Setters
 */
public class Address {
	private String StreetName;
	private String City;
	private String Province;
	private String PostalCode;
	
	
	
	//generated Getters ands Setters
	public String getStreetName() {
		return StreetName;
	}
	 
	public void setStreetName(String streetName) {
		StreetName = streetName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}
	
	public Address() {
		/**
		 * Non-args constructor
		 */
		StreetName = " ";
		City = " ";
		Province = " ";
		PostalCode = " ";
	}

	@Override
	/**
	 * Returns all info about the address
	 */
	public String toString() {
		return "Street Name: " + StreetName + ", City: " + City + ", Province:" + Province + ", PostalCode: "
				+ PostalCode ;
	}
	
	/**
	 * Parametric constructor
	 * @param streetName
	 * @param city
	 * @param province
	 * @param postalCode
	 */
	public Address(String streetName, String city, String province, String postalCode) {
		super();
		StreetName = streetName;
		City = city;
		Province = province;
		PostalCode = postalCode;
	}

}
