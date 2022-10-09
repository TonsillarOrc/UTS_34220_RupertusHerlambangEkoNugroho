package id.ac.umn.uts_34220_rupertusherlambangekonugroho;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class LoginDialog extends AppCompatDialogFragment {
    EditText name;
    Button login;
    SinginListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.login_dialog,null);

        builder.setView(view).setTitle("Login Page");

        name = view.findViewById(R.id.etName);
        login = view.findViewById(R.id.btnLogin);

        login.setOnClickListener(v-> {
            if(TextUtils.isEmpty(name.getText())) {
                name.setError("Nama Wajib Diisi.");
            } else {
                String namaLogin = name.getText().toString();
                listener.SignInAction(namaLogin);
            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (SinginListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "Error Implement SinginListener");
        }
    }

    public interface SinginListener {
        void SignInAction(String namaLogin);
    }
}