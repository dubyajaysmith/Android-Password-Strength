package com.passStrCalc;



import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class passStrCalc extends Activity implements OnClickListener{
	private Button h;
	private EditText wpe;
	private String wps,val;
	private int wp;
	private int up=0,low=0,no=0,spl=0,xtra=0,len=0,points=0,max=8;
	private char c;

	
	static final int DIALOG_LOW = 0;
	static final int DIALOG_HIGH = 2;
	static final int DIALOG_MID = 1;
	

	private void calcStr(String pass)
    {
    		len=pass.length();
    		if(len==0)
    		{
    				showMessage("Invalid Input ");
    				return;
    		}
    		if(len<=5) points++;
    		else
    			if(len<=10) points+=2;
    			else
    				points+=3;
    		for(int i=0;i<len;i++)
    		{
    			c=pass.charAt(i);
    			if(c >='a' && c<='z') { if(low==0) points++;	low=1;} 
    			else
    			{
    				if(c >='A' && c<='Z') {if(up==0) points++;	up=1;}
    				else
    				{
    					if(c >='0' && c<='9') {if(no==0) 	points++;	no=1;}
        				else
        				{
        					if(c == '_' || c == '@') { if(spl==0) 	points+=1;	spl=1;}
        					else
        					{
        						if(xtra==0)	points+=2;
        							xtra=1;
    						
        					}
        				}
    				}	
    			}
    		}
    		if(points<=3) showMessage("Password Strength : LOW ");
    		else
    			if(points<=6) showMessage("Password Strength : MEDIUM ");
    			else
    				if(points<=9) showMessage("Password Strength : HIGH ");
    		
    		
    		
    		points=0;len=0;up=0;low=0;no=0;xtra=0;spl=0;
    		
    		
    }
    		
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
 
        
        h = (Button)findViewById(R.id.high);
        h.setOnClickListener(this);
       
        wpe = (EditText)findViewById(R.id.wp);
       
    }
    
    private void showMessage(CharSequence text) {
    	Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();    	
    }
      
    
	public void onClick(View v) {
		try{	
			calcStr(wpe.getText().toString());
		}	
		catch(Exception e)
		{
			showMessage("Retry");
			return;
		}
	}
}