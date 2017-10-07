package com.nghiepnguyen.evolableasiaandroidtest.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nghiepnguyen.evolableasiaandroidtest.R;
import com.nghiepnguyen.evolableasiaandroidtest.adapter.CountrySpecAdapter;
import com.nghiepnguyen.evolableasiaandroidtest.application.MainApplication;
import com.nghiepnguyen.evolableasiaandroidtest.model.CountryModel;
import com.nghiepnguyen.evolableasiaandroidtest.model.Dummy;
import com.nghiepnguyen.evolableasiaandroidtest.utils.Constant;

import java.util.List;

/**
 * Created by Nghiep Nguyen on 30-Sep-17.
 */

public class CountryDetailFragment extends Fragment {
    private Context mContext;
    private CountryModel countryModel;

    public CountryDetailFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(Constant.BUNDLE_COUNTRY)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            countryModel = getArguments().getParcelable(Constant.BUNDLE_COUNTRY);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(countryModel.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (countryModel != null) {
            TextView tvCountryName = (TextView) rootView.findViewById(R.id.tv_item_country_name);
            ImageView ivCountryFlag = (ImageView) rootView.findViewById(R.id.iv_item_coutry_flag);
            RecyclerView rvCountrySpec = (RecyclerView) rootView.findViewById(R.id.rv_item_country_spec_list);

            rvCountrySpec.setHasFixedSize(true);
            LinearLayoutManager llm = new LinearLayoutManager(mContext);
            rvCountrySpec.setLayoutManager(llm);

            tvCountryName.setText(countryModel.getName());
            MainApplication.getRequestBuilder().diskCacheStrategy(DiskCacheStrategy.SOURCE)// SVG cannot be serialized so it's not worth to cache it
                    .load(Uri.parse(countryModel.getFlag()))
                    .into(ivCountryFlag);

            List<Dummy> dummyList = countryModel.toList();
            CountrySpecAdapter adapter = new CountrySpecAdapter(mContext, dummyList);
            rvCountrySpec.setAdapter(adapter);
        }

        return rootView;
    }
}
