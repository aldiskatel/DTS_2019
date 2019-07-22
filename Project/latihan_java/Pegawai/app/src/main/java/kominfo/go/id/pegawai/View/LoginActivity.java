package kominfo.go.id.pegawai.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import kominfo.go.id.pegawai.MainActivity;
import kominfo.go.id.pegawai.R;

public class LoginActivity extends AppCompatActivity {

    public static final String FILENAME = "login";
    private EditText editUsername, editPassword, ip;
    private Button btnLogin, btnRegister;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inisiasi();
    }

    private void inisiasi() {
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.action_login);
        btnRegister = findViewById(R.id.action_register);
        radioGroup = findViewById(R.id.rg);
        ip = findViewById(R.id.ip);
        setTitle("Login");
        gaskeun();
    }

    private void gaskeun() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioOnline:
                        ip.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.radioOffline:
                        ip.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
    }

    void simpanFileLogin() {
        String isiFile = editUsername.getText().toString() + ";" + editPassword.getText().toString();
        File file = new File(getFilesDir(), FILENAME);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    void login() {
        if (ip.getVisibility() == View.VISIBLE) {
            if (ip.getText().toString().trim().equals("")) {
                Toast.makeText(this, "Jika Lokal harus hubungkan ke server local!", Toast.LENGTH_SHORT).show();
            }
        } else {
            if (editUsername.getText().toString().trim().equals("") || editPassword.getText().toString().trim().equals("")) {
                Toast.makeText(this, "Mohon isi data dengan lengkap!", Toast.LENGTH_SHORT).show();
                editUsername.requestFocus();
            } else {
                File sdcard = getFilesDir();
                File file = new File(sdcard, editUsername.getText().toString());
                if (file.exists()) {
                    StringBuilder text = new StringBuilder();
                    try {
                        BufferedReader br =
                                new BufferedReader(new FileReader(file));
                        String line = br.readLine();
                        while (line != null) {
                            text.append(line);
                            line = br.readLine();
                        }
                        br.close();
                    } catch (IOException e) {
                        System.out.println("Error " + e.getMessage());
                    }
                    String data = text.toString();
                    String[] dataUser = data.split(";");

                    if (dataUser[1].equals(editPassword.getText().toString())) {
                        simpanFileLogin();
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(this, "Password Tidak Sesuai", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "User Tidak Ditemukan", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
