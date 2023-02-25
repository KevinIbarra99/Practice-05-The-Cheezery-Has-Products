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

class ProductsActivityColdDrinks : AppCompatActivity() {
    var coldDrinks = ArrayList<Product>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_cold_drinks)

        addProducts();

        var listview:ListView = findViewById(R.id.listView_coldDrinks) as ListView;
        var adapter:AdapterProducts = AdapterProducts(this, coldDrinks);
        listview.adapter = adapter;
    }

    fun addProducts(){
        coldDrinks.add(Product("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.00));
        coldDrinks.add(Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.00))
        coldDrinks.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.00))
        coldDrinks.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.00))
        coldDrinks.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.00))
        coldDrinks.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7.00))

    }

    private class AdapterProducts:BaseAdapter{
        var products = ArrayList<Product>();
        var context:Context?=null;

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