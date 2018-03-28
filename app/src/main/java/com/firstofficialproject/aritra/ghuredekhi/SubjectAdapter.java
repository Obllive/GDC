package com.firstofficialproject.aritra.ghuredekhi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {
    private List<Subject> subjectList;

    public SubjectAdapter(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public SubjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_bill_report, parent, false
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_adapter, parent, false);
        SubjectViewHolder viewHolder = new SubjectViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(SubjectViewHolder holder, int position) {
        Subject subject = this.subjectList.get(position);
        holder.textName_of_destination.setText(subject.getName_of_destination());
        holder.textPrice_of_package.setText(subject.getPrice_of_package());
    }

    @Override
    public int getItemCount() {
        return this.subjectList.size();
    }

    static class SubjectViewHolder extends RecyclerView.ViewHolder {
        TextView textName_of_destination;
        TextView textPrice_of_package;
        public SubjectViewHolder(View itemView) {
            super(itemView);
            textName_of_destination = (TextView) itemView.findViewById(R.id.name_of_destination);
            textPrice_of_package = (TextView) itemView.findViewById(R.id.price_of_package);
        }
    }
}