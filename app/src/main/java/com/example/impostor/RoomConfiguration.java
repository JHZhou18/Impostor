package com.example.impostor;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.impostor.adapters.PlayersNamesAdapter;

import java.util.ArrayList;
import java.util.List;

public class RoomConfiguration extends AppCompatActivity {

    private RecyclerView playersRecyclerView;
    private PlayersNamesAdapter playerAdapter;
    private List<String> playerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_room_configuration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Configuration), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Encontrar el RecyclerView
        playersRecyclerView = findViewById(R.id.rvPlayersNames);

        // 2. Crear y configurar el LayoutManager
        playersRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 3. Crear la lista inicial de jugadores (3 huecos)
        playerList = new ArrayList<>();
        playerList.add("");
        playerList.add("");
        playerList.add("");

        // 4. Crear y configurar el adaptador
        playerAdapter = new PlayersNamesAdapter(playerList);
        playersRecyclerView.setAdapter(playerAdapter);
    }
}
