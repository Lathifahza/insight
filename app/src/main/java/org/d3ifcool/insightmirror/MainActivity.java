package org.d3ifcool.insightmirror;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Queue;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Room> data = new ArrayList<>();
        data.add(new Room("G1"));
        data.add(new Room("G2"));
        data.add(new Room("G3/Lab Elektronika"));
        data.add(new Room("G4/Lab PLC"));
        data.add(new Room("G5"));
        data.add(new Room("G6/Hotel 1"));
        data.add(new Room("G7/Hotel 2"));
        data.add(new Room("G8"));
        data.add(new Room("G9/Gear Lab"));
        data.add(new Room("G10/Pride Lab"));
        data.add(new Room("Lab Kitchen"));
        data.add(new Room("Lab Studio"));
        data.add(new Room("Lab Bahasa"));
        data.add(new Room("Ruang Dosen LB"));
        data.add(new Room("Layanan Akademik"));
        data.add(new Room("Aslab 1"));
        data.add(new Room("Aslab 2"));
        data.add(new Room("Toilet"));
        data.add(new Room("Lift"));

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new RoomAdapter(this, data));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, data.get(position).getmName() , Toast.LENGTH_SHORT).show();
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                JSONObject request = new JSONObject();
                try {
                    request.put("name", data.get(position).getmName());
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                            (Request.Method.POST, "http://1e6fb5f7.ngrok.io/setRoute", request, MainActivity.this, MainActivity.this);
                    queue.add(jsonObjectRequest);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onResponse(JSONObject response) {
        Intent intent = new Intent(MainActivity.this, PathActivity.class);
        startActivity(intent);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Gagal", Toast.LENGTH_SHORT).show();
    }
}
