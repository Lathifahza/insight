package org.d3ifcool.insightmirror;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RoomAdapter extends ArrayAdapter<Room> {


    public RoomAdapter( @NonNull Context context, @NonNull List<Room> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Room currentRoom = getItem(position);

        TextView nameTextView = (TextView) convertView.findViewById(R.id.room_name);
        nameTextView.setText(currentRoom.getmName());

        return convertView;
    }
}
