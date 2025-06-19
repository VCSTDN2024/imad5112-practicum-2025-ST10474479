package vcmsa.ci.musicplaylist

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
    private val song = mutableListOf<String>()
    private val artistName = mutableListOf<String>()
    private val rating = mutableListOf<Int>()
    private val comments = mutableListOf<String>()
    //I am storing the different parts of each playlist entry
    //These are mutable lists to which songs can be added

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val addButton: Button = findViewById(R.id.addButton)
        val viewButton: Button = findViewById(R.id.viewButton)
        val exitButton: Button = findViewById(R.id.exitButton)
        //Get handles to the buttons from the xml layout so you can add functionality to them

        addButton.setOnClickListener {
            showAddItemDialog()
        }
        //This opens a dialog to collect the users input fro a new song
        viewButton.setOnClickListener {
            if (song.isNotEmpty()) {
                val intent = Intent(this, Playlist::class.java)
                intent.putStringArrayListExtra("item", ArrayList(song))
                intent.putStringArrayListExtra("category", ArrayList(artistName))
                intent.putIntegerArrayListExtra("quantity", ArrayList(rating))
                intent.putStringArrayListExtra("comments", ArrayList(comments))
                startActivity(intent)
            } else {
                Snackbar.make(viewButton, "Playlist is empty. Add songs first please.", Snackbar.LENGTH_SHORT).show()
            }
        }

        //checks if there are songs to display
        //if there are, it opens the playlist screen and passes the list there
        //IF not, shows user a warning using the snackbar
        //can also use a toast

        exitButton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }
    //finishAffinity() closes all activities in the stack
    //exitProcess() exits thr app entirely

    private fun showAddItemDialog() {
        val builder = AlertDialog.Builder(this)
        //creates a dialog builder and inflates the layout with the text fields for song name, artist name, rating, and comments

        builder.setTitle("Add New Item")
        //attaches the layout to the dialog

        val view = layoutInflater.inflate(R.layout.activity_detailed_view_screen, null)
        val songNameEditText: EditText = view.findViewById(R.id.songNameEditText)
        val artistNameEditText: EditText = view.findViewById(R.id.artistNameEditText)
        val ratingEditText: EditText = view.findViewById(R.id.ratingEditText)
        val commentsEditText: EditText = view.findViewById(R.id.commentsEditText)

        builder.setView(view)
        builder.setPositiveButton("Add") { dialog, _ ->
            val songName = songNameEditText.text.toString().trim()
            val artistName = artistNameEditText.text.toString().trim()
            val rating = ratingEditText.text.toString().trim()
            val comments = commentsEditText.text.toString().trim()
            //Reads user input, validates that nothings empty or invalid
            //Converts rating to an int
            //adds the song to the list
            //shows confirmation via Snackbar

            if (songName.isEmpty() || artistName.isEmpty() || rating.isEmpty()) {
                Snackbar.make(findViewById(android.R.id.content), "song name, artist name, and rating cannot be empty.", Snackbar.LENGTH_SHORT).show()
                return@setPositiveButton
                //This checks if the user left any of the required fields blank (item name, category, or quantity).
                //If any are empty, it shows a Snackbar message (a small notification) to the user.
                //Then, return@setPositiveButton cancels the rest of the function, so the item doesn’t get added.
            }
            val rating = rating.toIntOrNull()
            if (rating == null || rating <= 0) {
                Snackbar.make(findViewById(android.R.id.content), "Invalid rating. Please enter a number greater than zero.", Snackbar.LENGTH_SHORT).show()
                return@setPositiveButton

            }
            this.song.add(songName)
            this.artistName.add(artistName)
            this.rating.add(rating)
            this.comments.add(comments)
            // These lines add the user’s input into each respective list: item, category, quantity, and comments.
            // Each list holds one attribute of the packing item.

            Snackbar.make(findViewById(android.R.id.content), "$songName added to the Playlist.", Snackbar.LENGTH_SHORT).show()
            dialog.dismiss()
            //Shows a Snackbar confirming that the item was added.
            //Then dialog.dismiss() closes the dialog window.
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel()
            //If the user taps the Cancel button instead, this simply closes the dialog box without saving anything.
        }

        builder.show()
        //This actually pops up the whole dialog on the screen for the user.
    }
}