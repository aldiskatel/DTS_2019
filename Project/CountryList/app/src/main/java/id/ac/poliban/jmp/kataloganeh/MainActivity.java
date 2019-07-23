package id.ac.poliban.jmp.kataloganeh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] country={"Ernando Ari Sutaryadi","Muhammad Risky Sudirman","Adi Satrio","Fadhil","Ahmad Rusadi",
                            "Komang Teguh ","Salman Alfarid ","Bayu Fiqri","Amiruddin Bagas","Mochammad Yudha Febrian",
                            "Riski Ridho","Fajar Fathur Rahman","Komang Arta","Alfeandra Dewangga","Brylian Aldama","Theofillo Numberi"
                            ,"David Maulana","Beckham Putra Nugraha","Ahmad Imam Zakiri","Rendy Juliansyah"};
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inisiasi();
    }
    private void inisiasi() {
        listView=findViewById(R.id.lv_list);
        setAdapter();
        setAction();
    }

    private void setAction() {
        listView.getOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s="Kamu menekan:"+ listView.;

                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        })
    }
    private void setAdapter() {
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1, country);
        listView.setAdapter(adapter);
    }



}
