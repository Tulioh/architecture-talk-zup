package com.tuliohdev.test.clean;

import com.tuliohdev.test.model.CreditCardPresentation;
import io.reactivex.Observable;
import java.util.List;

public class CreditCardListPresenterImpl implements CreditCardListPresenter {

    private FindUserCreditCardsInteractor mFindUserCreditCardsInteractor;

    public CreditCardListPresenterImpl(FindUserCreditCardsInteractor findUserCreditCardsInteractor) {
        mFindUserCreditCardsInteractor = findUserCreditCardsInteractor;
    }

    public Observable<List<CreditCardPresentation>> getCreditCardPresentation() {
        return mFindUserCreditCardsInteractor.execute().toObservable();
    }
}
