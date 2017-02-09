#Welcome to this repository!
Welcome. By following the steps below, you'll easily create a working and clean RecyclerView. I'll guide you through the RecyclerView by using Books as example items. If you do not understand a step, just ask me by creating a new issue or look at the sample app. The sample app contains the same code as you use when you go through all the steps.

##Step 1
First add this to your app level build.gradle:
```
compile 'com.android.support:design:25.1.0'
```
##Step 2
Add this to your Activity's xml file:
```
<android.support.v7.widget.RecyclerView
	android:id="@+id/recyclerView"
	android:scrollbars="vertical"
	android:layout_width="match_parent"
	android:clipToPadding="false"
	android:layout_height="match_parent"
	app:layout_behavior="@string/appbar_scrolling_view_behavior"
	android:layout_alignParentTop="true"
	android:layout_alignParentLeft="true"
	android:layout_alignParentStart="true" />
```
##Step 3
Add the following variables at the top of your class:
```
ArrayList<Book> books = new ArrayList<>();
private RecyclerView mRecyclerView;
private RecyclerView.Adapter mAdapter;
private RecyclerView.LayoutManager mLayoutManager;
private RecyclerViewAdapter mRecyclerViewAdapter;
```
##Step 4
We are going to use a book collection as example, so create a class called 'Book' and do the same as down below
```
public class Book {
    private String title;
    private String author;
    private int yearOfPublication;
    private int amountOfPages;

    public Book(String title, String author, int yearOfPublication, int 	amountOfPages) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.amountOfPages = amountOfPages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public int getAmountOfPages() {
        return amountOfPages;
    }
}
```
##Step 5
Now create a new class called RecyclerViewAdapter:
```
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
	ArrayList<Book> books;

	public static class ViewHolder extends RecyclerView.ViewHolder {
	    public LinearLayout book;
	    public TextView title;
	    public TextView author;
	    public TextView pages;
	    public TextView date;

	    public ViewHolder(View v) {
	        super(v);
	        book = (LinearLayout) itemView.findViewById(R.id.book);
	        title = (TextView) itemView.findViewById(R.id.title);
	        author = (TextView) itemView.findViewById(R.id.author);
	        pages = (TextView) itemView.findViewById(R.id.pages);
	        date = (TextView) itemView.findViewById(R.id.date);
	    }
	}

	public RecyclerViewAdapter(ArrayList<Book> resultaten) {
	    this.books = resultaten;
	}

	@Override
	public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, 	int viewType) {
	    View v = LayoutInflater.from(parent.getContext()).inflate(	R.layout.book, parent, false);
	    return new ViewHolder(v);
	}

	@Override
	@SuppressWarnings("All")
	public void onBindViewHolder(ViewHolder holder, int position) {
	    final Book book = books.get(position);
	    holder.title.setText(book.getTitle());
	    holder.author.setText("Written by " + book.getAuthor());
	    holder.pages.setText("Date: " + book.getYearOfPublication());
	    holder.date.setText(book.getAmountOfPages() + " pages");
	}

	@Override
	public int getItemCount() {
	    return books.size();
	}
}
```
##Step 6
Add this in your onCreate method after you've done setContentview:
```
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
```
##Step 7
Now we need to create a layout that the Books can use:
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <LinearLayout
        android:id="@+id/book"
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:paddingBottom="10dp"
        android:paddingTop="10dp">

        <LinearLayout
            android:orientation="vertical"
            android:layout_gravity="center_horizontal|bottom"
            android:baselineAligned="true"
            android:layout_height="match_parent"
            android:layout_width="match_parent"
            android:paddingLeft="10dp">

            <LinearLayout
                android:orientation="horizontal"
                android:layout_width="match_parent"
                android:layout_height="wrap_content">

                <TextView
                    android:text="Title"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:id="@+id/title"
                    android:layout_weight="1"
                    android:textStyle="normal|bold"
                    android:textSize="18sp" />

                <TextView
                    android:text="100 pages"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:id="@+id/pages"
                    android:layout_weight="1"
                    android:layout_marginLeft="10dp"
                    android:layout_marginRight="10dp"
                    android:gravity="end" />
            </LinearLayout>

            <LinearLayout
                android:orientation="horizontal"
                android:layout_width="match_parent"
                android:layout_height="wrap_content">

                <TextView
                    android:text="Author"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:id="@+id/author"
                    android:layout_weight="1"
                    android:layout_marginTop="6dp"
                    android:maxLines="1"/>

                <TextView
                    android:text="28-01-2017"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:id="@+id/date"
                    android:layout_weight="1"
                    android:layout_marginRight="10dp"
                    android:layout_marginTop="6dp"
                    android:layout_marginLeft="10dp"
                    android:gravity="end" />
            </LinearLayout>
        </LinearLayout>
    </LinearLayout>
</LinearLayout>```
```
##The End
Now you're done :) . If you did not understand a step, just create a new issue or look at the sample app.


##Disclaimer
All the code provided in this repository is permitted to use without mentioning the author (me :smile:). However, claiming this guide as if you made the guide yourself is NOT PERMITTED.
