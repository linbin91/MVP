package com.example.linbin.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.linbin.mvp.model.User;
import com.example.linbin.mvp.presenter.UserInfoPresenter;
import com.example.linbin.mvp.view.IShowUserView;

public class MainActivity extends AppCompatActivity implements IShowUserView {

    private TextView tv;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        tv = (TextView) findViewById(R.id.id_tv);
        bt = (Button) findViewById(R.id.id_bt);

        final UserInfoPresenter presenter = new UserInfoPresenter(this);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getUserInfoToShow(2);
            }
        });
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMainActivity(User user) {
        tv.setText(user.getId() + " " + user.getName());
    }

    @Override
    public void showFailedError() {

    }
}
