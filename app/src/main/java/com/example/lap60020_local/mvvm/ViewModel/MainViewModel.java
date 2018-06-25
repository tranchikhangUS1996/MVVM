package com.example.lap60020_local.mvvm.ViewModel;

import com.example.lap60020_local.mvvm.DataModel.IDataModel;
import com.example.lap60020_local.mvvm.DataModel.Language;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

public class MainViewModel {

    private IDataModel mDataModel;

    private BehaviorSubject<Language> mSubject = BehaviorSubject.create();

    public MainViewModel(IDataModel mDataModel) {
        this.mDataModel = mDataModel;
    }

    public Observable<String> getGreeting(){
        return mSubject.observeOn(Schedulers.computation())
                .map(Language::getmCode)
                .flatMap(mDataModel::getGreetingFromLanguageCode);
    }

    public Observable<List<Language>> getSuporteLanguage() {
        return mDataModel.getSupportedLanguage();
    }

    public void selectLanguage(Language language) {
        mSubject.onNext(language);
    }
}
