package koushik.temp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student1 implements Comparable<Student> {
    int rollNumber;
    String name;
    int age;

    public Student1(int rollNumber, String name, int age) {
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
        return this.name.compareTo(other.getName());
    }
    public static Comparator<Student> ageComparatorDesc = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return Integer.compare(s2.getAge(), s1.getAge());
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
public class JavaPojo{
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"maruthi",21));
        students.add(new Student(2,"shiva",20));
        students.add(new Student(3,"karthik",17));
        students.add(new Student(4,"nithin",25));
        students.add(new Student(5,"koushik",21));
       for(Student student : students){
           System.out.println(student);
       }
    }
}
