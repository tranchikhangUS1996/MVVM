package com.example.lap60020_local.mvvm.DataModel;

import java.util.List;

import io.reactivex.Observable;

public interface IDataModel {

    public Observable<List<Language>> getSupportedLanguage();

    public Observable<String> getGreetingFromLanguageCode(Language.LangulageCode code);
}
