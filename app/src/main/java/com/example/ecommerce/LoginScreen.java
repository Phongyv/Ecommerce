package com.example.ecommerce;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginScreen extends AppCompatActivity {
    Button btnlogin;
    private EditText editEmail,editPassword;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_screen);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        editEmail = findViewById(R.id.editTextText);
        editPassword = findViewById(R.id.editTextText2);
        btnlogin = findViewById(R.id.button_login);
        btnlogin.setOnClickListener(v -> loginUser());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void loginUser(){
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();
        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this,task -> {
                    if(task.isSuccessful()){
                        //login success
                        FirebaseUser user = mAuth.getCurrentUser();
                        saveUserData(user.getUid(), email,password);
                        SuccessToast.showSuccessToast(this,"Login Success");
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);

                    } else {
                        // login fail
                    }
                });
    }

    private void saveUserData(String userId,String email,String password){
        User user = new User(email,password);
        db.collection("users")
                .add(user)
                .addOnSuccessListener(aVoid -> {
                    //user data saved success
                })
                .addOnFailureListener(e -> {
                    //user data saved fail
                });
    }
}
