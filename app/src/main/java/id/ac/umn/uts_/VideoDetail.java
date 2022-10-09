package id.ac.umn.uts_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoDetail extends AppCompatActivity {
    private Button btnPlay;
    private TextView tvJudul;
    private TextView tvKeterangan;
    private ImageView soundDetail;
    MediaPlayer player = new MediaPlayer();

//    VideoView videoView = findViewById(R.id.videoPlayer);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_detail);

        tvJudul = (TextView) findViewById(R.id.etJudul);
        tvKeterangan = (TextView) findViewById(R.id.etKeterangan);
//        soundDetail = (ImageView) findViewById(R.id.soundDetail);

        Intent detailIntent = getIntent();
        Bundle bundle = detailIntent.getExtras();
        SumberVideo sv =(SumberVideo) bundle.getSerializable("VideoDetail");
        String judul = detailIntent.getStringExtra("NamaVideo");
        getSupportActionBar(). setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle(judul);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        tvJudul.setText(sv.getJudul());
        tvKeterangan.setText(sv.getKeterangan());

//        btnPlay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try{
//                    player = MediaPlayer.create(VideoDetail.this, sv.getVideoURI());
//                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
//                    player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                        @Override
//                        public void onPrepared(MediaPlayer mp) {
//                            mp.start();
//                        }
//                    });
////                    MediaController mediaController = new MediaController(this);
////                    VideoView.setMediaController(mediaController);
////                    mediaController.setAnchorView(videoView);
//                } catch (Exception e){
//                    e.printStackTrace();
//                    if(player != null){
//                        player.release();
//                    }
//                }
//            }
//        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        player.stop();
        player.release();
        return true;
    }
}