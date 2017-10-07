package com.nghiepnguyen.evolableasiaandroidtest.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nghiepnguyen.evolableasiaandroidtest.R;
import com.nghiepnguyen.evolableasiaandroidtest.activity.CountryDetailActivity;
import com.nghiepnguyen.evolableasiaandroidtest.application.MainApplication;
import com.nghiepnguyen.evolableasiaandroidtest.model.CountryModel;
import com.nghiepnguyen.evolableasiaandroidtest.utils.Constant;

import java.util.List;
import java.util.Locale;

/**
 * Created by Nghiep Nguyen on 30-Sep-17.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ProjectViewHolder> {
    private Context mContext;
    private List<CountryModel> countries;

    public CountryAdapter(Context mContext, List<CountryModel> countries) {
        this.mContext = mContext;
        this.countries = countries;
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProjectViewHolder holder, int position) {
        final CountryModel country = countries.get(position);
        if (country != null) {
            holder.tvCountryName.setText(country.getName());
            String countrySpec = mContext.getString(R.string.txt_capital, country.getCapital() + "\n") +
                    mContext.getString(R.string.txt_population, String.format(Locale.US, "%1$,.0f", country.getPopulation()) + "\n") +
                    mContext.getString(R.string.txt_area, String.format(Locale.US, "%1$,.0f", country.getArea()) + "\n");
            holder.tvCountrySpec.setText(countrySpec);
            MainApplication.getRequestBuilder().diskCacheStrategy(DiskCacheStrategy.SOURCE)// SVG cannot be serialized so it's not worth to cache it
                    .load(Uri.parse(country.getFlag()))
                    .into(holder.ivCountryFlag);
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, CountryDetailActivity.class);
                    intent.putExtra(Constant.BUNDLE_COUNTRY, country);
                    mContext.startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    static class ProjectViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView tvCountryName;
        TextView tvCountrySpec;
        ImageView ivCountryFlag;
        ImageView ivGoDetail;

        ProjectViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            tvCountryName = (TextView) itemView.findViewById(R.id.tv_country_name);
            tvCountrySpec = (TextView) itemView.findViewById(R.id.tv_country_spec);
            ivCountryFlag = (ImageView) itemView.findViewById(R.id.iv_coutry_flag);
            ivGoDetail = (ImageView) itemView.findViewById(R.id.iv_go_detail);

            cardView.getBackground().setAlpha(225);
        }
    }
}
