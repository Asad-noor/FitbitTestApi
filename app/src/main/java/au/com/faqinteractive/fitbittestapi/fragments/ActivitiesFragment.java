package au.com.faqinteractive.fitbittestapi.fragments;


import android.content.Loader;
import android.os.Bundle;


import java.util.Date;

import au.com.faqinteractive.fitbitapi.loaders.ResourceLoaderResult;
import au.com.faqinteractive.fitbitapi.models.DailyActivitySummary;
import au.com.faqinteractive.fitbitapi.models.Goals;
import au.com.faqinteractive.fitbitapi.models.Summary;
import au.com.faqinteractive.fitbitapi.services.ActivityService;
import au.com.faqinteractive.fitbittestapi.R;

/**
 * Created by jboggess on 10/17/16.
 */

public class ActivitiesFragment extends InfoFragment<DailyActivitySummary> {

    @Override
    public int getTitleResourceId() {
        return R.string.activity_info;
    }

    @Override
    protected int getLoaderId() {
        return 3;
    }

    @Override
    public Loader<ResourceLoaderResult<DailyActivitySummary>> onCreateLoader(int id, Bundle args) {
        return ActivityService.getDailyActivitySummaryLoader(getActivity(), new Date());
    }

    @Override
    public void onLoadFinished(Loader<ResourceLoaderResult<DailyActivitySummary>> loader, ResourceLoaderResult<DailyActivitySummary> data) {
        super.onLoadFinished(loader, data);
        if (data.isSuccessful()) {
            bindActivityData(data.getResult());
        }
    }

    public void bindActivityData(DailyActivitySummary dailyActivitySummary) {
        StringBuilder stringBuilder = new StringBuilder();

        Summary summary = dailyActivitySummary.getSummary();
        Goals goals = dailyActivitySummary.getGoals();

        stringBuilder.append("<b>TODAY</b> ");
        stringBuilder.append("<br />");
        printKeys(stringBuilder, summary);

        stringBuilder.append("<br /><br />");
        stringBuilder.append("<b>GOALS</b> ");
        stringBuilder.append("<br />");
        printKeys(stringBuilder, goals);

        setMainText(stringBuilder.toString());
    }
}
