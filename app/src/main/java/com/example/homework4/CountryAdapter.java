package com.example.homework4;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.homework4.databinding.ItemCountyBinding;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private ArrayList <Country> countryList;
    private OnItemClick onItemClick;



    public CountryAdapter(ArrayList<Country> countryList, OnItemClick onItemClick ) {
        this.countryList = countryList;
        this.onItemClick= onItemClick;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountryViewHolder(ItemCountyBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override

    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.bind(countryList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder {
        private ItemCountyBinding binding;
        public CountryViewHolder(@NonNull ItemCountyBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(Country country){
            binding.tvCountry.setText(country.getName());
            Glide.with(binding.imgImg).load(country.getImage()).into(binding.imgImg);


        }
    }

}
