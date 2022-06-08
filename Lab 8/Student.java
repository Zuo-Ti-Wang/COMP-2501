package ca.bcit.comp2501.ruisitang;

public class Student
{
    private final String  firstName;
    private final String  lastName;
    private final String  idNumber;
    private final int     birthYear;
    private final double  percentageGrade;
    private final boolean pass;

    private static final double PASSING_GRADE = 60;
    private static final int    RUISI_BIRTH_YEAR = 1996;
    private static final double RUISI_GRADE = 100;
    private static final int    MIN_BIRTH_YEAR = 1900;
    private static final int    MAX_BIRTH_YEAR = 2021;
    private static final double MAX_GRADE_PERCENTAGE = 100;
    private static final double MIN_GRADE_PERCENTAGE = 0;


    public Student(final String firstName, final String lastName, final String idNumber, final int birthYear,
                   final double percentageGrade)
    {
        if(!firstName.isBlank() &&
           !lastName.isBlank() &&
           !idNumber.isBlank() &&
           birthYear >= MIN_BIRTH_YEAR &&
           birthYear <= MAX_BIRTH_YEAR &&
           percentageGrade >= MIN_GRADE_PERCENTAGE &&
           percentageGrade <= MAX_GRADE_PERCENTAGE)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.idNumber = idNumber;
            this.birthYear = birthYear;
            this.percentageGrade = percentageGrade;
        }
        else
        {
            throw new IllegalArgumentException();
        }

        pass = percentageGrade > PASSING_GRADE;
    }

    public Student()
    {
        this.firstName = "Ruisi";
        this.lastName = "Tang";
        this.birthYear = RUISI_BIRTH_YEAR;
        this.percentageGrade = RUISI_GRADE;
        this.idNumber = "A01304235";
        pass = true;
    }

    /**
     * getter for first name.
     * @return
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * getter for last name.
     * @return
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * getter for id number.
     * @return
     */
    public String getIdNumber()
    {
        return idNumber;
    }

    /**
     * getter for birth year.
     * @return
     */
    public int getBirthYear()
    {
        return birthYear;
    }

    /**
     * getter for % grade.
     * @return
     */
    public double getPercentageGrade()
    {
        return percentageGrade;
    }

    @Override
    public String toString()
    {
        return "Student [firstName= " + firstName + ", lastName= " + lastName + ", idNumber= " + idNumber +
                        ", birthYear= " + birthYear + ", percentageGrade= " + percentageGrade + ", pass=" + pass + "] :^)";
    }
}
