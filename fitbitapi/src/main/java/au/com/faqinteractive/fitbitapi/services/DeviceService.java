package au.com.faqinteractive.fitbitapi.services;

import android.app.Activity;
import android.content.Loader;

import au.com.faqinteractive.fitbitapi.exceptions.MissingScopesException;
import au.com.faqinteractive.fitbitapi.exceptions.TokenExpiredException;
import au.com.faqinteractive.fitbitapi.loaders.ResourceLoaderFactory;
import au.com.faqinteractive.fitbitapi.loaders.ResourceLoaderResult;
import au.com.faqinteractive.fitbitapi.models.Device;
import au.com.faqinteractive.fitbitauth.authentication.Scope;


/**
 * Created by jboggess on 9/14/16.
 */
public class DeviceService {

    private final static String DEVICE_URL = "https://api.fitbit.com/1/user/-/devices.json";
    private static final ResourceLoaderFactory<Device[]> USER_DEVICES_LOADER_FACTORY = new ResourceLoaderFactory<>(DEVICE_URL, Device[].class);

    public static Loader<ResourceLoaderResult<Device[]>> getUserDevicesLoader(Activity activityContext) throws MissingScopesException, TokenExpiredException {
        return USER_DEVICES_LOADER_FACTORY.newResourceLoader(activityContext, new Scope[]{Scope.settings});
    }

}
