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
}
