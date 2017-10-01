package mx.com.bit01.mvpexample.login;

/**
 * Created by roeeyn on 30/09/17.
 */

public interface LoginActivityMVP {

    interface View {

        String getFirstName();
        String getLastName();

        void showUserNotAvailable();
        void showInputError();
        void showUserSavedMessage();

        void setFirstName(String firstName);
        void setLastName(String lastName);

    }

    interface Presenter {

        void setView(LoginActivityMVP.View view);
        void loginButtonClicked();
        void getCurrentUser();

    }

    interface Model {

        void createUser(String firstName, String lastName);
        User getUser();

    }

}
