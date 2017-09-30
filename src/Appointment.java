import java.util.Calendar;
import java.util.GregorianCalendar;
//Noah Mifsud Lattari
//50076040
//CPS-209-052
//Tim Mclnerney
//April 10th 2017
public class Appointment implements Comparable<Appointment> {
	private Calendar date;
	private String description ;
	private Person person;
	//Constructor method, when this is called it will take in the date information as well as a description for the appointment
	Appointment(int year, int month, int day, int hour, int minute, String description, Person person) {
		GregorianCalendar GCalendar = new GregorianCalendar(year, month, day, hour, minute);
		date = GCalendar;
		date.set(year, month, day, hour, minute);
		this.person = person;
		this.description = description;
	}
	//To get the desciription
	public String getDescription() {
		return this.description;
	}
	//Getter method for date
	public Calendar getDate() {
		return this.date;
	}
	//Sets the description
	public void setDescription(String description) {
		this.description = description;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
	
	public void setPerson(Person ppl){
		person = ppl;
	}
	
	public Person getPerson(){
		return person;
	}
	
	public String stringTime() {
		

		if(date.get(Calendar.MINUTE) < 10) {	
			return (date.get(Calendar.HOUR_OF_DAY) + ":0" + date.get(Calendar.MINUTE) + " " + getDescription() + " " + person.getfirstName() + " " + person.getlastName() + " " + person.gettelephone() + " " + person.getemail() + "\n");
		} else {
			return (date.get(Calendar.HOUR_OF_DAY) + ":" + date.get(Calendar.MINUTE) + " " + getDescription() + " " + person.getfirstName() + " " + person.getlastName() + " " + person.gettelephone() + " " + person.getemail() + "\n");
		}
	}
	//prints the time 
	public void printTime() {
		System.out.println(date.HOUR + ":" + date.MINUTE + " " + getDescription());

		if(date.get(Calendar.MINUTE) < 10) {
			System.out.println(date.get(Calendar.HOUR_OF_DAY) + ":0" + date.get(Calendar.MINUTE) + " " + getDescription() + "\n");
		} else {
			System.out.println(date.get(Calendar.HOUR_OF_DAY) + ":" + date.get(Calendar.MINUTE) + " " + getDescription() + "\n");
		}
	}
	//Checks if one date is the same as another
	public boolean occursOn(int year, int month, int day, int hour, int minute) {
		Calendar date2;
		GregorianCalendar G2Calendar = new GregorianCalendar();
		date2 = G2Calendar;
		date2.set(year, month, day, hour, minute);

		if (date2.equals(date)) {
			return true;
		} else {
			return false;
		}

	}
	//This inherited the comparable interface, so this methid must be created, compares one appointment object to another
	public int compareTo(Appointment other) {
		return this.date.compareTo(other.date);

	}

}