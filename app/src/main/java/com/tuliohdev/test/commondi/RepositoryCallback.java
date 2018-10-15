package com.tuliohdev.test.commondi;

public interface RepositoryCallback<S, E> {

    void onSuccess(S success);
    void onError(E error);

}
