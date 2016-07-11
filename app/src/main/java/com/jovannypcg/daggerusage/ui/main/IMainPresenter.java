package com.jovannypcg.daggerusage.ui.main;

import com.jovannypcg.daggerusage.model.User;

/**
 * Provides methods which contain the programming logic to
 * manipulate de MainView.
 *
 * @version 1.0.
 */
public interface IMainPresenter {
    /**
     * Show the information of the user sent as parameter in a
     * text view.
     * @param user The user.
     */
    void showInformationFrom(User user);

    /**
     * Inserts a user into the database.
     *
     * @param user The user to be inserted.
     * @return true if the user was correctly inserted, false otherwise.
     */
    boolean insertUser(User user);

    /**
     * Shows the saved users in a text view.
     */
    void showSavedUsers();
}
