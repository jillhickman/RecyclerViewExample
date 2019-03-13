package com.example.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<AddOnItem> myDataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        myDataSet = new ArrayList<>();
        myDataSet.add(new AddOnItem("dog", 10));
        myDataSet.add(new AddOnItem("cat", 10));
        myDataSet.add(new AddOnItem("cow", 10));
        myDataSet.add(new AddOnItem("horse", 10));
        myDataSet.add(new AddOnItem("elephant", 10));
        myDataSet.add(new AddOnItem("Jill", 10));

        int columnCount = 2;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, columnCount);
        recyclerView.setLayoutManager(gridLayoutManager);

        // specify an adapter
        myAdapter = new MyAdapter(myDataSet);
        recyclerView.setAdapter(myAdapter);

    }
}
