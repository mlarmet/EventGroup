package eventgroup.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description de l'interface GestionEvenements.
 */

public interface GestionEvenements {
  /** Description membres de l'association. */
  static final Set<Membre> MEMBRES = new HashSet<>();
  /** Description evenements de l'association. */
  static final Map<Evenement, Set<Membre>> GESTION_EVENEMENTS = new HashMap<>();

  /**
   * Ajoute un membre a l'association.
   *
   * @param nom nom du membre
   * @param prenom prenom du membre
   * @param adresseMail adresse email du membre
   * @param pseudo pseudo du membre
   * @param motDePasse mot de passe du membre
   * @param villeDeResidence adresse du membre
   * @param dateNaissance date de naissance du membre
   * @param lieuNaissance lieu de naissance du membre
   * @return 0 si au moins un des arguments est incorrect, -1 si le pseudo est deja utilise ou si le
   *         membre existe deja, 1 si l'ajout est fait
   */
  static int ajouterMembre(String nom, String prenom, String adresseMail, String pseudo,
      String motDePasse, String villeDeResidence, Date dateNaissance, String lieuNaissance) {

    Membre membre = new Membre(null, null, null, null, null, null, null, null);
    if (membre.setNom(nom) == -1 || membre.setPrenom(prenom) == -1
        || membre.setAdresseMail(adresseMail) == -1 || membre.setPseudo(pseudo) == -1
        || membre.setMotDePasse(motDePasse) == -1
        || membre.setVilleDeResidence(villeDeResidence) == -1
        || membre.setDateNaissance(dateNaissance) == -1
        || membre.setLieuNaissance(lieuNaissance) == -1) {
      return 0;
    }

    if (modifierPseudoMembre(membre, pseudo) == 1) {
      MEMBRES.add(membre);
      return 1;
    }
    return -1;
  }

  static Set<Membre> getMembres() {
    return MEMBRES;
  }

  /**
   * Recupere un membre.
   *
   * @param pseudo pseudo du membre
   * @return null s'il n'y a pas de membre ayant ce pseudo, le membre si il existe
   */
  static Membre getMembre(String pseudo) {
    for (Membre m : MEMBRES) {
      if (m.getPseudo().equals(pseudo)) {
        return m;
      }
    }
    return null;
  }

  /**
   * Ajoute un evenement a l'association.
   *
   * @param nom nom de l'evenement
   * @param descriptif description de l'evenement
   * @param image image de profil de l'evenement
   * @param dateHoraire date et horaire de l'evenement
   * @param nomLieu nom du lieu de l'evenement
   * @param descriptionLieu description du lieu de l'evenement
   * @param lienLieu lien google du lieu de l'evenement
   * @param type type de l'evenement
   * @param nombreMaxPersonne nombre maximum de personnes dans l'evenement
   * @return 0 si au moins un des arguments est incorrect, -1 si le nom est deja utilise ou si
   *         l'evenement existe deja, 1 si l'ajout est fait
   */
  static int ajouterEvenement(String nom, String descriptif, String image,
      LocalDateTime dateHoraire, String nomLieu, String descriptionLieu, String lienLieu,
      TypeEvenement type, int nombreMaxPersonne) {
    Evenement evenement =
        new Evenement(null, null, null, null, new Lieu(null, null, null), null, 0);
    if (evenement.setNom(nom) == -1 || evenement.setDescriptif(descriptif) == -1
        || evenement.setImage(image) == -1 || evenement.setDateHoraire(dateHoraire) == -1
        || evenement.setNomLieu(nomLieu) == -1 || evenement.setDescriptifLieu(descriptionLieu) == -1
        || evenement.setLienLieu(lienLieu) == -1 || evenement.setType(type) == -1
        || evenement.setNombreMaxPersonne(nombreMaxPersonne) == -1) {
      return 0;
    }

    if (modifierNomEvenement(evenement, nom) == 1) {
      GESTION_EVENEMENTS.put(evenement, new HashSet<>());
      return 1;
    }
    return -1;
  }
  
  /**
   * Ajoute un evenement a l'association.
   *
   * @param evenement evenement a ajouter
   * @return -1 si le nom est deja utilise ou si l'evenement existe deja, 1 si l'ajout est fait
   */
  static int ajouterEvenement(Evenement evenement) {
    for (Evenement e : GESTION_EVENEMENTS.keySet()) {
      if (e.getNom().equals(evenement.getNom())) {
        return -1;
      }
    }
    GESTION_EVENEMENTS.put(evenement, new HashSet<>());
    return 1;
  }

  static Set<Evenement> getEvenements() {
    return GESTION_EVENEMENTS.keySet();
  }

  static Set<Membre> getMembresEvenement(Evenement evenement) {
    return GESTION_EVENEMENTS.get(evenement);
  }

  /**
   * Recupere les evenements auxquels participe un membre.
   *
   * @param membre membre de l'association
   * @return ensemble vide "{}" si le membre ne participe a aucun evenement, un ensemble contenant
   *         un ou plusieurs evenements sinon
   */
  static Set<Evenement> getEvenementsMembre(Membre membre) {
    Set<Evenement> evenements = new HashSet<>();
    for (Evenement e : GESTION_EVENEMENTS.keySet()) {
      if (GESTION_EVENEMENTS.get(e).contains(membre)) {
        evenements.add(e);
      }
    }
    return evenements;
  }

  /**
   * Recupere un evenement.
   *
   * @param nom nom de l'evenement
   * @return null si l'evenement n'existe pas, l'evenement si il existe
   */
  static Evenement getEvenement(String nom) {
    for (Evenement e : GESTION_EVENEMENTS.keySet()) {
      if (e.getNom().equals(nom)) {
        return e;
      }
    }
    return null;
  }

  /**
   * Ajoute un membre a un evenement.
   *
   * @param evenement evenement auquel on ajoute un membre
   * @param membre membre a ajouter a l'evenement
   * @return false si le membre fait deja partie de l'evenement, true si l'ajout est fait
   */
  static boolean ajouterMembreEvenement(Evenement evenement, Membre membre) {
    return GESTION_EVENEMENTS.get(evenement).add(membre);
  }

  /**
   * Supprime un membre de l'association y compris dans chaque evenement auquel il a ete ajoute.
   *
   * @param membre membre a supprimer de l'association
   * @return false si le membre n'existe pas, true si la supression est faite
   */
  static boolean supprimerMembre(Membre membre) {
    if (MEMBRES.remove(membre)) {
      for (Evenement evenement : GESTION_EVENEMENTS.keySet()) {
        GESTION_EVENEMENTS.get(evenement).remove(membre);
      }
      return true;
    }

    return false;
  }

  /**
   * Supprime un evenement de l'association.
   *
   * @param evenement evenement a supprimer
   * @return false si le membre n'existe pas, true si la supression est faite
   */
  static boolean supprimerEvenement(Evenement evenement) {
    return GESTION_EVENEMENTS.keySet().remove(evenement);
  }

  /**
   * Supprime un membre d'un evenement.
   *
   * @param evenement evenement duquel on supprime un membre
   * @param membre membre a supprimer de l'evenement
   * @return false si le membre ne fait pas partie de l'evenement, true si la suppression est faite
   */
  static boolean supprimerMembreEvenement(Evenement evenement, Membre membre) {
    return GESTION_EVENEMENTS.get(evenement).remove(membre);
  }

  /**
   * Modifie le nom d'un membre.
   *
   * @param membre membre a modifier
   * @param nom nouveau nom du membre
   * @return false si le nouveau nom n'est pas correct (null ou vide), true si la modification est
   *         faite
   */
  static boolean modifierNomMembre(Membre membre, String nom) {
    return membre.setNom(nom) == 1;
  }

  /**
   * Modifie le prenom d'un membre.
   *
   * @param membre membre a modifier
   * @param prenom nouveau prenom du membre
   * @return false si le nouveau prenom n'est pas correct (null ou vide), true si la modification
   *         est faite
   */
  static boolean modifierPrenomMembre(Membre membre, String prenom) {
    return membre.setPrenom(prenom) == 1;
  }

  /**
   * Modifie l'adresse mail d'un membre.
   *
   * @param membre membre a modifier
   * @param adresseMail nouvelle adresse mail du membre
   * @return false si la nouvelle adresse mail n'est pas correcte (nulle ou vide), true si la
   *         modification est faite
   */
  static boolean modifierAdresseMailMembre(Membre membre, String adresseMail) {
    return membre.setAdresseMail(adresseMail) == 1;
  }

  /**
   * Modifie le pseudo d'un membre.
   *
   * @param membre membre a modifier
   * @param pseudo nouveau pseudo du membre
   * @return 0 si le pseudo est deja utilise, -1 si le pseudo n'est pas correct, 1 si la
   *         modification est faite
   */
  static int modifierPseudoMembre(Membre membre, String pseudo) {
    if (pseudo == null || pseudo.trim().isEmpty() || pseudo.isEmpty()) {
      return -1;
    }

    for (Membre m : MEMBRES) {
      if (m.getPseudo().equals(pseudo)) {
        return 0;
      }
    }
    return membre.setPseudo(pseudo);
  }

  /**
   * Modifie le mot de passe d'un membre.
   *
   * @param membre membre a modifier
   * @param motDePasse nouveau mot de passe du membre
   * @return false si le nouveau mot de passe n'est pas correct (null ou vide), true si la
   *         modification est faite
   */
  static boolean modifierMotDePasseMembre(Membre membre, String motDePasse) {
    return membre.setMotDePasse(motDePasse) == 1;
  }

  /**
   * Modifie la ville de residence d'un membre.
   *
   * @param membre membre a modifier
   * @param villeDeResidence nouvelle ville de residence du membre
   * @return false si la nouvelle ville n'est pas correcte (nulle ou vide), true si la modification
   *         est faite
   */
  static boolean modifierVilleDeResidenceMembre(Membre membre, String villeDeResidence) {
    return membre.setVilleDeResidence(villeDeResidence) == 1;
  }

  /**
   * Modifie la date de naissance d'un membre.
   *
   * @param membre membre a modifier
   * @param dateNaissance nouvelle date de naissance du membre
   * @return false si la nouvelle date n'est pas correcte (nulle ou superieure a la date courrante),
   *         true si la modification est faite
   */
  static boolean modifierDateNaissanceMembre(Membre membre, Date dateNaissance) {
    return membre.setDateNaissance(dateNaissance) == 1;
  }

  /**
   * Modifie le lieu de naissance d'un membre.
   *
   * @param membre membre a modifier
   * @param lieuNaissance nouveau lieu de naissance du membre
   * @return false si le nouveau lieu de naissance n'est pas correct (null ou vide), true si la
   *         modification est faite
   */
  static boolean modifierLieuNaissanceMembre(Membre membre, String lieuNaissance) {
    return membre.setLieuNaissance(lieuNaissance) == 1;
  }

  /**
   * Modifie le nom d'un evenement.
   *
   * @param evenement evenement a modifier
   * @param nom nouveau nom de l'evenement
   * @return 0 si le nom est deja utilise, -1 si le nom n'est pas correct (null ou vide), 1 si la
   *         modification est faite
   */
  static int modifierNomEvenement(Evenement evenement, String nom) {
    if (nom == null || nom.trim().isEmpty() || nom.isEmpty()) {
      return -1;
    }
    for (Evenement e : GESTION_EVENEMENTS.keySet()) {
      if (e.getNom().equals(nom)) {
        return 0;
      }
    }
    return evenement.setNom(nom);
  }

  /**
   * Modifie le descriptif d'un evenement.
   *
   * @param evenement evenement a modifier
   * @param descriptif nouveau descriptif de l'evenement
   * @return false si le nouveau descriptif n'est pas correct (null ou vide), true si la
   *         modification est faite
   */
  static boolean modifierDescriptifEvenement(Evenement evenement, String descriptif) {
    return evenement.setDescriptif(descriptif) == 1;
  }

  /**
   * Modifie l'image d'un evenement.
   *
   * @param evenement evenement a modifier
   * @param image nouvelle image de l'evenement
   * @return false si la nouvelle image n'est pas correcte (vide), true si la modification est faite
   */
  static boolean modifierImageEvenement(Evenement evenement, String image) {
    return evenement.setImage(image) == 1;
  }

  /**
   * Modifie la date et l'horaire d'un evenement.
   *
   * @param evenement evenement a modifier
   * @param dateHoraire date et horaire de l'evenement
   * @return false si la nouvelle date n'est pas correcte (nulle ou inferieure a la date courrante),
   *         true si la modification est faite
   */
  static boolean modifierDateHoraireEvenement(Evenement evenement, LocalDateTime dateHoraire) {
    return evenement.setDateHoraire(dateHoraire) == 1;
  }

  /**
   * Modifie le lieu d'un evenement.
   *
   * @param evenement evenement a modifier
   * @param nom nouveau nom du lieu
   * @param descriptif nouveau descriptif du lieu
   * @param lien nouveau lien google du lieu
   * @return false si au moins un argument est incorrect, true si la modification est faite
   */
  static boolean modifierLieuEvenement(Evenement evenement, String nom, String descriptif,
      String lien) {
    return evenement.setNomLieu(nom) == 1 && evenement.setDescriptifLieu(descriptif) == 1
        && evenement.setLienLieu(lien) == 1;
  }

  /**
   * Modifie le type d'un evenement.
   *
   * @param evenement evenement a modifier
   * @param type nouveau type
   * @return false si le nouveau type n'est pas correct (null), true si la modification est faite
   */
  static boolean modifierTypeEvenement(Evenement evenement, TypeEvenement type) {
    return evenement.setType(type) == 1;
  }

  /**
   * Modifie le nombre maximum de personnes à l'evenement.
   *
   * @param evenement evenement a modifier
   * @param nombreMaxPersonne nouveau nombre
   * @return false si le nouveau nombre est strictement inferieur à 1, true si la modification est
   *         faite
   */
  static boolean modifierNombreMaxPersonneEvenement(Evenement evenement, int nombreMaxPersonne) {
    return evenement.setNombreMaxPersonne(nombreMaxPersonne) == 1;
  }
}
