package th.ac.su.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clearButton = findViewById(R.id.button_Clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textDistance = findViewById(R.id.editTextDistane);
                EditText textTime = findViewById(R.id.editTextTime);
                TextView textresulf = findViewById(R.id.textView_Resulf);
                textDistance.setText("");
                textTime.setText("");
                textresulf.setText("");
            }
        });

        Button calButton = findViewById(R.id.button_Cal);
        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textDistance = findViewById(R.id.editTextDistane);
                String distance = textDistance.getText().toString();
                double distanceVar = Double.parseDouble(distance);

                EditText textTime = findViewById(R.id.editTextTime);
                String time = textTime.getText().toString();
                double timeVar = Double.parseDouble(time);

                TextView textResulf = findViewById(R.id.textView_Resulf);

                if(distance.length() == 0 || time.length() == 0){
                    Toast t = Toast.makeText(MainActivity.this, R.string.toastNull,Toast.LENGTH_LONG);
                    t.show();
                }
                else if(distance.length() > 0 && time.length() > 0){
                    if(time.equals("0")){
                        Toast t = Toast.makeText(MainActivity.this, R.string.toastZero,Toast.LENGTH_LONG);
                        t.show();
                    }
                    else{
                        double resulf = (distanceVar/1000)/(timeVar/3600);
                        String strResulf = String.format(Locale.getDefault(), "%.2f", resulf);

                        textResulf.setText(strResulf);

                        if(resulf >= 80){
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("SPEED CALCULATOR");
                            dialog.setMessage(R.string.msgDialog);
                            dialog.setNegativeButton("OK", null);
                            dialog.show();

                        }
                    }
                }
            }
        });
    }
}