package ispu442.mobileprint.contolers;

import ispu442.mobileprint.models.User;

public class UserController {
    private static User user = null;

    public static Boolean IsSignedIn()
    {
        return user != null;
    }

    public static Boolean SignIn(String login, String password)
    {
        return false;
    }

}
