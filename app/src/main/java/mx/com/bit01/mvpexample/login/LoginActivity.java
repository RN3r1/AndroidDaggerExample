package mx.com.bit01.mvpexample.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import mx.com.bit01.mvpexample.R;
import mx.com.bit01.mvpexample.root.App;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {

    private EditText firstNameET, lastNameET;
    private Button loginButton;

    @Inject
    LoginActivityMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App)getApplication()).getComponent().inject(this);

        firstNameET = (EditText) findViewById(R.id.etFirstName);
        lastNameET = (EditText) findViewById(R.id.etLastName);
        loginButton = (Button) findViewById(R.id.btnLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loginButtonClicked();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }

    @Override
    public String getFirstName() {
        return firstNameET.getText().toString();
    }

    @Override
    public String getLastName() {
        return lastNameET.getText().toString();
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this, "¡ERROR! User not available", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "Names cannot be empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this, "User saved!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFirstName(String firstName) {
        firstNameET.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        lastNameET.setText(lastName);
    }
}
