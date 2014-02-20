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
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class Read extends Activity implements OnClickListener {
	Spinner spinner;
	TextView title, entry;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.read);

		spinner = (Spinner) findViewById(R.id.spinner1);

		title = (TextView) findViewById(R.id.textView1);
		entry = (TextView) findViewById(R.id.b3);

		getFilenames();
	}

	private void getFilenames() {
		// TODO Auto-generated method stub
		String[] filenames = getApplicationContext().fileList();
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < filenames.length; i++) {
			// Log.d("Filename", filenames[i]);
			list.add(filenames[i]);
		}
		ArrayAdapter<String> filenameAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, list);
		spinner.setAdapter(filenameAdapter);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String filename = String.valueOf(spinner.getSelectedItem());
		openFile(filename);

	}

	private void openFile(String filename) {
		// TODO Auto-generated method stub
		String value = "";

		FileInputStream fisw;

		try {
			fisw = openFileInput(filename);
			byte[] input = new byte[fisw.available()];
			while (fisw.read(input) != -1) {
				value += new String(input);

			}
			fisw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entry.setText(value);
		

	}

}
