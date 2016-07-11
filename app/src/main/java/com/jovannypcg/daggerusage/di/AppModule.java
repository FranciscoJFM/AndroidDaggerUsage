package com.jovannypcg.daggerusage.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provides methods to inject the Application class.
 *
 * @version 1.0.
 */
@Module
public class AppModule {
    /**
     * The application to be injected.
     */
    private Application application;

    /**
     * Constructor.
     *
     * @param application The application to be injected.
     */
    public AppModule(Application application) {
        this.application = application;
    }

    /**
     * Provides the application to be injected.
     * @return The application to be injected.
     */
    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }
}
