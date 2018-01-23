package ng.com.blogspot.httpofficialceo.fmtfuto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CompoundInterestActivity extends AppCompatActivity {

    private EditText compPrincipalAmount;
    private EditText rate;
    private EditText resultText;
    private EditText duration;
    private TextView adviceTextView;
    private Button calculate;
    private Button reset;
    private int principal;
    private int interestRate;
    private int time;
    private int amount;
    private Toast myToast;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compound_interest);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        compPrincipalAmount = (EditText) findViewById(R.id.c_principal_et);
        rate = (EditText) findViewById(R.id.c_rate_et);
        spinner = (Spinner) findViewById(R.id.compound_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.compounding_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

//        duration = (EditText) findViewById(R.id.duration_et);
//        resultText = (EditText) findViewById(R.id.result_tv);
//        calculate = (Button) findViewById(R.id.calculate_button);
//        reset = (Button) findViewById(R.id.compound_reset_button);
//        adviceTextView = (TextView) findViewById(R.id.advice_tv);
//
//        calculate.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (myToast != null){
//                    myToast.cancel();
//                }
//
//                String i = compPrincipalAmount.getText().toString().trim();
//                String j = rate.getText().toString().trim();
//                String k = duration.getText().toString().trim();
//                if(i.isEmpty() || i.length() == 0 ) {
//
//                    myToast =  Toast.makeText(CompoundInterestActivity.this, "Principal has not been assigned", Toast.LENGTH_SHORT);
//                    myToast.show();
//
//                } else if(j.isEmpty() || j.length() == 0) {
//                    myToast = Toast.makeText(CompoundInterestActivity.this, "Rate has not been assigned", Toast.LENGTH_SHORT);
//                    myToast.show();
//                } else if(k.isEmpty() || k.length() == 0) {
//                    myToast =  Toast.makeText(CompoundInterestActivity.this, "Duration is empty", Toast.LENGTH_SHORT);
//                    myToast.show();
//                }else
//                    calculation();
//
//
//            }
//        });
//        reset.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (myToast != null){
//                    myToast.cancel();
//                }
//                compPrincipalAmount.setText("");
//                rate.setText("");
//                duration.setText("");
//                resultText.setText("Your result will be displayed here after calculations");
//                adviceTextView.setText("");
//                myToast = Toast.makeText(CompoundInterestActivity.this, "Items cleared", Toast.LENGTH_SHORT);
//                myToast.show();
//            }
//        });
//    }
//
//
//    private void calculation() {
//        principal = Integer.parseInt(compPrincipalAmount.getText().toString());
//        interestRate = Integer.parseInt(rate.getText().toString());
//        time = Integer.parseInt(duration.getText().toString());
//        amount = principal * interestRate * time / 100;
//        if(amount >= principal) {
//            resultText.setText("Your total amount to be returned is ₦" + String.valueOf(amount) + "\n\nYour added profit is ₦" + (amount - principal) + "\n");
//            adviceTextView.setText("The investment is worth a trial");
//        } else {
//            resultText.setText("Your total amount to be returned is ₦" + String.valueOf(amount) + "\n\nYour loss is ₦" + (amount - principal) + "\n");
//            adviceTextView.setText("Please don\'t invest your money into this");
//        }
//
//    }
//
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if(id == R.id.action_settings) {
//            onBackPressed();
//        }
//
//        return super.onOptionsItemSelected(item);
    }
}
