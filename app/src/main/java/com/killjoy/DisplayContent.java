package com.killjoy;


import androidx.appcompat.app.AppCompatActivity;

import android.app.LoaderManager;
import android.content.Loader;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/*
JSON
 public static CompanyBP feature(String JSON)
    {
        String a="",c="";
        if(TextUtils.isEmpty(JSON))
        {
            Log.i("TEST","JSOn empty returned");
            return new CompanyBP("null","null");
        }
        Log.i("TEST","JSOn no problem");
        try {
            JSONObject root = new JSONObject(JSON);
            JSONObject feed = root.getJSONObject("feed");
            JSONArray entry = feed.getJSONArray("entry");
            JSONObject compt = entry.getJSONObject(12);
            JSONObject val= entry.getJSONObject(13);
            JSONObject compgscell = compt.getJSONObject("gs$cell");
            JSONObject valgscell = val.getJSONObject("gs$cell");
             a=compgscell.getString("$t");
             c=valgscell.getString("$t");
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("TEST","JSOn  problem during copying");
        }
        Log.i("TEST","obj created with values");

        return new CompanyBP(a,c);

    }


 */
// link for json from G Shit is   https://spreadsheets.google.com/feeds/cells/YOURGOOGLESHEETCODE/SHEETPAGENUMBER/public/full?alt=json
//    Change YOURGOOGLESHEETCODE and SHEETPAGENUMBER appropriatly
// originals link https://docs.google.com/spreadsheets/d/1vy3EHRm-8HkhkD7Utu271xl9Gl3prUUZ7_agI6gOIbk/edit#gid=289543815

public class DisplayContent extends AppCompatActivity implements LoaderManager.LoaderCallbacks<CompanyBP> {
    private static int LOADER_ID = 1;
    TextView name;
    TextView value0, value1, value2;
    String val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_content);
        name = (TextView) findViewById(R.id.name);
        value0 = (TextView) findViewById(R.id.value0);
        value1 = (TextView) findViewById(R.id.value1);
        value2 = (TextView) findViewById(R.id.value2);

        Intent i = getIntent();
        val = i.getExtras().getString("CompanyName");
//        Toast.makeText(this, val+" is the compant's name", Toast.LENGTH_SHORT).show();
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(LOADER_ID, null, this);
    }


    @Override
    public Loader<CompanyBP> onCreateLoader(int id, Bundle args) {
        Log.i("TEST", "value of val is " + val);

        return new CompanyLoader(this, val);
    }

    @Override
    public void onLoadFinished(Loader<CompanyBP> loader, CompanyBP data) {
        if (data != null) {
            name.setText(data.getName());
            value0.setText(data.getValue0());
            value1.setText(data.getValue1());
            value2.setText(data.getValue2());
        } else {
            Toast.makeText(this, "NULL coming ", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onLoaderReset(Loader<CompanyBP> loader) {

    }
}