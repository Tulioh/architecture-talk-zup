package com.tuliohdev.test.mvvm.withoutdiandrxjava;

import com.tuliohdev.test.clean.CreditCardPresentationConverter;
import com.tuliohdev.test.commondi.CreditCardRepository;
import com.tuliohdev.test.commondi.RepositoryCallback;
import com.tuliohdev.test.model.CreditCard;
import com.tuliohdev.test.model.CreditCardPresentation;
import com.tuliohdev.test.mvvm.ViewModelCallback;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;

public class CreditCardListViewModel {

    private CreditCardRepository creditCardRepository;
    private CreditCardPresentationConverter converter;

    public CreditCardListViewModel() {
        this.creditCardRepository = new CreditCardRepository();
        this.converter = new CreditCardPresentationConverter();
    }

    public void getCreditCardList(ViewModelCallback<List<CreditCardPresentation>, String> viewModelCallback) {
        creditCardRepository.getCreditCardList(new RepositoryCallback<List<CreditCard>, String>() {
            @Override public void onSuccess(List<CreditCard> creditCardList) {
                viewModelCallback.onSuccess(converter.convert(creditCardList));
            }

            @Override public void onError(String error) {
                viewModelCallback.onError(error);
            }
        });
    }
}
