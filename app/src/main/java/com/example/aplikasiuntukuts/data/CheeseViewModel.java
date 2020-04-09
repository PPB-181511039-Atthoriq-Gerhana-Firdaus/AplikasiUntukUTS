package com.example.aplikasiuntukuts.data;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CheeseViewModel extends AndroidViewModel {

    private CheeseRepository mRepository;

    private LiveData<List<Cheese>> mAllCheeses;

    public CheeseViewModel (Application application) {
        super(application);
        mRepository = new CheeseRepository(application);
        mAllCheeses = mRepository.getAllCheeses();
    }

    LiveData<List<Cheese>> getAllCheeses() { return mAllCheeses; }


}