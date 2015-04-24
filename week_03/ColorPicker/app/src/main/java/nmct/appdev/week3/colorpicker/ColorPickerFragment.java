package nmct.appdev.week3.colorpicker;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ColorPickerFragment extends Fragment {

    ColorView colorView;

    public ColorPickerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_color_picker, container, false);

        colorView = (ColorView)v.findViewById(R.id.colorView);

        if(savedInstanceState != null)
            colorView.setColor(savedInstanceState.getString("color", "#FFFFFF"));

        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("color", colorView.getColor());
    }
}
