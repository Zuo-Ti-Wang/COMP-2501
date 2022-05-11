/**
 * @author Ruisi Tang
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore(args[0]);

        try
        {
            bookStore.printAllTitles();
        }
        catch(RuntimeException e)
        {
            System.out.println(e.getMessage());
        }

        try {
            bookStore.printTitlesContaining(null, true);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }

        try
        {
            bookStore.printTitlesOfLength(-5);
        }
        catch (IllegalArgumentException error)
        {
            System.out.println(error.getMessage());;
        }

        try
        {
            bookStore.printNameStartEndsWith("      ");
        }
        catch (IllegalNameException error)
        {
            System.out.println(error.getMessage());
        }

        try
        {
            System.out.println(bookStore.getLongest("authOr"));
        }
        catch (IllegalNovelPropertyException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            System.out.println(bookStore.getLongest("tItlE"));
        }
        catch (IllegalNovelPropertyException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            System.out.println(bookStore.getLongest("hehehe"));
        }
        catch(IllegalNovelPropertyException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
