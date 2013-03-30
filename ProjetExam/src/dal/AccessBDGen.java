package dal;


import java.sql.*;
import java.util.*;

/**
 *
 * @author F.Dubisy
 *
 */

public class AccessBDGen
{
    /* Cr�e une connection � une base de donn�es � partir du nom logique de la BD,
     * du nom de l'utilisateur et du mot de passe.
     */
    public static Connection connecter(String bd, String user, String pass)
                throws SQLException
    {Connection connexion = null;
     try { Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           connexion = DriverManager.getConnection("jdbc:odbc:"+bd,user,pass);
         }
     catch (ClassNotFoundException ex)
        {ex.printStackTrace();
        }
     return connexion;
    }

    // Ferme la connection � la BD
    public static void deconnecter(Connection connec)
                throws SQLException
    {connec.close();
    }

    /*  Ex�cute n'importe quelle instruction de manipulation des donn�es autre qu'une requ�te
     *  ex: insert, delete, update.
    */
    public static int executerInstruction(Connection connec,String instruction)
                throws SQLException
    {int nbIns = 0;
     PreparedStatement prepStat = connec.prepareStatement(instruction);
     nbIns = prepStat.executeUpdate();
     return nbIns;
    }

    /* Ex�cute une requ�te d'acc�s en lecture � la BD (select)
     * et r�cup�re le mod�le des donn�es r�sultant de la requ�te (ensemble de lignes et de colonnes)
     */
    public static MyTableModel creerTableModel (Connection connec, String requete)
         throws SQLException
    {PreparedStatement prepStat = connec.prepareStatement(requete);
     ResultSet donnees = prepStat.executeQuery();
     ArrayList <String> nomColonnes = creerNomColonnes(donnees);
     ArrayList <Object> lignes = creerLignes(donnees);
     ArrayList <Object> objetTypes = creerObjetTypes(donnees);
     MyTableModel model = new MyTableModel(nomColonnes,lignes, objetTypes);
     return model;
    }

    // M�thode appel�e par la m�thode creerTableModel pour r�cup�rer les noms des colonnes
    public static ArrayList <String> creerNomColonnes(ResultSet donnees)
                throws SQLException
    {ResultSetMetaData meta = donnees.getMetaData();
     ArrayList <String> nomColonnes = new ArrayList <String>();

     for (int i = 1; i <= meta.getColumnCount();i++)
       { nomColonnes.add(meta.getColumnName(i));}

     return nomColonnes;
    }

    // M�thode appel�e par la m�thode creerTableModel pour r�cup�rer les lignes des donn�es
    public static ArrayList <Object> creerLignes(ResultSet donnees)
             throws SQLException
    {ResultSetMetaData meta = donnees.getMetaData();
     ArrayList <Object> lignes = new ArrayList <Object>();

     while (donnees.next())
        {lignes.add(getNextRow(donnees,meta)); }

     return lignes ;
    }

    // M�thode appel�e par la m�thode creerLignes pour r�cup�rer une ligne de donn�es
    private static ArrayList <Object> getNextRow(ResultSet donnees, ResultSetMetaData meta)
            throws SQLException
    {ArrayList <Object> ligneCourante = new ArrayList <Object>();
     String stringLu;
     int entierLu;
     double doubleLu;
     float floatLu;
     boolean booleenLu;
     java.util.Date dateLue;

     for (int i = 1; i <= meta.getColumnCount();i++)
     {switch (meta.getColumnType(i))
      {case Types.VARCHAR:
            stringLu = donnees.getString(i);
            ligneCourante.add(donnees.wasNull()?null:stringLu);
            break;
       case Types.CHAR:
            stringLu = donnees.getString(i);
            ligneCourante.add(donnees.wasNull()?null:stringLu);
            break;
       case Types.INTEGER:
            entierLu = donnees.getInt(i);
            ligneCourante.add(donnees.wasNull()?null:new Integer(entierLu));
            break;
       case  Types.SMALLINT :
            entierLu = donnees.getInt(i);
            ligneCourante.add(donnees.wasNull()?null:new Integer(entierLu));
            break;
       case  Types.TINYINT:
            entierLu = donnees.getInt(i);
            ligneCourante.add(donnees.wasNull()?null:new Integer(entierLu));
            break;
       case Types.REAL:
    	   floatLu = donnees.getFloat(i);
           ligneCourante.add(donnees.wasNull()?null:new Float(floatLu));
           break;
       case Types.DOUBLE:
            doubleLu = donnees.getDouble(i);
            ligneCourante.add(donnees.wasNull()?null:new Double(doubleLu));
            break;
       case Types.TIMESTAMP:
            dateLue = donnees.getDate(i);
            ligneCourante.add(donnees.wasNull()?null:dateLue);
            break;
      case Types.BIT:
            booleenLu = donnees.getBoolean(i);
            ligneCourante.add(donnees.wasNull()?null:new Boolean(booleenLu));
            break;
      }
     }
     return ligneCourante;
    }

    // M�thode appel�e par la m�thode creerTableModel pour r�cup�rer les types des colonnes
    private static ArrayList <Object> creerObjetTypes(ResultSet donnees)
            throws SQLException
    {ResultSetMetaData meta = donnees.getMetaData();
     ArrayList <Object> objetTypes = new ArrayList <Object>();
     String stringLu = "bidon";
     int entierLu = 1;
     double doubleLu = 1.0;
     float floatLu = 1.0f;
     boolean booleenLu = true;
     java.util.Date dateLue = new java.util.Date();

     for (int i = 1; i <= meta.getColumnCount();i++)
     {switch (meta.getColumnType(i))
      {case Types.VARCHAR: objetTypes.add(stringLu);
                           break;
       case Types.CHAR: objetTypes.add(stringLu);
                        break;
       case Types.INTEGER: objetTypes.add(new Integer(entierLu));
                           break;
       case Types.SMALLINT: objetTypes.add(new Integer(entierLu));
                           break;
       case Types.TINYINT: objetTypes.add(new Integer(entierLu));
                           break;
       case Types.REAL: objetTypes.add(new Float(floatLu));
       						break;
       case Types.DOUBLE: objetTypes.add(new Double(doubleLu));
                          break;
       case Types.TIMESTAMP: objetTypes.add(dateLue);
                             break;
      case Types.BIT: objetTypes.add(new Boolean(booleenLu));
                      break;
      }
     }
     return objetTypes;
    }

    /* R�cup�re sous forme d'un liste les donn�es correspondant � une colonne dans une table de la BD.
     * La requete doit �tre un select portant sur une seule colonne
     */
    public static Object[] creerListe1Colonne(Connection connec, String requete)
             throws SQLException
    {PreparedStatement prepStat = connec.prepareStatement(requete);
     ResultSet donnees = prepStat.executeQuery();
     ResultSetMetaData meta = donnees.getMetaData();
     Object[] uneColonne = new Object[100];
     int index = 0;

     String stringLu;
     int entierLu;
     float floatLu;
     double doubleLu;
     boolean booleenLu;
     java.util.Date dateLue;

     while (donnees.next())
     {switch (meta.getColumnType(1))
      {case Types.VARCHAR:
            stringLu = donnees.getString(1);
            if (donnees.wasNull() == false)
            {
             uneColonne[index] = stringLu;
             index++;
            }
            break;
       case Types.CHAR:
            stringLu = donnees.getString(1);
            if (donnees.wasNull() == false)
            {
             uneColonne[index] = stringLu;
             index++;
            }
            break;
       case Types.INTEGER:
            entierLu = donnees.getInt(1);
            if (donnees.wasNull() == false)
            {
             uneColonne[index] = new Integer(entierLu);
             index++;
            }
            break;
       case Types.SMALLINT:
            entierLu = donnees.getInt(1);
            if (donnees.wasNull() == false)
            {
             uneColonne[index] = new Integer(entierLu);
             index++;
            }
            break;
       case Types.TINYINT:
            entierLu = donnees.getInt(1);
            if (donnees.wasNull() == false)
            {
             uneColonne[index] = new Integer(entierLu);
             index++;
            }
            break;
       case Types.REAL:
    	    floatLu = donnees.getFloat(1);
    	    if (donnees.wasNull() == false)
            {
             uneColonne[index]=  new Float(floatLu);
             index++;
            }
            break;
       case Types.DOUBLE:
            doubleLu = donnees.getDouble(1);
            if (donnees.wasNull() == false)
            {
             uneColonne[index]=  new Double(doubleLu);
             index++;
            }
            break;
       case Types.TIMESTAMP:
            dateLue = donnees.getDate(1);
            if (donnees.wasNull() == false)
            {
             uneColonne[index]= dateLue;
             index++;
            }
            break;
      case Types.BIT:
            booleenLu = donnees.getBoolean(1);
            if (donnees.wasNull() == false)
            {
             uneColonne[index]=  new Boolean(booleenLu);
             index++;
            }
            break;
      }
     }
     return uneColonne ;
    }

}


