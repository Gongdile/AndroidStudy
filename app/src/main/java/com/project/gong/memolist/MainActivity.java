package com.project.gong.memolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView myListView;
    DBHelper mydb;
    ArrayAdapter mAdapter;
    Button btnbackup;
    Button btnbok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnbackup =findViewById(R.id.btnbackup);
        //pref로 null일 경우에 체크를해서 토큰발급하는 경우를 해주기..

        //token = pref.getString("token",null)
        //토큰을 가져와서 발생시키는걸 아까 한 코드처럼 넣어주면딤!!!

        btnbackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        btnbok=findViewById(R.id.btnbok);

        mydb = new DBHelper(this);
        ArrayList array_list = mydb.getAllMemos();

        mAdapter =
                new ArrayAdapter(this, android.R.layout.simple_list_item_1, array_list);

        myListView = (ListView) findViewById(R.id.listView1);
        myListView.setAdapter(mAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                int id = arg2 + 1;
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", id);
                Intent intent = new Intent(getApplicationContext(),com.project.gong.memolist.Display_Memo.class);
                intent.putExtras(dataBundle);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.clear();
        mAdapter.addAll(mydb.getAllMemos());
        mAdapter.notifyDataSetChanged();
    }

    public void onClick(View target) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", 0);
        Intent intent = new Intent(getApplicationContext(),com.project.gong.memolist.Display_Memo.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }



}
