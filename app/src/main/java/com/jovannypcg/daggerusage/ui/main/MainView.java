package com.jovannypcg.daggerusage.ui.main;

import android.widget.TextView;

import com.jovannypcg.daggerusage.repository.schema.IUserSchema;

/**
 * Provides methods to handle the MainActivity as view.
 *
 * @version 1.0.
 */
public interface MainView {
    /**
     * Gets the text view in which will be shown information
     * related to the user generated using dependency injection.
     *
     * @return The text view in which will be shown information
     * related to the user.
     */
    TextView getTextView();

    /**
     * Provides the user schema that is created in the class which
     * implements this interface.
     * @return The user schema that is created in the class which implements this interface.
     */
    IUserSchema getUserSchema();
}
