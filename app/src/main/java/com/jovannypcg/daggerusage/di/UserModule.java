package com.jovannypcg.daggerusage.di;

import com.jovannypcg.daggerusage.model.User;

import dagger.Module;
import dagger.Provides;

/**
 * Provides methods to inject the User class.
 *
 * @version 1.0.
 */
@Module
public class UserModule {
    /**
     * The user to be injected.
     */
    private User user;

    /**
     * Constructur.
     * @param user The user to be injected.
     */
    public UserModule(User user) {
        this.user = user;
    }

    /**
     * Provides the user to be injected.
     * @return The user to be injected.
     */
    @Provides
    public User provideUser() {
        return user;
    }
}
