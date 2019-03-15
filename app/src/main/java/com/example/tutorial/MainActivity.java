package com.example.tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 =(Button) findViewById(R.id.button4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
                Call<List<Tracks>> call = gitHubService.mistracks();

                call.enqueue(new Callback<List<Tracks>>() {
                    @Override
                    public void onResponse(Call<List<Tracks>> call, Response<List<Tracks>> response) {
                        final TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText(response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<List<Tracks>> call, Throwable t) {
                        final TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Something went wrong: " + t.getMessage());
                    }
                });
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
                Call<Tracks> call = gitHubService.Hola("xd217779302");

                call.enqueue(new Callback<Tracks>() {
                    @Override
                    public void onResponse(Call<Tracks> call, Response<Tracks> response) {
                        final TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText(response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<Tracks> call, Throwable t) {
                        final TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Something went wrong: " + t.getMessage());
                    }
                });
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
                Tracks tracks = new Tracks("La balada del boli", "La señora Marta");
                Call<Tracks> call = gitHubService.añadirunacancion(tracks);


                call.enqueue(new Callback<Tracks>() {
                    @Override
                    public void onResponse(Call<Tracks> call, Response<Tracks> response) {
                        final TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText(response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<Tracks> call, Throwable t) {
                        final TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Something went wrong: " + t.getMessage());
                    }
                });


            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
                Call<Tracks> call = gitHubService.deleteTrack("Jefazo");

                call.enqueue(new Callback<Tracks>() {

                    @Override
                    public void onResponse(Call<Tracks> call, Response<Tracks> response) {
                        final TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText(response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<Tracks> call, Throwable t) {
                        final TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Something went wrong: " + t.getMessage());
                    }
                });
            }
        });


    }

}
