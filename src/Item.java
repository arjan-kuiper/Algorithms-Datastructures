/*
Class Item
Summary:
    The Item class contains a collection of values based on the LEGO Dataset.
    Each Item object is a single product from the collection file.

 */

public class Item {
    private int itemNr;
    private String itemName;
    private int year;
    private String theme;
    private int pieces;
    private int minifigures;
    private String imageURL;
    private int GBP, USD, CAD, EUR;
    private String packiging;
    private String availability;

    // Constructor to set the values of certain items.
    public void Item(int itemNr, String itemName, int year, String theme, int pieces, int minifigures, String imageURL, int GBP, int USD, int CAD, int EUR, String packiging, String availability)
    {
        this.itemNr = itemNr;
        this.itemName = itemName;
        this.year = year;
        this.theme = theme;
        this.pieces = pieces;
        this.minifigures = minifigures;
        this.imageURL = imageURL;
        this.GBP = GBP;
        this.USD = USD;
        this.CAD = CAD;
        this.EUR = EUR;
        this.packiging = packiging;
        this.availability = availability;
    }

    // Getter methods
    public int getItemNr(){ return itemNr; }
    public String getItemName() { return itemName; }
    public int getYear() { return year; }
    public String getTheme() { return theme; }
    public int getPieces() { return pieces; }
    public int getMinifigures() { return minifigures; }
    public String getImageURL() { return imageURL; }
    public int getGBP() { return GBP; }
    public int getUSD() { return USD; }
    public int getCAD() { return CAD; }
    public int getEUR() { return EUR; }
    public String getPackiging() { return packiging; }
    public String getAvailability() { return availability; }

}
