package com.example.lap60020_local.mvvm.DataModel;

public class Language {
    public enum LangulageCode {
        EN, FR, VI
    }

    private String mName;
    private LangulageCode mCode;

    public Language(String mName, LangulageCode mCode) {
        this.mName = mName;
        this.mCode = mCode;
    }

    public String getmName() {
        return mName;
    }

    public LangulageCode getmCode() {
        return mCode;
    }

    public String toString() {
        return mName;
    }
}
