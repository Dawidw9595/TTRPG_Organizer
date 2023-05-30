package com.example.rollapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rollapp.R;
import com.example.rollapp.retrofit.userApi;
import com.example.rollapp.model.user;
import com.example.rollapp.retrofit.retrofitservice;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class informacjegracza extends AppCompatActivity {


    private TextView imieTextView;
    private TextView nickTextView;
    private TextView postacieTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacjegracza);

        imieTextView = findViewById(R.id.imieTextView);
        nickTextView = findViewById(R.id.nickTextView);
        postacieTextView = findViewById(R.id.postacieTextView);

        int userId = getIntent().getIntExtra("userId", 0);
        if (userId != 0) {
            getUserInfoFromApi(userId);
        }
    }

    private void getUserInfoFromApi(int userId) {
        userApi userApi = retrofitservice.getRetrofit().create(userApi.class);

        Call<user> userCall = userApi.getuserInfo(userId);
        userCall.enqueue(new Callback<user>() {
            @Override
            public void onResponse(Call<user> call, Response<user> response) {
                if (response.isSuccessful()) {
                    user user = response.body();
                    if (user != null) {
                        getUserCharactersFromApi(user);
                    }
                } else {
                    // Handle error
                }
            }

            @Override
            public void onFailure(Call<user> call, Throwable t) {
                // Handle failure
            }
        });
    }

    private void getUserCharactersFromApi(user user) {
        userApi userApi = retrofitservice.getRetrofit().create(userApi.class);

        Call<List<String>> charactersCall = userApi.getuserCharacters(user.getId());
        charactersCall.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.isSuccessful()) {
                    List<String> characters = response.body();
                    if (characters != null) {
                        displayUserInfo(user.getImie(), user.getNick(), characters);
                    }
                }  // Handle error

            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                // Handle failure
            }
        });
    }

    private void displayUserInfo(String imie, String nick, List<String> postacie) {
        imieTextView.setText(imie);
        nickTextView.setText(nick);

        StringBuilder postacieBuilder = new StringBuilder();
        for (String postac : postacie) {
            postacieBuilder.append(postac).append("\n");
        }
        postacieTextView.setText(postacieBuilder.toString());
    }
}
