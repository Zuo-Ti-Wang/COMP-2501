package ca.bcit.comp2501.ruisitang;

/**
 * @author Ruisi Tang
 */
public class Property
{

    private       double  priceInUsd;
    private final Address address;
    private final int     numberOfBedrooms;
    private final boolean swimmingPool;
    private final String  type;
    private final String  propertyId;

    private static final int MIN_PRICE_IN_USD    = 0;
    private static final int MIN_NUM_BR          = 1;
    private static final int MAX_NUM_BR          = 20;
    private static final int MIN_ID_LENGTH       = 1;
    private static final int MAX_ID_LENGTH       = 6;

    public Property(final double priceInUsd, final Address address, final int numberOfBedrooms, final boolean swimmingPool,
                    final String type, final String propertyId)
    {
        //price in USD exceptions
        if(priceInUsd < MIN_PRICE_IN_USD)
        {
            throw new IllegalArgumentException("Invalid price: " + priceInUsd);
        }

        //address exceptions
        if(address == null)
        {
            throw new NullPointerException("Invalid address: null");
        }

        //number of bedrooms exceptions
        if(numberOfBedrooms < MIN_NUM_BR ||
           numberOfBedrooms > MAX_NUM_BR)
        {
            throw new IllegalArgumentException("Invalid number of bedrooms: " + numberOfBedrooms);
        }

        //type exceptions
        if(type == null)
        {
            throw new NullPointerException("Invalid property type: null");
        }
        else if (
            !(type.equalsIgnoreCase("residence")   ||
              type.equalsIgnoreCase("commercial")  ||
              type.equalsIgnoreCase("retail"))
        )
        {
            throw new IllegalArgumentException("Invalid property type: " + type);
        }

        //property ID exceptions
        if(propertyId == null)
        {
            throw new NullPointerException("Invalid property id: null");
        }
        else if(propertyId.length() < MIN_ID_LENGTH ||
                propertyId.length() > MAX_ID_LENGTH)
        {
            throw new IllegalArgumentException("Invalid property id: " + propertyId);
        }

        this.priceInUsd       = priceInUsd;
        this.address          = address;
        this.numberOfBedrooms = numberOfBedrooms;
        this.swimmingPool     = swimmingPool;
        this.type             = type;
        this.propertyId       = propertyId;
    }

    /**
     * getter for price in usd
     * @return price in usd
     */
    public final double getPriceInUsd()
    {
        return priceInUsd;
    }

    /**
     * setter for price in usd
     * @return new price in usd
     */
    public final void setPriceInUsd(double priceInUsd)
    {
        if(priceInUsd > MIN_PRICE_IN_USD)
        {
            this.priceInUsd = priceInUsd;
        }
    }

    /**
     * getter for address
     * @return address
     */
    public final Address getAddress()
    {
        return address;
    }

    /**
     * getter for number of bedrooms
     * @return number of bedrooms
     */
    public final int getNumberOfBedrooms()
    {
        return numberOfBedrooms;
    }

    /**
     * getter for swimming pool
     * @return true if the property has swimming pool, false if not.
     */
    public final boolean isSwimmingPool()
    {
        return swimmingPool;
    }

    /**
     * getter for property type
     * @return property type
     */
    public final String getType()
    {
        return type;
    }

    /**
     * getter for property id
     * @return property id
     */
    public final String getPropertyId()
    {
        return propertyId;
    }
}
