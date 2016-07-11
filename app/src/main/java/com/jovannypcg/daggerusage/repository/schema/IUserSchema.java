package com.jovannypcg.daggerusage.repository.schema;

import com.jovannypcg.daggerusage.model.User;

import java.util.List;

/**
 * Provides methods to insert into and retrieve information
 * from the database.
 *
 * @version 1.0
 */
public interface IUserSchema {
    /**
     * Inserts a user into the database.
     * @param user The user to be inserted.
     * @return true if the user was successfully inserted, false otherwise.
     */
    boolean insertUser(User user);

    /**
     * Retrieves all the saved users.
     * @return All the saved users.
     */
    List<User> getAllUsers();
}
