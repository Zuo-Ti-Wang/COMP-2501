package ca.bcit.comp2501.ruisitang;
import java.util.*;

/**
 * @author Ruisi Tang
 */
public class Agency
{
    private final String name;
    private final Map<String, Property> properties;

    private static final double INITIAL_TOTAL_PROPERTY_VALUE = 0;
    private static final int ITERATOR                        = 0;
    private static final int PROPERTIES_ENTRY_LABEL          = 1;
    private static final int MIN_NUM_BEDROOM                 = 1;
    private static final int EMPTY_ARRAYLIST_OR_HASHMAP      = 0;



    public Agency(final String name, final HashMap<String , Property> properties)
    {
        this.name = name;
        this.properties = properties;
    }
    
    public Agency(final String name)
    {
        this.name = name;
        properties = new HashMap<>();
    }

    /**
     * getter for the agency name.
     * @return a string agency name.
     */
    public final String getName()
    {
        return name;
    }

    /**
     * add properties into the HashMap properties.
     * @param property the property to be added.
     */
    public final void addProperty(Property property)
    {
        if(!(property == null))
        {
            properties.put(property.getPropertyId(), property);
        }
    }

    /**
     * remove the properties from the HashMap properties.
     * @param propertyId the property ID of the property to be removed.
     */
    public final void removeProperty(String propertyId)
    {
        if(properties.containsKey(propertyId.toLowerCase()))
        {
            properties.remove(propertyId.toLowerCase());
        }
    }

    /**
     * get the property based on property ID.
     * @param propertyId property ID.
     * @return the corresponding property.
     */
    public final Property getProperty(String propertyId)
    {
        return properties.get(propertyId);
    }

    /**
     * get the total value of the properties in the HashMap properties.
     * @return the total value of the properties in the HashMap properties.
     */
    public final double getTotalPropertyValues()
    {
        double totalPropertyValues = INITIAL_TOTAL_PROPERTY_VALUE;
        for(Map.Entry<String, Property> set: properties.entrySet())
        {
            totalPropertyValues += set.getValue().getPriceInUsd();
        }
        return totalPropertyValues;
    }

    /**
     * get the properties with pools.
     * @return a list contains the properties with pools.
     */
    public final List<Property> getPropertiesWithPools()
    {
        List<Property> propertiesWithPools = new ArrayList<Property>();
        for(Map.Entry<String, Property> set: properties.entrySet())
        {
            if(set.getValue().isSwimmingPool())
            {
                propertiesWithPools.add(set.getValue());
            }
        }
        return propertiesWithPools;
    }

    /**
     * search for the properties that prices fall in the min and max US dollars range
     * @param minUsd minimum US dollar amount
     * @param maxUsd maximum US dollar amount
     * @return an array contains all the eligible properties.
     */
    public final Property[] getPropertiesBetween(int minUsd, int maxUsd)
    {
        ArrayList<Property> propertiesBetween = new ArrayList<>();
        int i = ITERATOR;
        for(Map.Entry<String, Property> set: properties.entrySet())
        {
            if(set.getValue().getPriceInUsd() >= minUsd &&
               set.getValue().getPriceInUsd() <= maxUsd)
            {
                propertiesBetween.add(set.getValue());
            }
            i++;
        }
        Property[] agencyResults = propertiesBetween.toArray(new Property[0]);
        return agencyResults;
    }

    /**
     * get the properties on the street name.
     * @param streetName street name.
     * @return the properties on the street name.
     */
    public final ArrayList<Address> getPropertiesOn(String streetName)
    {
        ArrayList<Address> propertiesOnStreet = new ArrayList<>();
        for(Map.Entry<String, Property> set: properties.entrySet())
        {
            if(set.getValue().getAddress().getStreetName().equalsIgnoreCase(streetName))
            {
                propertiesOnStreet.add(set.getValue().getAddress());
            }
        }

        if(propertiesOnStreet.size() == EMPTY_ARRAYLIST_OR_HASHMAP)
        {
            return null;
        }
        else
        {
            return propertiesOnStreet;
        }
    }

    /**
     * get the properties with range of numbers of bedrooms.
     * @param minBedrooms the min number of bedrooms.
     * @param maxBedrooms the max number of bedrooms.
     * @return the properties with range of numbers of bedrooms.
     */
    public final HashMap<String, Property> getPropertiesWithBedrooms(int minBedrooms, int maxBedrooms)
    {
        HashMap<String, Property> propertiesWithBedrooms = new HashMap<>();
        for(Map.Entry<String, Property> set: properties.entrySet())
        {
            if(set.getValue().getNumberOfBedrooms() >= minBedrooms &&
               set.getValue().getNumberOfBedrooms() <= maxBedrooms)
            {
                propertiesWithBedrooms.put(set.getKey(), set.getValue());
            }
        }
        if(propertiesWithBedrooms.size() == EMPTY_ARRAYLIST_OR_HASHMAP)
        {
            return null;
        }
        else
        {
            return propertiesWithBedrooms;
        }
    }

    /**
     * This method gets the properties of type and its details and put into an arraylist.
     * @param propertyType the property type.
     * @return an arraylist contains the properties of type.
     */
    public final ArrayList<String> getPropertiesOfType(String propertyType)
    {
        ArrayList<String> propertiesOfType = new ArrayList<>();
        int               entryLabel = PROPERTIES_ENTRY_LABEL;
        String            propertyId;
        String            unitNumber;
        int               streetNumber;
        String            streetName;
        String            postalCode;
        String            city;
        String            numberOfBedrooms = "";
        String            isPool;
        double            priceInUsd;
        String            propertyDetail;

        //add the property type to the arraylist.
        propertiesOfType.add(String.format("Type: %s\n", propertyType.toUpperCase()));

        if(!propertyType.toLowerCase().equals("commercial") &&
           !propertyType.toLowerCase().equals("residence") &&
           !propertyType.toLowerCase().equals("retail"))
        {
            propertiesOfType.add("<none found>");
        }
        else
        {
            //add the eligible properties to the arraylist.
            for (Map.Entry<String, Property> set : properties.entrySet()) {
                if (set.getValue().getType().equalsIgnoreCase(propertyType)) {
                    //check if the property has a unit number.
                    if (set.getValue().getAddress().getUnitNumber() != null) {
                        unitNumber = String.format(" unit #%s at", set.getValue().getAddress().getUnitNumber());
                    } else {
                        unitNumber = "";
                    }

                    //check if the property has pool.
                    if (set.getValue().isSwimmingPool()) {
                        isPool = " plus pool";
                    } else {
                        isPool = "";
                    }

                    //check how many bedrooms does the property have.
                    if (set.getValue().getNumberOfBedrooms() == MIN_NUM_BEDROOM) {
                        numberOfBedrooms = "1 bedroom";
                    } else {
                        if (set.getValue().getNumberOfBedrooms() > MIN_NUM_BEDROOM) {
                            numberOfBedrooms = String.format("%d bedrooms", set.getValue().getNumberOfBedrooms());

                        }
                    }

                    propertyId = set.getValue().getPropertyId();
                    streetNumber = set.getValue().getAddress().getStreetNumber();
                    streetName = capitalize(set.getValue().getAddress().getStreetName());
                    postalCode = set.getValue().getAddress().getPostalCode().toUpperCase();
                    city = capitalize(set.getValue().getAddress().getCity());
                    priceInUsd = set.getValue().getPriceInUsd();

                    propertyDetail = String.format(") ca.bcit.comp2501.ruisitang.Property %s:%s %s %s %s in %s (%s%s): $%.0f.\n",
                            propertyId, unitNumber, streetNumber, streetName, postalCode, city, numberOfBedrooms, isPool,
                            priceInUsd);

                    propertiesOfType.add(propertyDetail);
                }
                entryLabel++;
            }
        }
        return propertiesOfType;
    }

    /**
     * A private function used to capitalize the first letter of each word -- cited from Stack Overflow.
     * @param string the string to be capitalized.
     * @return a string that has first letter capitalized for each word.
     */
    private String capitalize(final String string)
    {
        char[] chars = string.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++)
        {
            if (!found && Character.isLetter(chars[i]))
            {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            }
            else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'')
            {
                found = false;
            }
        }
        return String.valueOf(chars);
    }
}



