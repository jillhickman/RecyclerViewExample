package com.example.recyclerviewexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<AddOnItem> myDataSet;


    // Provide a suitable constructor (depends on the kind of dataset)
    MyAdapter(List<AddOnItem> myDataSet) {
        this.myDataSet = myDataSet;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // create a new view
        Context context = viewGroup.getContext();
        LayoutInflater  layoutInflater = LayoutInflater.from(context);
        CheckedTextView checkedTextView = (CheckedTextView) layoutInflater.inflate(R.layout.name_list, viewGroup,false);
        return new MyViewHolder(checkedTextView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull List<Object> payloads) {
// - get element from your dataset at this position
        // - replace the contents of the view with that element
        String name = myDataSet.get(position).getName();
        boolean isChecked = myDataSet.get(position).isChecked();
        Log.d("MyAdapter", name);
        holder.checkedTextView.setText(name);
        holder.checkedTextView.setChecked(isChecked);
    }

    @Override
    public int getItemCount() {
        return myDataSet.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        private CheckedTextView checkedTextView;
        MyViewHolder(CheckedTextView checkedTextView) {
            super(checkedTextView);
            this.checkedTextView = checkedTextView;
            checkedTextView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int adapterPosition =  getAdapterPosition();
            boolean isChecked = myDataSet.get(adapterPosition).isChecked();
            //This is setting the isChecked to the reverse
            myDataSet.get(adapterPosition).setChecked(!isChecked);
            notifyDataSetChanged();
        }
    }
}
