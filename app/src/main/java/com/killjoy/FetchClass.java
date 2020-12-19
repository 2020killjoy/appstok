package com.killjoy;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchClass {
    public static String companyname;

    public FetchClass() {


    }

    public static CompanyBP CollectDataFromSheets(String name) {
        String query = "https://spreadsheets.google.com/feeds/cells/1vy3EHRm-8HkhkD7Utu271xl9Gl3prUUZ7_agI6gOIbk/1/public/full?alt=json";
        companyname = name;
        String JSON = null;
        Log.i("TEST", "ColectData() called ");
        URL url = createUrl(query);
        Log.i("TEST", "URL created perfectly ");

        try {
            Log.i("TEST", "trying for makeHTTP called ");
            JSON = makeHTTPReq(url);

        } catch (Exception e) {
            Log.i("TEST", "Error in makeHTTP  " + e);

        }
        Log.i("TEST", "No problem Before Extract called ");


//    Log.i("TEST","name of company "+Name);
        return extractfromSheet(new JsonName(JSON, companyname));
    }

    private static int Starting_index_of(String a) {
        switch (a) {
            case "RELIANCE":
            case "APPLICATION":
                return (12);
            case "TCS":
            case "CRAPBAG":
                return (24);
            case "HDFC":
                return (36);
            case "HDFCBANK":
                return (48);
            case "ICICIBANK":
                return (60);
            case "BAJFINANCE":
                return (72);
            default:
                return (84);
        }
    }

    private static CompanyBP extractfromSheet(JsonName obj) {
        String JSON = obj.getJSON();
        String name = "", details = "", marketcap = "", weekhigh = "",weeklow="",price = "", pe_ratio = "", eps = "", cagr = "",beta="",dividend="";
        String weekrange52 = "";
        Log.i("TEST", "name passed on to extract " + obj.getName());
        int index = Starting_index_of(obj.getName().toUpperCase());
        if (TextUtils.isEmpty(JSON)) {
            Log.i("TEST", "JSOn empty returned");
            return null;
        }
        Log.i("TEST", "JSOn no problem ");
        try {
            JSONObject root = new JSONObject(JSON);
            JSONObject feed = root.getJSONObject("feed");
            JSONArray entry = feed.getJSONArray("entry");
            name = (entry.getJSONObject(index).getJSONObject("gs$cell").getString("$t"));
            details = (entry.getJSONObject(index + 1).getJSONObject("gs$cell").getString("$t"));
            marketcap = (entry.getJSONObject(index + 2).getJSONObject("gs$cell")).getString("$t");
            weeklow = (entry.getJSONObject(index + 3).getJSONObject("gs$cell").getString("$t"));
            weekhigh = (entry.getJSONObject(index + 4).getJSONObject("gs$cell").getString("$t"));
            price = (entry.getJSONObject(index + 5).getJSONObject("gs$cell").getString("$t"));
            pe_ratio = (entry.getJSONObject(index + 6).getJSONObject("gs$cell").getString("$t"));
            eps = (entry.getJSONObject(index + 7).getJSONObject("gs$cell").getString("$t"));
            cagr = (entry.getJSONObject(index + 8).getJSONObject("gs$cell").getString("$t"));
            beta = (entry.getJSONObject(index + 9).getJSONObject("gs$cell").getString("$t"));
            dividend = (entry.getJSONObject(index + 10).getJSONObject("gs$cell").getString("$t"));
            weekrange52 = weeklow+"-"+weekhigh;


        } catch (Exception e) {
            Log.i("TEST", "JSOn  problem during copying");
        }
        Log.i("TEST", "obj created with values");


        return new CompanyBP(name,details,marketcap,weekrange52,price,pe_ratio,eps,cagr,beta,dividend);

    }

    private static String makeHTTPReq(URL url) throws IOException {

        String JSON = "";
        if (url == null) {
            return JSON;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(10000);
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                JSON = readFromStream(inputStream);
            } else {
                Log.i("TEST", "Trouble in reciving JSon  " + urlConnection.getResponseCode());

            }

        } catch (IOException e) {

            Log.i("TEST", "Trouble in reciving JSon  ", e);


        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return JSON;
    }

    private static URL createUrl(String stringurl) {
        URL url = null;
        try {
            url = new URL(stringurl);
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("TEST", "Problem with the URL ", e);
            return null;

        }
        return url;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                output.append(line);
                line = bufferedReader.readLine();
            }
        }

        return output.toString();
    }
}
