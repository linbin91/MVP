package com.example.linbin.mvp.view;

import com.example.linbin.mvp.model.User;

/**
 * Created by linbin_dian91 on 2016/3/3.
 */
public interface IShowUserView {
    void  showLoading();
    void hideLoading();
    void toMainActivity(User user);
    void showFailedError();
}
