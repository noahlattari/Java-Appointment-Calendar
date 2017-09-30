import java.util.Comparator;
//Noah Mifsud Lattari
//50076040
//CPS-209-052
//Tim Mclnerney
//April 10th 2017
public class compareEmail implements Comparator<Person> {
	
	public static void main(String[] args) {
		

	}
	
	
	//checks if one persons email is the same as another
	public int compare(Person one, Person two) {
	    return one.getemail().compareTo(two.getemail());
	
	
}
}
