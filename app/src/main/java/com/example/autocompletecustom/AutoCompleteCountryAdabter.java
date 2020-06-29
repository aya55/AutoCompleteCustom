package com.example.autocompletecustom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AutoCompleteCountryAdabter extends ArrayAdapter<countryItem> {
    private List <countryItem>countryListFull;
    public AutoCompleteCountryAdabter(@NonNull Context context, @NonNull List<countryItem> countryList) {
        super(context, 0, countryList);
        countryListFull=new ArrayList<>(countryList);
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return countryFilter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       if (convertView==null){
           convertView= LayoutInflater.from(getContext()).inflate(R.layout.country_autocomplete_row,parent,false);

       }
        TextView textViewName=convertView.findViewById(R.id.text_view_name);
        ImageView imageViewFlage=convertView.findViewById(R.id.image_view_flag);
         countryItem CountryItem=getItem(position);
         if (CountryItem!=null){
             textViewName.setText(CountryItem.getCountryName());
              imageViewFlage.setImageResource(CountryItem.getFlageImage());


         }
        return convertView;
    }

    private Filter countryFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
       FilterResults results=new FilterResults();
       List<countryItem> suggestions=new ArrayList<>();
       if (constraint==null||constraint.length()==0){
           suggestions.addAll(countryListFull);

       }
       else {
           String fillterPattern=constraint.toString().toLowerCase().trim();
           for (countryItem item:countryListFull){

               if (item.getCountryName().toLowerCase().contains(fillterPattern)){
                   suggestions.add(item);

               }
           }
       }
       results.values=suggestions;
       results.count=suggestions.size();
       return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
        clear();
        addAll((List)results.values);
        notifyDataSetChanged();

        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((countryItem) resultValue).getCountryName();
        }
    };
}
