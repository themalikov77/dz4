package com.example.homework4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework4.databinding.FragmentCityBinding;

import java.util.ArrayList;


public class CityFragment extends Fragment implements OnItemClick {
    private FragmentCityBinding binding;
    private ArrayList<Country> countryList = new ArrayList<>();
    private CountryAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCityBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String name = getArguments().getString("Key1");
        Log.d("ololo", "onViewCreated:" + name);
        adapter = new CountryAdapter(countryList,this::onClick);
        binding.rvCity.setAdapter(adapter);
        loadData(name);

    }

    private void loadData(String name) {
        if(name=="Australia"){
            countryList.add(new Country("Sydney",R.drawable.ic_sydney));
            countryList.add(new Country("New Zealand", R.drawable.ic_new_zealand));
            countryList.add(new Country("Island Norfolk",R.drawable.ic_icland_norfolk));
            countryList.add(new Country("Island Pitcairn",R.drawable.ic_icland_pitcairn));
            countryList.add(new Country("Fiji",R.drawable.ic_fiji));
        }
        if (name=="South America"){
            countryList.add(new Country("Argentina",R.drawable.ic_argentina));
            countryList.add(new Country("Brazil",R.drawable.ic_brazil));
            countryList.add(new Country("Colombia",R.drawable.ic_colombia));
            countryList.add(new Country("Uruguay",R.drawable.ic_uruguay));
            countryList.add(new Country("Peru",R.drawable.ic_peru));
        }
        if (name=="Eurasia"){
            countryList.add(new Country("Portugal",R.drawable.ic_portugal));
            countryList.add(new Country("Kyrgyzstan",R.drawable.ic_kyrgyzstan));
            countryList.add(new Country("Kazakhstan",R.drawable.ic_kazakhstan));
            countryList.add(new Country("Ukraine",R.drawable.ic_ukraine));
            countryList.add(new Country("Spain",R.drawable.ic_spain));
        }
        if (name=="North America"){
            countryList.add(new Country("USA",R.drawable.ic_usa));
            countryList.add(new Country("Canada",R.drawable.ic_canada));
            countryList.add(new Country("Bermuda",R.drawable.ic_bermuda));
            countryList.add(new Country("Mexico",R.drawable.ic_mexico));
            countryList.add(new Country("Isle of Man", R.drawable.ic_man));
        }
        if (name=="Africa"){
            countryList.add(new Country("Nigeria",R.drawable.ic_nigeria));
            countryList.add(new Country("Mali",R.drawable.ic_mali));
            countryList.add(new Country("Guinea",R.drawable.ic_guinea));
            countryList.add(new Country("Nigeria",R.drawable.ic_nigeria));
            countryList.add(new Country("Somalia",R.drawable.ic_somalia));

        }
    }

    @Override
    public void onClick(int position) {

    }
}