package au.com.faqinteractive.fitbittestapi.fragments;


import android.content.Loader;
import android.os.Bundle;

import au.com.faqinteractive.fitbitapi.loaders.ResourceLoaderResult;
import au.com.faqinteractive.fitbitapi.models.User;
import au.com.faqinteractive.fitbitapi.models.UserContainer;
import au.com.faqinteractive.fitbitapi.services.UserService;
import au.com.faqinteractive.fitbittestapi.R;


/**
 * Created by jboggess on 10/17/16.
 */

public class ProfileFragment extends InfoFragment<UserContainer> {

    @Override
    public int getTitleResourceId() {
        return R.string.user_info;
    }

    @Override
    protected int getLoaderId() {
        return 1;
    }

    @Override
    public Loader<ResourceLoaderResult<UserContainer>> onCreateLoader(int id, Bundle args) {
        return UserService.getLoggedInUserLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<ResourceLoaderResult<UserContainer>> loader, ResourceLoaderResult<UserContainer> data) {
        super.onLoadFinished(loader, data);
        if (data.isSuccessful()) {
            bindProfileInfo(data.getResult().getUser());
        }
    }

    public void bindProfileInfo(User user) {
        StringBuilder stringBuilder = new StringBuilder();
        printKeys(stringBuilder, user);
        setMainText(stringBuilder.toString());
    }


}
