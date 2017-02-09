package me.nielssg.simplerecyclerview;

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
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book, parent, false);
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
