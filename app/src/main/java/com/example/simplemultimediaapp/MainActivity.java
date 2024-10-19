package com.example.simplemultimediaapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlaces a los componentes de la interfaz
        imageView = findViewById(R.id.imageView);
        videoView = findViewById(R.id.myVideoView);
        Button playAudioButton = findViewById(R.id.playAudioButton);
        Button playVideoButton = findViewById(R.id.playVideoButton);
        Button animateButton = findViewById(R.id.animateButton);

        // Controlador de media para controlar el video (pausar, adelantar, etc.)
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        // Reproducción de audio
        playAudioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.audio);
                mediaPlayer.start();
            }
        });

        // Reproducción de video
        playVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // URI del video local en res/raw
                Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);

                // Configurar el video para el VideoView
                videoView.setVideoURI(videoUri);

                // Iniciar la reproducción del video
                videoView.start();
            }
        });

        // Aplicación de animación
        animateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation fadeInAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
                imageView.startAnimation(fadeInAnimation);
            }
        });
    }
}
