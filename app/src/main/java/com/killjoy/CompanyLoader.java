package com.killjoy;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.AsyncTask;

public class CompanyLoader extends AsyncTaskLoader<CompanyBP> {
    private final String Name;

    public CompanyLoader(Context context, String name) {
        super(context);
        Name = name;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
//        super.onStartLoading();
    }

    @Override
    public CompanyBP loadInBackground() {
//        return new CompanyBP(Name,"value0","value1","value2");
        return FetchClass.CollectDataFromSheets(Name);
    }

}
