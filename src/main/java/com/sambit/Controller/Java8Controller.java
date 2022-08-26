package com.sambit.Controller;

import com.sambit.Entity.Reg;
import com.sambit.Service.RegService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.SessionTrackingMode;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

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
@FunctionalInterface
interface displaySchoolName{
	public String displaylName();
}

class printWelcomeData {
	static void data(){
		System.out.println("Hello, Welcome to CSM.");
	}
}
class printFullName{
	public static String printFullName(String fName, String lName){
		return "My Full Name is :" + fName + " "  + lName;
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

//	Method References:
//	There are Four Types of Method References are as Follows:
//			1. Method reference to an instance method of an object – object::instanceMethod
//			2. Method reference to a static method of a class – Class::staticMethod
//			3. Method reference to an instance method of an arbitrary object of a particular type – Class::instanceMethod
//			4. Method reference to a constructor – Class::new


//	Using of Type 1 Method Reference to an instance method of an object
	public String printSchoolName(){
		return "Saraswati Shihu Vidya Mandir, Salipur";
	}

	@GetMapping(value = "/methodReference1")
	public String MethodReference1(){
		Java8Controller java8Controller = new Java8Controller();
		displaySchoolName schoolName = java8Controller::printSchoolName;
		System.out.println(schoolName.displaylName());
		return null;
	}

//	Using of Type 2 Method Reference to a static method of a class
	@ResponseBody
	@GetMapping(value = "methodReference2")
	public String methodReference2(){
		BiFunction<String, String, String> fullName = printFullName::printFullName;
		System.out.println(fullName.apply("Sambit", "Pradhan"));
		return fullName.apply("Dillip", "Suna");
	}

//	Using of Type 3 Method Reference to an instance method of an arbitrary object of a particular type
	@ResponseBody
	@GetMapping(value = "methodReference3")
	public String methodReference3(){
//		For String Array Sort Using Method Reference
		String[] names = {"Sambit", "Dillip", "Mohit", "Jyoti", "Hrusikesh"};
		Arrays.sort(names, String::compareToIgnoreCase);
		for (int i = 0; i < names.length; i++) {
			System.out.println(i + " :  " + names[i]);
		}
//		For Integer Array Sort Using Method Reference
		Integer[] marks = {90, 89, 88, 87, 86};
//		Arrays.sort(marks, Integer::compare);//Working
//		Arrays.sort(marks, Integer::compareTo);//Working
//		Arrays.sort(marks, Integer::max);//Woking Max to Min
		Arrays.sort(marks, Integer::min);//Woking Min to Max
		System.out.println(Arrays.toString(marks));
 		return Arrays.toString(names);
	}

//	Using of Type 4 Method Reference to a constructor
	public class printTechnology{
		public printTechnology(String technology){
			System.out.println("My Technology is = " + technology);
		}
	}

	public interface prntTechnology{
		printTechnology technology(String technology);
	}

	@ResponseBody
	@GetMapping(value = "/methodReference4")
	public String methodReference4(){
		prntTechnology prtTechnology = printTechnology::new;
		prtTechnology.technology("Java");
		return null;
	}

	@ResponseBody
	@GetMapping(value = "/preDefinedFunctionalInterface")
	public String preDefinedFunctionalInterface(){
//		Using Of Predicate<T>
		Predicate<Integer> predicate = (i) -> (i == 10);
		System.out.println(predicate.test(10));

		Predicate<String> predicate1 = (data) -> {
			if (data == "Java"){
				System.out.println("Java");
				return true;
			}else {
				System.out.println("Other");
				return false;
			}
		};
		System.out.println(predicate1.test("Java"));

//		Using of Function<T, R>
		Function<String, Integer> function = String::length;
		System.out.println(function.apply("Sambit"));

		Function<String, Character> function1 = data -> data.charAt(5);
		System.out.println(function1.apply("Sambit"));

		String[] names = {"Sambit", "Debabrata", "Dillip", "Mohit"};
		Function<String[], Integer> function2 = data -> {
			System.out.println(Arrays.toString(names));
			for (int i = 0; i < names.length; i++) {
				if (names[i] == "Sambit") {
					System.out.println("Present");
					break;
				}
				else
					System.out.println("Absent");
			}
			return data.length;
		};
		System.out.println(function2.apply(names));

//		Using Consumer<T>
		Consumer<String> consumer = System.out::println;
		consumer.accept("Welcome To CSM Technologies");
		return String.valueOf(predicate1.test("Java"));
	}


	//Java 8 Stram Practice
//	Letter Count Using Java8 Stream
	@ResponseBody
	@GetMapping("/letterCount")
		public Map<String, Long> letterCount(){
		System.out.println("Inside Letter Count Method--------->>");
		Stream<String> words = Stream.of("Java", "is", "the", "best", "programming", "language");
		Stream<String> name = Stream.of("Sambit", "Debabrata", "Dillip", "Mohit");
		Stream<String> myName = Stream.of("Sambit Kumar Pradhan");

		Map<String, Long> letterToCount = myName.map(w -> w.split(""))
			   .flatMap(Arrays::stream)
			   .collect(groupingBy(identity(), counting()));

		System.out.println("Letter Count : " + letterToCount);
		return letterToCount;
	}

//	Word Count
	@ResponseBody
	@GetMapping(value = "/wordCount")
	public Map<String, Long> wordCount(){
		System.out.println("Inside Word Count Method--------->>");
		Stream<String> sentence = Stream.of("Java is the best programming language, Geek for Geeks is the best website to learn java");

		Map<String, Long> wordToCount = sentence.map(word -> word.split(" "))
			   .flatMap(Arrays::stream)
			   .collect(groupingBy(identity(),counting()));

		System.out.println("Word Count : " + wordToCount);
		return wordToCount;
	}


//	Sum of Integers using Stram Java 8
	@ResponseBody
	@GetMapping(value = "/sumOfIntegers")
	public String sumOfIntegers(){
		System.out.println("Inside Sum Of Integers Method--------->>");
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> stream = integers.stream();
		int sum = stream.reduce(0, (a, b) -> a + b);
		System.out.println("Sum Of Integers : " + sum);


		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int sum1 = numbers.reduce(0, Integer::sum);//Using of Lambda Expression
		System.out.println("Sum Of Integers : " + sum1);

		return sum +", " + sum1;
	}

}




//We Can Declare a Class Inside a Class by Using of Access Modifiers or Not
//But We Can Declare a Class outside a Class Without Access Modifiers