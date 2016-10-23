package ispu442.mobileprint.models;

public class Printshop {
    public String Name;
    public String Address;
    public int Id;
    public int Rating;

    public Printshop(String name, String address, int id, int rating)
    {
        Name = name;
        Address = address;
        Id = id;
        Rating = rating;
    }
}
