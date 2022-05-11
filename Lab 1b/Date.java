class Date
{
    private int year;
    private int month;
    private int day;

    Date(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    final String getYyMMmDd()
    {
        return ""+ year + "-" + month + "-" + day;
    }

    final int getYear()
    {
        return year;
    }

    final int setYear(int newYear)
    {
        this.year = newYear;
        return year;
    }

    final int getMonth()
    {
        return month;
    }

    final int setMonth(int newMonth)
    {
        this.month = newMonth;
        return month;
    }

    final int getDay()
    {
        return day;
    }

    final int setDay(int newDay)
    {
        this.day = newDay;
        return day;
    }
}
