package labfive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;

import org.junit.jupiter.api.Test;

class JSONTest {

	@Test
	void test() {
		var person = new Person("John", "Doe");
	    var alien = new Alien("E.T.", 100);
		String personString = "{\n" +
        "  \"firstName\": \"" + person.getFirstName() + "\"\n" +
        "  \"lastName\": \"" + person.getLastName() + "\"\n" +
        "}\n";
        String alienString = "{\n" + 
                "  \"planet\": \"" + alien.getPlanet() + "\"\n" + 
                "  \"age\": \"" + alien.getAge() + "\"\n" + 
                "}\n";
        assertEquals(personString, Main.toJSON(person));
        assertEquals(alienString, Main.toJSON(alien));
	}
	
	public static class Alien {
		  private final String planet;
		  private final int age;

		  public Alien(String planet, int age) {
		    if (age <= 0) {
		      throw new IllegalArgumentException("Too young...");
		    }
		    this.planet = Objects.requireNonNull(planet);
		    this.age = age;
		  }

		  @JSONProperty
		  public String getPlanet() {
		    return planet;
		  }

		  @JSONProperty
		  public int getAge() {
		    return age;
		  }
	}
	
	public static class Person {
		  private final String firstName;
		  private final String lastName;

		  public Person(String firstName, String lastName) {
		    this.firstName = Objects.requireNonNull(firstName);
		    this.lastName = Objects.requireNonNull(lastName);
		  }
		  
		  @JSONProperty
		  public String getFirstName() {
		    return firstName;
		  }
		  @JSONProperty
		  public String getLastName() {
		    return lastName;
		  }
		}
}
