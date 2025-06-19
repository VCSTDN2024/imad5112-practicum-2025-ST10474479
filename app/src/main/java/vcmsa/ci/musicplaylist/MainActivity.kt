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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val addButton: Button = findViewById(R.id.addButton)
        val viewButton: Button = findViewById(R.id.viewButton)
        val exitButton: Button = findViewById(R.id.exitButton)

        addButton.setOnClickListener {
            showAddItemDialog()
        }
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

        exitButton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }
    private fun showAddItemDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Add New Item")

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

            if (songName.isEmpty() || artistName.isEmpty() || rating.isEmpty()) {
                Snackbar.make(findViewById(android.R.id.content), "song name, artist name, and rating cannot be empty.", Snackbar.LENGTH_SHORT).show()
                return@setPositiveButton
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
            Snackbar.make(findViewById(android.R.id.content), "$songName added to the Playlist.", Snackbar.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
    }
}