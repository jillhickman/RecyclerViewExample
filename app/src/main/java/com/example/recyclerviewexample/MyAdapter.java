package com.example.recyclerviewexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<String> myDataSet;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public  MyViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }
    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<String> myDataSet) {
        this.myDataSet = myDataSet;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // create a new view
        Context context = viewGroup.getContext();
        LayoutInflater  layoutInflater = LayoutInflater.from(context);
        TextView textView = (TextView)layoutInflater.inflate(R.layout.name_list, viewGroup,false);
        MyViewHolder viewHolder = new MyViewHolder(textView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
//        // - get element from your dataset at this position
//        // - replace the contents of the view with that element
//        Log.d("MyAdapter", myDataSet.get(position));
//        myViewHolder.textView.setText(myDataSet.get(position));
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull List<Object> payloads) {
// - get element from your dataset at this position
        // - replace the contents of the view with that element
        Log.d("MyAdapter", myDataSet.get(position));
        holder.textView.setText(myDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return myDataSet.size();
    }
}
