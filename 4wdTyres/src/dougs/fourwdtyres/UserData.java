package dougs.fourwdtyres;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserData extends Activity {
	
	 private static final String DEBUG_TAG= "DOUGIOS";
	
	EditText UserName;
	EditText UserEmail;
	Button bInsert;
	
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_data);
		
		UserName = (EditText)findViewById(R.id.names);
		UserEmail = (EditText)findViewById(R.id.emails);
		bInsert = (Button)findViewById(R.id.btnInsert);						
	}
	 	
	public void newUser(View views){
		try {
	
		Handler dbhandler = new Handler(this, null, null, 1);
			
		Users users = new Users();
		users.setName(UserName.getText().toString().trim());
		users.setEmail(UserEmail.getText().toString());
			
		dbhandler.addUser(users);
		UserName.setText("");
		UserEmail.setText("");
		try{
			startActivity(new Intent(UserData.this, MainActivity.class));
			} catch (Exception e){
			
				Log.e(DEBUG_TAG, "A FUCK UP", e);
				e.printStackTrace();
			}		
		} catch (Exception e){
			Log.e(DEBUG_TAG, "A FUCK UP", e);
		}		
	}	 
}
