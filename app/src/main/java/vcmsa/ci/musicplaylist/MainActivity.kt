package vcmsa.ci.musicplaylist
//Kincade garanganga
//https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    // Lists to store each song's details
    private val song = mutableListOf<String>()
    private val artistName = mutableListOf<String>()
    private val rating = mutableListOf<Int>()
    private val comments = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Initialize UI buttons
        val addButton: Button = findViewById(R.id.addButton)
        val viewButton: Button = findViewById(R.id.viewButton)
        val exitButton: Button = findViewById(R.id.exitButton)

        // Handle adding a new song entry
        addButton.setOnClickListener {
            showAddItemDialog()
        }
        // Handle viewing the playlist
        viewButton.setOnClickListener {
            if (song.isNotEmpty()) {
                // Prepare and start Playlist activity with the current song data
                val intent = Intent(this, Playlist::class.java).apply {
                    putStringArrayListExtra("item", ArrayList(song))
                    putStringArrayListExtra("category", ArrayList(artistName))
                    putIntegerArrayListExtra("quantity", ArrayList(rating))
                    putStringArrayListExtra("comments", ArrayList(comments))
                }
                startActivity(intent)
            } else {
                // Show message if playlist is empty
                Snackbar.make(viewButton, "Playlist is empty. Add songs first please.", Snackbar.LENGTH_SHORT).show()
            }
        }
// Handle exiting the application
        exitButton.setOnClickListener {
            finishAffinity() // Close all activities
            exitProcess(0)   // Exit the app
        }
    }
    // Opens a dialog for the user to input song details
    private fun showAddItemDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Add New Item")

        // Inflate the custom layout with input fields
        val view = layoutInflater.inflate(R.layout.activity_detailed_view_screen, null)
        val songNameEditText: EditText = view.findViewById(R.id.songNameEditText)
        val artistNameEditText: EditText = view.findViewById(R.id.artistNameEditText)
        val ratingEditText: EditText = view.findViewById(R.id.ratingEditText)
        val commentsEditText: EditText = view.findViewById(R.id.commentsEditText)

        builder.setView(view)
        // Set up Add button behavior
        builder.setPositiveButton("Add") { dialog, _ ->
            val songNameText = songNameEditText.text.toString().trim()
            val artistNameText = artistNameEditText.text.toString().trim()
            val ratingText = ratingEditText.text.toString().trim()
            val commentsText = commentsEditText.text.toString().trim()

            // Validate that all required fields are filled in
            if (songNameText.isEmpty() || artistNameText.isEmpty() || ratingText.isEmpty()) {
                Snackbar.make(findViewById(android.R.id.content), "Song name, artist name, and rating cannot be empty.", Snackbar.LENGTH_SHORT).show()
                return@setPositiveButton
            }

            // Try converting rating to an integer and validate range
            val ratingValue = ratingText.toIntOrNull()
            if (ratingValue == null || ratingValue <= 0) {
                Snackbar.make(findViewById(android.R.id.content), "Invalid rating. Please enter a number greater than zero.", Snackbar.LENGTH_SHORT).show()
                return@setPositiveButton
            }

            // Add user input to respective lists
            song.add(songNameText)
            artistName.add(artistNameText)
            rating.add(ratingValue)
            comments.add(commentsText)

            // Confirm successful addition
            Snackbar.make(findViewById(android.R.id.content), "\"$songNameText\" added to the Playlist.", Snackbar.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        // Cancel button simply closes the dialog
        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel()
        }

        builder.show() // Display the dialog to the user
    }
}
