package com.example.linbin.mvp.presenter;

import android.os.Handler;

import com.example.linbin.mvp.model.User;
import com.example.linbin.mvp.model.modeImplement.GetUserInfo;
import com.example.linbin.mvp.model.modelInterface.IGetUser;
import com.example.linbin.mvp.model.modelInterface.OnUserInfoListener;
import com.example.linbin.mvp.view.IShowUserView;


/**
 * Created by linbin_dian91 on 2016/3/3.
 */
public class UserInfoPresenter {
    private IGetUser iGetUser;
    private IShowUserView iShowUserView;
    private Handler mHandler = new Handler();

    public UserInfoPresenter(IShowUserView iShowUserView){
        this.iShowUserView = iShowUserView;
        iGetUser = new GetUserInfo();
    }

    public void  getUserInfoToShow(int id){
        iShowUserView.showLoading();
        iGetUser.getUserInfo(id, new OnUserInfoListener() {
            @Override
            public void getUserInfoSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iShowUserView.toMainActivity(user);
                    }
                });

            }

            @Override
            public void getUserInfoFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iShowUserView.showFailedError();
                        iShowUserView.hideLoading();
                    }
                });

            }
        });
    }
}
