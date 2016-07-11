package com.jovannypcg.daggerusage;

import com.jovannypcg.daggerusage.di.AppComponent;
import com.jovannypcg.daggerusage.di.AppModule;
import com.jovannypcg.daggerusage.di.DBModule;
import com.jovannypcg.daggerusage.di.DaggerAppComponent;
import com.jovannypcg.daggerusage.di.UserModule;
import com.jovannypcg.daggerusage.model.User;

/**
 * The application class.
 * Inside the onCreate method, the dependency injection
 * with Dagger 2 is configured.
 *
 * @version 1.0.
 */
public class Application extends android.app.Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .userModule(new UserModule(new User("Francisco", 23, "ayjtom@gmail.com")))
                .dBModule(new DBModule(this, getApplicationContext()))
                .build();
    }

    /**
     * Gets the dependency component of the app.
     *
     * @return The dependency component.
     */
    public AppComponent getComponent() {
        return component;
    }
}
