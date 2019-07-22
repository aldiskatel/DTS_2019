package id.ac.poliban.jmp.demomenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.optionsmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                startActivity(new Intent(MainActivity.this,MenuActivity1.class));
                break;
            case R.id.menu2:
                startActivity(new Intent(MainActivity.this,MenuActivity2.class));
                break;
            default:
                startActivity(new Intent(MainActivity.this,MenuActivity3.class));
                break;
        }
        return true;
    }
}
