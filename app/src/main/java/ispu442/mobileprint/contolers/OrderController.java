package ispu442.mobileprint.contolers;

import java.util.ArrayList;
import java.util.List;
import ispu442.mobileprint.models.Order;
import ispu442.mobileprint.network.OrderHelper;

public class OrderController {
    private static List<Order> Orders = null;

    public static List<Order> GetOrders()
    {
        if (Orders == null)
        {
            Orders = OrderHelper.GetOrders();
        }
        return Orders;
    }

    public static boolean UpdateOrders()
    {
        List<Order> newOrderList = OrderHelper.GetOrders();
        if (newOrderList == null)
            return false;
        if (Orders == null)
        {
            Orders = newOrderList;
            return false;
        }
        boolean key = !IsOrdersListEqual(Orders, newOrderList);
        if (key)
        {
            Orders = newOrderList;
        }
        return key;
    }

    private static boolean IsOrdersListEqual(List<Order> a, List<Order> b)
    {
        if (a.size() != b.size())
            return false;
        for (int i = 0; i < a.size(); i++)
        {
            boolean key = false;
            for (int j = 0; j < b.size(); j++)
            {
                if (a.get(i).Id == b.get(j).Id)
                {
                    key = true;
                    if (!a.get(i).Status.contentEquals(b.get(j).Status))
                    {
                        return false;
                    }
                    break;
                }
            }
            if (!key)
            {
                return false;
            }
        }
        return true;
    }
}
