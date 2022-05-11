class Student
{
    private final Name studentName;
    private final String studentNumber;
    private final Date dateOfBirth;
    private boolean graduated;

    Student(final Name studentName, final String studentNumber, final Date dateOfBirth, boolean graduated)
    {
        this.studentName   = studentName;
        this.studentNumber = studentNumber;
        this.dateOfBirth   = dateOfBirth;
        this.graduated     = graduated;
    }

    final Name getName()
    {
        return studentName;
    }

    final String getStudentNumber()
    {
        return studentNumber;
    }

    final Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public String isGraduated()
    {
        if (graduated) {
            return "graduated";
        } else {
            return "not graduated";
        }
    }
}

