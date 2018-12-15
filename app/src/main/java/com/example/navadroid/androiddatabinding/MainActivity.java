package com.example.navadroid.androiddatabinding;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.TextView;

import com.example.navadroid.androiddatabinding.databinding.ActivityMainBindingImpl;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    public DatabaseReference nameCard;
    private MainViewModel viewModel;

    // TODO Step 1: Declare binding instance instead view's (binding class is auto-generated)
    //private TextView textView;
    ActivityMainBindingImpl binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //get firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        nameCard = database.getReference();

        nameCard.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map =(Map)dataSnapshot.getValue();
                String name = String.valueOf(map.get("name"));
                viewModel.setName(name);
                binding.kri.setText(viewModel.getName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void initView(){
        viewModel = new MainViewModel();


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewmodel(viewModel);

    }

    public void click(View view) {
       int current=parseInt(viewModel.getString(),10);
        current++;
        String strCurrent= String.valueOf(current);

        viewModel.setString(strCurrent);
        binding.textView2.setText(viewModel.getString());
    }


}
