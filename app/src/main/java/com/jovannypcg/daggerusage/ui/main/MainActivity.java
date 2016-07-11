package com.jovannypcg.daggerusage.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.jovannypcg.daggerusage.Application;
import com.jovannypcg.daggerusage.R;
import com.jovannypcg.daggerusage.model.User;
import com.jovannypcg.daggerusage.repository.schema.IUserSchema;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Shows information related to a user generated using dependency injection.
 *
 * @version 1.0.
 */
public class MainActivity extends AppCompatActivity implements MainView {
    /**
     * The injected user.
     */
    @Inject User user;

    @Inject
    IUserSchema userSchema;

    /**
     * The text view that will show the user information.
     */
    @Bind(R.id.tv)
    TextView tv;

    /**
     * The presenter of this view.
     */
    private IMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ((Application) getApplication()).getComponent().inject(this);
        ButterKnife.bind(this);

        user.setName("Pablo");
        user.setAge(45);
        user.setEmail("pablo.marmol@gmail.com");

        presenter = new MainPresenter(this);
        presenter.showInformationFrom(user);
        presenter.insertUser(user);
        presenter.showSavedUsers();
    }

    /**
     * { @inheritDoc }
     */
    @Override
    public TextView getTextView() {
        return tv;
    }

    @Override
    public IUserSchema getUserSchema() {
        return userSchema;
    }
}
