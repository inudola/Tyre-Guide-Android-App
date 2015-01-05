package dougs.fourwdtyres;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Splash extends Activity {
	
	MediaPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        sound = new MediaPlayer();
        sound = MediaPlayer.create(this, R.raw.v8sound);
        sound.start();
     
       
        
        TimerTask task = new TimerTask() {
        	public void run() {
        		finish();
        		sound.stop();
        		startActivity(new Intent(Splash.this, UserData.class));
        	}
        };
        Timer Opening = new Timer();
        Opening.schedule(task,4500);
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
