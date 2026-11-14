# CLAUDE.md — valkn-mockbukkit

Le fork de MockBukkit pour Valkn : ce que les tests de la stack demandent à MockBukkit et qu'il n'implémente pas encore.
Java 25, le style et les conventions de MockBukkit (tabulations, accolades à la ligne, tests JUnit 5 avec
`MockBukkitExtension`). Code, javadoc et commits en anglais ; ce fichier en français.

## Commandes

./gradlew :compileJava :test --tests '…' (le sous-projet `metaminer` demande paperweight : ne pas le lancer pour rien)
Depuis le workspace : les dépôts qui testent sur MockBukkit le prennent depuis ses sources (composite, `valkn.sources`).

## Règles

- On travaille sur `valkn/v26.3`, partie de `minecraft/v26.3`, la branche de MockBukkit, gardée telle quelle pour suivre
  l'amont : une mise à jour de MockBukkit arrive sur `minecraft/v26.3`, puis `valkn/v26.3` est rebasée dessus.
- Chaque ajout est écrit pour pouvoir être proposé à MockBukkit : un commit par ajout, avec ses tests, dans leur style.
  Ce qui n'est propre qu'à Valkn (ce fichier, `.valkn-module`, le nom du projet en minuscules, la publication sur le
  registre) tient dans les commits `chore:` du fork, à replier en un seul au prochain rebase sur l'amont.
- Le fork se publie sur le registre de Valkn (valkn-workspace ADR 0007) sous `studio.valkn.mockbukkit:mockbukkit-v26.3`,
  jamais sous `org.mockbukkit` : un tag `v26.3-valkn.<n>` sur `valkn/v26.3` publie `26.3-valkn.<n>` (workflow
  `valkn-publish.yml`) ; le catalogue de valkn-gradle-plugin épingle cette version.
- Les commits sont ceux de l'utilisateur : auteur `Traqueur_ <traqueur.dev@gmail.com>`, messages courts au format de
  l'amont (`feat: …`, `fix: …`, `chore: …`), sans ligne `Co-Authored-By` ni lien de session.
- Une méthode implémentée suit Paper (ses évènements, ses valeurs par défaut) ; ce que MockBukkit ne peut pas simuler
  (le déplacement réel d'un pathfinder) est enregistré et exposé au test, jamais inventé.
