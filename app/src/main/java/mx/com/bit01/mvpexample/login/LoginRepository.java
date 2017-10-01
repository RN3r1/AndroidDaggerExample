package mx.com.bit01.mvpexample.login;

/**
 * Created by roeeyn on 30/09/17.
 */

public interface LoginRepository {

    User getUser();
    void saveUser(User user);

}
