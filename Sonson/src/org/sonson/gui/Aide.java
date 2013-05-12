package org.sonson.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

import javax.swing.JScrollPane;

public class Aide extends JPanel{
	private JEditorPane jep;	
	public Aide(){
		jep = new JEditorPane();
		jep.setEditable(false);
		jep.setContentType("text/html");
		//jep.setText("coucou");
		//TODO Aide
		//this.setPreferredSize(new Dimension(200,200));
		//jep = new JEditorPane();
		JScrollPane js = new JScrollPane();
		js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jep.setText("<html>"+
				"<body>"+
				"<h1>Bienvenue dans l'aide</h1>"+
				"<h2>Table des mati�res</h2>"+
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
				"<a href=#Raccourcis><li> Les raccour�is </li> </a>"+
				"<a href=#Conclusion><li> Conclusion </li> </a>"+
				"</ol>"+
				""+
				"<ol>"+
				"<a name=Intro><h2>Introduction</h2></a>"+
				"<p>"+
				"Bienvenue dans notre programme de gestion de petites et moyennes entreprises."+
				"</p>"+
				"<p>"+
				"Ce programme va vous permettre de g�rer d'une mani�re simple diff�rents point important pour votre entreprise."+
				"Commen les clients, l'inventaire et avoir une vue d'ensemble de diverses statistiques financi�res."+
				"Tout cela se fera dans une interface �pur�e pour plus de simplicit� et vous permettre de comprendre "+
				"toutes les fonctionalit�s. Il est aussi optimis� pour un acc�s rapide aux diff�rentes fonctionalit�s."+
				"</p>"+
				"<a name=Menus><h2>Les menus</h2></a>"+
				"<p>"+
				"Notre programme est compos� de cinq menus qui sont d�cris ci-dessous."+
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
				"Cette fonctionalit� vous permet de chercher un client dans la base de donn�es.<br>"+
				"Cette recherche pourra se faire selon les crit�res suivants : Num�ro d'identification, Nom, Pr�nom, Code Postal,"+
				"Adresse, Pays, Num�ro de t�l�phone fixe et portable."+
				""+
				"</p>"+
				""+
				"- Ajouter un client"+
				"<p>"+
				"Cette fonctionalit� vous permet d'ajouter un client � la base de donn�es. <br>"+
				"Il faudra rentrer ses donn�es personnelles et vous pourrai ensuite lui ajouter les produits ou services qu'il aura pris."+
				"Un num�ro d'identification sera rajouter automatique de mani�res incr�mentielles."+
				"</p>"+
				"</ul>"+
				"</p>"+
				"<a name=Inventaire><h3>Inventaire</h3></a>"+
				"<p>"+
				"<ul>"+
				"- Ajouter un produit/service"+
				"<p>"+
				"Cette fonctionalit� vous permet d'ajouter un produit/service.<br>"+
				"Dans un premier temps vous devez s�lectionner le type (Produit ou Service)."+
				"Ensuite, il faut completer le nom, la description et le prix."+
				"Un num�ro d'identification sera rajouter automatique de mani�res incr�mentielles."+
				"</p>"+
				"- Modifier un produit/service"+
				"<p>"+
				"Cette fonctionalit� vous permet de modifier un produit/service.<br>"+
				"Pour modifier un produit, il faudra le trouver en faisant une recherche soit avec le num�ro d'identification ou"+
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
				"Cette fonctionalit� vous fournira des informations diverses sur tous vos clients."+
				"</p>"+
				"- Statistiques des produits/services"+
				"<p>"+
				"Cette fonctionalit� vous fournira des informations diverses sur tous vos produits/services."+
				"</p>"+
				"- Statistiques financi�res"+
				"<p>"+
				"Cette fonctionalit� vous fournira des informations diverses sur tous vos finances."+
				"</p>"+
				"</ul>"+
				"</p>"+
				"<a name=Aide><h3>?</h3></a>"+
				"<p>"+
				"<ul>"+
				"- Aide"+
				"<p>"+
				"Cette fonctionalit� vous donne toutes les informations n�c�ssaire pour utiliser ce programme au mieux.<br>"+
				"</p>"+
				"- Cr�dits"+
				"<p>"+
				"Cette fonctionalit� vous donne toutes les informations sur les cr�ateurs de ce programme..<br>"+
				"</p>"+
				"</ul>"+
				"</p>"+
				"</ol>"+
				"<a name=Raccourcis><h2>Les raccour�is</h2></a>"+
				"<TABLE BORDER=1> "+
				"  <CAPTION> Voici la liste des raccour�is pour les diff�rentes fonctionalit�s </CAPTION> "+
				"  <TR> "+
				" <TH> Raccourcis </TH> "+
				" <TH> Fonctionnalit� </TH> "+
				"  </TR> "+
				"  <TR> "+
				" <TD> CTRL + A </TD> "+
				" <TD> Affiche l'aide </TD> "+
				"  </TR> "+
				"  <TR> "+
				" <TD> CTRL + F </TD> "+
				" <TD> Affiche la fen�tre pour la recherche d'un client </TD> "+
				"  </TR> "+
				"  <TR> "+
				" <TD> CTRL + I </TD> "+
				" <TD> Affiche la fen�tre pour l'ajout d'un produit/service </TD> "+
				"  </TR> "+
				"  <TR> "+
				" <TD> CTRL + N </TD> "+
				" <TD> Affiche la fen�tre pour l'ajout d'un client </TD> "+
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
		js.setViewportView(jep);
		this.add(js);
		
	}
}
