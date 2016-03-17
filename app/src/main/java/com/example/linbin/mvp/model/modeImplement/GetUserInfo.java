package com.example.linbin.mvp.model.modeImplement;

import com.example.linbin.mvp.model.User;
import com.example.linbin.mvp.model.modelInterface.IGetUser;
import com.example.linbin.mvp.model.modelInterface.OnUserInfoListener;

/**
 * Created by linbin_dian91 on 2016/3/3.
 */
public class GetUserInfo implements IGetUser{
    @Override
    public void getUserInfo(final int id, final OnUserInfoListener listener) {
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (id == 1){
                   listener.getUserInfoFailed();
                }else{
                    User user = new User();
                    user.setId(2);
                    user.setName("baidu");
                    listener.getUserInfoSuccess(user);
                }
            }
        }.start();
    }
}
