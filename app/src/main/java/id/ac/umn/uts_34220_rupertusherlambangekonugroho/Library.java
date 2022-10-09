package id.ac.umn.uts_34220_rupertusherlambangekonugroho;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class Library extends AppCompatActivity {
    RecyclerView rvSumberVideo;
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
        getSupportActionBar().setTitle("Selamat datang, " + namauser);
        isiDaftarVideo();

        rvSumberVideo = (RecyclerView) findViewById(R.id.RV);
        mAdapter = new LibraryAdapter(this, daftarVideo);
        rvSumberVideo.setAdapter(mAdapter);
        rvSumberVideo.setLayoutManager(new LinearLayoutManager(this));
        btnDelete = (ImageButton) findViewById(R.id.btnDelete);
    }

    public void isiDaftarVideo(){
        daftarVideo.add(new SumberVideo("Video 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "android.resource://" + getPackageName() + "/" + R.raw.bongo1));
        daftarVideo.add(new SumberVideo("Video 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "android.resource://" + getPackageName() + "/" + R.raw.bongo2));
        daftarVideo.add(new SumberVideo("Video 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "android.resource://" + getPackageName() + "/" + R.raw.rick));
        daftarVideo.add(new SumberVideo("Video 4", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "android.resource://" + getPackageName() + "/" + R.raw.cat));
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