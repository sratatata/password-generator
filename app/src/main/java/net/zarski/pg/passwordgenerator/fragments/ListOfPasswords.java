package net.zarski.pg.passwordgenerator.fragments;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.support.annotation.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import net.zarski.pg.passwordgenerator.*;

public class ListOfPasswords extends Fragment {
	ArrayAdapter<String> adapter;
    private final List<String> passwords = new ArrayList<>();
	
    public static ListOfPasswords newInstance(String param1, String param2) {
        ListOfPasswords fragment = new ListOfPasswords();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        return inflater.inflate(R.layout.fragment_list_of_passwords, container, false);
    }
	
	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstance){
		adapter = new ArrayAdapter<>(
			view.getContext(),
			R.layout.simple_password_item,
			passwords);

		ListView listView = (ListView) view.findViewById(R.id.password_list_view);
		listView.setAdapter(adapter);
	}

    public void onButtonPressed(Uri uri) {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void pushItem(Phrase phrase) {
		passwords.add(phrase.toString());
		adapter.notifyDataSetChanged();
	}
}
