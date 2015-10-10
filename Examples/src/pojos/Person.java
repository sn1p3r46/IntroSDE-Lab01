// classes are grouped together in 'packages'
// Classes in the same pakage already see each other. 
// If a class is in another package, in other to see it, you need to import it
package pojos;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

// This is a typical Java Class. 
public class Person {

	// As with any other object oriente language, classes have attributes (i.e. the properties of the class). 
	// Each attribute is in turn of another class
	private String firstname;	// this is an attribute of the class String, and it is 'private'
								// private attributes are only accesible inside the object
	private String lastname;	// this is an attribute of the class String
	private HealthProfile hProfile;	// this is an attribute of the class HealthProfile 
	private Date birth;
	private Long id;
	// constructors in java are used to create an object of the class 
	// (a java program basically plays with objects of different classes)
	// this constructor creates a Person object with a particular firstname, lastname and health profile
	
	public Person(String fname, String lname, HealthProfile hp, String birth, Long id){
		this.setFirstname(fname);
		this.setLastname(lname);
		this.hProfile=new HealthProfile();
		this.setBirthday(birth);
		this.setId(id);
	}
	public Person(String fname, String lname, HealthProfile hp) {
		this.setFirstname(fname);
		this.setLastname(lname);
		this.hProfile=hp;
		this.setBirthday();
		this.setId(id);
	}
	public Person(String fname, String lname) {
		this.setFirstname(fname);
		this.setLastname(lname);
		this.hProfile=new HealthProfile();
		this.setBirthday();
		this.setId();
	}
	public Person(String fname, String lname, HealthProfile hp, String birth) {
		this.setFirstname(fname);
		this.setLastname(lname);
		this.hProfile=new HealthProfile();
		this.setBirthday(birth);
		this.setId(id);
	}
	public Person() {
		this.firstname="Nuovo";
		this.lastname="Utente";
		this.hProfile=new HealthProfile();
		this.setBirthday();
		this.setId();
	}


	// classes have methods, which are basically pieces of programs that can be executed on objects of the class
	// this dummy class, has only 'accesor' methods (i.e. methods to access its properties, which are all private)
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getLastname() {
		return lastname;
	}

	public void setId(Long id){
		this.id=id;
	}
	public void setId(){
		this.id = new Long(RandomHelper.getRandomNumber(1, 9999));
	}
	public Long getId(){
		return this.id;	
	}
	
	
	public void setBirthday(){
		setBirthday(RandomHelper.getRandomDate());
	}
	public void setBirthday(String input){
		try{
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date data = dateFormat.parse(input);
			this.birth = data;
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getBirthday() {		
		if(this.birth!=null){
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String ss = dateFormat.format(this.birth);
		return ss;
		}
		return " Birthday not set in database ";
		
	}

	public HealthProfile gethProfile() {
		return hProfile;
	}
	public void sethProfile(HealthProfile hProfile) {
		this.hProfile = hProfile;
	}
}
