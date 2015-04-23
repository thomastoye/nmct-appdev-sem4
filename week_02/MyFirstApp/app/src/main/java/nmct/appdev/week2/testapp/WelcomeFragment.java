package nmct.appdev.week2.testapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeFragment extends Fragment {

    private Button buttonOK;
    private EditText editTextNaamDocent;
    private TextView textViewWelcome;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_welcome, container, false);
        buttonOK = (Button) v.findViewById(R.id.buttonOK);
        editTextNaamDocent = (EditText) v.findViewById(R.id.editTextNaamDocent);
        textViewWelcome = (TextView) v.findViewById(R.id.textViewWelkom);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toonInfo();
            }
        });
        return v;
    }

    private void toonInfo() {
        String naam = editTextNaamDocent.getText().toString();
        if (naam.toLowerCase().startsWith("thomas")) {
            textViewWelcome.setText("You will be blessed!");
        } else {
            textViewWelcome.setText("You will be damned!");
        }
    }
}
