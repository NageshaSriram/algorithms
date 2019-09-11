package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

interface TesterFunctionalInterface{
	void whoIam();
}
interface TesterSum{
	int sum(int a, int b);
	default int mul(int a,int b) {
		return a*b;
	}
	static float div(int a,int b) {
		return a/b;
	}
}

interface A{
	default int sum(int a,int b) {
		return 0;
	}
}
interface B{
	default int sum(int a,int b) {
		return 0;
	}
}

public class FunctionalInterface implements A,B{

	public static void main(String[] args) {

		TesterFunctionalInterface fn = () -> System.out.print("You are functional Interface");
		
		TesterSum sum = (a,b) -> a+b;
		
		System.out.println(sum.sum(10, 30));
		
		fn.whoIam();
		
		List<Integer> nums = Arrays.asList(10,20,30,40,50,3,5,1,0);
		
		nums.stream().forEach(i-> System.out.println(i));
		
		nums.stream().filter(FunctionalInterface::isEven).map(i->i*10).forEach(System.out::println);
		
		
		//sorting by streams
		Student s1 = new Student(1,"xyz");
		Student s2 = new Student(2,"abc");
		
		List<Student> slist = new ArrayList<>();
		slist.add(s1);
		slist.add(s2);
		System.out.println("Before sorting::"+ slist);
		

		List<Student> sortedList = slist.stream().sorted((o1,o2)-> {return o2.getId().compareTo(o1.getId());}).collect(Collectors.toList());
		
		System.out.println("After sorting::"+ sortedList);
		
		java.util.Collections.sort(slist, Student.sortByName);
		
		System.out.println("Sorting by name ::"+ slist);
	}
	
	public static boolean isEven(int a) {
		if(a%2==1) {
			return false;
		}
		return true;
	}

	public int sum(int a, int b) {
		A.super.sum(a,b);
		return 0;
	}

}

class Student{
	Integer id;
	String name;
	Student(Integer id, String name){
		this.id = id;
		this.name = name;
	}
	
	static Comparator<Student> sortByName = new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			
			return o1.getName().compareTo(o2.getName());
		}
	};
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}