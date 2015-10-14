package World;


import java.util.HashMap;
import java.util.Map;


import pojos.HealthProfile;
import pojos.Person;


public class HealthProfileReader {
	
	public static Map<String,Person> database = new HashMap<String,Person>();
	
	static 
    {
    	Person pallino = new Person();
		Person pallo = new Person("Pinco","Pallo");
		HealthProfile hp = new HealthProfile(68.0,1.72);
		Person john = new Person("John","Doe",hp, "12-12-2015", 1212L);
		Person guido = new Person("Guido","Galloni",hp, "12-12-2015", 999L);

		System.out.println(john.getId());
		System.out.println(guido.getId());
		System.out.println(pallo.getId());
		System.out.println(pallino.getId());
		
		database.put(String.valueOf(pallino.getId()), pallino);
		database.put(String.valueOf(pallo.getId()), pallo);
		database.put(String.valueOf(john.getId()), john);
		database.put(String.valueOf(guido.getId()), guido);
    }

	public static double getBMI(String personId){
		Person p = database.get(personId);
		HealthProfile hp = p.gethProfile();
		return hp.getBMI();
	}

	public static Person createPerson(String name, String surname){
		Person newPerson = new Person(name, surname);
		database.put(String.valueOf(newPerson.getId()), newPerson);
		return newPerson;
	}
	
	public static void displayHealthProfile(Long personId){
		String pID = String.valueOf(personId);
		System.out.println(database.get(pID).gethProfile().toString());
	}
	
	public static void updateHealthProfile(Long personId, Double height, Double weight){
		String pID = String.valueOf(personId);
		Person p = database.get(pID);
		if (p!=null){
			System.out.println("PERSON OLD PROFILE:" );
			System.out.println(p.getFirstname()+" "+p.getLastname()+"'s health profile is: "+p.gethProfile().toString()+" Birth Date="+p.getBirthday()+" "+p.getId());
			p.gethProfile().setHeight(height);
			p.gethProfile().setWeight(weight);
			database.replace(pID, p);
			System.out.println("PERSON UPDATED PROFILE:" );
			System.out.println(p.getFirstname()+" "+p.getLastname()+"'s health profile is: "+p.gethProfile().toString()+" Birth Date="+p.getBirthday()+" "+p.getId());
		} else {
			System.out.println("ID not in DB..");
		}
		
	}
	
	
	/**
	 * The health profile reader gets information from the command line about
	 * weight and height and calculates the BMI of the person based on this 
	 * parameters
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		//initializeDatabase();
		int argCount = args.length;
		if (argCount == 0) {
			System.out.println("I cannot get people from database in the air, please give me an ID.. ");
		} else if (argCount == 1) {
			String PId = args[0];
			// read the person from the DB
			Person p = database.get(PId);
			if (p!=null) { 
				System.out.println(p.getFirstname()+" "+p.getLastname()+"'s health profile is: "+p.gethProfile().toString()+" Birth Date="+p.getBirthday()+" "+p.getId());
			} else {
				System.out.println("User with this id does not exists on database... -.-'' ");
			}
		}
		else if(argCount == 2){
			String fname = args[0];
			String lname = args[1];
			Person newPerson = createPerson(fname, lname);
			System.out.println(fname+" "+lname+"'s health profile is: "+newPerson.gethProfile().toString()+" Birth Date="+newPerson.getBirthday()+"ID: "+newPerson.getId());
		}
		
		else if (argCount > 2) {
			if(args[0].equals("method")){
				System.out.println("You are in the method menu: ");
				if(args[1].equals("show")){
					long PId = Long.valueOf(args[2]);
					displayHealthProfile(PId);
					getBMI(args[2]);
				}
				else if(args[1].equals("update")){
					if (argCount == 5){
						System.out.println("sONO dentro update");
						updateHealthProfile(Long.valueOf(args[2]), Double.valueOf(args[3]), Double.valueOf(args[4]));
						displayHealthProfile(Long.valueOf(args[2]));
						
					
					} else {
						System.out.println(" ERROR in Parameters...");
					}
			} 
				
			}
			else {
				System.out.println("BAD COMMAND");
			}
		}
		// add the case where there are 3 parameters, the third being a string that matches "weight", "height" or "bmi"
	}
	
	//public static void initializeDatabase() {
	//	Person pallino = new Person();
	//	Person pallo = new Person("Pinco","Pallo");
	//	HealthProfile hp = new HealthProfile(68.0,1.72);
	//	Person john = new Person("John","Doe",hp);
	//	
	//	database.put(pallino.getFirstname()+" "+pallino.getLastname(), pallino);
	//	database.put(pallo.getFirstname()+" "+pallo.getLastname(), pallo);
	//	database.put(john.getFirstname()+" "+john.getLastname(), john);
	//}
}