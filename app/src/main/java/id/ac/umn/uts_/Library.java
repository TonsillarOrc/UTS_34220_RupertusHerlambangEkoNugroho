package id.ac.umn.uts_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.LinkedList;

public class Library extends AppCompatActivity {
    RecyclerView rvDaftarSfx;
    LibraryAdapter mAdapter;
    LinkedList<SumberVideo> daftarVideo = new LinkedList<>();
    ImageButton btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_page);

        Intent mainIntent = getIntent();
        String namauser = mainIntent.getStringExtra("Name");
        Toast.makeText(Library.this,"Selamat Datang, " + namauser, Toast.LENGTH_LONG).show();
        getSupportActionBar(). setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle(namauser);
        isiDaftarVideo();

        rvDaftarSfx = (RecyclerView) findViewById(R.id.RV);
        mAdapter = new LibraryAdapter(this, daftarVideo);
        rvDaftarSfx.setAdapter(mAdapter);
        rvDaftarSfx.setLayoutManager(new LinearLayoutManager(this));
        btnDelete = (ImageButton) findViewById(R.id.btnDelete);
    }

    public void isiDaftarVideo(){
        daftarVideo.add(new SumberVideo("Video 1", "Bongo Cat 1", "android.resource://" + getPackageName() + "/" + R.raw.bongo1));
        daftarVideo.add(new SumberVideo("Video 2", "Bongo Cat 2", "android.resource://" + getPackageName() + "/" + R.raw.bongo2));
        daftarVideo.add(new SumberVideo("Video 3", "Rick Astley", "android.resource://" + getPackageName() + "/" + R.raw.rick));
        daftarVideo.add(new SumberVideo("Video 4", "Cat", "android.resource://" + getPackageName() + "/" + R.raw.cat));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_profile) {
            Intent profileIntent = new Intent(Library.this, Profile.class);
            startActivity(profileIntent);
        } else if (id == R.id.menu_home) {
            Intent homeIntent = new Intent(Library.this, MainActivity.class);
            startActivity(homeIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}