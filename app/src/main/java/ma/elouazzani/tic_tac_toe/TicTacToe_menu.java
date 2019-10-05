package ma.elouazzani.tic_tac_toe;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class TicTacToe_menu extends Activity {
	ImageView onePlayer,twoPlayer,PlayOnline,exit,TicTacToe,l;
	Animation animation;
	public void click(View v){
		if(v==onePlayer){
			Intent intent= new Intent(TicTacToe_menu.this,OnePlayer.class);
			startActivity(intent);
		}
		if(v==twoPlayer){
			Intent intent= new Intent(TicTacToe_menu.this,TwoPlayer.class);
			startActivity(intent);
		}
		if(v==exit){
			DialogExit dialog =new DialogExit(this);
			dialog.show();
			
		}
		if(v==PlayOnline){
			AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

			dlgAlert.setMessage("Under construction");
			dlgAlert.setTitle("comming soon");
			
			dlgAlert.setCancelable(true);
			
			dlgAlert.create().show();
		}
	}
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        TicTacToe=(ImageView)findViewById(R.id.TicTacToe);
        onePlayer=(ImageView)findViewById(R.id.onePlayer);
        twoPlayer=(ImageView)findViewById(R.id.twoPlayer);
        exit=(ImageView)findViewById(R.id.exit);
        animation =AnimationUtils.loadAnimation(this,R.drawable.animation);
        TicTacToe.startAnimation(animation);
        
        
        
        
       

}
}