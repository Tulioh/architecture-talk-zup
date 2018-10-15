package com.tuliohdev.test.commondi;

import com.tuliohdev.test.model.CreditCard;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import javax.inject.Inject;

public class CreditCardRepository {

    @Inject
    public CreditCardRepository() {
    }

    public void getCreditCardList(RepositoryCallback<List<CreditCard>, String> repositoryCallback) {
        repositoryCallback.onSuccess(new ArrayList<>());
    }

    public Single<List<CreditCard>> getCreditCardList() {
        return Single.<List<CreditCard>>just(new ArrayList<CreditCard>());
    }

}
