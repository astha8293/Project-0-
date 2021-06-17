package com.day4.sort;

import java.util.ArrayList;
import java.util.Collections;

public class MovieMain {
	public static void main(String[] args) {
		ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));
        
        System.out.println(list);
        Collections.sort(list); // natural sorting
        System.out.println(list);
        
        //ratingcompare
        RatingCompare ratingCompare = new RatingCompare();
        Collections.sort(list, ratingCompare);
        System.out.println(list);
        
	}

}
