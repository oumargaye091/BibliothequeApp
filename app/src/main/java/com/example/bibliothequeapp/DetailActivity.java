package com.example.bibliothequeapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    TextView tvTitre, tvAuteur, tvIsbn, tvDisponibilite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Activation du bouton retour
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Récupération des vues
        tvTitre = findViewById(R.id.tvTitre);
        tvAuteur = findViewById(R.id.tvAuteur);
        tvIsbn = findViewById(R.id.tvIsbn);
        tvDisponibilite = findViewById(R.id.tvDisponibilite);

        // Récupération de l'objet Livre
        Livre livre = (Livre) getIntent().getSerializableExtra("livre");

        if (livre != null) {
            tvTitre.setText(livre.getTitre());
            tvAuteur.setText(livre.getAuteur());
            tvIsbn.setText(livre.getIsbn());

            if (livre.isDisponible()) {
                tvDisponibilite.setText("✓ Disponible");
                tvDisponibilite.setBackgroundResource(R.drawable.badge_background);
                tvDisponibilite.setBackgroundTintList(
                        android.content.res.ColorStateList.valueOf(
                                android.graphics.Color.parseColor("#2E7D32")
                        )
                );
            } else {
                tvDisponibilite.setText("✗ Indisponible");
                tvDisponibilite.setBackgroundResource(R.drawable.badge_background);
                tvDisponibilite.setBackgroundTintList(
                        android.content.res.ColorStateList.valueOf(
                                android.graphics.Color.parseColor("#C62828")
                        )
                );
            }
        }
    }

    // Gestion du bouton retour dans la barre
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}