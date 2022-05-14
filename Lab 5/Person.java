import java.util.Locale;
/***
 * @author Ruisi Tang
 * @version 1.0
 */
public class Person
{
    private final String firstName;
    private final String lastName;
    private final int    birthYear;
    private final String married;
    private final double weightInPounds;
    private final String highestEducation;

    private static final int CURRENT_YEAR = 2022;
    private static final double POUND_TO_KG = 0.454;

    //first constructor
    public Person(final String firstName, final String lastName, final int birthYear, final String married,
                  final double weightInPounds, final String highestEducation)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        if(isValidMarriageStatus(married))
        {
            this.married = married;
        }
        else
        {
            throw new IllegalArgumentException("wrong marriage status");
        }
        this.weightInPounds = weightInPounds;
        if(isValidEducationLevel(highestEducation))
        {
            this.highestEducation = highestEducation;
        }
        else
        {
            throw new IllegalArgumentException("wrong education level");
        }
    }

    //second constructor
    public Person(final String firstName, final String lastName, final String married, final double weightInPounds,
                  final String highestEducation)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = CURRENT_YEAR;
        if(isValidMarriageStatus(married))
        {
            this.married = married;
        }
        else
        {
            throw new IllegalArgumentException("wrong marriage status");
        }
        this.weightInPounds = weightInPounds;
        if(isValidEducationLevel(highestEducation))
        {
            this.highestEducation = highestEducation;
        }
        else
        {
            throw new IllegalArgumentException("wrong education level");
        }
    }

    //third constructor
    public Person(final String firstName, final String lastName, final double weightInPounds)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = CURRENT_YEAR;
        this.married = "no";
        this.weightInPounds = weightInPounds;
        this.highestEducation = "high school";
    }

    /***
     * getters for all instance variables.
     * @return the corresponded instance variable.
     */
    public final String getFirstName()
    {
        return firstName;
    }

    public final String getLastName()
    {
        return lastName;
    }

    public final int getBirthYear()
    {
        return birthYear;
    }

    public final String isMarried()
    {
        return married;
    }

    public final double getWeightInPounds()
    {
        return weightInPounds;
    }

    public final String getHighestEducation()
    {
        return highestEducation;
    }

    /***
     * education level validator
     * @param educationLevelToVerify a string that must be "high school" or "undergraduate" or "graduate"
     * @return true or false
     */
    private boolean isValidEducationLevel(String educationLevelToVerify)
    {
        return educationLevelToVerify.equalsIgnoreCase("high school")   |
                educationLevelToVerify.equalsIgnoreCase("undergraduate") |
                educationLevelToVerify.equalsIgnoreCase("graduate");
    }

    /***
     * marriage status validator
     * @param marriageStatusToVerify a string that must be "yes" or "no" or "divorced"
     * @return true or false
     */
    private boolean isValidMarriageStatus(String marriageStatusToVerify)
    {
        return marriageStatusToVerify.equalsIgnoreCase("yes")   |
                marriageStatusToVerify.equalsIgnoreCase("no") |
                marriageStatusToVerify.equalsIgnoreCase("divorced");
    }

    /***
     * method 1
     * prints out the detailed information of the person.
     */
    public final void printDetails()
    {
        String marriageStatus;
        String educationLevel;

        //figures out the marriage status of the person
        if(isMarried().equalsIgnoreCase("yes"))
        {
            marriageStatus = "married";
        }
        else
        {
            if(isMarried().equalsIgnoreCase("no"))
            {
                marriageStatus = "single";
            }
            else
            {
                marriageStatus = "divorced";
            }
        }

        //figures out the education level of the person
        if(getHighestEducation().equalsIgnoreCase("high school"))
        {
            educationLevel = "a high school diploma";
        }
        else
        {
            if(getHighestEducation().equalsIgnoreCase("undergraduate"))
            {
                educationLevel = "an undergraduate degree";
            }
            else
            {
                educationLevel = "a graduate degree";
            }
        }

        //prints out the message
        String printOut = String.format("%s %s(%s) was born in %d, weights %.1f pounds, and has %s!",firstName, lastName,
                marriageStatus, birthYear, weightInPounds, educationLevel);
        System.out.println(printOut);
    }

    /***
     * methods 2
     * prints out the detailed information of the person.
     * @param kilograms a boolean variable to specify if the weight of the person will be in kilos or pounds.
     */
    public final void printDetails(boolean kilograms)
    {
        String marriageStatus;
        String educationLevel;
        double weight;

        //figures out the marriage status of the person
        if(isMarried().equalsIgnoreCase("yes"))
        {
            marriageStatus = "married";
        }
        else
        {
            if(isMarried().equalsIgnoreCase("no"))
            {
                marriageStatus = "single";
            }
            else
            {
                marriageStatus = "divorced";
            }
        }

        //figures out the education level of the person
        if(getHighestEducation().equalsIgnoreCase("high school"))
        {
            educationLevel = "a high school diploma";
        }
        else
        {
            if(getHighestEducation().equalsIgnoreCase("undergraduate"))
            {
                educationLevel = "an undergraduate degree";
            }
            else
            {
                educationLevel = "a graduate degree";
            }
        }

        //pounds to kilo converter
        if (kilograms)
        {
            weight = weightInPounds * POUND_TO_KG;
            String printOut = String.format("%s %s(%s) was born in %d, weights %.1f kilograms, and has %s!",firstName,
                    lastName, marriageStatus, birthYear, weight, educationLevel);
            System.out.println(printOut);
        }
        else
        {
            weight = weightInPounds;
            String printOut = String.format("%s %s(%s) was born in %d, weights %.1f pounds, and has %s!",firstName,
                    lastName, marriageStatus, birthYear, weight, educationLevel);
            System.out.println(printOut);
        }
    }

    /***
     * methods 3
     * @param kilograms a boolean variable to specify if the weight of the person will be in kilos or pounds.
     * @param uppercase a boolean variable to specify if the name of the person will be printed in upper or power cases.
     */
    public final void printDetails(boolean kilograms, boolean uppercase)
    {
        String marriageStatus;
        String educationLevel;
        double weight;

        //figures out the marriage status of the person
        if(isMarried().equalsIgnoreCase("yes"))
        {
            marriageStatus = "married";
        }
        else
        {
            if(isMarried().equalsIgnoreCase("no"))
            {
                marriageStatus = "single";
            }
            else
            {
                marriageStatus = "divorced";
            }
        }

        //figures out the education level of the person
        if(getHighestEducation().equalsIgnoreCase("high school"))
        {
            educationLevel = "a high school diploma";
        }
        else
        {
            if(getHighestEducation().equalsIgnoreCase("undergraduate"))
            {
                educationLevel = "an undergraduate degree";
            }
            else
            {
                educationLevel = "a graduate degree";
            }
        }

        //pounds to kilo converter with an upper lower case checker
        if (kilograms)
        {
            weight = weightInPounds * POUND_TO_KG;
            //upper lower case checker and print out message
            String printOut;
            if(uppercase)
            {
                printOut = String.format("%s %s(%s) was born in %d, weights %.1f kilograms, and has %s!",
                        getFirstName().toUpperCase(), getLastName().toUpperCase(), marriageStatus, birthYear, weight,
                        educationLevel);
            }
            else
            {
                printOut = String.format("%s %s(%s) was born in %d, weights %.1f kilograms, and has %s!",
                        getFirstName().toLowerCase(), getLastName().toLowerCase(), marriageStatus, birthYear, weight,
                        educationLevel);
            }
            System.out.println(printOut);
        }
        else
        {
            weight = weightInPounds;
            //upper lower case checker and print out message
            String printOut;
            if(uppercase)
            {
                printOut = String.format("%s %s(%s) was born in %d, weights %.1f pounds, and has %s!",
                        getFirstName().toUpperCase(), getLastName().toUpperCase(), marriageStatus, birthYear, weight,
                        educationLevel);
            }
            else
            {
                printOut = String.format("%s %s(%s) was born in %d, weights %.1f pounds, and has %s!",
                        getFirstName().toLowerCase(), getLastName().toLowerCase(), marriageStatus, birthYear, weight,
                        educationLevel);
            }
            System.out.println(printOut);
        }
    }
}
