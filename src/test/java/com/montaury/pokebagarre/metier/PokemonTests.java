package com.montaury.pokebagarre.metier;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTests {
    @Test
    public void j1_gagne_avec_attaque_superieur() {
        // GIVEN
        Pokemon pokemon1 = new Pokemon("Joueur1", "oui", new Stats(200, 150));
        Pokemon pokemon2 = new Pokemon("Joueur2", "non", new Stats(199, 150));

        var res = pokemon1.estVainqueurContre(pokemon2);

        //THEN
        assertThat(res).isTrue();
        ;
    }

    @Test
    public void j2_gagne_avec_attaque_superieur() {
        // GIVEN
        Pokemon pokemon1 = new Pokemon("Joueur1", "oui", new Stats(200, 150));
        Pokemon pokemon2 = new Pokemon("Joueur2", "non", new Stats(201, 150));

        //WHEN
        var res = pokemon2.estVainqueurContre(pokemon1);

        //THEN
        Assertions.assertThat(res).isTrue();
    }

    @Test
    public void j1_gagne_avec_defense_superieur_car_meme_attaque() {
        // GIVEN
        Pokemon pokemon1 = new Pokemon("Joueur1", "oui", new Stats(200, 151));
        Pokemon pokemon2 = new Pokemon("Joueur2", "non", new Stats(200, 150));

        //WHEN
        var res = pokemon1.estVainqueurContre(pokemon2);

        //THEN
        Assertions.assertThat(res).isTrue();
    }

    @Test
    public void j2_gagne_avec_defense_superieur_car_meme_attaque() {
        // GIVEN
        Pokemon pokemon1 = new Pokemon("Joueur1", "oui", new Stats(200, 149));
        Pokemon pokemon2 = new Pokemon("Joueur2", "non", new Stats(200, 150));

        //WHEN
        var res = pokemon2.estVainqueurContre(pokemon1);

        //THEN
        Assertions.assertThat(res).isTrue();
    }

    @Test
    public void meme_stats_donc_j1_gagne() {
        // GIVEN
        Pokemon pokemon1 = new Pokemon("Joueur1", "oui", new Stats(200, 150));
        Pokemon pokemon2 = new Pokemon("Joueur2", "non", new Stats(200, 150));

        //WHEN
        boolean res = pokemon1.estVainqueurContre(pokemon2);

        //THEN
        Assertions.assertThat(res).isTrue();
    }
}