package net.zarski.pg.passwordgenerator;

import android.os.*;
import android.support.design.widget.*;
import android.support.v7.app.*;
import java.io.*;
import net.zarski.pg.passwordgenerator.fragments.*;
import android.view.View.*;
import android.view.*;

public class MainActivity extends AppCompatActivity implements Generate.OnFragmentInteractionListener, FloatingActionButton.OnClickListener
{
    private RandomWord nouns;
    private RandomWord adjectives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            nouns = new RandomWord(this.getApplicationContext().getResources().openRawResource(R.raw.rzeczowniki));
            adjectives = new RandomWord(this.getApplicationContext().getResources().openRawResource(R.raw.przymiotniki));
        } catch (IOException e) {
        }
		
		FloatingActionButton fab = (FloatingActionButton) this.findViewById(R.id.fab);
		fab.setOnClickListener(this);
    }

	@Override
	public void onClick(View p1)
	{
        RandomPhrase randomPhrase = new RandomPhrase(nouns, adjectives);

        ListOfPasswords list = (ListOfPasswords)getFragmentManager().findFragmentById(R.id.list);
        if(list == null) {
            // The user hasn't viewed this tab yet
        } else {
            // Here's your data is a custom function you wrote to receive data as a fragment
            list.pushItem(randomPhrase.next());
        }
    }
	
	@Override
	public void onGeneratePressed()
	{
		// TODO: Implement this method
	}
}
