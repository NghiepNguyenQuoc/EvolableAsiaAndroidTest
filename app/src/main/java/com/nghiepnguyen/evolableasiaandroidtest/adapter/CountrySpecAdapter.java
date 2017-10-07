package com.nghiepnguyen.evolableasiaandroidtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nghiepnguyen.evolableasiaandroidtest.R;
import com.nghiepnguyen.evolableasiaandroidtest.model.Dummy;

import org.apache.commons.lang3.text.WordUtils;

import java.util.List;

/**
 * Created by Nghiep Nguyen on 30-Sep-17.
 */

public class CountrySpecAdapter extends RecyclerView.Adapter<CountrySpecAdapter.ProjectViewHolder> {
    private Context mContext;
    private List<Dummy> dummyList;

    public CountrySpecAdapter(Context mContext, List<Dummy> dummyList) {
        this.mContext = mContext;
        this.dummyList = dummyList;
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spec, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProjectViewHolder holder, int position) {
        final Dummy dummy = dummyList.get(position);
        if (dummy != null) {
            holder.tvSpecTitle.setText(WordUtils.capitalizeFully(dummy.getKey()));
            if (!TextUtils.isEmpty(dummy.getData().toString()))
                holder.tvSpecValue.setText(dummy.getData().toString());
            else
                holder.tvSpecValue.setText("[]");
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return dummyList.size();
    }

    static class ProjectViewHolder extends RecyclerView.ViewHolder {
        TextView tvSpecTitle;
        TextView tvSpecValue;

        ProjectViewHolder(View itemView) {
            super(itemView);

            tvSpecTitle = (TextView) itemView.findViewById(R.id.tv_item_spec_name);
            tvSpecValue = (TextView) itemView.findViewById(R.id.tv_item_spec_value);
        }
    }
}
