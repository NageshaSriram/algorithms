package algorithms;

import java.util.Arrays;
import java.util.List;

interface TesterFunctionalInterface{
	void whoIam();
}
interface TesterSum{
	int sum(int a, int b);
}

public class FunctionalInterface {

	public static void main(String[] args) {

		TesterFunctionalInterface fn = () -> System.out.print("You are functional Interface");
		
		TesterSum sum = (a,b) -> a+b;
		
		System.out.println(sum.sum(10, 30));
		
		fn.whoIam();
		
		List<Integer> nums = Arrays.asList(10,20,30,40,50,3,5,1,0);
		
		nums.stream().forEach(i-> System.out.println(i));
		
		nums.stream().filter(FunctionalInterface::isEven).map(i->i*10).forEach(System.out::println);
	}
	
	public static boolean isEven(int a) {
		if(a%2==1) {
			return false;
		}
		return true;
	}

}

