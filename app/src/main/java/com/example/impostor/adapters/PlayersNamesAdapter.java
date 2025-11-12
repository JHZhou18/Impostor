package com.example.impostor.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.impostor.R;
import com.google.android.material.textfield.TextInputEditText;
import java.util.List;

public class PlayersNamesAdapter extends RecyclerView.Adapter<PlayersNamesAdapter.PlayerViewHolder> {

    private final List<String> playerList;

    public PlayersNamesAdapter(List<String> playerList) {
        this.playerList = playerList;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_player, parent, false);
        return new PlayerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        String playerName = playerList.get(position);
        holder.playerNameEditText.setText(playerName);
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    static class PlayerViewHolder extends RecyclerView.ViewHolder {
        TextInputEditText playerNameEditText;

        PlayerViewHolder(View view) {
            super(view);
            playerNameEditText = view.findViewById(R.id.etPlayerName);
        }
    }
}
