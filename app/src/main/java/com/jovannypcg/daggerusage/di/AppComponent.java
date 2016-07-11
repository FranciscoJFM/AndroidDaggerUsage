package com.jovannypcg.daggerusage.di;

import com.jovannypcg.daggerusage.repository.schema.UserSchema;
import com.jovannypcg.daggerusage.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Provides the method to inject the specified object in the modules
 * written in the @Component annotation.
 *
 * @version 1.0.
 */
@Singleton
@Component(modules = {AppModule.class, UserModule.class, DBModule.class})
public interface AppComponent {
    /**
     * Injects dependencies in MainActivity,
     * @param activity The MainActivity.
     */
    void inject(MainActivity activity);

    /**
     * Injects dependencies in the UserSchema.
     * @param userSchema The UserSchema.
     */
    void inject(UserSchema userSchema);
}
