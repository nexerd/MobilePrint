package ispu442.mobileprint.models;


public class User {
    public String Name;
    public String Login;
    public String Password;
    public int Id;

    public User(String name, String login, String password, int id )
    {
        Name = name;
        Login = login;
        Password = password;
        Id = id;
    }

}
