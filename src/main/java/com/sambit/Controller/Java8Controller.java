package com.sambit.Controller;

import com.sambit.Entity.Reg;
import com.sambit.Service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/*Java 8 got released on March 18, 2014.
	   Java 8 Features :
	   Lambda Expression
	   Method references
	   Functional interfaces
	   Interface changes: Default and static methods
	   Streams
	   Stream filter
	   forEach()
	   Collectors class with example
	   StringJoiner class with example
	   Optional class with example
	   Arrays Parallel Sort*/

interface add{
	int addMethod(int a, int b);
}

interface average{
	int averageMethod(int a, int b, add addObj);
}

interface Arithmetic{
	int operation (int a, int b);
}

@FunctionalInterface
interface areaOfTriangle {
	void area();
}

@FunctionalInterface
interface PrintName{
	String print();
}

@FunctionalInterface
interface printData{
	void printData();
}

@FunctionalInterface
interface printName{
	public String namePrint();
}
@FunctionalInterface
interface printNameOneParameter{
	public String namePrint(String name);
}
@FunctionalInterface
interface printNameMultipleParameter{
	public String printName(String firstName, String lastName);
}

class printWelcomeData {
	static void data(){
		System.out.println("Hello, Welcome to CSM.");
	}
}


@Controller
public class Java8Controller {

	@Autowired
	private RegService regService;

	@GetMapping(value = "/java8ArithmeticOperation")
	public String arithmeticOperation(){
		System.out.println("Inside Arithmetic Operation Using JAVA 8 Lambda Function---------->>");
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter First Number: ");
		int x = scanner.nextInt();
		System.out.println("Enter Second Number: ");
		int y = scanner.nextInt();

//        For Addition
		Arithmetic arithmetic = (a, b)-> a+b;
		System.out.println("Addition of of these numbers are: " + arithmetic.operation(x,y));

//        For Multiplication
		Arithmetic arithmetic1 = (int a, int b)-> a*b;
		System.out.println("Multiplication of these two numbers are: " + arithmetic1.operation(x,y));

		//    For Substraction
		Arithmetic arithmetic2 = (a, b)-> a-b;
		System.out.println("Substraction of these thwo numbers are: " + arithmetic2.operation(x,y));
		return null;
	}

	@ResponseBody
	@GetMapping(value = "/arrayListEx1")
	public String arrayListEx1(){
		String name;
		System.out.println("Enter size of an Arraylist");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		ArrayList<String> arrayList = new ArrayList<String>(size);
//        System.out.println("Enter the names for an ArrayList:");
		for (int x = 1; x <= size; x++){
			System.out.println("Enter " + x + " Location Name:");
			name = scanner.next();
			arrayList.add(name);
			System.out.println("Name Added to Arraylist!");
		}
		System.out.println("ArrayList contents are: ");
		System.out.println(arrayList);
		arrayList.forEach((n)-> System.out.println(n)
		);
		return "ArrayListExample1";
	}

	@ResponseBody
	@GetMapping(value = "/areaOfTriangle/{base}&{height}")
	public String areaOfTriangle(@PathVariable(value = "base")int base, @PathVariable(value = "height")int height){
		areaOfTriangle areaOfTriangle = ()->{
			System.out.println("Area of the triangle is: " + (base * height)/2);
		};
		areaOfTriangle.area();
		return "Area Of The Triangle is : " + (base * height)/2;
	}

	@ResponseBody
	@GetMapping(value = "/printName")
	public String printName(){
		System.out.println("Enter Your Name:");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		PrintName printName = ()->{
			return "Hello " + name + " Welcome To CSM Technologies.";
		};
		System.out.println(printName.print());
		return "Your Name is : " + printName.print();
	}

	@GetMapping(value = "/removingOfDuplicateDataFromList")
	public String removingDuplicateDataFromList(){
//		List<String> regList = regService.findAllName();
		List<String> regList = new ArrayList<>();
		regList.add("Sambit");
		regList.add("Dilip");
		regList.add("Mohit");
		regList.add("Deba");
		regList.add("Sambit");
		regList.add("Mohit");

//		@Method 1 For Removing Duplicate Data
		HashSet<String> regData = new HashSet<>();
		System.out.println("Registration Data List : " + regList);
		for (String name : regList) {
			regData.add(name);
		}

//		@Method 2 For Removing Duplicate Data
		Set<String> regData1 = new HashSet<>(regList);
		regList.clear();
		regList.addAll(regData1);
		System.out.println("Unique Data : " + regList);
		return null;
	}

	@GetMapping("/java8AddAvg")
	public String example1(){
		add addObj;
		System.out.println("Enter First Number?");
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		System.out.println("Enter Second Number?");
		int y = scanner.nextInt();

		addObj = (a, b)-> a+b;
		System.out.println("Addition of the two numbers are " + addObj.addMethod(x, y));

		average averageObj = (a, b, addObj1)->{
			int addValue = addObj1.addMethod(x,y);
			return addValue/2;
		};
		System.out.println("Average of these two numbers are: " + averageObj.averageMethod(x,y, addObj));
		return null;
	}

	@GetMapping("/printWelcomeData")
	public String printWelcomeData(){
		printData print = printWelcomeData::data;
		print.printData();
		return null;
	}

	@ResponseBody
	@GetMapping(value = "/listOperation")
	public String ListOperation(){
		List<Reg> regList = regService.getAllRegList();
		regList.forEach(System.out::println);
		regList.forEach(reg -> System.out.println("Registration Data : " + reg));
		regList.forEach(reg ->{
			if (reg != null){
				System.out.println("Registration Data is Not Null.");
			}
			System.out.println(reg.getName());
		});
		return "Success";
	}

	@ResponseBody
	@GetMapping(value = "/mapOperation")
	public String mapOperation(){
		Map<String, Double> laptopList = new HashMap<>();
		laptopList.put("Dell", 65000.00);
		laptopList.put("Hp", 85000.50);
		laptopList.forEach((x, y)->System.out.println("Model Name : " + x + ", Price : " + y));//For Single Line
		laptopList.forEach((x, y)->{
			System.out.println("Model Name : " + x + ", Price : " + y);//For Multiple Line
		});
		return "Success";
	}

	@GetMapping(value = "/functionalInterface")
	public String functionInterface(){
		System.out.println("Inside Functional Interface.");
		//Without No Parameters
		printName prntName = () ->{
			return "Hello Sambit";
		};
		System.out.println(prntName.namePrint());

//		With Only One Parameters
		printNameOneParameter prntNameOneParameter= (name) -> {
			return "My Name is : " + name;
		};
		System.out.println(prntNameOneParameter.namePrint("Sambit"));

//		With More Than One Parameters
		printNameMultipleParameter prntNameMultipleParameter = (firstName, lastName) ->
			   "My Name is : " + firstName + " " + lastName;//No Need to write return Statement
		System.out.println(prntNameMultipleParameter.printName("Sambit", "Pradhan"));
		return null;
	}

}
