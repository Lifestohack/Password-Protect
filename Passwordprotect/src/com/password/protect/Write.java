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

public class Write  extends Activity  implements OnClickListener{

	Button save;
	EditText filename, entry, pass;
	String FILENAME, JOUR, PASSWORD;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.write);
		save = (Button) findViewById(R.id.b5);
		save.setOnClickListener(this);
		filename = (EditText) findViewById(R.id.editText3);
		entry = (EditText) findViewById(R.id.editText1);
		pass = (EditText) findViewById(R.id.editText2);
		
	}


	@Override
	public void onClick(View arg0) {
		
		// TODO Auto-generated method stub
		FILENAME = filename.getText().toString();

		JOUR = entry.getText().toString();

		PASSWORD = pass.getText().toString();

		if (PASSWORD.contentEquals("") || JOUR.contentEquals("")
				|| FILENAME.contentEquals("")) {

			Toast.makeText(getApplicationContext(), "All field required.",
					Toast.LENGTH_SHORT).show();
		} else {

			String usernametext = "Username:\n";
			String passwordtext = "Password:\n";
			String space = "\n";

			try {
				FileOutputStream fos = openFileOutput(FILENAME,
						Context.MODE_PRIVATE);
				fos.write(usernametext.getBytes());
				fos.write(JOUR.getBytes());
				fos.write(space.getBytes());
				fos.write(passwordtext.getBytes());
				fos.write(PASSWORD.getBytes());
				fos.close();
				Toast.makeText(getApplicationContext(),
						"Your Credentials are saved.", Toast.LENGTH_SHORT)
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


