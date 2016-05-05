package sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.swing.JButton;

public class Samples {
	
	public static void doSomething(ActionEvent e) {
		System.out.println("hello");
	}
	
	public static void some(String... names) {
		System.out.println(names.length);
	}
	
	

	public static void main(String[] args) {
		
		some("ad", "adf", "adsf");
		
		List<String> names = Arrays.asList("Mati", "Kati", "Toomas", "Teet");
		
		names.stream().filter(s -> s.contains("a")).forEach(System.out::println);
		Object[] lengths = names.stream().map(s -> s.length()).toArray();
		System.out.println(Arrays.toString(lengths));
		
		//print(names, s -> s.contains("a"));
		//print(names, s -> s.length() > 4);
		
		List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 6);
		iterate(numbers, number -> number != 2, n -> System.out.println(n * n));		
	}
	
	public static <T> void iterate(List<T> values, Predicate<T> condition, Consumer<T> consumer) {
		for (T o : values) {
			if (condition.test(o)) {
				consumer.accept(o);
			}
		}
	}
	
	public static <T> void print(List<T> names, Predicate<T> condition) {
		iterate(names, condition, System.out::println);
	}
	
	

}
