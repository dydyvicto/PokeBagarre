package com.montaury.pokebagarre.metier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTests {
    @Test
    public void j1_gagne_avec_attaque_superieur() {
        // GIVEN
        Pokemon pokemon1 = new Pokemon("Joueur1", "oui", new Stats(200, 150));
        Pokemon pokemon2 = new Pokemon("Joueur2", "non", new Stats(199, 150));

        //WHEN
        boolean res1 = pokemon1.estVainqueurContre(pokemon2);
        boolean res2 = pokemon2.estVainqueurContre(pokemon1);

        //THEN
        Assertions.assertEquals(true, res1);
        Assertions.assertEquals(false, res2);
    }

    @Test
    public void j2_gagne_avec_attaque_superieur() {
        // GIVEN
        Pokemon pokemon1 = new Pokemon("Joueur1", "oui", new Stats(200, 150));
        Pokemon pokemon2 = new Pokemon("Joueur2", "non", new Stats(201, 150));

        //WHEN
        boolean res1 = pokemon1.estVainqueurContre(pokemon2);
        boolean res2 = pokemon2.estVainqueurContre(pokemon1);

        //THEN
        Assertions.assertEquals(false, res1);
        Assertions.assertEquals(true, res2);
    }

    @Test
    public void j1_gagne_avec_defense_superieur_car_meme_attaque() {
        // GIVEN
        Pokemon pokemon1 = new Pokemon("Joueur1", "oui", new Stats(200, 151));
        Pokemon pokemon2 = new Pokemon("Joueur2", "non", new Stats(200, 150));

        //WHEN
        boolean res1 = pokemon1.estVainqueurContre(pokemon2);
        boolean res2 = pokemon2.estVainqueurContre(pokemon1);

        //THEN
        Assertions.assertEquals(true, res1);
        Assertions.assertEquals(false, res2);
    }

    @Test
    public void j2_gagne_avec_defense_superieur_car_meme_attaque() {
        // GIVEN
        Pokemon pokemon1 = new Pokemon("Joueur1", "oui", new Stats(200, 149));
        Pokemon pokemon2 = new Pokemon("Joueur2", "non", new Stats(200, 150));

        //WHEN
        boolean res1 = pokemon1.estVainqueurContre(pokemon2);
        boolean res2 = pokemon2.estVainqueurContre(pokemon1);

        //THEN
        Assertions.assertEquals(false, res1);
        Assertions.assertEquals(true, res2);
    }

    @Test
    public void meme_stats_donc_j1_gagne() {
        // GIVEN
        Pokemon pokemon1 = new Pokemon("Joueur1", "oui", new Stats(200, 150));
        Pokemon pokemon2 = new Pokemon("Joueur2", "non", new Stats(200, 150));

        //WHEN
        boolean res1 = pokemon1.estVainqueurContre(pokemon2);
        boolean res2 = pokemon2.estVainqueurContre(pokemon1);

        //THEN
        Assertions.assertEquals(true, res1);
        Assertions.assertEquals(true, res2);
    }
}