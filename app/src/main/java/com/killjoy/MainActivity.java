package com.killjoy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String a = "BAG";
//        switch (a) {
//            case "APP":case "APPLICATION":
//                Toast.makeText(this, "APP", Toast.LENGTH_SHORT).show();break;
//            case "BAG":case "CRAPBAG":
//                Toast.makeText(this, "CRAP", Toast.LENGTH_SHORT).show();break;
//            default:
//                Toast.makeText(this, "default", Toast.LENGTH_SHORT).show();
//        }
//        textView=(TextView)this.findViewById(R.id.textView);
//        textView.setSelected(true);
//        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
//        textView.setSingleLine(true);
        ListView listView = findViewById(R.id.list);
        List<String> mylist = new ArrayList<>();
        mylist.add("Reliance");
        mylist.add("Tcs");

        mylist.add("Hdfc");
        mylist.add("Hdfcbank");

        mylist.add("Icicibank");
        mylist.add("BajFinace");
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_selectable_list_item, mylist);
        listView.setAdapter(arrayAdapter);
        listView.setVisibility(View.GONE);
        SearchView searchView = (SearchView) findViewById(R.id.find);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String b;
            b = (String) ((TextView) view).getText();
//            Toast.makeText(this, searchvalue(b), Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, DisplayContent.class);
            i.putExtra("CompanyName", b);
            startActivity(i);

        });


        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                listView.setVisibility(View.GONE);
                return false;
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {


            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                int c = arrayAdapter.getCount();
                String newText = text.toUpperCase();
                arrayAdapter.getFilter().filter(newText);
                Log.i("TEST", "\n***********\n");
                for (int i = 0; i < arrayAdapter.getCount(); i++) {
                    if (arrayAdapter.getItem(i).contains(newText)) {
                        Log.i("TEST", newText + " found in " + arrayAdapter.getItem(i));

                    } else {
                        Log.i("TEST", newText + " not found in " + arrayAdapter.getItem(i));
                        c--;
//                       arrayAdapter.remove(arrayAdapter.getItem(i));
                    }

                }

                listView.setVisibility(View.VISIBLE);
                if (c != 0) {
                    Toast.makeText(MainActivity.this, " Found", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "Found NOT ", Toast.LENGTH_SHORT).show();
                }

                return true;
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