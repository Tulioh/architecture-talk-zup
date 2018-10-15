package com.tuliohdev.test.clean;

import com.tuliohdev.test.commondi.CreditCardRepository;
import com.tuliohdev.test.model.CreditCardPresentation;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;

public class FindUserCreditCardsInteractorImpl implements FindUserCreditCardsInteractor {

    private CreditCardRepository mCreditCardRepository;
    private CreditCardPresentationConverter converter;

    public FindUserCreditCardsInteractorImpl(CreditCardRepository creditCardRepository, CreditCardPresentationConverter converter) {
        mCreditCardRepository = creditCardRepository;
        this.converter = converter;
    }

    @Override
    public Single<List<CreditCardPresentation>> execute() {
        return mCreditCardRepository.getCreditCardList().map(creditCards -> converter.convert(creditCards));
    }
}
