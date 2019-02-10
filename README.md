# Le Voyage De La Fourmi
### Règles du jeu :

La fourmi de Langton est un automate cellullaire créé par C.Langton.

Les régles sont simples : sur un quadrillage de 7 par 8, des cellules sont initialement soit blanches 'b' soit noires 'n'

La fourmi démarre sur la case (5, 6) et regarde dans la direction (1, 0) (vers la droite du quadrillage):

A chaque pas, la fourmi se déplace selon les règles suivantes :

- si la fourmi est sur une case blanche, elle tourne à gauche (rotation antihoraire de 90°), la case devient noire
- si la fourmi est sur une case noire, elle tourne à droite (rotation horaire de 90°), la case devient orange ('o'),
- si la fourmi est sur une case orange, elle continu tout droit, la case devient blanche
- si la fourmi fait un mouvement qui devrait la faire sortir du quadrillage, elle fait demi-tour.

Le but du jeu est de donner la position de la fourmi après 61 pas sur la grille ci-dessous.
