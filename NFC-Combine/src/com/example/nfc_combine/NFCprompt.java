package com.example.nfc_combine;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;

public class NFCprompt extends DialogFragment{
	
	public static NFCprompt newInstance() {
		return new NFCprompt();
	}

	public Dialog onCreateDialog(Bundle savedInstanceState){		
		AlertDialog prompt = new AlertDialog.Builder(getActivity())
		.setMessage("Please scan a Tag with your phone or the scanner...")		
		.setCancelable(false)
		.setOnKeyListener(new DialogInterface.OnKeyListener() {
			
			@Override
			public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
				if(keyCode == KeyEvent.KEYCODE_BACK){
					getActivity().finish();
				}
				return false;
			}
		})
		.setNegativeButton("Leave", 
				new DialogInterface.OnClickListener(){

					@Override
					public void onClick(DialogInterface dialog,
							int which) {
						// TODO destroy AddTagActivity and 		
						dialog.dismiss();
//						setResult(RESULT_CANCELED, leaveIntent);
						getActivity().finish(); 	//enough for killing AddTagActivity?						
					}							
		})
		.create();
		
		prompt.setCanceledOnTouchOutside(false);
//		prompt.setCancelable(false);

		return prompt;
	}
	
}
