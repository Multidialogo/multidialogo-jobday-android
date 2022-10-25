package it.multidialogo.jobday.data;

import android.util.Base64;
import it.multidialogo.jobday.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {
        final String usernameBase64 = Base64.encodeToString(username.getBytes(), Base64.NO_WRAP);
        final String passwordBase64 = Base64.encodeToString(password.getBytes(), Base64.NO_WRAP);
        if (usernameBase64.equals("dGVzdEBtdWx0aWRpYWxvZ28uaXQ=") && passwordBase64.equals("dGhpc2lzanVzdGF0ZXN0")) {
            LoggedInUser fakeUser = new LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe");
            return new Result.Success<>(fakeUser);
        } else {
            return new Result.Error(new Exception("Error logging in"));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}