package com.tuliohdev.test.clean;

import com.tuliohdev.test.model.CreditCardPresentation;
import io.reactivex.Single;
import java.util.List;

public interface FindUserCreditCardsInteractor {

    Single<List<CreditCardPresentation>> execute();

}
