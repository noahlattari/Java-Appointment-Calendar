//Noah Mifsud Lattari
//50076040
//CPS-209-052
//Tim Mclnerney
//April 10th 2017
public class Person implements Comparable<Person> {
private String lastName;
private String firstName;
private String telephone;
private String address;
private String email;
	
	//Contructor to create a person, takes in all info as strings
public Person(String lastName, String firstName, String telephone, String adress, String email){
	this.lastName = lastName;
	this.firstName = firstName;
	this.telephone = telephone;
	this.address = adress;
	this.email = email;
}
	
public Person(){
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//gets last name
	public String getlastName(){
	return lastName;
}
//gets first name
	public String getfirstName(){
		return firstName;
	}
	
	public String gettelephone(){
		return telephone;
	}
	
	public String getaddress(){
		return address;
	}
	
	public String getemail(){
		return email;
	}
	//sets last nmame
	public void setlastName(String name){
		lastName = name;
	}
	//sets first name
	public void setfirstName(String name){
		firstName = name;
	}
	
	public void settelephone(String phone){
		telephone = phone;
	}
	
	public void setadress(String adr){
		address = adr;
	}
	
	public void setemail(String mail){
		email = mail;
	}
	//Checks if one person object is the same as another (0 if same)
	public int compareTo(Person other) {
		if(this.lastName.compareTo(other.lastName) == 0) {
            return this.firstName.compareTo(other.firstName);
        } else {
            return this.lastName.compareTo(other.lastName);
        }
		
	
	}



	

}
