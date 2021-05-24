package PersonalityTests;

import org.openqa.selenium.InvalidArgumentException;

public class MyPersonality extends Person {
	
	
	public MyPersonality (String name, int age, float height, float weight) {
		
		setName(name);
		setAge(age);
		setHeight(height);
		setWeight(weight);
		
	}
	
	public float calculateBMI(){	
		if(getHeight()<=0) {
		throw new InvalidArgumentException("Height can't be 0 or less");
		}
		return  (getWeight() / (getHeight()*getHeight()));
	};
	
	public Seniority getSeniority () {
		if ( getAge() >= 0 && getAge() < 18) {
			return Seniority.MINOR;
		}
		else if (getAge() >= 18 && getAge() <= 65) {
			return Seniority.ADULT;
		}
		else if (getAge() > 65 ){
			return Seniority.SENIOR;
		}
		else {
			throw new InvalidArgumentException("The age is below 0.");
		}
	}

}
