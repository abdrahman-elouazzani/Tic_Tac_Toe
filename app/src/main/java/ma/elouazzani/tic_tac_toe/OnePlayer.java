package ma.elouazzani.tic_tac_toe;

import java.util.Random;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OnePlayer extends Activity {
	ImageView m1,m2,m3,m4,m5,m6,m7,m8,m9,turn_player,newGame,ling1,ling2,ling3,colone1,colone2,colone3;
	ImageView[] ImageArray,brushArray;
	ImageView[][] M=new ImageView[3][3];
	TextView x_wins,o_wins,draw;	
	boolean turn=true,find_winer=false,find_draw=false,computer_win=false,find;	
	int x=0,o=0,d=0,a,b;
	Random random =new Random();
	public static int happy=0,said=1,wtf=2;
	int[] icone=new int[]{R.drawable.emo_im_happy,R.drawable.emo_im_sad,R.drawable.emo_im_undecided,R.drawable.emo_im_winking};
	String message_win="You win in this round!",message_lose="Sorry you lose play again!",message_draw="draw!!!";
	Toast toast;
	Song song;
	boolean show=false;
	
public void click(View v){
	ImageView image=(ImageView)v;
	ImageClicked(image);
}

public void ImageClicked(ImageView image){
	
	
		Player(image);
		CheckforWiner();
		if(!find_winer){Computer_Play();CheckforWiner(); 
		}
	CheckforDraw();
	
	
}	
public void Player(ImageView image){
	turn=true;
	song.media.start();
	
	turn_player.setBackgroundResource(R.drawable.turn_x);
	image.setBackgroundResource(R.drawable.x);
	image.setTag("x");
	image.setClickable(false);
	
}
public void Computer_Play(){
	for(int i=0;i<3;i++){
		 find=false;	 
		 
	if(M[i][0].getTag()==M[i][1].getTag()&&!M[i][0].isClickable()&&M[i][2].isClickable()){ M[i][2].setBackgroundResource(R.drawable.o);M[i][2].setTag("o"); M[i][2].setClickable(false);find=true; break;}
	else if(M[i][0].getTag()==M[i][2].getTag()&&!M[i][0].isClickable()&&M[i][1].isClickable()){M[i][1].setBackgroundResource(R.drawable.o);M[i][1].setTag("o"); M[i][1].setClickable(false);find=true; break;}
	else if(M[i][1].getTag()==M[i][2].getTag()&&!M[i][1].isClickable()&&M[i][0].isClickable()){M[i][0].setBackgroundResource(R.drawable.o);M[i][0].setTag("o"); M[i][0].setClickable(false);find=true; break;}
	else if(M[0][i].getTag()==M[1][i].getTag()&&!M[0][i].isClickable()&&M[2][i].isClickable()){M[2][i].setBackgroundResource(R.drawable.o);M[2][i].setTag("o"); M[2][i].setClickable(false);find=true; break;}
	else if(M[0][i].getTag()==M[2][i].getTag()&&!M[0][i].isClickable()&&M[1][i].isClickable()){M[1][i].setBackgroundResource(R.drawable.o);M[1][i].setTag("o"); M[1][i].setClickable(false);find=true; break;}
	else if(M[1][i].getTag()==M[2][i].getTag()&&!M[1][i].isClickable()&&M[0][i].isClickable()){M[0][i].setBackgroundResource(R.drawable.o);M[0][i].setTag("o"); M[0][i].setClickable(false);find=true; break;}
	else if(M[0][0].getTag()==M[1][1].getTag()&&!M[0][0].isClickable()&&M[2][2].isClickable()){M[2][2].setBackgroundResource(R.drawable.o);M[2][2].setTag("o"); M[2][2].setClickable(false);find=true; break;}
	else if(M[0][0].getTag()==M[2][2].getTag()&&!M[0][0].isClickable()&&M[1][1].isClickable()){M[1][1].setBackgroundResource(R.drawable.o);M[1][1].setTag("o"); M[1][1].setClickable(false);find=true; break;}
	else if(M[1][1].getTag()==M[2][2].getTag()&&!M[1][1].isClickable()&&M[0][0].isClickable()){M[0][0].setBackgroundResource(R.drawable.o);M[0][0].setTag("o"); M[0][0].setClickable(false);find=true; break;}
	else if(M[0][2].getTag()==M[1][1].getTag()&&!M[0][2].isClickable()&&M[2][0].isClickable()){M[2][0].setBackgroundResource(R.drawable.o);M[2][0].setTag("o"); M[2][0].setClickable(false);find=true; break;}
	else if(M[0][2].getTag()==M[2][0].getTag()&&!M[0][2].isClickable()&&M[1][1].isClickable()){M[1][1].setBackgroundResource(R.drawable.o);M[1][1].setTag("o"); M[1][1].setClickable(false);find=true; break;}
	else if(M[1][1].getTag()==M[2][0].getTag()&&!M[1][1].isClickable()&&M[0][2].isClickable()){M[0][2].setBackgroundResource(R.drawable.o);M[0][2].setTag("o"); M[0][2].setClickable(false);find=true; break;}}
	
	while(!find){
	int	i=random.nextInt(3);
	int	j=random.nextInt(3);
		/*	
	for(int i=0;i<3;i++)
	{
	for(int j=0;j<3;j++)
		if(M[i][j].isClickable()){
			M[i][j].setBackgroundResource(R.drawable.o);
			
		M[i][j].setTag("o"); M[i][j].setClickable(false);find=true; break;}if(find){find=false; break;}}*/
	if(M[i][j].isClickable()){M[i][j].setBackgroundResource(R.drawable.o);
	
M[i][j].setTag("o"); M[i][j].setClickable(false);find=true; break;}
	
	if(!M[0][0].isClickable()&&!M[0][1].isClickable()&&!M[0][2].isClickable()
		&&!M[1][0].isClickable()&&!M[1][1].isClickable()&&!M[1][2].isClickable()
		&&!M[2][0].isClickable()&&!M[2][1].isClickable()&&!M[2][2].isClickable())
		break;

	}
	turn=false;	
		
	
	
		

}

public void CheckforWiner() {
	// TODO Auto-generated method stub
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
	if(turn){x++; x_wins.setText(""+x);computer_win=false; ShowTaost(this, happy, message_win);show=true;}
	else {o++; o_wins.setText(""+o);computer_win=true; ShowTaost(this, said, message_lose);show=true;}
	disableClick(false);
}
}
public void disableClick(boolean b) {
	// TODO Auto-generated method stub
	for(int i=0;i<3;i++)
		for(int j=0;j<3;j++)
			M[i][j].setClickable(b);
	
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
	if(find_draw){d++;draw.setText(""+d); ShowTaost(this, wtf, message_draw);show=true;}
	
}
public void Game(View v){
	if(v==newGame){
		
		turn=true;
		find_draw=false;
		
			toast.cancel();
		disableClick(true);
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++){
			M[i][j].setTag(""); M[i][j].setBackgroundResource(R.drawable.button_1);}
		for(ImageView image:brushArray)
			image.setBackgroundDrawable(null);
		if(computer_win)
			Computer_Play();
			
	}
}

	

public void ShowTaost(Context context ,int keySmaily,String message) {
	
	View v;
	LayoutInflater inflater=getLayoutInflater();
	v=inflater.inflate(R.layout.layou_show,(ViewGroup)findViewById(R.id.toastLayout));
	ImageView imageView = (ImageView)v.findViewById(R.id.image_show);
	TextView text=(TextView)v.findViewById(R.id.text_show);
	imageView.setBackgroundResource(icone[keySmaily]);
	text.setText(message);
	 toast= new Toast(context);		
	toast.setGravity(Gravity.CENTER, 0, 0);
	toast.setDuration(Toast.LENGTH_LONG);
	toast.setView(v);
	toast.show();
	
	
}
	
private String TAG = OnePlayer.class.getSimpleName();
InterstitialAd mInterstitialAd;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
     // for google adds
       
        
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Typeface type=Typeface.createFromAsset(getAssets(),"GhoulFriAOE.ttf");
        turn_player=(ImageView)findViewById(R.id.player_turn);
       M[0][0]=(ImageView)findViewById(R.id.m1);
       M[0][1]=(ImageView)findViewById(R.id.m2);
       M[0][2]=(ImageView)findViewById(R.id.m3);
       M[1][0]=(ImageView)findViewById(R.id.m4);
       M[1][1]=(ImageView)findViewById(R.id.m5);
       M[1][2]=(ImageView)findViewById(R.id.m6);
       M[2][0]=(ImageView)findViewById(R.id.m7);
       M[2][1]=(ImageView)findViewById(R.id.m8);
       M[2][2]=(ImageView)findViewById(R.id.m9);
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
    
    
}
	private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

}