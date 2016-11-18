package ispu442.mobileprint.network;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ispu442.mobileprint.models.Order;
import ispu442.mobileprint.utilities.HttpHelper;

public class OrderHelper {

    public static final String OrdersUrl = "orders";

    private static Order GetOrderFromJSON(JSONObject jsonObject) throws JSONException
    {
        return new Order(jsonObject.getString("hash"),
                jsonObject.getString("filename"),
                jsonObject.getInt("id"),
                jsonObject.getInt("user_id"),
                jsonObject.getInt("printservice_id"),
                jsonObject.getString("status"),
                jsonObject.getDouble("price"));
    }

    private static List<Order> GetOrdersListFromJSON(String jsonString) throws JSONException
    {
        JSONArray ordersJSON = new JSONArray(jsonString);
        ArrayList<Order> orders = new ArrayList<Order>();
        for (int i = 0; i < ordersJSON.length(); i++)
        {
            orders.add(GetOrderFromJSON(ordersJSON.getJSONObject(i)));
        }
        return orders;
    }

    public static List<Order> GetOrders()
    {
        String responseString = "";
        try
        {
            responseString = HttpHelper.GET(OrdersUrl);
        }
        catch (IOException e)
        {
            String str = e.getMessage();
            return null;
        }
        try
        {
            return GetOrdersListFromJSON(responseString);
        }
        catch (JSONException e)
        {
            String str = e.getMessage();
            return null;
        }
    }

}
