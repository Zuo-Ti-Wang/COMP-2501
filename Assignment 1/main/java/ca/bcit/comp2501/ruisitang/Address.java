package ca.bcit.comp2501.ruisitang;

/**
 * @author Ruisi Tang
 */
public class Address
{
    private final String unitNumber;
    private final int    streetNumber;
    private final String streetName;
    private final String postalCode;
    private final String city;

    private static final int MIN_UNIT_NUMBER_LENGTH    = 1;
    private static final int MAX_UNIT_NUMBER_LENGTH    = 4;
    private static final int MIN_STREET_NUM            = 1;
    private static final int MAX_STREET_NUM            = 999999;
    private static final int MIN_STREET_NAME_LENGTH    = 1;
    private static final int MAX_STREET_NAME_LENGTH    = 20;
    private static final int POSTAL_CODE_LENGTH_SHORT  = 5;
    private static final int POSTAL_CODE_LENGTH_LONG   = 6;
    private static final int MIN_CITY_LENGTH           = 1;
    private static final int MAX_CITY_LENGTH           = 30;



    public Address(final String unitNumber, final int streetNumber, final String streetName, final String postalCode,
                   final String city)
            throws IllegalArgumentException
    {
        //unit number exceptions
        if(unitNumber != null)
        {
            if (unitNumber.length() > MAX_UNIT_NUMBER_LENGTH ||
                unitNumber.length() < MIN_UNIT_NUMBER_LENGTH)
            {
                throw new IllegalArgumentException("Invalid unit number: " + unitNumber);
            }
        }

        //street number exceptions
        if(streetNumber < MIN_STREET_NUM ||
           streetNumber > MAX_STREET_NUM)
        {
            throw new IllegalArgumentException("Invalid street number: " + streetNumber);
        }

        //street name exceptions
        if(streetName == null)
        {
            throw new NullPointerException("Invalid street name: null");
        }
        else if(streetName.length() < MIN_STREET_NAME_LENGTH ||
                streetName.length() > MAX_STREET_NAME_LENGTH)
        {
            throw new IllegalArgumentException("Invalid street name: " + streetName);
        }

        //postal code exceptions
        if(postalCode == null)
        {
            throw new NullPointerException("Invalid postal code: null");
        }
        else if(!(postalCode.length() == POSTAL_CODE_LENGTH_SHORT ||
                postalCode.length() == POSTAL_CODE_LENGTH_LONG))
        {
            throw new IllegalArgumentException("Invalid postal code: " + postalCode);
        }

        //city exceptions
        if(city == null)
        {
            throw new NullPointerException("Invalid city: null");
        }
        else if(city.length() < MIN_CITY_LENGTH ||
                city.length() > MAX_CITY_LENGTH)
        {
            throw new IllegalArgumentException("Invalid city: " + city);
        }

        this.unitNumber   = unitNumber;
        this.streetNumber = streetNumber;
        this.streetName   = streetName;
        this.postalCode   = postalCode;
        this.city         = city;
    }

    /**
     * getter for unit number
     * @return unit number
     */
    public String getUnitNumber()
    {
        return unitNumber;
    }

    /**
     * getter for unit number
     * @return unit number
     */
    public int getStreetNumber()
    {
        return streetNumber;
    }

    /**
     * getter for street number
     * @return street number
     */
    public String getStreetName()
    {
        return streetName;
    }

    /**
     * getter for postal code
     * @return postal code
     */
    public String getPostalCode()
    {
        return postalCode;
    }

    /**
     * getter for city
     * @return city
     */
    public String getCity()
    {
        return city;
    }
}
