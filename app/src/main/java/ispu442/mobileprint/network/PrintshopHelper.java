package ispu442.mobileprint.network;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ispu442.mobileprint.models.Printshop;
import ispu442.mobileprint.utilities.HttpHelper;

public class PrintshopHelper {

    public static final String PrintshopsUrl = "printservices";

    private static Printshop GetPrintshopFromJSOn(JSONObject jsonObject) throws JSONException
    {
        return new Printshop(jsonObject.getString("name"),
                jsonObject.getString("address"),
                jsonObject.getInt("id"),
                jsonObject.getInt("rating"));
    }

    private static List<Printshop> GetPrintshopsListFromJSON(String jsonString) throws JSONException
    {
        JSONArray printshopsJSON = new JSONArray(jsonString);
        ArrayList<Printshop> printshops = new ArrayList<Printshop>();
        for (int i = 0; i < printshopsJSON.length(); i++)
        {
            printshops.add(GetPrintshopFromJSOn(printshopsJSON.getJSONObject(i)));
        }
        return printshops;
    }

    public static List<Printshop> GetPrintshops()
    {
        String responseString = "";
        try
        {
            responseString = HttpHelper.GET(PrintshopsUrl);
        }
        catch (IOException e)
        {
            String str = e.getMessage();
            return null;
        }
        try
        {
            return GetPrintshopsListFromJSON(responseString);
        }
        catch (JSONException e)
        {
            String str = e.getMessage();
            return null;
        }
    }

}
