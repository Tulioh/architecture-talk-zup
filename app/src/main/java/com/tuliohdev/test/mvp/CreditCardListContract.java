package com.tuliohdev.test.mvp;

import com.tuliohdev.test.model.CreditCardPresentation;

import java.util.List;

public interface CreditCardListContract {

    interface Presenter {

        void onViewLoaded();

    }

    interface View {

        void setCreditCardList(List<CreditCardPresentation> creditCardList);
        void showErrorMessage(String errorMessage);
        void showLoading();
        void hideLoading();

    }

}
