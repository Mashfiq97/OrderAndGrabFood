package com.example.foody_v6_11dec.ui.home;

import android.widget.Button;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foody_v6_11dec.R;
import com.google.firebase.database.DatabaseReference;

public class HomeViewModel extends ViewModel {


    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
    }


    public LiveData<String> getText() {
        return mText;
    }
}