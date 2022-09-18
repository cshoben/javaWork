/**
 * Adapted from Keep on Coding: Java Streams Tutorial
 * https://www.youtube.com/watch?v=FWoYpM-E3EQ
 * @author Chelsea Shoben
 * 
 */



import java.util.*;
import java.util.stream.Collectors;

class streams {
    static class Person {
        String name;
        int billions;

        //constructor
        public Person(String name, int billions) {
            this.name = name;
            this.billions = billions;
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person ("Jeff Bezos", 131));
        people.add(new Person ("Bill Gates", 100));
        people.add(new Person ("Warren Buffett", 83));
        people.add(new Person ("Bernard Arnault", 76));



/*** Example with filtering: 
* Type list you want to filer dot stream() dot filter for each person with 
* the arrow notation and then do it on what we want to filter on. 
* Since we want a new list, we do dot collect, and Collectors to list(). 
* This whole thing will return a list.
* So then we can set this whole thing equal to the hundredClud list.  
***/


// with streams:
/* 
        List<Person> hundredClub = people.stream()
        .filter(person -> person.billions >= 100)
        .collect(Collectors.toList());
*/

// filtering solution without streams:
        /* 

        List<Person> hundredClub = new ArrayList<>();

        for (Person p : people) {
            if (p.billions >= 100) {
                hundredClub.add(p);
            }
        }
*/
        //hundredClub.forEach(person -> System.out.println(person.name));




/*** Example with sorting:
* Since we are sorting on an object we need to tell it what we want to sort on. 
* We can use a comparator to do that. 
* Comparator.comparing with arrow notation as below. 
* Then call collect function.  
***/

/*
List<Person> sortedList = people.stream()
.sorted(Comparator.comparing(person -> person.name))
.collect(Collectors.toList());

sortedList.forEach(person -> System.out.println(person.name));
*/


/*** Example stacking streams
 * We can use multiple streams at once. 
 * We can chain the methods
 */


List<Person> hundredSortedClub = people.stream()
.filter(person -> person.billions >= 100)
.sorted(Comparator.comparing(person -> person.name))
.collect(Collectors.toList());

hundredSortedClub.forEach(person -> System.out.println(person.name));

    }
}