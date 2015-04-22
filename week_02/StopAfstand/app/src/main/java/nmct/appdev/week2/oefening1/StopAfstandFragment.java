package nmct.appdev.week2.oefening1;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import nmct.appdev.week2.oefening1.cars.StopAfstandInfo;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StopAfstandFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StopAfstandFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StopAfstandFragment extends Fragment {


    private Button buttonBereken;
    private EditText editTextSnelheid;
    private EditText editTextReactietijd;
    private RadioGroup radioGroup;
    private TextView textViewStopafstand;

    private StopAfstandInfo.Wegtype currentWegdektype;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stop_afstand, container, false);

        buttonBereken = (Button) v.findViewById(R.id.btnBereken);
        editTextSnelheid = (EditText) v.findViewById(R.id.snelheid);
        editTextReactietijd = (EditText) v.findViewById(R.id.snelheid);
        //radioGroup = (RadioGroup) v.findViewById(R.id.radioGroup);
        //textViewStopafstand = (TextView) v.findViewById(R.id.textViewStopafstand);

        buttonBereken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BerekenStopAfstand();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                /*RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {
                    if (rb.getText().toString().contains("Droog")) {
                        currentWegdektype = StopAfstandInfo.WegType.WEGDEK_DROOG;
                    } else {
                        currentWegdektype = StopAfstandInfo.WegType.WEGDEK_NAT;
                    }
                }*/

            }
        });

        return v;
    }

    private void BerekenStopAfstand() {
        double snelheid;
        double reactietijd;

        snelheid = Double.parseDouble(editTextSnelheid.getText().toString());
        reactietijd = Double.parseDouble(editTextReactietijd.getText().toString());

        //StopAfstandInfo sai = new StopAfstandInfo(snelheid, reactietijd, currentWegdektype);
        //textViewStopafstand.setText("De stopafstand is " + Math.round(sai.getStopafstand()) + " meter");

        Context context = getActivity().getApplicationContext();
        //Toast.makeText(context, Math.round(sai.getStopafstand()) + " meter", Toast.LENGTH_LONG).show();
    }
}
