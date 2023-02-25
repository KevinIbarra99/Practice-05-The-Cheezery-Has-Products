package ibarra.kevin.prctica4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var buttonColdDrinks:Button = findViewById(R.id.button_cold_drinks) as Button;
        var buttonHotDrinks:Button = findViewById(R.id.button_hot_drinks) as Button;
        var buttonSweets:Button = findViewById(R.id.button_sweets) as Button;
        var buttonSalties:Button = findViewById(R.id.button_salties) as Button;

        buttonColdDrinks.setOnClickListener {
            var intent:Intent = Intent(this, ProductsActivityColdDrinks::class.java)
            startActivity(intent);
        }

        buttonHotDrinks.setOnClickListener {
            var intent:Intent = Intent(this, ProductsActivityHotDrinks::class.java);
            startActivity(intent);
        }

        buttonSweets.setOnClickListener {
            var intent:Intent = Intent(this, ProductsActivitySweets::class.java)
            startActivity(intent);
        }

        buttonSalties.setOnClickListener {
            var intent:Intent = Intent(this, ProductsActivitySalties::class.java);
            startActivity(intent);
        }
    }
}