package im.unicolas.insertitem;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LeeQ on 2016-10-26.
 * Use :
 */

public class MainAdapter extends BaseAdapter {
    private static final String TAG = "MainAdapter";

    private Context context;
    private List<MainBean> data;
    private OnClickScanListener listener;

    public MainAdapter(@Nullable OnClickScanListener listener, List<MainBean> data, Context context) {
        this.listener = listener;
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewsHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.layout_add_child_awb, null);
            holder = new ViewsHolder();
            holder.initViews(convertView);
            convertView.setTag(holder);
        }else
            holder = (ViewsHolder) convertView.getTag();

        String content = data.get(position).getContent();
        Log.e(TAG, "getView: " + position + " -- " + data.size() + " -- " + content);

        holder.etContent.setText(content);

        holder.etContent.setFocusable(false);



        holder.ivScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onScan(position);
            }
        });

        return convertView;
    }

    private class ViewsHolder {
        EditText etContent;
        ImageView ivScan;

        public void initViews(View convertView) {
            etContent = (EditText) convertView.findViewById(R.id.fsearch_et_child_awb);
            ivScan = (ImageView) convertView.findViewById(R.id.fsearch_btn_scan);
        }
    }

    public interface OnClickScanListener {
        void onScan(int position);

        void onTextChange(EditText editText,int position,String change);
    }
}
