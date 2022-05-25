public class Main
{
    public static void main(final String[] args)
    {
        // good argument
        try
        {
            StarWarName elonMusk = new StarWarName("elon|musk|haldeman|pretoria");
            elonMusk.getStarWarName();
        }
        catch(Error e)
        {
            System.out.println(e.getMessage());
        }

        // argument has less than four strings
        try
        {
            StarWarName ruisiTang = new StarWarName("ruisi||zhang|zhengzhou");
            ruisiTang.getStarWarName();
        }
        catch(Error e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            StarWarName anonymous = new StarWarName("|||");
            anonymous.getStarWarName();
        }
        catch(Error e)
        {
            System.out.println(e.getMessage());
        }

        // argument is blank or null
        StarWarName noBody = new StarWarName(null);
        noBody.getStarWarName();
    }
}
