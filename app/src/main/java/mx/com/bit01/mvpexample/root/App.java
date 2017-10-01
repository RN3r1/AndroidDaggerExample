package mx.com.bit01.mvpexample.root;

import android.app.Application;

import mx.com.bit01.mvpexample.login.LoginModule;

/**
 * Created by roeeyn on 30/09/17.
 */

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .build();

    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
