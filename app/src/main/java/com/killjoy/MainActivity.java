package com.killjoy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> arrayAdapter;
    private TextView textView;
    List<String> mylist = new ArrayList<>();
    SearchView searchView;
    ListView listView;
    FilterSearch filterSearch;

    @Override
    public void onBackPressed() {
        keyboardhide.hideSoftKeyboard(this);
        Toast.makeText(this, "back pressed ", Toast.LENGTH_SHORT).show();
        searchView.setQuery("",false);
        searchView.clearFocus();


    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        final InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
//        if (inputMethodManager != null && inputMethodManager.isActive()) {
//            if (getCurrentFocus() != null) {
//                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
//            }
//        }
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         listView = findViewById(R.id.list);
        mylist.add("Reliance");
        mylist.add("Tcs");
        mylist.add("Real");
        mylist.add("REd");
        mylist.add("ready");
        mylist.add("Hdfc");
        mylist.add("Hdfcbank");

        mylist.add("Icicibank");
        mylist.add("BajFinace");
        filterSearch = new FilterSearch(this, android.R.layout.simple_selectable_list_item,mylist);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_selectable_list_item, mylist);
        listView.setAdapter(arrayAdapter);
//        listView.setAdapter(filterSearch);
        listView.setVisibility(View.GONE);
         searchView = (SearchView) findViewById(R.id.find);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String b;
            b = (String) ((TextView) view).getText();
//            Toast.makeText(this, searchvalue(b), Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, DisplayContent.class);
            i.putExtra("CompanyName", b);
            startActivity(i);

        });
//        searchView.clearFocus();

        searchView.setOnCloseListener(() -> {
            listView.setVisibility(View.GONE);
            return false;
        });



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {


            @Override
            public boolean onQueryTextSubmit(String query) {
                listView.setVisibility(View.GONE);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                CharSequence actual  =  searchView.getQuery();
                String newText = actual.toString().toUpperCase();

                if(newText.length()==0)
                {
                    listView.setVisibility(View.GONE);

                }
                else
                {
                    listView.setVisibility(View.VISIBLE);

                }

                int c = filterSearch.getCount();
//                Log.i("TEST","actual value at query is    "+actual.toString());
                arrayAdapter.getFilter().filter(newText);
//                    Log.i("TEST","count before clear() "+ filterSearch.getCount() );
//                    filterSearch.clear();
//                Log.i("TEST","count after clear() "+ filterSearch.getCount() );
//                       filterSearch.result(newText);


//                filterSearch.getFilter().filter(newText);

//                Log.i("TEST","No of Obj with "+newText+ " are "+filterSearch.noofobjwith(newText));
                for (int i = 0 ; i<c;i++)
                {
//                    Log.i("TEST","element in "+i+" is "+arrayAdapter.getItem(i));
//                      Log.i("TEST","element in "+i+" is "+filterSearch.getItem(i));

                }

//                try{
//                    for (int i = 0 ; i<100;i++)
//                    {
//                       arrayAdapter.
//                    }
//                }
//                catch (Exception e)
//                {
//                    Log.i("TEST","error in looping "+e);
//
//                }

//                if(c==0)
//                {
//                    Log.i("TEST","getCount is zero and query is "+newText);
//                }
//                else
//                {
//                    Log.i("TEST","getCount is "+c+" and query is "+newText);
//
//                }
//                Log.i("TEST", "\n*\n\t");
//                for (int i = 0; i < arrayAdapter.getCount(); i++) {
//                    if (arrayAdapter.getItem(i).contains(newText)) {
//                        Log.i("TEST", newText + " found in " + arrayAdapter.getItem(i));
//
//                    } else {
//                        Log.i("TEST", newText + " not found in " + arrayAdapter.getItem(i));
//                        c--;
////                       arrayAdapter.remove(arrayAdapter.getItem(i));
//                    }
//
//                }

//                if (c != 0) {
//                    Toast.makeText(MainActivity.this, " Found", Toast.LENGTH_SHORT).show();
//
//                } else {
//                    Toast.makeText(MainActivity.this, "Found NOT ", Toast.LENGTH_SHORT).show();
//                }

                return false;
            }
        });
    }



    private String searchvalue(String b) {
        switch (b) {
            case "APP":
            case "APPLICATION":
                return ("Its an APP");
            case "BAG":
            case "CRAPBAG":
                return ("Its a Crap ");
            default:
                return ("Its not An App or a Crap");
        }
    }

    public void searchtest(View view) {
        Intent i = new Intent(this, Search.class);
        startActivity(i);
    }
}
class keyboardhide
{

    public static void hideSoftKeyboard(Activity activity) {
        final InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (inputMethodManager.isActive()) {
            if (activity.getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
            }
        }
    }
}
