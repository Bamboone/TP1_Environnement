package Graphique;

public interface AffichageConstantes {

	// Liens des images
	final String[] lienImages = { "../images/ovale.jpg", "../images/rectangle.jpg", "../images/trait.jpg",
			"../images/triangle.png", "../images/bleuclair.jpg", "../images/bleumarin.jpg", "../images/jaune.jpg",
			"../images/mauve.jpg", "../images/noir.jpg", "../images/orange.jpg", "../images/fillrouge.png",
			"../images/fillrose.png", "../images/fillvert.png", "../images/fillnoir.png", "../images/filljaune.png",
			"../images/fillbleu.png" };

	// Lien de l'icone de l'appliaction
	final String iconeApp = "../images/iconeApplication.png";

	final String A_PROPOS = "Nom du logiciel :          FakePaint"
			+ "\nAuteurs :                       Gabriel Lévesque-Duval et Hugo Migner"
			+ "\nNuméro de version :   0.0.2";

	// Tooltips
	final String[] tabToolTips = { "Ovale", "Rectangle", "Trait", "Triangle", "Contour bleu clair",
			"Contour bleu marin", "Contour jaune", "Contour mauve", "Contour noir", "Contour orange",
			"Remplissage rouge", "Remplissage rose", "Remplissage vert", "Remplissage noir", "Remplissage jaune",
			"Remplissage bleu" };

	final int NB_BOUTONS = 16;

	final int NB_FORMES = 4;

	final int NB_CONTOURS = 6;

	final int NB_REMPLISSAGE = 6;

	final int OVALE = 0;

	final int RECTANGLE = 1;

	final int TRAIT = 2;

	final int TRIANGLE = 3;
}
