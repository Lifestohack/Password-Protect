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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

import android.content.Intent;

public class Alreadyuser extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.protect);

		final String passs = "Password for this app";

		Button sumbitButton = (Button) findViewById(R.id.submitbutton);

		sumbitButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int ch;
				StringBuffer fileContent = new StringBuffer("");
				FileInputStream foss;
				try {

					foss = openFileInput(passs);
					try {
						while ((ch = foss.read()) != -1)
							fileContent.append((char) ch);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

				String data = new String(fileContent);

				EditText passwordEditText = (EditText) findViewById(R.id.passwordedittext);
				if (passwordEditText.getText().toString().equals(data)) {
					startActivity(new Intent(
							"com.password.protect.PASSWORDPROTECT"));
					Toast.makeText(getApplicationContext(), "Login Successful",
							Toast.LENGTH_SHORT).show();
					finish();

				} else {
					Toast.makeText(getApplicationContext(), "Wrong Password",
							Toast.LENGTH_SHORT).show();
					finish();
				}

			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.passwordprotect, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.help:
			startActivity(new Intent("com.password.protect.HELP"));
			return true;
		case R.id.privacy:
			startActivity(new Intent("com.password.protect.PRIVACY"));
			return true;
		}

		return false;

	}
}