class Name
{
    private String first;
    private String last;

    Name(final String first, final String last)
    {
        this.first = first;
        this.last = last;
    }

    String getFullName()
    {
        return first + " " + last;
    }

    String getInitials()
    {
        return first.toUpperCase().charAt(0) + "." + last.toUpperCase().charAt(0);
    }

    String getLast()
    {
        return last;
    }

    String getFirst()
    {
        return first;
    }

    String changeLast(String newLast)
    {
        last = newLast;
        return last;
    }
}
