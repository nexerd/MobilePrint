package ispu442.mobileprint.contolers;

import java.util.ArrayList;
import java.util.List;
import ispu442.mobileprint.models.Order;

public class OrderControler {
    public static List<Order> GetOrders()
    {
        List<Order> Orders = new ArrayList<Order>();
        Orders.add(new Order("a1s5d12", 1, "Выполнен",  10));
        Orders.add(new Order("1s2s52", 1, "Подтвержден",  10));
        Orders.add(new Order("77a3da2", 1, "Отлонен",  10));
        return Orders;
    }
}
