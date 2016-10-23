package ispu442.mobileprint.models;

public class Order {
    public String Hash;
    public int Id;
    public String Status;
    public int PringshopId;
    public double Price;

    public Order(String hash, int id, String status, double price)
    {
        Hash = hash;
        Id = id;
        Status = status;
        Price = price;
    }
}
