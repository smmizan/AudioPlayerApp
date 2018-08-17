package me.smmizan.audioplayerapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button pause,start,stop;

    MediaPlayer mediaPlayer;

    int currentPausePositions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pause = (Button) findViewById(R.id.bPause);
        start = (Button) findViewById(R.id.bStart);
        stop = (Button) findViewById(R.id.bStop);


        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer != null)
                {
                    mediaPlayer.pause();
                    currentPausePositions = mediaPlayer.getCurrentPosition();
                }
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer==null)
                {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.bakbakum);
                    mediaPlayer.start();
                }

                else if(!mediaPlayer.isPlaying())
                {
                    mediaPlayer.seekTo(currentPausePositions);
                    mediaPlayer.start();
                }

            }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer!=null)
                {
                    mediaPlayer.stop();
                    mediaPlayer=null;
                }

            }
        });

    }
}
