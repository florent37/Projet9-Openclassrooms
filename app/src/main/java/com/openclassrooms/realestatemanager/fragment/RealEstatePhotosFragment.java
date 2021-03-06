package com.openclassrooms.realestatemanager.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.realestatemanager.R;
import com.openclassrooms.realestatemanager.adapter.MyRealEstatePhotosRecyclerViewAdapter;
import com.openclassrooms.realestatemanager.model.RealEstatePhotos;

import java.util.List;

public class RealEstatePhotosFragment extends Fragment {

    //no more service here

    private RecyclerView mRecyclerView;
    private RealEstatePhotosViewModel viewModel;
    private MyRealEstatePhotosRecyclerViewAdapter adapter;

    public RealEstatePhotosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_real_estate_photos_list,container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        adapter = new MyRealEstatePhotosRecyclerViewAdapter(); //empty constructor adapter
        mRecyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(RealEstatePhotosViewModel.class);
        viewModel.photos.observe(getViewLifecycleOwner(), new Observer<List<RealEstatePhotos>>() {
            @Override
            public void onChanged(List<RealEstatePhotos> realEstatePhotos) {
                adapter.setRealEstatePhotosList(realEstatePhotos);
            }
        });
    }
}