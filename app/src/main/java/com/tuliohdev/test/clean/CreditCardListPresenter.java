package com.tuliohdev.test.clean;

import com.tuliohdev.test.model.CreditCardPresentation;
import io.reactivex.Observable;
import java.util.List;

public interface CreditCardListPresenter {

    Observable<List<CreditCardPresentation>> getCreditCardPresentation();

}
