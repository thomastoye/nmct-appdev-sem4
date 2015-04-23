package nmct.appdev.week02.stopafstand;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class StopAfstandFragment extends Fragment {

    private TextView editTextSnelheid;
    private TextView editTextReactietijd;
    private RadioButton droogWegType;
    private Button buttonBereken;
    private TextView stopAfstandResult;

    public StopAfstandFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_stop_afstand, container, false);

        editTextSnelheid = (EditText) v.findViewById(R.id.editTextSnelheid);
        editTextReactietijd = (EditText) v.findViewById(R.id.editTextReactietijd);
        droogWegType = (RadioButton) v.findViewById(R.id.radioButtonWegdekDroog);
        buttonBereken = (Button) v.findViewById(R.id.buttonBerekenStopAfstand);
        stopAfstandResult = (TextView) v.findViewById(R.id.textViewStopAfstandResult);

        buttonBereken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toonStopAfstand(v);
            }
        });

        return v;
    }

    public void toonStopAfstand(View v) {
        int snelheid = Integer.parseInt(editTextSnelheid.getText().toString());
        int reactietijd = Integer.parseInt(editTextReactietijd.getText().toString());
        StopAfstandInfo.Wegtype wegtype;

        if (droogWegType.isChecked()) {
            wegtype = StopAfstandInfo.Wegtype.WEGDEK_DROOG;
        } else {
            wegtype = StopAfstandInfo.Wegtype.WEGDEK_NAT;
        }

        StopAfstandInfo stopAfstandInfo = new StopAfstandInfo(snelheid, reactietijd, wegtype);

        String result = stopAfstandInfo.getStopAfstand() + "m";
        stopAfstandResult.setText(result);

        Context context = getActivity().getApplicationContext();

        Toast toast = Toast.makeText(context, result, Toast.LENGTH_SHORT);
        toast.show();

    }

}
