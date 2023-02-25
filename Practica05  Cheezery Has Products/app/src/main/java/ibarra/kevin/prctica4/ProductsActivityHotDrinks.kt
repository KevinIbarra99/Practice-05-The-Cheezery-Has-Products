package ibarra.kevin.prctica4

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class ProductsActivityHotDrinks : AppCompatActivity() {
    var hotDrinks = ArrayList<Product>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_hot_drinks)

        addProducts();

        var listview: ListView = findViewById(R.id.listView_hotDrinks) as ListView;
        var adapter:AdapterProducts = AdapterProducts(this, hotDrinks);
        listview.adapter = adapter;
    }

    fun addProducts(){
        hotDrinks.add(Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6.00))
        hotDrinks.add(Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5.00))
        hotDrinks.add(Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4.00))
        hotDrinks.add(Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6.00))
        hotDrinks.add(Product("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7.00))
        hotDrinks.add(Product("American coffee", R.drawable.americano, "Espresso with hot water", 2.00))
    }

    private class AdapterProducts: BaseAdapter {
        var products = ArrayList<Product>();
        var context: Context?=null;

        constructor(context: Context, products:ArrayList<Product>){
            this.products = products;
            this.context = context;
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod = products[position];
            var inflator = LayoutInflater.from(context);
            var view = inflator.inflate(R.layout.product_view, null);

            var img = view.findViewById(R.id.product_img) as ImageView;
            var name = view.findViewById(R.id.product_name) as TextView;
            var description = view.findViewById(R.id.product_description) as TextView;
            var price = view.findViewById(R.id.product_price) as TextView;

            img.setImageResource(prod.image);
            name.setText(prod.name);
            description.setText(prod.description);
            price.setText("$${prod.price}");

            return view;
        }

        override fun getItem(position: Int): Any {
            return products[position];
        }

        override fun getItemId(position: Int): Long {
            return position.toLong();
        }

        override fun getCount(): Int {
            return products.size;
        }
    }
}