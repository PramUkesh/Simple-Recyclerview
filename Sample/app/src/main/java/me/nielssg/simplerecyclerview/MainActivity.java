package me.nielssg.simplerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Initialize the ArrayList, RecyclerView and RecyclerViewAdapter
    ArrayList<Book> books = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //First create some books that we can use to display in the recyclerview
        for (int i = 0; i < 5; i++) {
            books.add(new Book("My Great Book", "Anthony", 2016, 149));
            books.add(new Book("The Wonders of the World", "John", 2014, 56));
            books.add(new Book("Tales of Mystery", "Gregory", 1996, 307));
            books.add(new Book("The Great, Great Story", "Bernard", 2002, 218));
        }

        //Initialize the Recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerViewAdapter = new RecyclerViewAdapter(books);
        mAdapter = mRecyclerViewAdapter;
        mRecyclerView.setAdapter(mAdapter);
    }
}
