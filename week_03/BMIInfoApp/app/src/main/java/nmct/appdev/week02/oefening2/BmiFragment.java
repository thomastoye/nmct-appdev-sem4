package nmct.appdev.week02.oefening2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class BmiFragment extends Fragment {

    private Button calculateButton;
    private EditText editTextHeight;
    private EditText editTextMass;
    private TextView textViewIndex;
    private TextView textViewCategory;
    private ImageView imageViewIllustration;

    public static final String PREFS_NAME = "MyPrefsFile";


    public BmiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_bmi, container, false);

        calculateButton = (Button) v.findViewById(R.id.buttonCalculate);
        editTextMass = (EditText) v.findViewById(R.id.editTextMass);
        editTextHeight = (EditText) v.findViewById(R.id.editTextHeight);
        textViewCategory = (TextView) v.findViewById(R.id.textViewCategoryResult);
        textViewIndex = (TextView) v.findViewById(R.id.textViewIndexResult);
        imageViewIllustration = (ImageView) v.findViewById(R.id.imageViewBmi);

        SharedPreferences settings = getActivity().getSharedPreferences(PREFS_NAME, 0);
        editTextHeight.setText(settings.getString("height", ""));
        editTextMass.setText(settings.getString("mass", ""));

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                berekenBmi();
            }
        });

        berekenBmi();

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        berekenBmi();
    }

    private void berekenBmi() {
        double height = 1.80;
        int mass = 80;

        try {
            height = Double.parseDouble(editTextHeight.getText().toString());
        } catch (NullPointerException | NumberFormatException e) {
        }

        try {
            mass = Integer.parseInt(editTextMass.getText().toString());
        } catch (NullPointerException | NumberFormatException e) {
        }

        BmiInfo info = new BmiInfo(height, mass);

        Context context = getActivity().getApplicationContext();
        String category = "(not set)";
        if (info.getCategory() != null) category = info.getCategory().toString();
        Toast.makeText(context, height + "cm " + mass + "kg: " + category, Toast.LENGTH_SHORT).show();

        textViewCategory.setText(info.getCategory().toString());
        textViewIndex.setText(Double.toString(info.getIndex()));
        imageViewIllustration.setImageResource(getResourceId(info.getCategory()));
    }

    private int getResourceId(BmiInfo.Category category) {
        switch (category) {
            case GrootOndergewicht:
                return R.drawable.silhouette_1;
            case ErnstigOndergewicht:
                return R.drawable.silhouette_2;

            case Ondergewicht:
                return R.drawable.silhouette_3;

            case Normaal:
                return R.drawable.silhouette_4;

            case Overgewicht:
                return R.drawable.silhouette_5;

            case MatigOvergewicht:
                return R.drawable.silhouette_6;

            case ErnstigOvergewicht:
                return R.drawable.silhouette_7;

            case ZeerGrootOvergewicht:
                return R.drawable.silhouette_8;
        }

        return R.drawable.silhouette_1;
    }

    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences settings = getActivity().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString("height", editTextHeight.getText().toString());
        editor.putString("mass", editTextMass.getText().toString());

        editor.commit();
    }
}
