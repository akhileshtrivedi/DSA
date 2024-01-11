package intermediate.dec_12;



    // Java Program to show
// How objects can an ArrayList hold

// Importing ArrayList class from
// java.util package
import java.util.ArrayList;
import java.util.List;

// Class
    public class ListManupulation {

        // Main driver method
        public static void main(String[] args)
        {

            // Make Person data-type objects
            Person p1 = new Person("Aditya", 19);
            Person p2 = new Person("Shivam", 19);
            Person p3 = new Person("Anuj", 15);
            Person p4 = new Person("AAAA", 0);
            Person p5 = new Person("BBB", 0);
            ArrayList<Person> names = new ArrayList<Person>();

            // Adding objects to the ArrayList
            names.add(p1);
            names.add(p2);
            names.add(p3);
            names.add(p4);
            names.add(p5);
            // Print and display the elements of adobe ArrayList
            // using get() method
            System.out.println(names.get(0).name);
            System.out.println(names.get(0).age);
            System.out.println(names.get(1).name);
            System.out.println(names.get(1).age);
            System.out.println(names.get(2).name);
            System.out.println(names.get(2).age);

            System.out.println(names.get(3).name);
            System.out.println(names.get(3).age);
            System.out.println(names.get(4).name);
            System.out.println(names.get(4).age);

            // New Line
            System.out.println();

         List<Person> finalList= names.stream().filter(x -> x.age > 0).toList();
           // long resultCount = names.stream().filter(x -> x.age == 0).count();
          // names.stream().reduce(p-> p.age==0).stream().count();
           // names.stream().filter()

            // Optional Part for better understanding
            System.out.println(
                    "Optional Part Added For Better Understanding"+finalList);
            finalList.stream().forEach(s-> System.out.println(s.name+"----Here---"+s.age));
            // (Optional)
            // Displaying what happens if printed by simply
            // passing List object as parameter
           // System.out.println(names);
        }
    }

    // Class user-defined
    class Person {

        // Random properties associated with the person
        // Person name
        String name;
        // Person age
        int age;

        // Constructor for class Person
        // for initializing objects
        Person(String name, int age)
        {
            // This keyword for efering to current object
            this.name = name;
            this.age = age;
        }
    }


