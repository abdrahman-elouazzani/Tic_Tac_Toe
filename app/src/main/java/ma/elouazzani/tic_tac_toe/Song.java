package ma.elouazzani.tic_tac_toe;

import android.content.Context;
import android.media.MediaPlayer;

public class Song {

public	MediaPlayer media;
public Song(Context context){
	media=MediaPlayer.create(context,R.raw.tic );
	
}

}
