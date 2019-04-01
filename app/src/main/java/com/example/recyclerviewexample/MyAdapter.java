package com.example.recyclerviewexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<AddOnItem> myDataSet;
    RadioButton radio;
    TextView tv;
    private int lastSelectedPosition = -1;


    // Provide a suitable constructor (depends on the kind of dataset)
    MyAdapter(List<AddOnItem> myDataSet) {
        this.myDataSet = myDataSet;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // create a new view
        Context context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.name_list, viewGroup, false);
        radio = (RadioButton) view.findViewById(R.id.add_ons_radioButton);
        tv = (TextView) view.findViewById(R.id.add_ons_name);
        return new MyViewHolder(view, radio, tv);
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
        holder.tv.setText(name);
        holder.radio.setChecked(isChecked);
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
        RadioButton radio;
        TextView tv;

        MyViewHolder(View view, RadioButton radio, TextView tv) {
            super(view);
            this.radio = radio;
            this.tv = tv;
            radio.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            lastSelectedPosition = getAdapterPosition();
            boolean isChecked = myDataSet.get(lastSelectedPosition).isChecked();
            //First check to see if there are any items that are checked to true for isChecked
            if(myDataSet != null && myDataSet.size() > 0){
                for (int addOnItemIndex = 0; addOnItemIndex < myDataSet.size(); addOnItemIndex++) {
                    boolean isCheckedTrue = myDataSet.get(addOnItemIndex).isChecked();
                    if(isCheckedTrue){
                        myDataSet.get(addOnItemIndex).setChecked(false);
                    }
                }
            }
            myDataSet.get(lastSelectedPosition).setChecked(!isChecked);
            long addOnsTotalAmount = myDataSet.get(lastSelectedPosition).getAmount();

            notifyDataSetChanged();
        }


//        @Override
//        public void onClick(View view) {
//            int adapterPosition =  getAdapterPosition();
//            boolean isChecked = myDataSet.get(adapterPosition).isChecked();
//            //This is setting the isChecked to the reverse
//            myDataSet.get(adapterPosition).setChecked(!isChecked);
//            notifyDataSetChanged();
//        }

    }
}
