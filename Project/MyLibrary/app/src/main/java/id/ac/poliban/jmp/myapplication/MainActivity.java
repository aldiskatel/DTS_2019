package id.ac.poliban.jmp.myapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnStore,btnGet;
    private EditText edtNama;
    private DatabaseHelper databaseHelper;
    private TextView tvName;
    private ArrayList<String> arrayList;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inisiasi();
    }

    private void inisiasi() {
        databaseHelper=new DatabaseHelper(this);
        tvName=findViewById(R.id.tvName);
        btnStore=findViewById(R.id.btnStore);
        btnGet=findViewById(R.id.btnGet);
        edtNama=findViewById(R.id.edtName);

        setAction();
    }

    private void setAction() {
        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addStudentDetail(edtNama.getText().toString()+", ");
                edtNama.setText("");
                Toast.makeText(MainActivity.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();
            }
        });
        btnGet.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                arrayList=databaseHelper.studentsArrayList();
                tvName.setText("");
                for (int i = 0; i < arrayList.size(); i++){
                    tvName.setText(tvName.getText().toString()+arrayList.get(i));
                }
            }
        });
    }
}
