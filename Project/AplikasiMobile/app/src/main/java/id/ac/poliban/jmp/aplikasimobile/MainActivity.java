package id.ac.poliban.jmp.aplikasimobile;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eNama,eNim,eTel,eAl;
    private Button btnTampil,btnClear;
    private TextView lbHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inisiasi();
        clear();
    }

    private void inisiasi() {
        eNama=findViewById(R.id.edtNama);
        btnTampil=findViewById(R.id.btnShow);
        btnClear=findViewById(R.id.btnClear);
        lbHasil=findViewById(R.id.lblHasil);
        eNim=findViewById(R.id.edtNim);
        eTel=findViewById(R.id.edtTel);
        eAl=findViewById(R.id.edtAlamat);

        hajar();
    }
    private void hajar() {
        btnTampil.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(eNim.getText().length() == 0 || eNama.getText().length() == 0 || eAl.getText().length() == 0){
                    Toast.makeText(MainActivity.this, "Tolong nim, nama dan alamat diisi mas!", Toast.LENGTH_SHORT).show();
                    clear();
                }else{
                    if(eTel.getText().length()==0){
                        lbHasil.setText("Nim :"+eNim.getText().toString().trim());
                        lbHasil.append("\nNama :"+eNama.getText().toString().trim());
                        lbHasil.append("\nTelephone : Tidak Ada");
                        lbHasil.append("\nAlamat :"+eAl.getText().toString().trim());
                    }else{
                        lbHasil.setText("Nim :"+eNim.getText().toString().trim());
                        lbHasil.append("\nNama :"+eNama.getText().toString().trim());
                        lbHasil.append("\nTelephone :"+eTel.getText().toString().trim());
                        lbHasil.append("\nAlamat :"+eAl.getText().toString().trim());
                    }
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
    }
    private void clear() {
        eNim.setText("");
        eNama.setText("");
        eTel.setText("");
        eAl.setText("");
        eNim.requestFocus();
    }

}
