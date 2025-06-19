package vcmsa.ci.musicplaylist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class Playlist : AppCompatActivity() {
    // Lists to hold the data passed from MainActivity
    private lateinit var song: ArrayList<String>
    private lateinit var artistName: ArrayList<String>
    private lateinit var rating: ArrayList<Int>
    private lateinit var comments: ArrayList<String>

    // TextView to display output
    private lateinit var displayTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist)

        // Retrieve data passed through the Intent (null-safe fallback to empty lists)
        song = intent.getStringArrayListExtra("item") ?: arrayListOf()
        artistName = intent.getStringArrayListExtra("category") ?: arrayListOf()
        rating = intent.getIntegerArrayListExtra("quantity") ?: arrayListOf()
        comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        // Get a handle to the TextView that will display the playlist or stats
        displayTextView = findViewById(R.id.displayTextView)

        // Set up button references and their click listeners
        val displayAllButton: Button = findViewById(R.id.displayAllButton)
        val avgButton: Button = findViewById(R.id.AvgButton)
        val backButton: Button = findViewById(R.id.backButton)
        val exitButton: Button = findViewById(R.id.exitButton)

        // Show full playlist details when "Display All" is clicked
        displayAllButton.setOnClickListener {
            displayFullPlaylist()
        }

        // Calculate and show average rating
        avgButton.setOnClickListener {
            if (rating.isNotEmpty()) {
                val average = rating.average()
                displayTextView.text = "Average Rating: %.2f".format(average)
            } else {
                displayTextView.text = "No ratings available to calculate average."
            }
        }

        // Navigate back to MainActivity
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Exit the app completely
        exitButton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }

    // Constructs a formatted display of the playlist contents
    private fun displayFullPlaylist() {
        val stringBuilder = StringBuilder()

        // Loop through the songs and append each one's details to the string
        if (song.isNotEmpty()) {
            for (i in song.indices) {
                stringBuilder.append("Song: ${song[i]}\n")
                stringBuilder.append("Artist: ${artistName[i]}\n")
                stringBuilder.append("Rating: ${rating[i]}\n")
                stringBuilder.append("Comments: ${comments[i]}\n\n")
            }
            // Show the complete formatted result
            displayTextView.text = stringBuilder.toString()
        } else {
            // If list is empty, show fallback message
            displayTextView.text = "Playlist is empty."
        }
    }
}