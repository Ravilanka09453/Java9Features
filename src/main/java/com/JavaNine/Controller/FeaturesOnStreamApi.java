package com.JavaNine.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeaturesOnStreamApi {

	List<Integer> sample1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	List<Integer> sample2 = Arrays.asList(1, 2, null, 4, null, 6, 7, 8, null, 10);

	/**
	 * 
	 * takewhile method is similar to filter since it returns stream of elements
	 * that match the given predicate The major difference between filter and take
	 * while is In a given set of elements take while will consider the predicated
	 * satisfied first elements only
	 */

	@GetMapping("/takewhile")
	public List<Integer> takeWhile() {
		List<Integer> result = sample1.stream().takeWhile(sample1 -> sample1 < 5).collect(Collectors.toList());
		return result;

	}

	/**
	 * Opposite to takewhile method,it return the elements which doesn't satisfy
	 * predicate.
	 * 
	 * @return
	 */

	@GetMapping("/dropwhile")
	public List<Integer> dropWhile() {
		List<Integer> result = sample1.stream().dropWhile(sample1 -> sample1 < 5).collect(Collectors.toList());
		return result;

	}

	/**
	 * Iterate method in java9 gives flexibility to declare
	 * initialization,condition,increment in one go as shown below
	 *
	 */

	@GetMapping("/iterate")
	public List<Integer> iterateExample() {
		List<Integer> result = Stream.iterate(1, num -> num < 10, num -> num + 1).collect(Collectors.toList());
		return result;
	}

	/**
	 * 
	 * Nullable method ignorance the null in the given list as shown below.
	 */

	@GetMapping("/nullable")
	public List<Integer> ofNullable() {
		List<Integer> result = sample2.stream().flatMap(sample2 -> Stream.ofNullable(sample2))
				.collect(Collectors.toList());
		return result;
	}

}
