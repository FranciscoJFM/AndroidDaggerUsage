package com.jovannypcg.daggerusage.ui.main;

import android.util.Log;

import com.jovannypcg.daggerusage.model.User;

import java.util.List;

/**
 * Provides methods which contain the programming logic to
 * manipulate de MainView.
 *
 * @version 1.0.
 */
public class MainPresenter implements IMainPresenter {
    /**
     * The view of this presenter.
     */
    private MainView view;

    /**
     * Constructor.
     * @param view The view of this presenter.
     */
    public MainPresenter(MainView view) {
        this.view = view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showInformationFrom(User user) {
        view.getTextView().setText(String.format("Name: %s\nAge: %d\nemail: %s\n",
                user.getName(), user.getAge(), user.getEmail()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean insertUser(User user) {
        Log.e("*****INSER USER", "The user is being saved");
        return view.getUserSchema().insertUser(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSavedUsers() {
        List<User> savedUsers = view.getUserSchema().getAllUsers();

        if (!savedUsers.isEmpty()) {
            view.getTextView().append("\n\nSaved users:\n");

            for (User u : savedUsers) {
                view.getTextView().append(String.format("%s %d %s\n", u.getName(), u.getAge(), u.getEmail()));
            }
        }
    }
}
