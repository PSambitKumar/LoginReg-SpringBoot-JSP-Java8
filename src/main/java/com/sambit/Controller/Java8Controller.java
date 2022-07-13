package com.sambit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Scanner;

interface Arithmetic{
	public int operation (int a, int b);
}

@FunctionalInterface
interface areaOfTriangle {
	public void area();
}

@FunctionalInterface
interface PrintName{
	public String print();
}

@Controller
public class Java8Controller {

	@GetMapping(value = "/java8ArithmeticOperation")
	public String arithmeticOperation(){
		System.out.println("Inside Arithmetic Operation Using JAVA 8 Lambda Function---------->>");
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter First Number: ");
		int x = scanner.nextInt();
		System.out.println("Enter Second Number: ");
		int y = scanner.nextInt();

//        For Addition
		Arithmetic arithmetic = (a, b)->{
			return a+b;
		};
		System.out.println("Addition of of these numbers are: " + arithmetic.operation(x,y));

//        For Multiplication
		Arithmetic arithmetic1 = (int a, int b)->{
			return a*b;
		};
		System.out.println("Multiplication of these two numbers are: " + arithmetic1.operation(x,y));

		//    For Substraction
		Arithmetic arithmetic2 = (a, b)-> {
			return a-b;
		};
		System.out.println("Substraction of these thwo numbers are: " + arithmetic2.operation(x,y));
		return null;
	}

	@ResponseBody
	@GetMapping(value = "/arrayListEx1")
	public String arrayListEx1(){
		String name = null;
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


}
