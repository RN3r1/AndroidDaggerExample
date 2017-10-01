package mx.com.bit01.mvpexample.root;

import dagger.Component;
import mx.com.bit01.mvpexample.login.LoginActivity;
import mx.com.bit01.mvpexample.login.LoginModule;

/**
 * Created by roeeyn on 30/09/17.
 */

@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity tagret);

}
