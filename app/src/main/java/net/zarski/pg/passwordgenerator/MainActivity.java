package net.zarski.pg.passwordgenerator;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import net.zarski.pg.passwordgenerator.fragments.Generate;
import net.zarski.pg.passwordgenerator.fragments.ListOfPasswords;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements Generate.OnFragmentInteractionListener, ListOfPasswords.OnFragmentInteractionListener {
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
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onGeneratePressed() {
        RandomPhrase randomPhrase = new RandomPhrase(nouns, adjectives);

        ListOfPasswords list = (ListOfPasswords)getFragmentManager().findFragmentById(R.id.list);
        if(list == null) {
            // The user hasn't viewed this tab yet
        } else {
            // Here's your data is a custom function you wrote to receive data as a fragment
            list.pushItem(randomPhrase.next());
        }
    }
}
