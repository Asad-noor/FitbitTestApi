package au.com.faqinteractive.fitbitapi.services;

import android.app.Activity;
import android.content.Loader;

import au.com.faqinteractive.fitbitapi.exceptions.MissingScopesException;
import au.com.faqinteractive.fitbitapi.exceptions.TokenExpiredException;
import au.com.faqinteractive.fitbitapi.loaders.ResourceLoaderFactory;
import au.com.faqinteractive.fitbitapi.loaders.ResourceLoaderResult;
import au.com.faqinteractive.fitbitapi.models.UserContainer;
import au.com.faqinteractive.fitbitauth.authentication.Scope;


/**
 * Created by jboggess on 9/14/16.
 */
public class UserService {

    private final static String USER_URL = "https://api.fitbit.com/1/user/-/profile.json";
    private static final ResourceLoaderFactory<UserContainer> USER_PROFILE_LOADER_FACTORY = new ResourceLoaderFactory<>(USER_URL, UserContainer.class);

    public static Loader<ResourceLoaderResult<UserContainer>> getLoggedInUserLoader(Activity activityContext) throws MissingScopesException, TokenExpiredException {
        return USER_PROFILE_LOADER_FACTORY.newResourceLoader(activityContext, new Scope[]{Scope.profile});
    }

}
