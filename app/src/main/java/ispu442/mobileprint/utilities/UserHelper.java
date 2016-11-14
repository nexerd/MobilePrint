package ispu442.mobileprint.utilities;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import ispu442.mobileprint.models.User;

public class UserHelper {

    public static final String SignInUrl = "user/SignIn";

    public static User SignIn(String login, String password)
    {
        JSONObject jsonObj = new JSONObject();
        try
        {
            jsonObj.accumulate("login", login);
            jsonObj.accumulate("password", password);
        }
        catch (JSONException e)
        {
            String str = e.getMessage();
        }

        try
        {
            HttpHelper.POST(SignInUrl, jsonObj.toString());
        }
        catch (IOException e)
        {
            String str = e.getMessage();
        }

        return null;
    }
}


