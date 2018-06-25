package com.example.lap60020_local.mvvm;

import android.app.Application;

import com.example.lap60020_local.mvvm.DataModel.Data;
import com.example.lap60020_local.mvvm.DataModel.IDataModel;
import com.example.lap60020_local.mvvm.ViewModel.MainViewModel;

public class MVVMApplication extends Application {

    private MainViewModel mMainViewmodel;
    private IDataModel mIDataModel;

    @Override
    public void onCreate() {
        super.onCreate();
        mIDataModel = new Data();
        mMainViewmodel = new MainViewModel(mIDataModel);
    }

    public MainViewModel getmMainViewmodel() {
        return mMainViewmodel;
    }

    public IDataModel getmIDataModel() {
        return mIDataModel;
    }
}
