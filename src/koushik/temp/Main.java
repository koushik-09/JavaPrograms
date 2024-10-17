package koushik.temp;

import java.util.*;
class Student implements Comparable<Student> {
    private int rollNumber;
    private String name;
    private int age;

    public Student(int rollNumber, String name, int age) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
    }
    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public int compareTo(Student other) {
        return other.getName().compareTo(this.name);
    }

    public static Comparator<Student> ageComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return s2.getAge() - s1.getAge();
        }
    };

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"maruthi",21));
        students.add(new Student(2,"shiva",20));
        students.add(new Student(3,"karthik",17));
        students.add(new Student(4,"nithin",25));
        students.add(new Student(5,"koushik",21));
        Collections.sort(students);
        System.out.println("Students sorted by name");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
        Collections.sort(students, Student.ageComparator);
        System.out.println("Students sorted by age");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
