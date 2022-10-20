package com.example.homework4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework4.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public class FirstFragment extends Fragment implements OnItemClick{
    private FragmentFirstBinding binding;
    private CountryAdapter adapter;
    private ArrayList<Country> countryList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater,container,false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        adapter=new CountryAdapter(countryList,this::onClick);
        binding.rvCountry.setAdapter(adapter);
    }
    private void loadData() {
        countryList.add(new Country("Australia",R.drawable.ic_australia));
        countryList.add(new Country("South America",R.drawable.ic_south_america));
        countryList.add(new Country("Eurasia",R.drawable.ic_eurasia));
        countryList.add(new Country("North America",R.drawable.ic_north_america));
        countryList.add(new Country("Africa",R.drawable.ic_africa));
    }

    @Override
    public void onClick(int position) {
        CityFragment cityFragment = new CityFragment();
        Bundle bundle = new Bundle();
        Country country = countryList.get(position);
        bundle.putString("Key1",country.getName());
        cityFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace
                (R.id.container1,cityFragment).addToBackStack(null).commit();

         }

    }
