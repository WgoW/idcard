package com.ccd.filing.test.presenter.interfaces;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;


public abstract class BasePresenter<V> {
    private Reference<V> mViewRef;

    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    protected V getView() {
        return mViewRef.get();
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detchView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
