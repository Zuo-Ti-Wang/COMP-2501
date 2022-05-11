/**
 * @author Robert Culver and Ruisi Tang and Lillian Vu
 * @verion 1.0
 */

public class Main
{
    public static void main(final String[] args)
    {
        Student s1 = new Student(new Name("Tiger","Woods") , "A00123456", new Date(1975, 12, 30), true);
        Student s2 = new Student(new Name("Bill","Gates") , "A00987654", new Date(1955, 10, 28), false);

        System.out.print(s1.getName().getFullName());
        System.out.print("(" + s1.getName().getInitials() + ")");
        System.out.print("(st# " + s1.getStudentNumber() + ") ");
        System.out.print("was born on " + s1.getDateOfBirth().getYyMMmDd() + ". ");
        System.out.print("The student is " + s1.isGraduated()+ ".");
        System.out.println();

        System.out.print(s2.getName().getFullName());
        System.out.print("(" + s2.getName().getInitials() + ")");
        System.out.print("(st# " + s1.getStudentNumber() + ") ");
        System.out.print("was born on " + s1.getDateOfBirth().getYyMMmDd() + ". ");
        System.out.print("The student is " + s2.isGraduated() + ".");
        System.out.println();
    }
}
