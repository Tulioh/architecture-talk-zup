package com.tuliohdev.test.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tuliohdev.test.R;
import com.tuliohdev.test.model.CreditCardPresentation;

import java.util.List;

import javax.inject.Inject;

public class CreditCardListActivity extends AppCompatActivity implements CreditCardListContract.View {

    @Inject
    CreditCardListContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter.onViewLoaded();
    }

    @Override
    public void setCreditCardList(List<CreditCardPresentation> creditCardList) {
        // TODO: set credit card list on RecylerView
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        // TODO: show error message
    }

    @Override
    public void showLoading() {
        // TODO: show loading
    }

    @Override
    public void hideLoading() {
        // TODO: hide loading
    }
}
