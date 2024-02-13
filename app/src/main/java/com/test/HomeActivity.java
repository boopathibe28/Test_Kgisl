package com.test;

import static com.test.library.MainActivity.showCustomErrorToast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.test.databinding.ActivityMainBinding;
import com.test.library.MainActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        binding.txtOpenLib.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == binding.txtOpenLib){
            if (binding.edtFirstName.getText().toString().trim().isEmpty()) {
                MainActivity.firstName(this, binding.edtFirstName.getText().toString().trim());
            }
            else if (binding.edtLastName.getText().toString().trim().isEmpty()){
                MainActivity.lastName(this, binding.edtLastName.getText().toString().trim());
            }
            else if (binding.edtMobileNumber.getText().toString().trim().isEmpty() || binding.edtMobileNumber.getText().toString().trim().length() < 10){
                MainActivity.mobileNo(this, binding.edtMobileNumber.getText().toString().trim());
            }
            else if (!MainActivity.isValidEmail(binding.edtEmailID.getText().toString().trim())){
                MainActivity.emailID(this, binding.edtEmailID.getText().toString().trim());
            }
            else {
                MainActivity.successResponce(this);
            }
        }
    }



}