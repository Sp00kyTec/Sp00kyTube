package dev.sp00kytec.spookytube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import dev.sp00kytec.spookytube.utils.VideoExtractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    // Tag for logging
    private val TAG = "Sp00kyTubeMain"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Let's test our extractor on app start!
        testVideoExtraction()
    }

    private fun testVideoExtraction() {
        // Use a famous video ID for testing
        val testVideoId = "dQw4w9WgXcQ" // ;)
        Log.d(TAG, "Testing extraction for video ID: $testVideoId")

        // Use Coroutines for proper background threading
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val videoUrl = VideoExtractor.extractVideoUrl(testVideoId)
                Log.d(TAG, "Extracted Video URL: $videoUrl")
            } catch (e: Exception) {
                Log.e(TAG, "Extraction ritual failed!", e)
            }
        }
    }
}