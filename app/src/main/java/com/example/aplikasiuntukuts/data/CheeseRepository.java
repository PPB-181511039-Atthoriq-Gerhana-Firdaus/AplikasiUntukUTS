package com.example.aplikasiuntukuts.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CheeseRepository {

    private CheeseDao mCheeseDao;
    private LiveData<List<Cheese>> mAllCheeses;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    CheeseRepository(Application application) {
        SampleDatabase db = SampleDatabase.getDatabase(application);
        mCheeseDao = db.cheese();
        mAllCheeses = mCheeseDao.getAlphabetizedWords();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Cheese>> getAllCheeses() {
        return mAllCheeses;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
}
