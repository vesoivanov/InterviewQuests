package PersonalityTests;

import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.Before;

import org.junit.runners.Parameterized;
import org.openqa.selenium.InvalidArgumentException;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class MyPersonalityTest {
   private String 	name;
   private Integer 	age;
   private float 	height;
   private float 	weight;
   private float 	expectedBM;
   private Seniority expectedSeniority;
   private MyPersonality myPersonality;

   @Before
   public void initialize() {
	   myPersonality = new MyPersonality(name, age, height, weight);
   }
	
   public MyPersonalityTest(String name, int age, float height, float weight, float expectedBM, Seniority seniority) {
      this.name = name;
      this.age = age;
      this.height = height;
      this.weight = weight;
      this.expectedBM = expectedBM;
      this.expectedSeniority = seniority;
   }

   @Parameterized.Parameters
   public static Collection data() {
	      return Arrays.asList(new Object[][]{
	         { "John", 68, 1.67F, 73F, 26.17F, Seniority.SENIOR},
	         { "Richard", 43, 1.87F, 90F, 25.73F, Seniority.ADULT},
	         { "Amily", 7, 1.21F, 25F, 17.1F, Seniority.MINOR},
	         { "Rose", 14, 1.43F, 54F, 26.41F, Seniority.MINOR}
	      });
	   }

   @Test
   public void testBMI() {
	  Assertions.assertEquals(expectedBM, myPersonality.calculateBMI(), 0.1);
   }
   
   @Test
   public void InvalidHeightBMI() {
	   MyPersonality personality = new MyPersonality("John", 10, 0, 10);
	   Assertions.assertThrows(InvalidArgumentException.class, ()->personality.calculateBMI());
   }
   
   @Test
   public void testSeniority() {
	  Assertions.assertEquals(expectedSeniority, myPersonality.getSeniority());
   }
}