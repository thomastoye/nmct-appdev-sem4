
# NMCT App Development (4th semester)

These are my files for the Android App Development course offered in the fourth semester of the [NMCT](http://nmct.be) curriculum.

Following is my cheat sheet/recipe list.


# Android recipes

## Adding a button listener

        buttonBereken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ...
            }
        });

## Working with seekbars

Add a listener:

        seekBarSnelheid.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // ...
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // ...
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // ...
            }
        });

## Showing a toast

        Context context = getActivity().getApplicationContext();

        Toast toast = Toast.makeText(context, result, Toast.LENGTH_SHORT);
        toast.show();

In an activity: `getApplicationContext()`, in a fragment `getActivity().getApplicationContext()`.

## Getting UI elements in fragment classes

In your `Fragment` class:

    private SeekBar seekBarSnelheid;
    private RadioButton droogWegType;
    private Button buttonBereken;
    private TextView stopAfstandResult;
    private EditText huidigeSnelheid;

In the `onCreateView` of that `Fragment`:

        seekBarReactieTijd = (SeekBar) v.findViewById(R.id.seekBarReactietijd);
        droogWegType = (RadioButton) v.findViewById(R.id.radioButtonWegdekDroog);
        buttonBereken = (Button) v.findViewById(R.id.buttonBerekenStopAfstandSliders);

Then add event listeners.

## Working with images

### Getting images in Android Studio

1. Open up file manager
1. Go to `app/src/main/res`
1. Copy all the images in there (in hdpi/mdpi/xhdpi/xxhdpi folders?)

Then they will be available in `app/res/drawable`. You might need to Gradle sync/sync Android Studio project to get them to show up.

### Using imageviews

Example usage:

    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/imageView"
        android:layout_below="@+id/textView"
        android:layout_alignParentStart="true"
        android:layout_alignParentBottom="true"
        android:layout_alignParentEnd="true"
        android:src="@drawable/silhouette_1"/>

Note the `android:src="@drawable/imagename"` attribute.

## Working with fragments

### Bare minimum

1. `extends Fragment`
1. Empty constructor
1. `onCreateView` overridden

Example:

    public class StopAfstandFragment extends Fragment {

        private Button buttonBereken;

        public StopAfstandFragment() {
            // Required empty public constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View v = inflater.inflate(R.layout.fragment_stop_afstand, container, false);

            buttonBereken = (Button) v.findViewById(R.id.buttonBerekenStopAfstand);

            buttonBereken.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toonStopAfstand(v);
                }
            });

            return v;
        }

        public void toonStopAfstand(View v) {
            // ...
        }

    }

## Android Studio new project set-up

1. Always choose the `Activity with Fragment` template
1. Delete the placeholder template in the main activity
1. Create a new `Fragment` class and use that instead

## Using ImageViews

Fragment XML:


    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/imageViewBmi"
        android:src="@drawable/silhouette_1"
        android:layout_centerVertical="true"
        android:layout_alignParentStart="true" />

Set resource programmatically:

    private ImageView imageViewIllustration = (ImageView) v.findViewById(R.id.imageViewBmi);
    imageViewIllustration.setImageResource(R.drawable.my_drawable_name);

## Preferences

Multiple ways to persist preferences. Easiest: `SharedPreferences`. See [the docs](http://developer.android.com/guide/topics/data/data-storage.html#pref)

### Shared preferences

At the top of the class, define a name for the preference file:

    public static final String PREFS_NAME = "MyPrefsFile";

Now get the preferences:

    SharedPreferences settings = getActivity().getSharedPreferences(PREFS_NAME, 0)
    SharedPreferences.Editor editor = settings.edit(); // get an editor

Writing preferences:

    editor.putString("height", editTextHeight.getText().toString());
    editor.putString("mass", editTextMass.getText().toString());
    
    editor.commit(); // persist

Writing preferences should usually happen in the `onStop` method.

Reading preferences (does not require an editor):

        SharedPreferences settings = getActivity().getSharedPreferences(PREFS_NAME, 0);
        String test = settings.getString("height", "");
        editTextMass.setText(settings.getString("mass", ""));

The second parameter of `getString` is a default value. Reading preferences and filling the UI back up should usually happen in the `onCreateView` method.

## Bundle and savedInstance

Used only for temporary state (not persistent storage), e.g. when rotating the device.

### Save

In your fragment:

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("color", colorView.getColor());
    }

### Retrieve

Usually in `onCreate`/`onCreateView`/`onActivityCreated`. Always check if the `Bundle` you're getting is null - if it is, this is a fresh launch and you shouldn't/can't restore state.


    if(savedInstanceState != null) {
        colorView.setColor(savedInstanceState.getString("color", "#FFFFFF"));
        // ...
    }

