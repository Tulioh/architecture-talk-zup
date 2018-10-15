package com.tuliohdev.test.mvvm;

public interface ViewModelCallback<SUCCESS, ERROR> {

    void onSuccess(SUCCESS success);

    void onError(ERROR error);

}
