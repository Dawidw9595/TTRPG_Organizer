package com.example.rollapp;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class IGracza extends Activity {

    private informacjegracza informacjegracza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacjegracza);

        informacjegracza = new informacjegracza(this);

        // Pobranie informacji o graczu
        List<String> informacjeGracza = informacjegracza.getInformacjeGracza();

        // Pobranie postaci gracza
        List<String> postacieGracza = informacjegracza.getPostacieGracza();

        // Wyświetlanie informacji o graczu
        TextView textViewImie = findViewById(R.id.textViewImie);
        TextView textViewNick = findViewById(R.id.textViewNick);
        textViewImie.setText(informacjeGracza.get(0));
        textViewNick.setText(informacjeGracza.get(1));

        // Wyświetlanie postaci gracza w ListView
        ListView listViewPostacie = findViewById(R.id.listViewPostacie);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, postacieGracza);
        listViewPostacie.setAdapter(adapter);
    }
}
