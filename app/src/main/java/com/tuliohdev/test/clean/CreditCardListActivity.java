package com.tuliohdev.test.clean;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tuliohdev.test.R;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;

public class CreditCardListActivity extends AppCompatActivity {

    @Inject CreditCardListPresenter mPresenter;

    private CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compositeDisposable = new CompositeDisposable();

        compositeDisposable.add(mPresenter.getCreditCardPresentation().subscribe(creditCardPresentations -> {
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
