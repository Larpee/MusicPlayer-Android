package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        song = MediaPlayer.create(this, R.raw.song);
        song.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer player) {
                Toast.makeText(MainActivity.this, "Done!", Toast.LENGTH_SHORT).show();
            }
        });
        // Find and store play Button
        Button playButton = (Button) findViewById(R.id.play_button);
        // Set OnClickListener on play Button
        playButton.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                // If the song is not playing, start it
                if (!song.isPlaying()) {
                    song.start();
                }
            }
        });

        // Find and store pause Button
        Button pauseButton = (Button) findViewById(R.id.pause_button);
        // Set OnClickListener on pause Button
        pauseButton.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                // If the song is playing, pause it
                if (song.isPlaying()) {
                    song.pause();
                }
            }

        });

        // Find and store reset Button
        Button resetButton = (Button) findViewById(R.id.reset_button);
        // Set OnClickListener on reset Button
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (song.getCurrentPosition() > 0) {
                    song.seekTo(0);
                }
            }
        });
    }
}
