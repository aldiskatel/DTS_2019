package id.ac.poliban.jmp.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class InternalStorageActivity extends AppCompatActivity {

    public static String FILENAME="namafile.txt";
    private Button btnBuat,btnUbah,btnBaca,btnHapus;
    private TextView tvHasil;
    private File file;
    private FileOutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);

        inisiasi();
    }

    private void inisiasi() {
        btnBuat=findViewById(R.id.btnBuat);
        btnUbah=findViewById(R.id.btnUbah);
        btnBaca=findViewById(R.id.btnBaca);
        btnHapus=findViewById(R.id.btnHapus);
        tvHasil=findViewById(R.id.tvHasil);
        file=new File(getFilesDir(),FILENAME);

        action();
    }
    private void action() {
        btnBuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buatFile();
            }
        });
        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ubahFile();
            }
        });
        btnBaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bacaFile();
            }
        });
        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hapusFile();
            }
        });
    }

    private void buatFile(){
        String isi="Coba isi data file text";
        outputStream=null;
        try {
            file.createNewFile();
            outputStream.write(isi.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            Log.d(getPackageName()+"Error :",String.valueOf(e));
        }
    }
    private void ubahFile(){
        String isi="Coba UBAH data file text";
        outputStream=null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file,false);
            outputStream.write(isi.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void bacaFile(){
        if(file.exists()){
            StringBuilder text=new StringBuilder();
            try {
                BufferedReader br=new BufferedReader(new FileReader(file));
                String line=br.readLine();
                while(line != null){
                    text.append(line);
                    line=br.readLine();
                }
                br.close();
            } catch (FileNotFoundException e) {
                Log.d(getPackageName(),String.valueOf(e));
            } catch (IOException e) {
                Log.d(getPackageName(),String.valueOf(e));
            }
        }
    }
    private void hapusFile(){
        if(file.exists()){
            file.delete();
        }
    }
}
