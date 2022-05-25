/**
 * @author Ruisi Tang
 * @version 1.0
 */
public class StarWarName
{
    private final String userInputNameArguments;
    private static final int INPUT_NAME_SPLIT_LIMIT = 4;


    public StarWarName(String userInputNameArguments)
    {
        if(userInputNameArguments == null)
        {
            throw new IllegalArgumentException("missing data input");
        }
        else if(userInputNameArguments.isBlank())
        {
            throw new IllegalArgumentException("missing data input");
        }

        this.userInputNameArguments = userInputNameArguments;
    }

    /**
     * this method prints out the message to give the star war name.
     * @throws Error when user input name argument can be split to less than four strings.
     */
    public final void getStarWarName()
            throws Error
    {
        String starWarFirstName;
        String starWarLastName;
        String[] starWarNameArray = userInputNameArguments.split("\\|", INPUT_NAME_SPLIT_LIMIT);

        for(String a: starWarNameArray)
        {
            if(a.isBlank())
            {
                throw new Error("ERROR: incorrect number of words provided.");
            }
        }

        starWarFirstName = starWarNameArray[0].substring(0,1).toUpperCase() +
                           starWarNameArray[0].substring(1,3).toLowerCase() +
                           starWarNameArray[1].substring(0,2).toLowerCase();
        starWarLastName = starWarNameArray[2].substring(0,1).toUpperCase() +
                          starWarNameArray[2].substring(1,2).toLowerCase() +
                          starWarNameArray[3].substring(0,3).toLowerCase();

        System.out.format("Your Star War name is: %s %s \n", starWarFirstName, starWarLastName);
    }
}
