package com.project.fr.suarahewan

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var catImageView: ImageView
    private lateinit var dogImageView: ImageView

    // MediaPlayer instances for each sound
    private lateinit var catSound: MediaPlayer
    private lateinit var dogSound: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        catImageView = findViewById(R.id.catImage)
        dogImageView = findViewById(R.id.dogImage)

        // Initialize sounds
        catSound = MediaPlayer.create(this, R.raw.cat_sound)
        dogSound = MediaPlayer.create(this, R.raw.dog_sound)

        // Set click listeners
        setClickListeners()
    }

    private fun setClickListeners() {
        catImageView.setOnClickListener {
            playSound(catSound)
        }

        dogImageView.setOnClickListener {
            playSound(dogSound)
        }
    }

    private fun playSound(sound: MediaPlayer) {
        if (sound.isPlaying) {
            sound.stop()
            sound.prepareAsync()
        }
        sound.start()
    }

    // Release MediaPlayer resources when the activity is destroyed
    override fun onDestroy() {
        super.onDestroy()
        catSound.release()
        dogSound.release()
    }
}
