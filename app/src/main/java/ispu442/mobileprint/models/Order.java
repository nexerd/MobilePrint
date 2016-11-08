package ispu442.mobileprint.models;

public class Order {
    public String Hash;
    public String FileName;
    public int Id;
    public String Status;
    public int PringshopId;
    public double Price;

    public Order(String hash, String fileName , int id, String status, double price)
    {
        Hash = hash;
        FileName = fileName;
        Id = id;
        Status = status;
        Price = price;
    }
}
