package com.example.a24270.morelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<morelayout> MorelayoutList=new ArrayList<>();
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setnews();
        Button button=(Button) findViewById(R.id.send);
        editText = (EditText) findViewById(R.id.input_message);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        String inputText = editText.getText().toString();
                        Toast.makeText(MainActivity.this,inputText,Toast.LENGTH_SHORT).show();
                }
            }
        );

        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);//将实例存于recyclerview中;
        MAdapter adapter= new MAdapter(MorelayoutList);
        recyclerView.setAdapter(adapter);

    }
    private void setnews(){
        for(int i=0;i<5;i++){
            morelayout n1=new morelayout("特朗普宣布：美国对叙利亚实施精准打击",R.drawable.mg);
            MorelayoutList.add(n1);
        }

}}