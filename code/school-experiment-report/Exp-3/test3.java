import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        System.out.println("-- Test3 : Student Info Weigthed Grade --");

        // Class
        Class myClass = new Class("计科17级1班", 5);

        // Student
        Student stu_fmw = new Student(17001, "范茂伟", 3);
        // Course
        Course java_fmw = new Course(11001, "Java程序设计", 4);
        Course cpp_fmw = new Course(11002, "C++程序设计", 5);
        Course math_fmw = new Course(11003, "高等数学", 3);
        Course demo_fmw = new Course(11002, "课程id重复测试对象", 5.5);
        // add course to student
        java_fmw.stuInfo(false, 95);
        stu_fmw.addCourse(java_fmw);
        cpp_fmw.stuInfo(false, 86);
        stu_fmw.addCourse(cpp_fmw);
        math_fmw.stuInfo(true, 68);
        stu_fmw.addCourse(math_fmw);
        demo_fmw.stuInfo(false, 76);
        stu_fmw.addCourse(demo_fmw);
        System.out.println();

        // Student
        Student stu_txy = new Student(17002, "唐小钰", 1);
        // Course
        Course math_txy = new Course(11003, "高等数学", 3);
        // add course to student
        math_txy.stuInfo(false, 98);
        stu_txy.addCourse(math_txy);
        System.out.println();

        // Student
        Student stu_demo3 = new Student(17003, "demo3", 2);
        // Course
        Course java_demo3 = new Course(11001, "Java程序设计", 4);
        Course cpp_demo3 = new Course(11002, "C++程序设计", 5);
        // add course to student
        java_demo3.stuInfo(false, 89);
        stu_demo3.addCourse(java_demo3);
        cpp_demo3.stuInfo(false, 76);
        stu_demo3.addCourse(cpp_demo3);
        System.out.println();

        // Student
        Student stu_demo4 = new Student(17004, "demo4", 2);
        // Course
        Course java_demo4 = new Course(11001, "Java程序设计", 4);
        Course cpp_demo4 = new Course(11002, "C++程序设计", 5);
        // add course to student
        java_demo4.stuInfo(false, 78);
        stu_demo4.addCourse(java_demo4);
        cpp_demo4.stuInfo(false, 69);
        stu_demo4.addCourse(cpp_demo4);
        System.out.println();

        // Student
        Student stu_demo5 = new Student(17005, "demo5", 1);
        // Course
        Course java_demo5 = new Course(11001, "Java程序设计", 4);
        // add course to student
        java_demo5.stuInfo(false, 92);
        stu_demo5.addCourse(java_demo5);
        System.out.println();

        // Student
        Student stu_text = new Student(17004, "学生id重复测试对象", 0);
        
        myClass.addStudent(stu_fmw);
        myClass.addStudent(stu_txy);
        myClass.addStudent(stu_demo3);
        myClass.addStudent(stu_demo4);
        myClass.addStudent(stu_demo5);
        myClass.addStudent(stu_text);
        System.out.println();


        // calculate weigthed grade
        myClass.calculateWeightedGrade();
        System.out.println();

        Scanner input = new Scanner(System.in);
        System.out.print("Please input the student's id for searching : ");
        int choose = input.nextInt();
        while (choose != -1) {
            myClass.search(choose);
            System.out.print("\nPlease input the student's id for searching : ");
            choose = input.nextInt();
            if (choose == -1) {
                System.out.println("System is ready to exit!");
            }
        }
        input.close();
    }
}

/**
 * Class
 */
class Class {
    private String name;
    private int stuNum;
    private Student[] students;

    public Class(String name, int nStudent) {
        this.name = name;
        stuNum = nStudent;
        students = new Student[stuNum];
    }

    public void addStudent(Student student) {
        // if student id repeat
        boolean idRepeat = false;
        // if not enough stuNum
        boolean ifAdd = false;
        for (int i = 0; i < stuNum; i++) {
            if (students[i] != null && students[i].getId() == student.getId()) {
                idRepeat = true;
                System.out.println(name + " hint : The add student " + student + "'s id repeat as before.");
                break;
            }
            if (students[i] == null && !ifAdd) {
                students[i] = student;
                System.out.println(name + " hint : Add student " + student + " success!");
                ifAdd = true;
            }
        }
        // enough stuNum
        if (!ifAdd && !idRepeat) {
            stuNum += 1;
            List<Student> list = new ArrayList<Student>(Arrays.asList(students));
            list.add(student);
            students = new Student[stuNum];
            list.toArray(students);
            System.out.println(name + " hint : Add student " + student + " success!");
        }
    }

    public void calculateWeightedGrade() {
        for (Student student : students) {
            student.calculateWeightedGrade();
        }
    }

    @Override
    public String toString() {
        return "<class name : " + name + ", the number of students : " + stuNum + ">";
    }

    public void search(int id) {
        boolean ifSearched = false;
        for (Student student : students) {
            if (student.getId() == id && !ifSearched) {
                student.printStudentInfo();
                ifSearched = true;
            }
        }
        if (!ifSearched) {
            System.out.println("Sorry, id<" + id + "> didn't find!");
        }
    }

}

/**
 * Student
 */
class Student {
    private int id;
    private String name;
    private int courseNum;
    private Course[] courses;

    public Student(int id, String name, int nCourse) {
        this.id = id;
        this.name = name;
        courseNum = nCourse;
        courses = new Course[courseNum];
    }

    public void addCourse(Course course) {
        // if course id repeat
        boolean idRepeat = false;
        // if not enough courseNum
        boolean ifAdd = false;
        for (int i = 0; i < courseNum; i++) {
            if (courses[i] != null && courses[i].getId() == course.getId()) {
                idRepeat = true;
                System.out.println(name + " hint : The add course " + course + "'s id repeat as before.");
                break;
            }
            if (courses[i] == null && !ifAdd) {
                courses[i] = course;
                ifAdd = true;
                System.out.println(name + " hint : Add course " + course + " success!");
            }
        }
        // enough courseNum
        if (!ifAdd && !idRepeat) {
            courseNum += 1;
            List<Course> list = new ArrayList<Course>(Arrays.asList(courses));
            list.add(course);
            courses = new Course[courseNum];
            list.toArray(courses);
            System.out.println(name + " hint : Add course " + course + " success!");
        }
    }

    public int getId() {
        return id;
    }

    public void calculateWeightedGrade() {
        double totalScore = 0;
        double totalcredit = 0;
        for (Course course : courses) {
            if (!course.isDelayExam()) {
                totalScore += course.getScore() * course.getCredit();
                totalcredit += course.getCredit();
            }
        }
        System.out.println(toString() + " weighted grade is : " + (totalScore/totalcredit));
    }

    public void printStudentInfo() {
        // Student name and id
        System.out.println(toString());
        // Course info
        for (Course course : courses) {
            System.out.println(course + " is delayed exam? " + course.isDelayExam() + ", the score is : " + course.getScore());
        }
        // Weighted grade
        calculateWeightedGrade();
    }

    @Override
    public String toString() {
        return "<Student:" + name + ", id:" + id + ">";
    }
    
}

/**
 * Course
 */
class Course {
    private int id;
    private String name;
    private double credit;
    private boolean isDelayExam;
    private double score;

    Course(int id, String name, double credit) {
        this.id = id;
        this.name = name;
        this.credit = credit;
    }

    public void stuInfo(boolean isDelayExam, double score) {
        this.isDelayExam = isDelayExam;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public double getCredit() {
        return credit;
    }

    public double getScore() {
        return score;
    }

    public boolean isDelayExam() {
        return isDelayExam;
    }

    @Override
    public String toString() {
        return "<Course name : " + name + ", id : " + id + ", credit : " + credit + ">";
    }

}