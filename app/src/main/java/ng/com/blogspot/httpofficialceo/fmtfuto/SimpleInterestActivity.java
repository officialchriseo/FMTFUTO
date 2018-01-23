package ng.com.blogspot.httpofficialceo.fmtfuto;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleInterestActivity extends AppCompatActivity {

    private EditText principalAmount;
    private EditText rate;
    private EditText resultText;
    private EditText duration;
    private TextView adviceTextView;
    private Button calculate;
    private Button reset;
    private FloatingActionButton shareSimpleResult;
    private int principal;
    private int interestRate;
    private int time;
    private int amount;
    private Toast myToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_interest);
       this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        principalAmount = (EditText) findViewById(R.id.principal_et);
        rate = (EditText) findViewById(R.id.rate_et);
        duration = (EditText) findViewById(R.id.duration_et);
        resultText = (EditText) findViewById(R.id.result_tv);
        calculate = (Button) findViewById(R.id.calculate_button);
        reset = (Button) findViewById(R.id.reset_button);
        adviceTextView = (TextView) findViewById(R.id.advice_tv);
        shareSimpleResult = (FloatingActionButton) findViewById(R.id.share_fab);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        resultText.setEnabled(false);
        resultText.setClickable(false);

        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (myToast != null) {
                    myToast.cancel();
                }

                String i = principalAmount.getText().toString().trim();
                String j = rate.getText().toString().trim();
                String k = duration.getText().toString().trim();
                if (i.isEmpty() || i.length() == 0) {

                    myToast = Toast.makeText(SimpleInterestActivity.this, "Principal has not been assigned", Toast.LENGTH_SHORT);
                    myToast.show();

                } else if (j.isEmpty() || j.length() == 0) {
                    myToast = Toast.makeText(SimpleInterestActivity.this, "Rate has not been assigned", Toast.LENGTH_SHORT);
                    myToast.show();
                } else if (k.isEmpty() || k.length() == 0) {
                    myToast = Toast.makeText(SimpleInterestActivity.this, "Duration is empty", Toast.LENGTH_SHORT);
                    myToast.show();
                } else
                    calculation();


            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (myToast != null) {
                    myToast.cancel();
                }
                principalAmount.setText("");
                rate.setText("");
                duration.setText("");
                resultText.setText("");
                resultText.setVisibility(View.INVISIBLE);
                adviceTextView.setText("");
                myToast = Toast.makeText(SimpleInterestActivity.this, "Items cleared", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

        shareSimpleResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSimpleAlertBox();

            }
        });
    }

    private void calculation() {

        resultText.setVisibility(View.VISIBLE);
        adviceTextView.setVisibility(View.VISIBLE);
        principal = Integer.parseInt(principalAmount.getText().toString());
        interestRate = Integer.parseInt(rate.getText().toString());
        time = Integer.parseInt(duration.getText().toString());
        amount = principal * interestRate * time / 100;
        if (amount >= principal) {
            resultText.setText("Total Amount = ₦" + String.valueOf(amount)
                    + "\n\nInterest Amount = ₦" + (amount - principal) + "\n");
            adviceTextView.setTextColor(this.getResources().getColor(R.color.white));
            adviceTextView.setText("The investment is worth a trial");

        } else {
            resultText.setText("Your total amount to be returned is ₦" + String.valueOf(amount)
                    + "\n\nYour loss is ₦" + (amount - principal) + "\n");
            adviceTextView.setTextColor(this.getResources().getColor(R.color.colorAccent));
            adviceTextView.setText("Please don\'t invest your money into this");
        }

    }

    private void openSimpleAlertBox() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("SHARE RESULT...");
        alertDialog.setMessage("Do you want to share this result?");
        alertDialog.setIcon(R.drawable.action_share_result);

        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                if (resultText.getText().toString().isEmpty() || adviceTextView.getText().toString().isEmpty()) {

                    myToast = Toast.makeText(SimpleInterestActivity.this, "Unable to share empty result",
                            Toast.LENGTH_LONG);
                    myToast.show();
                } else {

                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, resultText.getText().toString() + "\n\n"
                            + adviceTextView.getText().toString());
                    startActivity(Intent.createChooser(shareIntent, "Share via"));
                }

            }
        });

        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Share action aborted", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (item.getItemId()) {

            case R.id.action_settings:
                myToast = Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT);
                myToast.show();


        }

        return super.onOptionsItemSelected(item);
    }
}
