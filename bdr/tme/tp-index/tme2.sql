-- Compl�ter l'ent�te de ce fichier:

-- Pitton Oliver:
-- Metin Hakan :
-- Numéro de Binome:

-- Compte rendu du TME sur les index : compléter ce fichier
-- ==================================


-- Préparation :
-- création de la relation Annuaire
-- @annuaire


-- 2) Proposer une requete pour vérifier que la distribution de l'attribut 
--    age est uniforme.

select age, count(age) 
from annuaire 
group by age 
order by age;

-- Nous montre que la distribution de la table est quasiment uniforme


-- 3) Proposer une requete pour vérifier que les attributs age et prénom 
--    sont indépendants.

select age, count(distinct prenom) 
from annuaire 
group by age 
d  | Operation	  | Name     | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------
|   0 | SELECT STATEMENT  |	     |	6465 |	 176K|	  14   (0)| 00:00:01 |
|*  1 |  TABLE ACCESS FULL| ANNUAIRE |	6465 |	 176K|	  14   (0)| 00:00:01 |
------------------------------------------------------------------------------
d  | Operation	  | Name     | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------
|   0 | SELECT STATEMENT  |	     |	6465 |	 176K|	  14   (0)| 00:00:01 |
|*  1 |  TABLE ACCESS FULL| ANNUAIRE |	6465 |	 176K|	  14   (0)| 00:00:01 |
------------------------------------------------------------------------------
order by age;

-- permet de verifier pour un certain age le nombre de prenom distinct
-- select count(distinct prenom) from annuaire;
-- permet d obtenier le nombre total de prenom distinct

select prenom, count(distinct age) from annuaire group by prenom order by prenom;
permet de verifier pour un certain prenom le nombre de age distinct
select count(distinct age) from annuaire;
permet d obtenier le nombre total d age distinct

On voit bien qu il n y a pas tous les prenoms possible pour un certain age.
 Il n y a pas tous les ages possible pour un certain prenom.

-- 4) calculer puis vérifier la cardinalité des requetes suivantes:
-- ===============================================================

-- R1: select * from Annuaire; #(R1) = 10000
-- R2: select * from Annuaire where age < 65; #(R2) = 10000*65/100 =estim� 6500, r�sultat 6439
-- R3: select * from Annuaire where cp between 75000 and 78000; #(R3) = estim� 303.03, r�sultat 324 
-- R4: select * from Annuaire where age=18 and cp < 1200; #(R4) = estim� 0.2, r�sultat 1
-- R5: select * from Annuaire where age=18 and cp = 1200; #(R5) = estim� 0.1, r�sultat 0
-- R6: select count(*) from Annuaire where age < 65; #(R6) = 1



-- 5)
create index iage on annuaire(age);
create index icp on annuaire(cp);

alter session set optimizer_mode = rule;

-- 5.1) Pour chaque requete, afficher les index utilisés par le moteur de requete. 

	R1  ---

	R2  INDEX RANGE SCAN    | IAGE 

	R3  INDEX RANGE SCAN    | ICP 

	R4 1 |  TABLE ACCESS BY INDEX ROWID | ANNUAIRE |
	   2 |   INDEX RANGE SCAN	    | IAGE

	R5 1 |  TABLE ACCESS BY INDEX ROWID| ANNUAIRE |
	   2 |   AND-EQUAL		    |	       |
	   3 |    INDEX RANGE SCAN	    | IAGE     |
	   4 |    INDEX RANGE SCAN	    | ICP

	R6 1 |  SORT AGGREGATE   |	 |
	   2 |   INDEX RANGE SCAN| IAGE


-- En déduire les règles heuristiques que l'optimiseur utilise pour choisir un index.
l optimiseur utilise la taille de l espace des attributs comme heuristique si il existe un index sur les
attributs.
S'il y a une �galit� et une in�galit�, Oracle choisit en premier lieu l'�galit� s'il y a un index. 

-- @config_autotrace 
-- set autotrace trace explain stat
-- pour désactiver ce mode : set autotrace off

-- 5.2)

SELECT * FROM annuaire WHERE age < 200 AND cp > 10; 
Cette requ�te provoque 9871 consistent gets alors qu'elle est �quivalente � un SELECT * FROM Annuaire. Cette-derni�re ne provoque en revanche que 728 consistent gets. L'optimiseur n'est pas capable de d�terminer que ces requ�tes sont �quivalentes.

-- 6.1)

LOW_VALUE = Valeur la plus faible
HIGH_VALUE = Valeur la plus �lev�e
NUM_ROWS = Nombre de lignes
NUM_DISTINCT = Nombre de lignes distinctes.
BLOCKS = Nombre de blocs pris
INDEX_TYPE = Le type d'index utilis�

-- 6.2)

R1 : Aucun index n'est utilis�
R2 : Aucun index n'est utilis� 
R3 : Aucun index n'est utilis�
R4 : Oracle utilise 2 index pour traiter la requ�te et fait une jointure sur les r�sultats produits. Cette jointure est effectu�e directement avec les row id. L'optimiseur se base sur la s�lectivit� pour le mod�le de co�t, ce qui implique qu'il d�cide d'utiliser un index s'il juge que son utilisation sera meilleure que de parcourir directement les row id, apr�s une projection. Ici, puisque le nombre de valeurs de l'in�galit� est tr�s petites, puisque proche de la valeur minimale, il d�cide d'utiliser un index pour r�cup�rer celles-ci, et faire une jointure apr�s.
R5 : Identique � la requ�te pr�c�dente pour les m�mes raisons

-- 6.2.1�)

Oracle utilise le mod�le par cout pour choisir les index � utiliser. S'il consid�re que le gain apport� par l'index n'est pas optimal  face � la pure ex�cution de la requ�te, il utilise la requ�te sans index.

-- 6.2.2�) 

Non. Effectuer avec pr�cision le plan d'ex�cution pourrait prendre plus de temps que d'effectuer purement et simplement la requ�te. Le gain apport� par la g�n�ration de plan d'ex�cution optimis� peut �tre null si le temps perdu par une requ�te moins optimis�e est compens�e par une g�n�ration de plan d'ex�cution optimis�e. G�n�rer un meilleur plan n'est pas un r�el b�n�fice si le temps pour le g�n�rer est sup�rieur au gain qu'il apporte. Donc un plan extr�mement optimis�, impliquant des plans moins optimis�s, peut ne pas �tre si b�n�fique.

-- 6.3�)

La s�lectivit� est de 1 / 1000. Oracle utilise l'index sur cp � partir du moment o� cp vaut "1130".

La s�lectivit� est de 1 / 1000. Oracle utilise l'index sur cp � partir du moment o� cp vaut "1130" et l'index sur age � partir du moment o� age vaut 3.
