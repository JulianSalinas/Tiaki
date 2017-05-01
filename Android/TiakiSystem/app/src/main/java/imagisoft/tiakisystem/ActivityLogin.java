package imagisoft.tiakisystem;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import imagisoft.tiakisystem.model.Session;

public class ActivityLogin extends AppCompatActivity implements OnClickListener {

    private EditText editTextUser;
    private EditText editTextPassword;
    private Button buttonSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextUser = (EditText) findViewById(R.id.edit_text_login_user);
        editTextPassword = (EditText) findViewById(R.id.edit_text_login_password);
        buttonSign = (Button) findViewById(R.id.button_login);
        buttonSign.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        attemptLogin();
    }

    private void attemptLogin() {
        editTextUser.setError(null);
        editTextPassword.setError(null);
        String user= editTextUser.getText().toString();
        String password = editTextPassword.getText().toString();
        if(isValidUser(user) && isValidPassword(password)) {
            buttonSign.setBackgroundColor(Color.GRAY);
            handleLogin(Integer.parseInt(user), password);
        }
    }

    private void handleLogin(int identification, String password){
        try{
            Session.getInstance().login(identification, password);
            Intent intent = new Intent(getApplicationContext(), ActivityMain.class);
            startActivity(intent);
        }
        catch (Exception e) {
            showLoginFailed();
        }
    }

    private void showLoginFailed(){
        int m = R.string.error_invalid_count;
        Context c = getApplicationContext();
        Toast toast = Toast.makeText(c, m, Toast.LENGTH_LONG);
        toast.show();
    }

    private boolean isValidUser(String user){
        if (!TextUtils.isEmpty(user)) return true;
        else requestFocusError(editTextUser, R.string.error_invalid_user);
        return false;
    }

    private boolean isValidPassword(String password){
        if(!TextUtils.isEmpty(password) && password.length() >= 4) return true;
        else requestFocusError(editTextPassword, R.string.error_invalid_password);
        return false;
    }

    private void requestFocusError(EditText text, int error){
        text.setError(getString(error));
        View view = text;
        view.requestFocus();
    }

}
