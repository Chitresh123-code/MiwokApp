/*
 * Copyright (C) 2016 The Android Open Source Project
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
package com.example.android.miwoklanguage;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.miwok.R;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();// generic class provided here is of type word because we make custom class i.e word.java to pass two parameters(one for miwok translation and another one for english translation)

        //words.add("one");--> use when generic class is string

        /*Word w = new Word("one","lutti");
        words.add(w);//we have made the new object and stored it in variable w then added that variable to our words list
        to use in very concise way it is equal to.....*/
        words.add(new Word("one","lutti"));
        words.add(new Word("one", "lutti"));
        words.add(new Word("two", "otiiko"));
        words.add(new Word("three", "tolookosu"));
        words.add(new Word("four", "oyyisa"));
        words.add(new Word("five", "massokka"));
        words.add(new Word("six", "temmokka"));
        words.add(new Word("seven", "kenekaku"));
        words.add(new Word("eight", "kawinta"));
        words.add(new Word("nine", "wo’e"));
        words.add(new Word("ten", "na’aacha"));

            // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
            // adapter knows how to create layouts for each item in the list, using the
            // simple_list_item_1.xml layout resource defined in the Android framework.
            // This list item layout contains a single {@link TextView}, which the adapter will set to
            // display a single word.
            /*ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<Word>(this, R.layout.list_item, words); // the arrayadapter can't fullfill the need as it provide list of one textview so we make a custom adapter class i.e. Word adapter to fulfill the need*/

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words);


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);


    }
}
