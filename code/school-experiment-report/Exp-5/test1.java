import java.sql.Struct;
import java.util.Arrays;
import java.util.Vector;
import java.util.Scanner;

public class test1{
    public static void main(String[] args) {
        System.out.println("-- Test1 : Average Grade calculate --");
        // The dynamic array
        Vector<Student> students = new Vector<Student>();
        Scanner input = new Scanner(System.in);
        String name;
        double grade;
        while (true) {
            System.out.print("Please input the Student's name: ");
            name = input.next();
            if (name.equals("-1")) {
                break;
            }
            System.out.print("Please input the Student's grade: ");
            grade = input.nextDouble();

            while (true) {
                try {
                    if (grade == -1) {
                        break;
                    }
                    if (grade < 0 || grade > 100) {
                        throw new InvalidScoreException("Exp:input the grade again(0-100):");
                    } else {
                        break;
                    }    
                } catch (InvalidScoreException e) {
                    grade = e.getNewGrade();
                }
            }
            if (grade == -1) {
                break;
            }
            
            Student student = new Student(name, grade);
            students.add(student);
        }

        System.out.println();
        display(students);
    }

    public static String getAverGrade(Vector<Student> students) {
        double totalGrade = 0;
        for (Student student : students) {
            totalGrade += student.getGrade();
        }
        String result = String.format("%.1f", totalGrade/students.size());
        return result;
    }

    public static String getPassRate(Vector<Student> students) {
        double passCount = 0;
        for (Student student : students) {
            if (student.getGrade() >= 60) {
                passCount++;
            }
        }
        String result = String.format("%.3f", passCount/students.size());
        return Double.parseDouble(result)*100 + "%";
    }

    public static void display(Vector<Student> students) {
        for (Student student : students) {
            System.out.println(student.getName() + "\t" + student.getGrade());
        }
        System.out.println("====");
        System.out.println("平均成绩：" + getAverGrade(students));
        System.out.println("及格率：" + getPassRate(students));
    }
}

// ReList interface
interface ReList {
    public void add(Object obj);   // add item from arr's tail
    public Object get(int index);  // get index position's arr item
    public void clear();           // clear all the items
    public boolean isEmpty();      // judge the arr if have items
    public int size();             // get the number of arr's items
    public int capacity();         // get the capacity size
}

/**
 * Student
 */
class Student {
    private String name;
    private double grade;
    
    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
    
    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}

/**
 * StudentList
 */
class StudentList implements ReList {
    private Student[] students;

    public StudentList(int stuNum) {
        students = new Student[stuNum];
    }

    public void add(Object obj) {
        boolean ifAddObj = false;
        int stuLength = students.length;
        for (int i = 0; i < stuLength; i++) {
            if (students[i] == null) {
                students[i] = (Student)obj;
                ifAddObj = true;
                break;
            }
        }
        if (!ifAddObj) {
            students = Arrays.copyOf(students, stuLength+1);
            students[stuLength] = (Student)obj;
        }
    }

    public Object get(int index) {
        if (index >= students.length) {
            System.err.println("Hint: index error!");
            return null;
        } else {
            return students[index];
        }
    }

    public void clear() {
        students = new Student[students.length];
    }
    
    public boolean isEmpty() {
        for (Student student : students) {
            if (student != null) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        return students.length;
    }

    public int capacity() {
        return students.length * 4;
    }
}


class InvalidScoreException extends Exception {

    private static final long serialVersionUID = 1L;
    private double newGrade;

    public InvalidScoreException(String message) {
        System.out.print(message);
    }

    public double getNewGrade() {
        Scanner input = new Scanner(System.in);
        newGrade = input.nextDouble();
        return newGrade;
    }
}
