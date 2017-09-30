import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;
//Noah Mifsud Lattari
//50076040
//CPS-209-052
//Tim Mclnerney
//April 10th 2017
public class Contacts {
	
	public static void main(String args[]) throws Exception {

        Contacts contact = new Contacts();
        //calls the method to read from the file
        contact.readContactsFile();
    }
	//creates a list for all the person objects
	LinkedList<Person> persons = new LinkedList<Person>();
	
	

	public Person FindPersonTelephone(String phone) {
		Person result = new Person();
		//Find a person with the entered telephone
		for (int i = 0; i < persons.size(); i++)
			if (persons.get(i).gettelephone().compareTo(phone) == 0) {
				result = persons.get(i);
				return result;
			}
		return null;
	}

	public Person FindPersonEmail(String mail) {
		Person result = new Person();
		//finds the person with the entered email
		for (int i = 0; i < persons.size(); i++)
			if (persons.get(i).getemail().compareTo(mail) == 0) {
				result = persons.get(i);
				return result;
			}
		return null;
	}
	
	public Person FindPersonName(String last, String first) {
	//If they have the same last name as the one entered, check the first name
		Person result = new Person();
		for (int i = 0; i < persons.size(); i++)
			if (persons.get(i).getlastName().compareTo(last) == 0
					|| persons.get(i).getfirstName().compareTo(first) == 0) {
				result = persons.get(i);
				return result;
			}
		return null;
	}

	public void readContactsFile() throws Exception {
		//gets the info from the file
		String email;
		String address;
		String lastname ;
		String firstname;
		String telephone;		
		int count = 1;
	
		BufferedReader reader = new BufferedReader(new FileReader("contacts.txt"));
		Scanner scanner = new Scanner("contacts.txt");
		String temp = reader.readLine();
		
		
		//Gets the first line of the file which is an int to tell us how many contacts we have
		//if the number is less then 1 throws an error
		int tempInt = Integer.parseInt(temp);
		if(tempInt < 1){
			persons.clear();
			throw new Exception("Invalid number of contacts, enter 1 or greater");
		}
		
		
		
		for(int i = 0;i < tempInt; i++) {
		
		
			//gets all strings from the file and updates the count
			lastname = reader.readLine();
			count++;
			firstname = reader.readLine();
			count++;
			address = reader.readLine();
			count++;
			telephone = reader.readLine();
			count++;
			email = reader.readLine();
			count++;
		    System.out.println(count);
			//if name lengths are 0 throw an error
		    if(lastname.length() == 0 || firstname.length() == 0){
				persons.clear();
				throw new Exception("Invalid name length");
			}
			//if the contact info (besides the first line) is not a multiple of 5 throws an error
			if((count -1) % 5 != 0){
				persons.clear();
				throw new Exception("Invalid contact information");
			
			}
			
			//adds the person from the file to the list and sorts it
			Person newPerson = new Person(lastname, firstname, telephone, address, email);
			persons.add(newPerson);
			Collections.sort(persons);
		}
		
		
		

	}
}
