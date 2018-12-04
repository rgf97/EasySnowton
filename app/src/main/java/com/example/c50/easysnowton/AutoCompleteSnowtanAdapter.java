package com.example.c50.easysnowton;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import android.*;


import java.util.ArrayList;
import java.util.List;

public class AutoCompleteSnowtanAdapter extends ArrayAdapter<SnowtanItem> {

    private List<SnowtanItem> snowtonListFull;

    public AutoCompleteSnowtanAdapter(@NonNull Context context, @NonNull List<SnowtanItem> snowtanItemList) {
        super(context, 0, snowtanItemList);
        snowtonListFull = new ArrayList<>(snowtanItemList);
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return snowtanFilter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.snowtam_autocomplete_row, parent, false);
        }

        TextView textViewName = convertView.findViewById(R.id.text_view_name);
        ImageView imageViewFlag = convertView.findViewById(R.id.image_view_flag);
        SnowtanItem snowtanItem = getItem(position);

        if (snowtanItem != null) {
            textViewName.setText(snowtanItem.getSnowtanName());
            imageViewFlag.setImageResource(snowtanItem.getCountryFlag());
        }

        return convertView;
    }

    private Filter snowtanFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<SnowtanItem> suggestions = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                suggestions.addAll(snowtonListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (SnowtanItem item : snowtonListFull) {
                    if (item.getSnowtanName().toLowerCase().contains(filterPattern)) {
                        suggestions.add(item);
                    }
                }
            }
            results.values = suggestions;
            results.count = suggestions.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            addAll((List) results.values);
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((SnowtanItem) resultValue).getSnowtanName();
        }
    };
}
