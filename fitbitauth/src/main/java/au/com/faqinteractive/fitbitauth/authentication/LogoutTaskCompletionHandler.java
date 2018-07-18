package au.com.faqinteractive.fitbitauth.authentication;

/**
 * Created by jboggess on 9/19/16.
 */
public interface LogoutTaskCompletionHandler {
    void logoutSuccess();

    void logoutError(String message);
}
