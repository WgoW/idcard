package com.ccd.filing.test.view.interfaces;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.ccd.filing.test.presenter.interfaces.BasePresenter;


/**
 *         <p>
 *         description  基础的activity
 *         </p>
 */
public abstract class BaseActivity<V, P extends BasePresenter<V>> extends AppCompatActivity {
    protected P mPresenter;

    @Override
    final protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 全屏显示
         */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mPresenter = createPresenter(savedInstanceState);
        mPresenter.attachView((V) this);
        /**
         * 唤醒
         */
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    protected abstract P createPresenter(Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detchView();
    }

}
