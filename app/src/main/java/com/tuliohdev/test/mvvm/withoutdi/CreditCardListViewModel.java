package com.tuliohdev.test.mvvm.withoutdi;

import com.tuliohdev.test.clean.CreditCardPresentationConverter;
import com.tuliohdev.test.commondi.CreditCardRepository;
import com.tuliohdev.test.model.CreditCard;
import com.tuliohdev.test.model.CreditCardPresentation;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class CreditCardListViewModel {

    private CreditCardRepository creditCardRepository;
    private PublishSubject<Boolean> loadingStateObservable;
    private CreditCardPresentationConverter converter;

    public CreditCardListViewModel() {
        this.creditCardRepository = new CreditCardRepository();
        this.converter = new CreditCardPresentationConverter();

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
