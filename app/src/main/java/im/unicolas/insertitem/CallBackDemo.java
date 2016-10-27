package im.unicolas.insertitem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CallBackDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_back_demo);

    }

    public void callback(View view) {
        double v = (Math.random() *10) +1;
        Toast.makeText(this, "" + v, Toast.LENGTH_SHORT).show();
        setResult(101, new Intent().putExtra("hh", v));
        finish();
    }
}
