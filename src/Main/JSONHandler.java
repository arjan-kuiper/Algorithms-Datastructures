package Main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// The purpose of this class is to simple fetch the data from the .json file
// and put it in a collection of Main.Item objects. Each Main.Item object contains the variables
// which can be found in the LEGO_DATASET.csv / LEGO_DATASET.json.
public final class JSONHandler {

    // Make it inaccessable
    private JSONHandler() {
        //Unavailable
    }

    // Static function to be called to generate the Main.Item ArrayList collection.
    public static ArrayList<Item> getItemsArrayList() {
        // Fetch the file form the 'res' folder & create a parser in order to separate the data in the file.
        String url = JSONHandler.class.getResource("../LEGO_DATASET.json").getPath();
        JSONParser parser = new JSONParser();
        ArrayList<Item> items = new ArrayList<>();

        // Attempt to fetch JSON from file and put it into a JSONArray format.
        try {
            JSONArray dataSet = (JSONArray) parser.parse(new FileReader(url));
            // Iterate over every item in the JSON array.
            for (Object item : dataSet) {
                JSONObject obj = (JSONObject) item;
                // Add a new instance of Main.Item to the items collection.
                // The constructor of Main.Item will take care of the logic.
                try {
                    int itemId = Integer.parseInt((String.valueOf(obj.get("Item_Number"))));
                    items.add(new Item(obj));
                    //System.out.println(obj.get("Name") + "  Has been added.");
                } catch (Exception e) {
                    //System.out.println(obj.get("Name") + "  Skipped (Invalid ID).");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // Returns an ArrayList with the generated Main.Item objects.
        return items;
    }
}
