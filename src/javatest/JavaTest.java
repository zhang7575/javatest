package javatest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Consumer;

public class JavaTest {
	
	
	
	public void modTest(String input, int seed) {
		int output = input.hashCode()%seed;
		System.out.println(input.hashCode());
		System.out.println(output);
		
	}
	
	public void modTest(int input, int seed) {
		int output = input%seed;
		System.out.println(input);
		System.out.println(output);
		
	}
	
	public void stringTest(String input) {
		input = "OK";
		System.out.println(input);
	}

	
	public static void main(String[] args) {
		ForkJoinPool p = new ForkJoinPool(1);
		
		Consumer<JavaTest> a = (input)->System.out.println(input.toString());
		// TODO Auto-generated method stub
		JavaTest t = new JavaTest();
		//t.modTest("17.99", 5);
		t.modTest(32, 1);
		t.stringTest("abc");
		List<String> list = new ArrayList<String>();
		list.add("great");
		list.stream().map(input->input.length());
	}

}

class Child extends JavaTest{
	
}
