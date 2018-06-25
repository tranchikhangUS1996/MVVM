package com.example.lap60020_local.mvvm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.example.lap60020_local.mvvm.DataModel.Language;

import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<Language> {

    public SpinnerAdapter(@NonNull Context context, List<Language> objects) {
        super(context, android.R.layout.simple_spinner_item, objects);
    }

}
