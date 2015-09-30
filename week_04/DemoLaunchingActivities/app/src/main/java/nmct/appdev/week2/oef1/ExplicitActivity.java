package nmct.appdev.week2.oef1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ExplicitActivity extends ActionBarActivity {

    public static final String EXTRA_INFO = "nmct.appdev.week2.oef1.EXTRA_INFO";
    public static final int RESULT_CUSTOM_CODE =  55;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);

        String value = getIntent().getStringExtra(ExplicitActivity.EXTRA_INFO);
        Toast toast = Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT);
        toast.show();

        ((Button)findViewById(R.id.buttonCancel)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        ((Button)findViewById(R.id.buttonOk)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });

        ((Button)findViewById(R.id.buttonCustom)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setResult(RESULT_CUSTOM_CODE);

                Intent intent = new Intent();
                intent.putExtra(MainActivity.EXTRA_INFO_BACK_NAME, "Thomas");
                intent.putExtra(MainActivity.EXTRA_INFO_BACK_AGE, 19);

                setResult(RESULT_CUSTOM_CODE, intent);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_explicit, menu);
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
}
