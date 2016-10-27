package im.unicolas.insertitem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainAdapter.OnClickScanListener, AdapterView.OnItemClickListener {
    private static final String TAG = "MainActivity";

    private ListView mListView;
    private List<MainBean> data = new ArrayList<>();
    private MainAdapter mAdapter;
    private int mPosition = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.main_list_view);

        mAdapter = new MainAdapter(this, data, this);
        mListView.setAdapter(mAdapter);

        View bottom = LayoutInflater.from(this).inflate(R.layout.bottom_layout, null);
        mListView.addFooterView(bottom);

        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onScan(int position) {
        mPosition = position;
        Log.e(TAG, "onScan: " + position);
        startActivityForResult(new Intent(this, CallBackDemo.class), 100);
    }

    @Override
    public void onTextChange(EditText editText, int position, String change) {
        Object tag = editText.getTag();
        int tag1 = (int) tag;
        if (tag1 == position) {
            data.get(position).setContent(change);
            Log.e(TAG, "onTextChange: " + position + " -- " + data.get(position).getContent());
        }
        mPosition = position;
        Log.e(TAG, "onTextChange: " + mPosition + " -- " + tag1 + " -- " + data.size() + " -- " );
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (data.size() >= 2) {
            Log.e(TAG, "onItemClick: BEFORE " + data.size() + " -- " + data.get(1).getContent());
        }

        if (position == data.size()) {
            data.add(new MainBean());
            mAdapter.notifyDataSetChanged();
        }
        if (data.size() >= 2) {
            Log.e(TAG, "onItemClick: AFTER " + data.size() + " -- " + data.get(1).getContent());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            if (resultCode == 101) {
                double hh = data.getDoubleExtra("hh", -1);
                String s = hh + "";
                this.data.get(mPosition).setContent(s);
                Log.e(TAG, "onActivityResult: " + mPosition + " -- " + this.data.size() + " -- " + s);
                mAdapter.notifyDataSetChanged();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
