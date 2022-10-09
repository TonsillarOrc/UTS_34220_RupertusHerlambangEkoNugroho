package id.ac.umn.uts_;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
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

        btnLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intentLogin = new Intent(MainActivity.this, Login.class);
//                startActivity(intentLogin);
                loginDialog();
            }
        });
    }

    private void loginDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.login_dialog);

        etName = dialog.findViewById(R.id.etName);
        btnLogin = dialog.findViewById(R.id.btnLogin);

        dialog.show();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(etName.getText())){
                    Toast.makeText(MainActivity.this, "Name must be entered",Toast.LENGTH_SHORT).show();
                } else {
                    Intent intentLibrary = new Intent(MainActivity.this, Library.class);
                    String namaLogin = etName.getText().toString();
                    intentLibrary.putExtra("Name", namaLogin);
                    startActivityForResult(intentLibrary, 1);
                }
            }
        });
    }
}