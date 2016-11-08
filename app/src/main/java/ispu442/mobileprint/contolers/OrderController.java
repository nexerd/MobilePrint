package ispu442.mobileprint.contolers;

import java.util.ArrayList;
import java.util.List;
import ispu442.mobileprint.models.Order;

public class OrderController {
    public static List<Order> GetOrders()
    {
        List<Order> Orders = new ArrayList<Order>();
        Orders.add(new Order("a1s5d12", "Курсовая", 1, "Выполнен",  150));
        Orders.add(new Order("1s2s52", "Лаб1. ТПР", 1, "Подтвержден",  25.1));
        Orders.add(new Order("77a3da2", "Лаба тест 1", 1, "Отклонен",  10));
        Orders.add(new Order("77a3da2", "Лаба тест 2", 2, "Отклонен",  10));
        Orders.add(new Order("77a3da2", "Лаба тест 3", 3, "Отклонен",  10));
        Orders.add(new Order("77a3da2", "Лаба тест 4", 4, "Отклонен",  10));
        Orders.add(new Order("77a3da2", "Лаба тест 5", 5, "Отклонен",  10));
        Orders.add(new Order("77a3da2", "Лаба тест 6", 6, "Отклонен",  10));
        Orders.add(new Order("77a3da2", "Лаба тест 7", 7, "Отклонен",  10));
        Orders.add(new Order("77a3da2", "Лаба тест 8", 8, "Отклонен",  10));
        Orders.add(new Order("77a3da2", "Лаба тест 9", 9, "Отклонен",  10));
        Orders.add(new Order("77a3da2", "Лаба тест 10", 10, "Отклонен",  10));
        return Orders;
    }
}
