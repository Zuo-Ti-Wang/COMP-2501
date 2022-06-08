package ca.bcit.comp2501.ruisitang;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab8Driver
{
    private HashMap<String, Student> students;

    public Lab8Driver(HashMap<String, Student> students)
    {
        this.students = students;
    }

    /**
     * This method will use scanner to allow users to enter student data when prompted.
     */
    public final void readFromPrompt()
    {
        Scanner scanner = new Scanner(System.in);
        boolean proceed = true;

        do
        {
            System.out.println("Do you wish to create a Student? (y/n): ");
            String choice = scanner.next().toLowerCase();

            if (choice.equals("y"))
            {
                System.out.println("Please enter first name:");
                String firstName = scanner.next();

                System.out.println("Please enter last name:");
                String lastName = scanner.next();

                System.out.println("Please enter student number:");
                String idNumber = scanner.next();

                System.out.println("Please enter birth year:");
                int birthYear = scanner.nextInt();

                System.out.println("Please enter %grade:");
                double percentageGrade = scanner.nextDouble();

                Student student = new Student(firstName, lastName, idNumber, birthYear, percentageGrade);
                students.put(student.getIdNumber(), student);
            }
            else
            {
                proceed = false;
                System.out.println("Data entry finished!");
            }
        } while (proceed);

        scanner.close();
    }

    /**
     * This method will read data from the student_data.txt file and create Student objects and add them to the HashMap.
     * @throws FileNotFoundException
     */
    public final void readFromFile() throws FileNotFoundException
    {
        File studentData = new File("student_data.txt");
        try
        {
            Scanner scanner = new Scanner(studentData);

            while (scanner.hasNext())
            {
                String firstName = scanner.next();
                String lastName = scanner.next();
                String idNumber = scanner.next();
                int birthYear = scanner.nextInt();
                double percentageGrade = scanner.nextDouble();

                scanner.close();

                Student student = new Student(firstName, lastName, idNumber, birthYear, percentageGrade);
                students.put(student.getIdNumber(), student);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method will display the contents of the HashMap to the console calling Student.toString() for each Student.
     */
    public final void showStudents()
    {
        System.out.println("DEBUG: calling readFromFile\n" + "List of Students created:");
        students.forEach((key,value) -> System.out.println(value.toString()));
    }

    public static void main(final String[] args) throws FileNotFoundException
    {
        HashMap<String, Student> students = new HashMap<>();
        Lab8Driver demo = new Lab8Driver(students);
        demo.readFromPrompt();
        //demo.readFromFile();
        demo.showStudents();
    }
}
