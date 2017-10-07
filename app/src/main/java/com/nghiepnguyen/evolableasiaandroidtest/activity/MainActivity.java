package com.nghiepnguyen.evolableasiaandroidtest.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nghiepnguyen.evolableasiaandroidtest.R;
import com.nghiepnguyen.evolableasiaandroidtest.adapter.CountryAdapter;
import com.nghiepnguyen.evolableasiaandroidtest.model.CountryModel;
import com.nghiepnguyen.evolableasiaandroidtest.networking.ApiClient;
import com.nghiepnguyen.evolableasiaandroidtest.networking.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView countryRecycerView;
    private ProgressBar mProgressBar;
    private TextView tvNoData;
    private SearchView searchView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<CountryModel> countryModels;
    private CountryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countryRecycerView = (RecyclerView) findViewById(R.id.rv_country_list);
        countryRecycerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        countryRecycerView.setLayoutManager(llm);
        mProgressBar = (ProgressBar) findViewById(R.id.pb_loading);
        tvNoData = (TextView) findViewById(R.id.tv_no_data);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.pullRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (countryModels != null && countryModels.size() > 0) {
                    adapter = new CountryAdapter(MainActivity.this, countryModels);
                    countryRecycerView.setAdapter(adapter);
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });
        callApiGetProjectList();
    }

    @Override
    public void onBackPressed() {
        if (searchView != null && !searchView.isIconified()) {
            searchView.setIconified(true);
            adapter = new CountryAdapter(MainActivity.this, countryModels);
            countryRecycerView.setAdapter(adapter);
        } else {
            super.onBackPressed();
        }
    }

    private void callApiGetProjectList() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<CountryModel>> call;
        mProgressBar.setVisibility(View.VISIBLE);
        tvNoData.setVisibility(View.GONE);
        call = apiService.getAllCountriesByQuery();
        call.enqueue(new Callback<List<CountryModel>>() {
            @Override
            public void onResponse(Call<List<CountryModel>> call, Response<List<CountryModel>> response) {
                countryModels = response.body();
                if (countryModels != null && countryModels.size() > 0) {
                    adapter = new CountryAdapter(MainActivity.this, countryModels);
                    countryRecycerView.setAdapter(adapter);
                    mProgressBar.setVisibility(View.GONE);
                } else {
                    countryRecycerView.setVisibility(View.GONE);
                    mProgressBar.setVisibility(View.GONE);
                    tvNoData.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<CountryModel>> call, Throwable t) {
                countryRecycerView.setVisibility(View.GONE);
                mProgressBar.setVisibility(View.GONE);
                tvNoData.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        final MenuItem searchMenuItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) searchMenuItem.getActionView();

        // Get the search close button image view
        ImageView closeButton = (ImageView) searchView.findViewById(R.id.search_close_btn);

        // Set on click listener
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                List<CountryModel> list = new ArrayList<>();

                // ISO 3166 1 2

                for (CountryModel countryModel : countryModels) {
                    boolean isAdded = false;
                    if (query.length() == 2 || query.length() == 3) {
                        if (countryModel.getAlpha2Code().equalsIgnoreCase(query.toLowerCase().trim()) || countryModel.getAlpha3Code().equalsIgnoreCase(query.toLowerCase().trim())) {
                            list.add(countryModel);
                            isAdded = true;
                        }
                    }
                    if (countryModel.getName().toLowerCase().trim().contains(query.toLowerCase().trim()) || countryModel.getNativeName().toLowerCase().trim().contains(query.toLowerCase().trim())) {
                        if (!isAdded)
                            list.add(countryModel);
                    }
                }
                if (list.size() > 0) {
                    adapter = new CountryAdapter(MainActivity.this, list);
                    countryRecycerView.setAdapter(adapter);
                    mProgressBar.setVisibility(View.GONE);
                } else {
                    countryRecycerView.setVisibility(View.GONE);
                    mProgressBar.setVisibility(View.GONE);
                    tvNoData.setVisibility(View.VISIBLE);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }
}
