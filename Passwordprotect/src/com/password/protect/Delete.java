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


import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class Delete  extends Activity  implements OnClickListener{
	Spinner spinnerd;
	TextView entryd;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delete);
		spinnerd = (Spinner)findViewById(R.id.spinnerd1);
		
		entryd = (TextView)findViewById(R.id.textViewd2);
		getFilenames();
	}
	

	private void getFilenames() {
		
		String[] filenames = getApplicationContext().fileList();
		List<String> list = new ArrayList<String>();
		for(int i = 0; i<filenames.length; i++){
			list.add(filenames[i]);
		}
		ArrayAdapter<String> filenameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list);
		spinnerd.setAdapter(filenameAdapter);
	}


	@Override
	public void onClick(View v) {
		
		String selectFile = String.valueOf(spinnerd.getSelectedItem());
		deleteFile(selectFile);
		
		Toast.makeText(getApplicationContext(), "Selected Credential is deleted. It will take effect next time you open this page again.", Toast.LENGTH_SHORT).show();
	}

}
