/* Copyright 2014 www.lifestohack.com

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   */
package com.password.protect;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Change  extends Activity  implements OnClickListener{

	Button Submitbutton;
	EditText Passwordedittext;
	String string;
	final String passs = "Password for this app";
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.change);
		Submitbutton = (Button) findViewById(R.id.btnchange);
		Submitbutton.setOnClickListener(this);
		Passwordedittext = (EditText) findViewById(R.id.edittextchange);
		
		
	}


	@Override
	public void onClick(View arg0) {
		
		// TODO Auto-generated method stub
		string = Passwordedittext.getText().toString();
	

	

		if (string.contentEquals("") ) {

			Toast.makeText(getApplicationContext(), "Password cannot be blank.",
					Toast.LENGTH_SHORT).show();
		} else {
			try {
				FileOutputStream foss = openFileOutput(passs,
						Context.MODE_PRIVATE);
				foss.write(string.getBytes());
				foss.close();
				Toast.makeText(getApplicationContext(),
						"Your Password is changed.", Toast.LENGTH_SHORT)
						.show();
				finish();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	}


