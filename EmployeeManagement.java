import java.io.*;
import java.util.Scanner;

class Employee implements Serializable {
    String id;
    String name;
    String designation;
    double salary;

    Employee(String id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public String toString() {
        return id + " | " + name + " | " + designation + " | " + salary;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        File file = new File("employees.dat");

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Employee ID: ");
                String id = sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Designation: ");
                String designation = sc.nextLine();
                System.out.print("Enter Salary: ");
                double salary = sc.nextDouble();
                sc.nextLine();

                Employee emp = new Employee(id, name, designation, salary);
                FileOutputStream fos = new FileOutputStream(file, true);
                ObjectOutputStream oos = file.length() == 0 ? 
                    new ObjectOutputStream(fos) : new AppendableObjectOutputStream(fos);
                oos.writeObject(emp);
                oos.close();
                fos.close();
            } else if (choice == 2) {
                if (!file.exists() || file.length() == 0) {
                    System.out.println("No records found.");
                } else {
                    FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    try {
                        while (true) {
                            Employee e = (Employee) ois.readObject();
                            System.out.println(e);
                        }
                    } catch (EOFException e) {
                    }
                    ois.close();
                    fis.close();
                }
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }
        }
        sc.close();
    }
}

class AppendableObjectOutputStream extends ObjectOutputStream {
    AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
    protected void writeStreamHeader() throws IOException {}
}
