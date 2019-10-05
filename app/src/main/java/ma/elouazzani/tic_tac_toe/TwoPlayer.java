package ma.elouazzani.tic_tac_toe;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TwoPlayer extends Activity {
ImageView m1,m2,m3,m4,m5,m6,m7,m8,m9,turn_player,newGame,ling1,ling2,ling3,colone1,colone2,colone3;
ImageView[] ImageArray,brushArray;
TextView x_wins,o_wins,draw;	
boolean turn=true,find_winer,find_draw;	
int x=0,o=0,d=0;
int[] icone =new int[]{R.drawable.emo_im_winking,R.drawable.emo_im_undecided};
public static int win=0,wtf=1;
String message_win="win in this round!",message_draw="draw!!!";
Song song;
Toast toast;
public void click(View v){
	ImageView image=(ImageView)v;
	song.media.start();
	ImageClicked(image);
    CheckforWiner();
	CheckforDraw();
}

public void ImageClicked(ImageView image){
	if(turn){
		image.setBackgroundResource(R.drawable.x); image.setTag("x");turn_player.setBackgroundResource(R.drawable.turn_o);}
	else{
		image.setBackgroundResource(R.drawable.o); image.setTag("o");turn_player.setBackgroundResource(R.drawable.turn_x);}
	turn=!turn;
	image.setClickable(false);
	
}
public void CheckforWiner(){
	find_winer=false;
	//check for ling
	if(m1.getTag()==m2.getTag()&&m2.getTag()==m3.getTag()&&!m1.isClickable()){find_winer=true;ling1.setBackgroundResource(R.drawable.brush_cling);}
	else if(m4.getTag()==m5.getTag()&&m5.getTag()==m6.getTag()&&!m4.isClickable()){find_winer=true;ling2.setBackgroundResource(R.drawable.brush_cling);}
	else if(m7.getTag()==m8.getTag()&&m8.getTag()==m9.getTag()&&!m7.isClickable()){find_winer=true;ling3.setBackgroundResource(R.drawable.brush_cling);}
	//check for colon
	else if(m1.getTag()==m4.getTag()&&m4.getTag()==m7.getTag()&&!m1.isClickable()){find_winer=true;colone1.setBackgroundResource(R.drawable.brush);}
	else if(m2.getTag()==m5.getTag()&&m5.getTag()==m8.getTag()&&!m2.isClickable()){find_winer=true;colone2.setBackgroundResource(R.drawable.brush);}
	else if(m3.getTag()==m6.getTag()&&m6.getTag()==m9.getTag()&&!m3.isClickable()){find_winer=true;colone3.setBackgroundResource(R.drawable.brush);}
	//check for dingonal
	else if(m1.getTag()==m5.getTag()&&m5.getTag()==m9.getTag()&&!m1.isClickable()){find_winer=true;colone2.setBackgroundResource(R.drawable.brush_dg);}
	else if(m3.getTag()==m5.getTag()&&m5.getTag()==m7.getTag()&&!m3.isClickable()){find_winer=true;colone2.setBackgroundResource(R.drawable.brush_no_dg);}
if(find_winer){
	if(!turn){x++; x_wins.setText(""+x); ShowTaost(this, win, message_win);}
	else {o++; o_wins.setText(""+o);ShowTaost(this, win, message_win);}
	disableClick(false);
}

}
public void CheckforDraw(){
	find_draw=false;
if((m1.getTag()!=m2.getTag()||m2.getTag()!=m3.getTag()||m1.getTag()!=m3.getTag())
  &&(m4.getTag()!=m5.getTag()||m5.getTag()!=m6.getTag()||m4.getTag()!=m6.getTag())
  &&(m7.getTag()!=m8.getTag()||m8.getTag()!=m9.getTag()||m7.getTag()!=m9.getTag())
  &&(m1.getTag()!=m4.getTag()||m4.getTag()!=m7.getTag()||m1.getTag()!=m7.getTag())
  &&(m2.getTag()!=m5.getTag()||m5.getTag()!=m8.getTag()||m2.getTag()!=m8.getTag())
  &&(m3.getTag()!=m6.getTag()||m6.getTag()!=m9.getTag()||m3.getTag()!=m6.getTag())
  &&(m1.getTag()!=m5.getTag()||m5.getTag()!=m9.getTag()||m1.getTag()!=m9.getTag())
  &&(m3.getTag()!=m5.getTag()||m5.getTag()!=m7.getTag()||m3.getTag()!=m7.getTag())
  &&(!m1.isClickable()&&!m2.isClickable()&&!m3.isClickable()&&!m4.isClickable()&&!m5.isClickable()&&!m6.isClickable()&&!m7.isClickable()&&!m8.isClickable()&&!m9.isClickable())
	)
	find_draw=true;
if(find_draw){d++;draw.setText(""+d); ShowTaost(this, wtf, message_draw); }
}


	public void disableClick(boolean enable) {
	// TODO Auto-generated method stub
	for(ImageView image:ImageArray){
		image.setClickable(enable);
	}
	}
	public void Game(View v){
		if(v==newGame){
			turn=true;
			find_draw=false;
			toast.cancel();
			disableClick(true);
			turn_player.setBackgroundResource(R.drawable.turn_x);
			for(ImageView image:ImageArray){
				image.setTag(""); image.setBackgroundResource(R.drawable.button_1);}
			for(ImageView image:brushArray)
				image.setBackgroundDrawable(null);
				
		}
	}
	public void ShowTaost(Context context ,int keySmaily,String message) {
		
		View v;
		LayoutInflater inflater=getLayoutInflater();
		v=inflater.inflate(R.layout.layou_show,(ViewGroup)findViewById(R.id.toastLayout));
		ImageView imageView = (ImageView)v.findViewById(R.id.image_show);
		TextView text=(TextView)v.findViewById(R.id.text_show);
		TextView text2=(TextView)v.findViewById(R.id.player);
		imageView.setBackgroundResource(icone[keySmaily]);
		text.setText(message);
		if(find_winer){
			if(!turn){ text2.setTextColor(Color.BLUE);text2.setText("Player-x ");}
			else {text2.setTextColor(Color.RED);text2.setText("Player-o ");}
		}
		 toast= new Toast(context);		
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(v);
		toast.show();
		
		
	}
	
	private String TAG = TwoPlayer.class.getSimpleName();
	InterstitialAd mInterstitialAd;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        // for google adds

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //  for change the type of the textView
        Typeface type=Typeface.createFromAsset(getAssets(),"GhoulFriAOE.ttf");
        turn_player=(ImageView)findViewById(R.id.player_turn);
        m1=(ImageView)findViewById(R.id.m1);
        m2=(ImageView)findViewById(R.id.m2);
        m3=(ImageView)findViewById(R.id.m3);
        m4=(ImageView)findViewById(R.id.m4);
        m5=(ImageView)findViewById(R.id.m5);
        m6=(ImageView)findViewById(R.id.m6);
        m7=(ImageView)findViewById(R.id.m7);
        m8=(ImageView)findViewById(R.id.m8);
        m9=(ImageView)findViewById(R.id.m9);
        ImageArray=new ImageView[]{m1,m2,m3,m4,m5,m6,m7,m8,m9};
       ling1=(ImageView)findViewById(R.id.ling1);
       ling2=(ImageView)findViewById(R.id.ling2);
       ling3=(ImageView)findViewById(R.id.ling3);
       colone1=(ImageView)findViewById(R.id.colone1);
       colone2=(ImageView)findViewById(R.id.colone2);
       colone3=(ImageView)findViewById(R.id.colone3);
       brushArray=new ImageView[]{ling1,ling2,ling3,colone1,colone2,colone3};
       newGame=(ImageView)findViewById(R.id.newGame);
       x_wins=(TextView)findViewById(R.id.x_wine);
       o_wins=(TextView)findViewById(R.id.o_wine);
       draw=(TextView)findViewById(R.id.draw);
       x_wins.setTypeface(type);
       o_wins.setTypeface(type);
       draw.setTypeface(type);
       
        song=new Song(this);
        

        mInterstitialAd = new InterstitialAd(this);
        
        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.admob_intestitial));

        AdRequest adRequestt = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequestt);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });
        

}private void showInterstitial() {
    if (mInterstitialAd.isLoaded()) {
        mInterstitialAd.show();
    }
}
}