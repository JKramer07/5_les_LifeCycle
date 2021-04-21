package com.geek.a5_les_lifecycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private List<String> list;


    public RecyclerAdapter(List<String> list){
        this.list = list;
    }

    public void addNewItem(String s) {
        list.add(s);
        notifyItemInserted(list.indexOf(s));
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerViewHolder holder, int position) {
        holder.txtTitle.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle =itemView.findViewById(R.id.title_txt);
        }
    }
}
