package com.example.linbin.mvp.model.modelInterface;

import com.example.linbin.mvp.model.User;

/**
 * Created by linbin_dian91 on 2016/3/3.
 */
public interface OnUserInfoListener {
    void getUserInfoSuccess(User user);
    void  getUserInfoFailed();
}
