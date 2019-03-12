package Graphique;

/**
 * Cette interface contient plusieurs constantes utiles pour les classes graphiques.
 * @author Gabriel Lévesque-Duval
 * @author Hugo Migner
 * @version 1.0
 */
public interface AffichageConstantes {

	/**
	 * Tableau contenant les liens des images des boutons de la barre d'outils
	 */
	final String[] lienImages = { "../images/ovale.jpg", "../images/rectangle.jpg", "../images/trait.jpg",
			"../images/triangle.png", "../images/bleuclair.jpg", "../images/bleumarin.jpg", "../images/jaune.jpg",
			"../images/mauve.jpg", "../images/noir.jpg", "../images/orange.jpg", "../images/fillrouge.png",
			"../images/fillrose.png", "../images/fillvert.png", "../images/fillnoir.png", "../images/filljaune.png",
			"../images/fillbleu.png" };

	/**
	 * Lien de l'image de l'icone de l'application
	 */
	final String iconeApp = "../images/iconeApplication.png";

	/**
	 * Informations sur l'application
	 */
	final String A_PROPOS = "Nom du logiciel :          FakePaint"
			+ "\nAuteurs :                       Gabriel Lévesque-Duval et Hugo Migner"
			+ "\nNuméro de version :   0.0.2";

	/**
	 * Tableau contenant le texte des tooltips des boutons de la barre d'outils
	 */
	final String[] tabToolTips = { "Ovale", "Rectangle", "Trait", "Triangle", "Contour bleu clair",
			"Contour bleu marin", "Contour jaune", "Contour mauve", "Contour noir", "Contour orange",
			"Remplissage rouge", "Remplissage rose", "Remplissage vert", "Remplissage noir", "Remplissage jaune",
			"Remplissage bleu", "Épaisseur du contour" };
	/**
	 * Tableau contenant les items de la comboBox
	 */
	final Integer[] tabComboBox = {1, 5, 10, 15, 20};

	/**
	 * Nombre de boutons dans la barre d'outils
	 */
	final int NB_BOUTONS = 16;

	/**
	 * Nombre de formes dans la barre d'outils
	 */
	final int NB_FORMES = 4;

	/**
	 * Nombre de couleur de contour dans la barre d'outils
	 */
	final int NB_CONTOURS = 6;
	
	/**
	 * Nombre de couleur de remplissage dans la barre d'outils
	 */
	final int NB_REMPLISSAGE = 6;

	/**
	 * Constante qui représente une forme Ovale
	 */
	final int OVALE = 0;

	/**
	 * Constante qui représente un rectangle
	 */
	final int RECTANGLE = 1;

	/**
	 * Constante qui représente un trait
	 */
	final int TRAIT = 2;
	
	/**
	 * Constante qui représente un triangle
	 */
	final int TRIANGLE = 3;
}
