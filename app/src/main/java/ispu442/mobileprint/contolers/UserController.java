package ispu442.mobileprint.contolers;

import ispu442.mobileprint.models.User;
import ispu442.mobileprint.utilities.UserHelper;

public class UserController {
    private static User user = null;

    public static Boolean IsSignedIn()
    {
        return user != null;
    }

    public static String UserName() { return user != null ? user.Name : null; }

    public static Boolean SignIn(String login, String password)
    {
        user = UserHelper.SignIn(login, password);
        return user != null;
    }

}
