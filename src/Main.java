import java.util.ArrayList;
import java.util.Comparator;

class Student {
    int rollno;
    String name;
    String address;

    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        // Display elements by the sorted value first
        if (Main.sortBy == SortBy.NAME) {
            return "Student Name: " + name + ", \nRoll Number: " + rollno + ",  \nStudent Address: " + address + "\n";
        } else if (Main.sortBy == SortBy.ROLL_NUMBER) {
            return "Roll Number: " + rollno + ", \nStudent Name: " + name + ",  \nStudent Address: " + address + "\n";
        } else if (Main.sortBy == SortBy.ADDRESS) {
            return "Student Address: " + address + ", \nRoll Number: " + rollno + ",  \nStudent Name: " + name + "\n";
        }
        return "";
    }
}

// specify sorting criteria
enum SortBy {
    NAME,
    ROLL_NUMBER,
    ADDRESS
}

public class Main {
    // Variable that holds current sorting value
    public static SortBy sortBy;

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        // generated random addresses from randomlists.com/random-addresses
        students.add(new Student(10, "Alice", "8101 North Victoria Street Vienna, VA 22180"));
        students.add(new Student(9, "Marvin", "27 Rock Creek St. Kings Mountain, NC 28086"));
        students.add(new Student(8, "Tyrell", "3 Trenton Ave. Shelton, CT 06484"));
        students.add(new Student(7, "David", "200 Theatre Street Salt Lake City, UT 84119"));
        students.add(new Student(6, "Lilly", "367 Lafayette Street Bakersfield, CA 93306"));
        students.add(new Student(5, "Frank", "476 Woodsman Drive Bethpage, NY 11714"));
        students.add(new Student(4, "Nora", "2 Briarwood St. Chesapeake, VA 23320"));
        students.add(new Student(3, "Hank", "299 Wall Dr. Port Washington, NY 11050"));
        students.add(new Student(2, "Ivy", "7216 W. Sutor St. Owatonna, MN 55060"));
        students.add(new Student(1, "Jack", "72 Maple Avenue Grovetown, GA 30813"));

        // Students by name
        sortBy = SortBy.NAME;
        StudentSort.selectionSort(students, Comparator.comparing(student -> student.name));
        System.out.println("Students by name:");
        System.out.println("-------------------\n");
        students.forEach(System.out::println);

        // Students by roll number
        sortBy = SortBy.ROLL_NUMBER;
        StudentSort.selectionSort(students, Comparator.comparingInt(student -> student.rollno));
        System.out.println("\nStudents by roll number:");
        System.out.println("-------------------\n");
        students.forEach(System.out::println);

        // Students by address
        sortBy = SortBy.ADDRESS;
        StudentSort.selectionSort(students, Comparator.comparing(student -> student.address));
        System.out.println("\nStudents by address:");
        System.out.println("-------------------\n");
        students.forEach(System.out::println);

    }
}
