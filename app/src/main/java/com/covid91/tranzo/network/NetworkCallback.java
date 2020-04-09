package com.covid91.tranzo.network;


public interface NetworkCallback {
    void onSuccess(Object response);
    void onError(Throwable error);
}
