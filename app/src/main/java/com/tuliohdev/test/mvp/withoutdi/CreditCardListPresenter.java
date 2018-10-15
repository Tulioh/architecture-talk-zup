package com.tuliohdev.test.mvp.withoutdi;

import com.tuliohdev.test.commondi.CreditCardRepository;
import com.tuliohdev.test.commondi.RepositoryCallback;
import com.tuliohdev.test.model.CreditCard;
import com.tuliohdev.test.model.CreditCardPresentation;
import com.tuliohdev.test.mvp.CreditCardListContract;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class CreditCardListPresenter implements CreditCardListContract.Presenter {

    private CreditCardListContract.View view;
    private CreditCardRepository repository;

    @Inject
    public CreditCardListPresenter(CreditCardListContract.View view) {
        this.view = view;
        this.repository = new CreditCardRepository();
    }

    @Override
    public void onViewLoaded() {
        repository.getCreditCardList(new RepositoryCallback<List<CreditCard>, String>() {
            @Override
            public void onSuccess(List<CreditCard> creditCardList) {
                List<CreditCardPresentation> creditCardPresentations = convertToCreditCardPresentation(creditCardList);


                view.setCreditCardList(creditCardPresentations);
            }

            @Override
            public void onError(String errorMessage) {
                view.showErrorMessage(errorMessage);
            }
        });
    }

    private List<CreditCardPresentation> convertToCreditCardPresentation(List<CreditCard> creditCardList) {
        // TODO: convert objects

        return new ArrayList<>();
    }
}
