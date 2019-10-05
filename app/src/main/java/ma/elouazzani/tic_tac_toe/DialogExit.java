package ma.elouazzani.tic_tac_toe;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class DialogExit extends Dialog implements
android.view.View.OnClickListener {

ImageView button_yes, button_no;
RelativeLayout dialog_exit;

Activity mActivity;

public DialogExit(Context context) {
super(context);
this.mActivity = (Activity) context;

requestWindowFeature(Window.FEATURE_NO_TITLE);
getWindow().setBackgroundDrawableResource(R.drawable.bg_null);

this.getWindow().getAttributes().windowAnimations = R.style.Animations_SmileWindow;

setContentView(R.layout.message_layout);

dialog_exit = (RelativeLayout) findViewById(R.id.dialog_exit);
Util.resizeDialog(dialog_exit, this.mActivity);

button_yes = (ImageView) findViewById(R.id.yes);
button_yes.setOnClickListener(this);

button_no = (ImageView) findViewById(R.id.no);
button_no.setOnClickListener(this);
}

@Override
public void onClick(View view) {
if(view==button_yes){
	mActivity.finish();
	this.dismiss();
	System.exit(0);
}
if(view==button_no){
	this.dismiss();
}
}}
