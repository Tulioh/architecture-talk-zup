package com.tuliohdev.test.mvvm.withdi;

import com.tuliohdev.test.clean.CreditCardPresentationConverter;
import com.tuliohdev.test.model.CreditCard;
import com.tuliohdev.test.model.CreditCardPresentation;
import com.tuliohdev.test.commondi.CreditCardRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class CreditCardListViewModel {

    private CreditCardRepository creditCardRepository;
    private PublishSubject<Boolean> loadingStateObservable;
    private CreditCardPresentationConverter converter;

    @Inject
    public CreditCardListViewModel(CreditCardRepository creditCardRepository,
        CreditCardPresentationConverter converter) {
        this.creditCardRepository = creditCardRepository;
        this.converter = converter;

        loadingStateObservable = PublishSubject.create();
    }

    public Observable<Boolean> getLoadingState() {
        return loadingStateObservable;
    }

    public Observable<List<CreditCardPresentation>> getCreditCardList() {
        loadingStateObservable.onNext(true);
        return creditCardRepository.getCreditCardList().map(creditCards ->
            converter.convert(creditCards)
        ).toObservable().doOnComplete(() ->
            loadingStateObservable.onNext(false)
        );
    }
}
