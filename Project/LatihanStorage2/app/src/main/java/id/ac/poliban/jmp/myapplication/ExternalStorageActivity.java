package id.ac.poliban.jmp.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
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

public class ExternalStorageActivity extends AppCompatActivity {

    public static final String FILENAME="namafile.txt";
    public static String TAG= BuildConfig.APPLICATION_ID;
    public static final int REQUEST_CODE_STORAGE=100;

    private Button btnBuat,btnUbah,btnBaca,btnHapus;
    public int selectEvent=0;
    TextView tvHasil;
    private File file;
    private FileOutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);

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
        String isiFile="Coba isi Data File Text";
        String state= Environment.getExternalStorageState();

        if(!Environment.MEDIA_MOUNTED.equals(state)){
            return;
        }
        File file=new File(Environment.getExternalStorageDirectory(),FILENAME);
        FileOutputStream output=null;
        try{
            file.createNewFile();
            output=new FileOutputStream(file,true);
            output.write(isiFile.getBytes());
            output.flush();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void ubahFile(){
        String isiFile="UPDATE ISINYA";
        String state= Environment.getExternalStorageState();

        if(!Environment.MEDIA_MOUNTED.equals(state)){
            return;
        }
        File file=new File(Environment.getExternalStorageDirectory(),FILENAME);
        FileOutputStream output=null;
        try{
            file.createNewFile();
            output=new FileOutputStream(file,false);
            output.write(isiFile.getBytes());
            output.flush();
            output.close();
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
    public Boolean periksaIzinPenyimpanan(){
        if(Build.VERSION.SDK_INT >= 23){
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                return true;
            }else{
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_CODE_STORAGE);
                return false;
            }
        }else{
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                jalankanPerintah(selectEvent);
            }
            break;
        }
    }

}
