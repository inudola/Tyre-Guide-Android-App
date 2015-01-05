package dougs.fourwdtyres;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	@SuppressWarnings("unused")
	private static final String DEBUG_TAG= "DOUGIOS";
	 
	String rType;
	String rSize;

	Spinner tType;
	Spinner tSize;
	
	TextView tname;
	TextView tsize;
	TextView ttype;
	ImageView tyrepic;
	
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tType = (Spinner)findViewById(R.id.tyreType);
		tSize = (Spinner)findViewById(R.id.tyreSize);
		@SuppressWarnings("unused")
		Button butResult = (Button)findViewById(R.id.btnResult);
		
		tname = (TextView)findViewById(R.id.ttName);
		tsize = (TextView)findViewById(R.id.ttSize);
		ttype = (TextView)findViewById(R.id.tttType);
		
		tyrepic = (ImageView)findViewById(R.id.tyreimage);

	}
	

	public void lookUpProduct (View view) {
		Handler dbhandler = new Handler(this, "dougstyres.db", null, 4);
		
		Tyres product = dbhandler.findProduct(tType.getSelectedItem().toString(), tSize.getSelectedItem().toString());
		
		if (product != null) {
			String.valueOf(product.getID());
			String.valueOf(product.getName());
			String.valueOf(product.getSize());
			tname.setText(String.valueOf("Brand : " + product.getType()));
			tsize.setText(String.valueOf("Name  : " + product.getBrandName()));
			ttype.setText(String.valueOf("Price  : $" + product.getPrice()));
			
			String picdata = product.getBrandName();
			
			if (picdata.equals("BuckShot")) {
				tyrepic.setImageResource(R.drawable.buckshot);
			}
			if (picdata.equals("Discoverer")) {
				tyrepic.setImageResource(R.drawable.discoverer);
			}
			if (picdata.equals("AO")) {
				tyrepic.setImageResource(R.drawable.ao);
			}
			if (picdata.equals("Slinger")) {
				tyrepic.setImageResource(R.drawable.slinger);
			}
			if (picdata.equals("Bravo")) {
				tyrepic.setImageResource(R.drawable.bravo);
			}
			if (picdata.equals("ATZ")) {
				tyrepic.setImageResource(R.drawable.atz);
			}
			if (picdata.equals("Silverstone")) {
				tyrepic.setImageResource(R.drawable.silverstone);
			}
			if (picdata.equals("KO")) {
				tyrepic.setImageResource(R.drawable.ko);
			}
			if (picdata.equals("At 980")) {
				tyrepic.setImageResource(R.drawable.at980);
			}
			
		} else {
			tname.setText("Error occurred");
		}
		
	}
}
