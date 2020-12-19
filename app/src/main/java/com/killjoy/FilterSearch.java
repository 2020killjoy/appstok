package com.killjoy;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FilterSearch extends ArrayAdapter<String> {

    List<String> objs;
    int count =  0;
    List<String> mylist = new ArrayList<>();

    public FilterSearch(@NonNull Context context, int textViewResourceId, @NonNull List<String> objects) {
        super(context, textViewResourceId, objects);
        objs = objects;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return objs.get(position);
    }

    @Override
    public int getCount() {
        return objs.size();
    }

    @NonNull
    @Override
    public Filter getFilter() {
        mylist.add("Reliance");
        mylist.add("Tcs");
        mylist.add("Real");
        mylist.add("REd");
        mylist.add("ready");
        mylist.add("Hdfc");
        mylist.add("Hdfcbank");

        mylist.add("Icicibank");
        mylist.add("BajFinace");
        try {

            return super.getFilter();

        } catch (Exception e) {
//            e.printStackTrace();
        Log.i("TEST","exception on Filter "+e);
        }
        Log.i("TEST","Try failed");
        return super.getFilter();
    }

    @Override
    public void clear() {
        objs.clear();
    }
public void result(String text)
{
//    objs.clear();
    for (int i = 0; i <mylist.size(); i++) {
       String p =  (mylist.get(i));
       if(p.contains(text))
       {
           Log.i("TEST",p+" p contains  text "+text);
           objs.add(p);
       }

    }


}
    @Override
    public void add(@Nullable String object) {
        try {
            objs.add(object);
        } catch (Exception e) {
            Log.i("TEST","add  eror "+e);
        }

//        super.add(object);
    }

    @Override
    public void addAll(String... items) {
        objs.addAll(Arrays.asList(items));

//        try {
//            objs.addAll(Arrays.asList(items));
//        } catch (Exception e) {
//            Log.i("TEST","add all eror "+e);
//        }
    }

        public int noofobjwith(String a)
    {
        count = 0;
        for (int j = 0; j <objs.size() ; j++) {
            String temp = objs.get(j).toUpperCase();
            Log.i("TEST","temp value is "+temp+" and we are searching for "+a);
            if(temp.contains(a))
            {
                Log.i("TEST",objs.get(j)+" has a "+a);
                count++;
            }

        }
        return  count;
    }
}
