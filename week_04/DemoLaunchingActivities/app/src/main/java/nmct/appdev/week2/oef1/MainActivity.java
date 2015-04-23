package nmct.appdev.week2.oef1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    public static final int REQUEST_CODE_EXPLICIT = 1;
    public static final String EXTRA_INFO_BACK_NAME = "EXTRA_INFO_BACK_NAME";
    public static final String EXTRA_INFO_BACK_AGE = "EXTRA_INFO_BACK_AGE";

    private Button buttonStartExplicitActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast toast = Toast.makeText(getApplicationContext(), "created main activity", Toast.LENGTH_LONG);
        toast.show();

        buttonStartExplicitActivity = (Button) findViewById(R.id.buttonExplicitActivity);

        buttonStartExplicitActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExplicitActivity.class);
                intent.putExtra(ExplicitActivity.EXTRA_INFO, "Dit is extra info");
                //startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE_EXPLICIT);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case REQUEST_CODE_EXPLICIT:
                switch (resultCode) {
                    case RESULT_CANCELED:
                        Toast.makeText(MainActivity.this, "User canceled", Toast.LENGTH_SHORT).show();
                        break;
                    case RESULT_OK:
                        Toast.makeText(MainActivity.this, "User OK'd", Toast.LENGTH_SHORT).show();
                        break;
                    case ExplicitActivity.RESULT_CUSTOM_CODE:
                        String name =  data.getStringExtra(MainActivity.EXTRA_INFO_BACK_NAME);
                        int age = data.getIntExtra(MainActivity.EXTRA_INFO_BACK_AGE, 0);
                        Toast.makeText(MainActivity.this, "Naam: " + name + ", leeftijd: " + age, Toast.LENGTH_SHORT).show();
                        break;

                }
            break;
            default: super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
