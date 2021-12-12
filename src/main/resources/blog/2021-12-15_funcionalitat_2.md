---
writer: lluisgenoher
coder: lluisgenoher
---
# Funcionalitat 2

Escriu aquí el post de la funcionalitat descrita a l'enunciat.
No canviïs el nom del fitxer ni el títol del post.

## Que afegeixes?

Què necessites per començar? Quina acció fas? Quin resultat trobes?

 * Given that "leonard" is playing.
 * Go to the next player "leonard"
 <!-- SNAPSHOT status=200 -->

Si el test comença de 0 asssegurar que existeix

 * Go to the "leonard" "ship" "Beagle"
 * Go to the contained "deck" "Builder".
 * Build the "Potato store".
 <!-- SNAPSHOT status=200 -->
 
Posar un cost: ex, 2 steel

  * Given that the "leonard" "city" "Capital" has resource "steel" count 2.

Afegir el leveledComponent al Potato store

  * Go to the contained "deck" "Potato store".
  * The _level_ number should be 1.

Crear el PotatoStoreUpgrader

  * The resource modifier for "potato" maximum should be 5.
  * Upgrade the level.
  <!-- SNAPSHOT status=200 -->
  * The _level_ number should be 2.

  * The resource modifier for "potato" maximum should be 10.
  * Go back to the previous screen.
  * The resource "potato" maximum should be 10.
  * The dock resource "steel" count should be 0.
