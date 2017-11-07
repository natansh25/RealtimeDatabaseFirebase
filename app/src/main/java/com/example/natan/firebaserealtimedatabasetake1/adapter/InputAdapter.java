package com.example.natan.firebaserealtimedatabasetake1.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.natan.firebaserealtimedatabasetake1.R;

import java.util.List;

/**
 * Created by natan on 11/6/2017.
 */

public class InputAdapter extends ArrayAdapter<Input> {





    public InputAdapter(@NonNull Context context, int resource, @NonNull List<Input> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.msgstyle, parent, false);
        }
        // findviewbyid of custom layout

        TextView name=convertView.findViewById(R.id.nameTextView);
        TextView msg=convertView.findViewById(R.id.messageTextView);

        Input message=getItem(position);

        name.setText(message.getName());
        msg.setText(message.getText());





        return convertView;
    }
}
