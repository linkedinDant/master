package tp3.exo1.collection;

import java.util.Arrays;


public interface IList {

  /**
   * Retourne vrai si la liste est vide.
   * @return vrai si la liste est vide.
   */
  public boolean isEmpty();

  /**
   * Retourne le nombre d'éléments de la liste
   * @return le nombre d'éléments de la liste
   */
  public int size(); 

  /**
   * Ajoute l'élément spécifié dans la liste.
   * @param ob L'objet à ajouter
   * @return l'instance appelante
   */
  public IList add(Object ob);

  /**
   * Retourne l'objet à la position spécifiée.
   * @param pos Une position
   * @return L'objet à la position spécifiée
   */
  public Object get(int pos);

  /**
   * Vide la liste de tous les éléments
   */
  public void clear();
  
  /**
   * Ajoute l'élément spécifié à la position spécifiée dans la liste.
   * Cette méthode décale tous les éléments situés après la position spécifiée
   * pour ajouter l'objet en paramètre.
   * @param pos La position à laquelle ajouter l'objet
   * @param ob L'objet à ajouter
   * @return l'instance appelante
   */
  public IList add(int pos, Object ob);

  /**
   * Supprime l'objet à la position spécifiée et le retourne.
   * Cette méthode décale tous les éléments situés après la position spécifiée
   * pour supprimer l'objet dont la position est spécifiée.
   * @param pos La position de l'objet à supprimer
   * @return L'objet supprimé
   */
  public Object remove(int pos);

  /**
   * Supprime l'objet spécifié en paramètre.
   * @param ob L'objet à supprimer
   * @return vrai si l'objet a été supprimé, faux sinon
   */
  public boolean remove(Object ob);

  /**
   * Modifie l'objet situé à la position spécifiée par l'objet spécifié.
   * @param pos La position où modifier l'objet
   * @param ob L'objet remplaçant
   * @return l'instance appelante
   */
  public IList set(int pos, Object ob);

  /**
   * Ajoute l'ensemble des objets de la liste spécifiée dans l'instance appelante.
   * @param a La liste
   * @return l'instance appelante
   */
  public IList addAll(IList a);
  
  /**
   * Retourne une copie des éléments de l'instance appelante.
   * @see Arrays#copyOfRange(Object[], int, int)
   * @return la copie des éléments
   */
  public Object[] toArray();

  /**
   * Retourne une sous liste des éléments compris entre pos inclus et end exclus.
   * Exemple : Si une liste contient [1, 2, 3, 4], un appel à subList(1, 3) renverra
   * [2, 3]
   * @param from La position d'où commencer
   * @param end La position d'où s'arrêter
   * @return La sous liste
   */
  public IList subList(int from, int end);

  /**
   * Retourne l'indice en partant du début dans la liste de l'objet spécifié, ou -1 s'il n'existe pas.
   * @param ob L'objet recherché
   * @return l'indice dans la liste de l'objet spécifié, ou -1 s'il n'existe pas.
   */
  public int indexOf(Object ob);

  /**
   * Retourne l'indice en parant de la fin dans la liste de l'objet spécifié, ou -1 s'il n'existe pas.
   * @param ob L'objet recherché
   * @return l'indice dans la liste de l'objet spécifié, ou -1 s'il n'existe pas.
   */
  public int lastIndexOf(Object ob);

  /**
   * Retourne vrai si l'objet spécifié est contenu dans la liste, faux sinon.
   * @param ob Un objet dont on cherche à savoir s'il est contenu dans la liste
   * @return vrai si l'objet spécifié est contenu dans la liste, faux sinon.
   */
  public boolean contains(Object ob);

}
