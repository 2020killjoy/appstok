package com.killjoy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toolbar;
import com.killjoy.SearchPredFragment;
import com.killjoy.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;


public class Search extends AppCompatActivity {

    MySearchPredRecyclerViewAdapter adapter ;
    SearchPredFragment fragment;
    DummyContent dummyContent;
    DummyContent.DummyItem dummyItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
//        adapter = new MySearchPredRecyclerViewAdapter();
//        fragment = new SearchPredFragment();
//        List<DummyContent.DummyItem> dummyItems = new ArrayList<>();
//
//        dummyItems.add(0,new DummyContent.DummyItem("zeroth index","element 0","element no 0"));
//        ListAdapter  listAdapter = (ListAdapter) new MySearchPredRecyclerViewAdapter(dummyItems);
//
//        adapter = new MySearchPredRecyclerViewAdapter(dummyItems);
//        Log.i("TEST",(dummyItems.toArray()[0]).toString());
//        ListView listView = (ListView)findViewById(R.id.list);
////        adapter.onCreateViewHolder(listView,0);
////       ListView recyclerView = (ListView)findViewById(R.id.list);
////        recyclerView.setAdapter(adapter);
//        LinearLayoutManager linearLayoutManager;
//        listView.setAdapter(listAdapter);





    }

}
