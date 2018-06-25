package com.example.lap60020_local.mvvm.View;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.lap60020_local.mvvm.DataModel.Language;
import com.example.lap60020_local.mvvm.MVVMApplication;
import com.example.lap60020_local.mvvm.R;
import com.example.lap60020_local.mvvm.SpinnerAdapter;
import com.example.lap60020_local.mvvm.ViewModel.MainViewModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private TextView mTextView;
    private Spinner mSpinner;
    private SpinnerAdapter spinnerAdpter;
    private CompositeDisposable disposable;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = ((MVVMApplication) getApplication()).getmMainViewmodel();
        mTextView = findViewById(R.id.text);
        mSpinner = findViewById(R.id.spinner);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemSelected(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        disposable = new CompositeDisposable();
        context = this;
    }

    private void itemSelected(int position) {
        Language language = spinnerAdpter.getItem(position);
        mainViewModel.selectLanguage(language);
    }

    public void bind() {
        disposable.add(mainViewModel.getGreeting()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setGreeting)
        );

        disposable.add(mainViewModel.getSuporteLanguage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setList));
    }

    private void setList(List<Language> languages) {
        spinnerAdpter = new SpinnerAdapter(context,languages);
        mSpinner.setAdapter(spinnerAdpter);
    }

    private void setGreeting(String s) {
        mTextView.setText(s);
    }


    public void unbind() {
        disposable.clear();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bind();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbind();
    }
}
