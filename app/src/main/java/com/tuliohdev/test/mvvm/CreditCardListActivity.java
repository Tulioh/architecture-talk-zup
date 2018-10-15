package com.tuliohdev.test.mvvm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tuliohdev.test.R;

import com.tuliohdev.test.mvvm.withdi.CreditCardListViewModel;
import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class CreditCardListActivity extends AppCompatActivity {

    @Inject CreditCardListViewModel mViewModel;

    private CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compositeDisposable = new CompositeDisposable();

        compositeDisposable.add(mViewModel.getLoadingState().subscribe(isLoading -> {
            // TODO: handle loading visibility
        }));

        compositeDisposable.add(mViewModel.getCreditCardList().subscribe(creditCardPresentations -> {
            // TODO: set credit card list on RecylerView
        }, throwable -> {
            // TODO: show error message
        }));
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.dispose();

        super.onDestroy();
    }
}
