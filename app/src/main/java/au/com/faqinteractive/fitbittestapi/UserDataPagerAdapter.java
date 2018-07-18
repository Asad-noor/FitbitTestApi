package au.com.faqinteractive.fitbittestapi;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;



import java.util.ArrayList;
import java.util.List;

import au.com.faqinteractive.fitbitauth.authentication.AuthenticationManager;
import au.com.faqinteractive.fitbitauth.authentication.Scope;
import au.com.faqinteractive.fitbittestapi.fragments.ActivitiesFragment;
import au.com.faqinteractive.fitbittestapi.fragments.DeviceFragment;
import au.com.faqinteractive.fitbittestapi.fragments.InfoFragment;
import au.com.faqinteractive.fitbittestapi.fragments.ProfileFragment;
import au.com.faqinteractive.fitbittestapi.fragments.WeightLogFragment;

/**
 * Created by jboggess on 10/17/16.
 */

public class UserDataPagerAdapter extends FragmentPagerAdapter {

    private final List<InfoFragment> fragments = new ArrayList<>();

    public UserDataPagerAdapter(FragmentManager fm) {
        super(fm);

        fragments.clear();
        if (containsScope(Scope.profile)) {
            fragments.add(new ProfileFragment());
        }
        if (containsScope(Scope.settings)) {
            fragments.add(new DeviceFragment());
        }
        if (containsScope(Scope.activity)) {
            fragments.add(new ActivitiesFragment());
        }
        if (containsScope(Scope.weight)) {
            fragments.add(new WeightLogFragment());
        }
    }

    private boolean containsScope(Scope scope) {
        return AuthenticationManager.getCurrentAccessToken().getScopes().contains(scope);
    }

    @Override
    public Fragment getItem(int position) {
        if (position >= fragments.size()) {
            return null;
        }

        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public int getTitleResourceId(int index) {
        return fragments.get(index).getTitleResourceId();
    }
}
