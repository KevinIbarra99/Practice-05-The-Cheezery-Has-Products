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

class ProductsActivitySweets : AppCompatActivity() {
    var sweets = ArrayList<Product>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_sweets)

        addProducts();

        var listview: ListView = findViewById(R.id.listView_sweets) as ListView;
        var adapter: AdapterProducts = AdapterProducts(this, sweets);
        listview.adapter = adapter;
    }

    fun addProducts(){
        sweets.add(Product("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake flavor, topped with cheese topping and blueberries.", 6.00))
        sweets.add(Product("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakes topped with butter cream and cherries", 3.00))
        sweets.add(Product("Lemon tartalette", R.drawable.lemontartalette, "Pastry shell with a lemon flavored filling", 4.00))
        sweets.add(Product("Red Velvet cake", R.drawable.redvelvetcake, "Soft, moist, buttery cake topped with an easy cream cheese frosting.", 6.00))
        sweets.add(Product("Cherry cheesecake", R.drawable. strawberrycheesecake, "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.", 7.00))
        sweets.add(Product("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert", 6.00))

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