import java.io.*;

class Student implements Serializable {
    String studentID;
    String name;
    String grade;

    Student(String studentID, String name, String grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }
}

public class StudentSerialization {
    public static void main(String[] args) throws Exception {
        Student student = new Student("S101", "Komal Yadav", "A");

        FileOutputStream fos = new FileOutputStream("student.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(student);
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream("student.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student s = (Student) ois.readObject();
        ois.close();
        fis.close();

        System.out.println("Student ID: " + s.studentID);
        System.out.println("Name: " + s.name);
        System.out.println("Grade: " + s.grade);
    }
}
