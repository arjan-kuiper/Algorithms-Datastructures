package Main;/*
Class Main.Item
Summary:
    The Main.Item class contains a collection of values based on the LEGO Dataset.
    Each Main.Item object is a single product from the collection file.

 */

import org.json.simple.JSONObject;

public class Item {
    private int itemNr;
    private String itemName;
    private int year;
    private String theme;
    private int pieces;
    private int minifigures;
    private String imageURL;
    private double GBP, USD, CAD, EUR;
    private String packiging;
    private String availability;

    // Constructor to set the values of certain items.
    public Item(JSONObject item)
    {
        this.itemNr = Integer.parseInt(String.valueOf(item.get("Item_Number")));
        this.itemName = (String)item.get("Name");
        this.year = Integer.parseInt(String.valueOf(item.get("Year")));
        this.theme = (String)item.get("Theme");
        this.pieces = checkNAInt(item, "Pieces");
        this.minifigures = checkNAInt(item, "Minifigures");
        this.imageURL = (String)item.get("Image_URL");
        this.GBP = checkPrice(item, "GBP_MSRP");
        this.USD = checkPrice(item, "CAD_MSRP");
        this.EUR = checkPrice(item, "EUR_MSRP");
        this.packiging = (String)item.get("Packaging");
        this.availability = (String)item.get("Availability");
    }

    // Check whether the price is valid. In case a pricing isn't specified (NA) return -1 to indicate it isn't available in that currency.
    private double checkPrice(JSONObject item, String input)
    {
        String fetchedVal = String.valueOf(item.get(input));
        if(fetchedVal.equals("NA"))
        {
            // Return -1 if a pricing isn't available for the selected currency.
            return -1;
        }else{
            return Double.parseDouble(fetchedVal);
        }
    }

    // Check whether the field actually is an Integer value.
    private int checkNAInt(JSONObject item, String input)
    {
        String fetchedVal = String.valueOf(item.get(input));
        if(fetchedVal.equals("NA"))
        {
            // If not available, return an amount of 0.
            return 0;
        }else{
            return Integer.parseInt(fetchedVal);
        }
    }


    // Getter methods
    public int getItemNr(){ return itemNr; }
    public String getItemName() { return itemName; }
    public int getYear() { return year; }
    public String getTheme() { return theme; }
    public int getPieces() { return pieces; }
    public int getMinifigures() { return minifigures; }
    public String getImageURL() { return imageURL; }
    public double getGBP() { return GBP; }
    public double getUSD() { return USD; }
    public double getCAD() { return CAD; }
    public double getEUR() { return EUR; }
    public String getPackiging() { return packiging; }
    public String getAvailability() { return availability; }

}
