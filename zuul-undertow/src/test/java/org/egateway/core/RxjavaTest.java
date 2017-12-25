package org.egateway.core;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class RxjavaTest {
	
	public static String potentialException(String s){
		if ( s.equals("null") ){
			throw new RuntimeException(s);
		}
		return "potentialException " + s;
	}
	
	public static String anotherPotentialException(String s){
		if ( s.equals("null") ){
			throw new RuntimeException(s);
		}
		return "anotherPotentialException " + s;
	}
	
	public static void main(String args[]){
		Observable.just("Some String") // Computation
		  .observeOn(Schedulers.computation()) // -- changing the thread
		  .map(str -> str.length()) // Computation
		  .map(length -> 2 * length) // Computation
		  .subscribe(number -> System.out.println(number));// Computation;
	}
}
