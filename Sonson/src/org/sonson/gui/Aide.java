package org.sonson.gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.ScrollPaneConstants;


public class Aide extends JFrame{
	public Aide() {
		getContentPane().setLayout(null);
		this.setTitle("Aide");
		this.setBounds(0, 0, 620, 640);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 600, 600);
		getContentPane().add(scrollPane);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setContentType("text/html");
		editorPane.setEditable(false);
		editorPane.setText("<html>"+
				"<body>"+
				"<h1>Bienvenue dans l'aide</h1>"+
				"<h2>Table des matiéres</h2>"+
				"<ol>"+
				"<a href=#Intro><li> Introduction </li> </a>"+
				"<a href=#Menus><li> Les menus </li></a>"+
				"<ol>"+
				"<a href=#Fichier><li> Fichier </li></a>"+
				"<a href=#Clients><li> Clients </li></a>"+
				"<a href=#Inventaire><li> Inventaire </li></a>"+
				"<a href=#Stat><li> Statistiques </li> </a>"+
				"<a href=#Aide><li> ? </li> </a>"+
				"</ol>"+
				"<a href=#Raccourcis><li> Les raccourçis </li> </a>"+
				"<a href=#Conclusion><li> Conclusion </li> </a>"+
				"</ol>"+
				""+
				"<ol>"+
				"<a name=Intro><h2>Introduction</h2></a>"+
				"<p>"+
				"Bienvenue dans notre programme de gestion de petites et moyennes entreprises."+
				"</p>"+
				"<p>"+
				"Ce programme va vous permettre de gérer d'une manière simple différents point important pour votre entreprise."+
				"Commen les clients, l'inventaire et avoir une vue d'ensemble de diverses statistiques financières."+
				"Tout cela se fera dans une interface épurée pour plus de simplicité et vous permettre de comprendre "+
				"toutes les fonctionalités. Il est aussi optimisé pour un accès rapide aux différentes fonctionalités."+
				"</p>"+
				"<a name=Menus><h2>Les menus</h2></a>"+
				"<p>"+
				"Notre programme est composé de cinq menus qui sont décris ci-dessous."+
				"</p>"+
				"<ol>"+
				"<a name=Fichier><h3>Fichier</h3></a>"+
				"<p>"+
				"Dans le menu Fichier : <br>"+
				"On retrouve le traditionnel bouton Quitter."+
				"</p>"+
				"<a name=Clients><h3>Clients</h3></a>"+
				"<p>"+
				"Dans le menu Clients : <br>"+
				"<ul>"+
				"- Recherche d'un client"+
				"<p>"+
				"Cette fonctionalité vous permet de chercher un client dans la base de données.<br>"+
				"Cette recherche pourra se faire selon les critères suivants : Numéro d'identification, Nom, Prénom, Code Postal,"+
				"Adresse, Pays, Numéro de téléphone fixe et portable."+
				""+
				"</p>"+
				""+
				"- Ajouter un client"+
				"<p>"+
				"Cette fonctionalité vous permet d'ajouter un client à la base de données. <br>"+
				"Il faudra rentrer ses données personnelles et vous pourrai ensuite lui ajouter les produits ou services qu'il aura pris."+
				"Un numéro d'identification sera rajouter automatique de maniéres incrémentielles."+
				"</p>"+
				"</ul>"+
				"</p>"+
				"<a name=Inventaire><h3>Inventaire</h3></a>"+
				"<p>"+
				"<ul>"+
				"- Ajouter un produit/service"+
				"<p>"+
				"Cette fonctionalité vous permet d'ajouter un produit/service.<br>"+
				"Dans un premier temps vous devez sélectionner le type (Produit ou Service)."+
				"Ensuite, il faut completer le nom, la description et le prix."+
				"Un numéro d'identification sera rajouter automatique de maniéres incrémentielles."+
				"</p>"+
				"- Modifier un produit/service"+
				"<p>"+
				"Cette fonctionalité vous permet de modifier un produit/service.<br>"+
				"Pour modifier un produit, il faudra le trouver en faisant une recherche soit avec le numéro d'identification ou"+
				"avec son nom ou avec son prix. Ensuite il vous sera possible de modifier le nom et la description de ce produit."+
				"Pour le modifier le prix, il faudra ajouter une nouveau produit pour ne pas fausser nos statistiques."+
				"</p>"+
				"</ul>"+
				"</p>"+
				"<a name=Stat><h3>Statistiques</h3></a>"+
				"<p>"+
				"<ul>"+
				"- Statistiques des clients"+
				"<p>"+
				"Cette fonctionalité vous fournira des informations diverses sur tous vos clients."+
				"</p>"+
				"- Statistiques des produits/services"+
				"<p>"+
				"Cette fonctionalité vous fournira des informations diverses sur tous vos produits/services."+
				"</p>"+
				"- Statistiques financières"+
				"<p>"+
				"Cette fonctionalité vous fournira des informations diverses sur tous vos finances."+
				"</p>"+
				"</ul>"+
				"</p>"+
				"<a name=Aide><h3>?</h3></a>"+
				"<p>"+
				"<ul>"+
				"- Aide"+
				"<p>"+
				"Cette fonctionalité vous donne toutes les informations nécéssaire pour utiliser ce programme au mieux.<br>"+
				"</p>"+
				"- Crédits"+
				"<p>"+
				"Cette fonctionalité vous donne toutes les informations sur les créateurs de ce programme..<br>"+
				"</p>"+
				"</ul>"+
				"</p>"+
				"</ol>"+
				"<a name=Raccourcis><h2>Les raccourçis</h2></a>"+
				"<TABLE BORDER=1> "+
				"  <CAPTION> Voici la liste des raccourçis pour les différentes fonctionalités </CAPTION> "+
				"  <TR> "+
				" <TH> Raccourcis </TH> "+
				" <TH> Fonctionnalité </TH> "+
				"  </TR> "+
				"  <TR> "+
				" <TD> CTRL + A </TD> "+
				" <TD> Affiche l'aide </TD> "+
				"  </TR> "+
				"  <TR> "+
				" <TD> CTRL + F </TD> "+
				" <TD> Affiche la fenètre pour la recherche d'un client </TD> "+
				"  </TR> "+
				"  <TR> "+
				" <TD> CTRL + I </TD> "+
				" <TD> Affiche la fenètre pour l'ajout d'un produit/service </TD> "+
				"  </TR> "+
				"  <TR> "+
				" <TD> CTRL + N </TD> "+
				" <TD> Affiche la fenètre pour l'ajout d'un client </TD> "+
				"  </TR> "+
				"  <TR> "+
				" <TD> CTRL + Q </TD> "+
				" <TD> Pour quitter le programme </TD> "+
				"  </TR> "+
				"  <TR> "+
				" <TD> CTRL + A </TD> "+
				" <TD> Affiche l'aide </TD> "+
				"  </TR> "+
				"  <TR> "+
				" <TD> CTRL + A </TD> "+
				" <TD> Affiche l'aide </TD> "+
				"  </TR> "+
				"  <TR> "+
				" <TD> CTRL + A </TD> "+
				" <TD> Affiche l'aide </TD> "+
				"  </TR> "+
				"  <TR> "+
				" <TD> CTRL + A </TD> "+
				" <TD> Affiche l'aide </TD> "+
				"  </TR> "+
				"  <TR> "+
				" <TD> CTRL + A </TD> "+
				" <TD> Affiche l'aide </TD> "+
				"  </TR> "+
				"  <TR> "+
				" <TD> CTRL + A </TD> "+
				" <TD> Affiche l'aide </TD> "+
				"  </TR> "+
				"</TABLE> "+
				""+
				"<a name=Conclusion><h2>Conclusion</h2></a>"+
				"</ol>"+
				""+
				""+
				"</body>"+
				"</html>");
		scrollPane.setViewportView(editorPane);
		this.setVisible(true);
	}
}
