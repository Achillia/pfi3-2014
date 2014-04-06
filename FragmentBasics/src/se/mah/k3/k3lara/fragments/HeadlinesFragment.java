/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package se.mah.k3.k3lara.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class HeadlinesFragment extends ListFragment{ //This is a special fragment that creates a list
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    String[] headlines = {"Article One","Article Two","Min Artikel","Genombrottet"};
	    // Create an ArrayAdapter for the list view, using a string Array
	    // An ArrayAdapter is the magic rolls up all the items in a list using the supplied layout, there are pre-constructed
	    //layouts also named android.R.layout.simple_list_item_1, 
	    ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(),  R.layout.list_item, headlines);
	    //Ok tell the fragment that we are serious
	    setListAdapter(myAdapter);
	    //return whatever it will not really be used
		return super.onCreateView(inflater, container, savedInstanceState);
	}
   
    
	//This is a special method for ListFragment that is called when an item is clicked.
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
    	super.onListItemClick(l, v, position, id);
    	TextView tv = (TextView)v;
    	Log.i("k3lara","Clicked row: "+ tv.getText());
    	//Swop in the articles fragment the verbose way
    	FragmentManager manager = getFragmentManager();
    	FragmentTransaction ft = manager.beginTransaction();
    	ArticleFragment af = new ArticleFragment();  //WE are supposed to check if this exists but that is for next week
    	//ft.addToBackStack(null);  //add the first fragment to the stack so we can use back button
    	ft.add(R.id.main_activity_container, af);  //Put this new fragment on top of the other   	
    	ft.commit();
    }
}