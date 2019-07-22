package com.aldi.myRecycleView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    TextView lbNama,lbLokasi,lbDetail,lbDibuat;
    CircleImageView profileImage;
    String nama,lokasi,detail,dibuat,photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle("Keajaiban Dunia");

        inisiasi();
        tarikData();
    }

    private void tarikData() {
        Intent i=getIntent();
        nama=i.getStringExtra("nama");
        lokasi=i.getStringExtra("lokasi");
        detail=i.getStringExtra("detail");
        dibuat=i.getStringExtra("dibuat");
        photo=i.getStringExtra("photo");

        lbNama.setText(nama);
        lbLokasi.setText(lokasi);
        lbDetail.setText(detail);
        lbDibuat.setText(dibuat);

        Glide.with(this)
                .load(photo)
                .apply(new RequestOptions().override(350, 550))
                .into(profileImage);
    }

    private void inisiasi() {
        lbNama=(TextView) findViewById(R.id.textView);
        lbLokasi=(TextView) findViewById(R.id.subPresident);
        lbDetail=(TextView) findViewById(R.id.DetailPresidenText);
        lbDibuat=(TextView) findViewById(R.id.lbLahir);
        profileImage=(CircleImageView) findViewById(R.id.profile_image);

    }
}
