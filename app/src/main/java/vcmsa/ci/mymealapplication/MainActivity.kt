package vcmsa.ci.mymealapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Declaring variables
        val editTextTime = findViewById<EditText>(R.id.editTextTime)
        val buttonSuggest = findViewById<Button>(R.id.buttonSuggest)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        val textViewSuggestion = findViewById<TextView>(R.id.textViewSuggestion)

        // Setting up the functionality of the suggest meal button
        buttonSuggest.setOnClickListener {
            val timeOfDay = editTextTime.text.toString().trim()
            val suggestion = when (timeOfDay.lowercase()){
                "morning" -> "Breakfast (eg., Eggs)"
                "mid-morning snack" -> "Light snack (eg., Fruit)"
                "afternoon" -> "Lunch (eg., Sandwich)"
                "afternoon snack" -> "Quick bites (eg., Biltong)"
                "dinner" -> "Main course (eg., Pasta)"
                "after dinner snack" -> "Desserts (eg., Cake)"
                else -> "Please enter a valid time of day."
            }
            //author: Zahra Bulbilia
            //url:https://github.com/zb662000/assignmen
            textViewSuggestion.text = suggestion
        }
        //Setting up the functionality of the reset button
        buttonReset.setOnClickListener {
            editTextTime.text.clear()
            textViewSuggestion.text = ""
        }
        //author:Zahra Bulbilia
        //url:https://github.com/zb662000/assignmen
    }

    }
