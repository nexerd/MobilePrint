package ispu442.mobileprint.models;

import android.printservice.PrintService;

public class Order {
    public String Hash;
    public String FileName;
    public int Id;
    public int UserId;
    public int PrintShopId;
    public String Status;
    public double Price;

    public Order(String hash, String fileName , int id, int userId, int printServiceId, String status, double price)
    {
        Hash = hash;
        FileName = fileName;
        Id = id;
        UserId = userId;
        PrintShopId = printServiceId;
        Status = status;
        Price = price;
    }
}
