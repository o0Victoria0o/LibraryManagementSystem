package theGuy;

public class ThisGuy{

	private String guyId; private String firstName; private String middleName; private String lastName;
	private String gender; private String bday; private String contactNumber;
	private String email; private String address;

	private int strikes;

    public ThisGuy(String guyId, String firstName, String middleName, String lastName,
	String gender, String bday, String contactNumber, String email, String address, int strikes) {
		this.guyId = guyId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.bday = bday;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.strikes = strikes;
    }

	public String getGuyId(){return guyId;} public void setGuyId(String guyId){this.guyId = guyId;}
	public String getFirstName(){return firstName;} public void setFirstName(String firstName){this.firstName = firstName;}
	public String getMiddleName(){return middleName;} public void setMiddleName(String middleName){this.middleName = middleName;}
	public String getLastName(){return lastName;} public void setLastName(String lastName){this.lastName = lastName;}
	public String getGender(){return gender;} public void setGender(String gender){this.gender = gender;}
	public String getBday(){return bday;} public void setBday(String bday){this.bday = bday;}
	public String getContactNumber(){return contactNumber;} public void setContactNumber(String contactNumber){this.contactNumber = contactNumber;}
	public String getEmail(){return email;} public void setEmail(String email){this.email = email;}
	public String getAddress(){return address;} public void setAddress(String address){this.address = address;}
	public int getStrikes(){return strikes;} public void setStrikes(int strikes){this.strikes = strikes;}
}
