package com.tuliohdev.test.mvp.withdi;

import com.tuliohdev.test.clean.CreditCardPresentationConverter;
import com.tuliohdev.test.model.CreditCard;
import com.tuliohdev.test.model.CreditCardPresentation;
import com.tuliohdev.test.commondi.CreditCardRepository;
import com.tuliohdev.test.commondi.RepositoryCallback;

import com.tuliohdev.test.mvp.CreditCardListContract;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CreditCardListPresenter implements CreditCardListContract.Presenter {

    private CreditCardListContract.View view;
    private CreditCardRepository repository;
    private CreditCardPresentationConverter converter;

    @Inject
    public CreditCardListPresenter(CreditCardListContract.View view, CreditCardRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void onViewLoaded() {
        repository.getCreditCardList(new RepositoryCallback<List<CreditCard>, String>() {
            @Override
            public void onSuccess(List<CreditCard> creditCardList) {
                List<CreditCardPresentation> creditCardPresentations = converter.convert(creditCardList);


                view.setCreditCardList(creditCardPresentations);
            }

            @Override
            public void onError(String errorMessage) {
                view.showErrorMessage(errorMessage);
            }
        });
    }
}
