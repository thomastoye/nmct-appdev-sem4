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

import org.w3c.dom.Text;


public class StopAfstandSliderFragment extends Fragment {

    private SeekBar seekBarSnelheid;
    private SeekBar seekBarReactieTijd;
    private RadioButton droogWegType;
    private Button buttonBereken;
    private TextView stopAfstandResult;
    private TextView huidigeSnelheid;
    private TextView huidigeReactietijd;

    public StopAfstandSliderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_stop_afstand_slider, container, false);

        seekBarSnelheid = (SeekBar) v.findViewById(R.id.seekBarSnelheid);
        seekBarReactieTijd = (SeekBar) v.findViewById(R.id.seekBarReactietijd);
        droogWegType = (RadioButton) v.findViewById(R.id.radioButtonWegdekDroog);
        buttonBereken = (Button) v.findViewById(R.id.buttonBerekenStopAfstandSliders);
        stopAfstandResult = (TextView) v.findViewById(R.id.textViewStopAfstandResult);
        huidigeSnelheid = (TextView) v.findViewById(R.id.textViewHuidigeSnelheid);
        huidigeReactietijd = (TextView) v.findViewById(R.id.textViewHuidigReactietijd);

        buttonBereken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toonStopAfstand(v);
            }
        });


        seekBarSnelheid.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                huidigeSnelheid.setText(i + "km/s");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        seekBarReactieTijd.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                huidigeReactietijd.setText(i + "s");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return v;
    }

    public void toonStopAfstand(View v) {
        int snelheid = seekBarSnelheid.getProgress();
        int reactietijd = seekBarReactieTijd.getProgress();
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
