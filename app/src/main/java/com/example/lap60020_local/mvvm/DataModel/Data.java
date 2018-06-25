package com.example.lap60020_local.mvvm.DataModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class Data implements IDataModel {
    @Override
    public Observable<List<Language>> getSupportedLanguage() {
        return Observable.fromCallable(this::getList);
    }

    public List<Language> getList() {
        ArrayList<Language> list = new ArrayList<>();
        list.add(new Language("ENGLISH", Language.LangulageCode.EN));
        list.add(new Language("France", Language.LangulageCode.FR));
        list.add(new Language("VIETNAMESE", Language.LangulageCode.VI));
        return list;
    }

    @Override
    public Observable<String> getGreetingFromLanguageCode(Language.LangulageCode code) {
        switch (code) {
            case EN:
                return Observable.just("Hello");
            case FR:
                return  Observable.just("Bonjour");
            case VI:
                return Observable.just("Xin chào");
            default:
                return Observable.empty();
        }
    }
}
