package com.example.covidapp;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CustomAdaptor extends ArrayAdapter<CountryModel> {
    private Context mContext;
    private List<CountryModel> countryModelList;
    private List<CountryModel> filteredCountryModelList;

    public CustomAdaptor(Context context, List<CountryModel> countryModelList) {
        super(context, R.layout.list_custom_item,countryModelList);
        this.mContext = context;
        this.countryModelList = countryModelList;
        this.filteredCountryModelList = countryModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item,null,true);
        TextView name = view.findViewById(R.id.countyName);
        ImageView image = view.findViewById(R.id.flagImage);

        name.setText(filteredCountryModelList.get(position).getCountry());
        Glide.with(mContext).load(filteredCountryModelList.get(position).getFlag()).into(image);
        return view;
    }

    @Override
    public int getCount() {
        return filteredCountryModelList.size();
    }

    @Nullable
    @Override
    public CountryModel getItem(int position) {
        return filteredCountryModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                if(charSequence==null || charSequence.length()==0){
                    filterResults.count = countryModelList.size();
                    filterResults.values = countryModelList;
                }else{
                    List<CountryModel> list = new ArrayList<>();
                    String searchStr = charSequence.toString().toLowerCase();
                    for(CountryModel itemModel:countryModelList){
                        if(itemModel.getCountry().toLowerCase().contains(searchStr)){
                            list.add(itemModel);
                        }
                        filterResults.count = list.size();
                        filterResults.values = list;
                    }
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {
                filteredCountryModelList = (List<CountryModel>) results.values;
                AffectedCountries.countryModelList = (List<CountryModel>) results.values;
                notifyDataSetChanged();
            }

        };
        return filter;
    }
}
