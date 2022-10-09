package id.ac.umn.uts_34220_rupertusherlambangekonugroho;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements LoginDialog.SinginListener {
    Button btnProfile;
    Button btnLibrary;
    Button btnLogin;
    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnProfile = findViewById(R.id.btnProfile);
        btnLibrary = findViewById(R.id.btnLibrary);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProfile = new Intent(MainActivity.this, Profile.class);
                startActivity(intentProfile);
            }
        });

        btnLibrary.setOnClickListener(v -> {
            loginDialog();
        });
    }

    public void loginDialog() {
        LoginDialog LoginView = new LoginDialog();
        LoginView.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void SignInAction(String namaLogin) {
        Intent libraryIntent = new Intent(MainActivity.this, Library.class);
        libraryIntent.putExtra("Name", namaLogin);
        startActivity(libraryIntent);
    }

//    private void loginDialog() {
//        Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.login_dialog);
//
//        etName = dialog.findViewById(R.id.etName);
//        btnLogin = dialog.findViewById(R.id.btnLogin);
//
//        dialog.show();
//
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(TextUtils.isEmpty(etName.getText())){
//                    Toast.makeText(MainActivity.this, "Name must be entered",Toast.LENGTH_SHORT).show();
//                } else {
//                    Intent intentLibrary = new Intent(MainActivity.this, Library.class);
//                    String namaLogin = etName.getText().toString();
//                    intentLibrary.putExtra("Name", namaLogin);
//                    startActivityForResult(intentLibrary, 1);
//                }
//            }
//        });
//    }
}