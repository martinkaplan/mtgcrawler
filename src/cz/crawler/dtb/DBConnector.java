package cz.crawler.dtb;

import cz.crawler.ProjectProperties;
import cz.crawler.dtb.entity.MtgCard;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class DBConnector {

    protected static final Logger logger = Logger.getLogger(DBConnector.class);
    private static DBConnector instance = null;
    private Connection conn = null;
    private PreparedStatement isAlive;
    private PreparedStatement insertCard;
    public static final String DB_CLASS = "com.mysql.jdbc.Driver";

    public static synchronized DBConnector getInstance() {
        if (instance == null) {
            instance = new DBConnector();
        }
        return instance;
    }

    private DBConnector() {
        connect();
    }

    /**
     * Otestuje jestli existuje aktivní spojení
     *
     * @return true jestli je pripojeno, false jestli neni
     */
    public boolean isAlive() {
        if (isAlive == null) {
            return false;
        }
        try {
            return isAlive.execute();
        } catch (SQLException ex) {
            logger.warn("Nelze provest test isAlive", ex);
            return false;
        }
    }

    /**
     * Metoda se pokusi uzavrit existujici pripojeni (pokud existuje) a zaroven
     * vytvorit nove;
     */
    public void reconnect() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                logger.warn("Chyba pri zavirani spojeni pri pokusu o reconnect", ex);
            }
        }
        connect();
    }

    /**
     * Metoda vytvoreni pripojeni k databazi.
     *
     * @return vraci info jestli se pripojeni podarilo nebo ne
     */
    private boolean connect() {
        try {
            Class.forName(DB_CLASS).newInstance();
            conn = null;
            ProjectProperties prop = ProjectProperties.getInstance();

            String dbUser = prop.getStringProperty(ProjectProperties.DB_USER);
            String dbPass = prop.getStringProperty(ProjectProperties.DB_PASSWD);


            String dbUrl = "jdbc:mysql://" + prop.getStringProperty(ProjectProperties.DB_IP)
                    + ":3306/mtg?characterEncoding=utf8";

            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (ClassNotFoundException ex) {
            logger.error("Nelze nacist driver databaze", ex);
            ex.printStackTrace();
            return false;
        } catch (SQLException ex) {
            logger.error("Nepodarilo se vytvorit pripojeni", ex);
            ex.printStackTrace();

            return false;
        } catch (Exception ex) {
            logger.error("Neco se pokazilo pro pokusu o pripojeni k databazi", ex);
            ex.printStackTrace();
            return false;
        }
        clearStatements();
        prepareStatement();
        return true;
    }

    public final void prepareStatement() {
        try {
            if (conn != null) {
                isAlive = conn.prepareStatement("SELECT 1");
                insertCard = conn.prepareStatement(
                        "INSERT INTO  mtg.CARD (MULTIVERSE_ID ,NAME , MANA_COST , CONVERTED_MANACOST , TYPES ,CARD_TEXT , FLAVOR_TEXT ,EXPANSION ,RARITY ,ARTIST ,IMAGE_URL)"
                        + "VALUES ( ?, ?, ?, ?,  ?, ?,  ?, ?, ?, ?,?);");
            }
        } catch (SQLException ex) {
            logger.error("Nepodarilo se vyrobit prepared statementy", ex);
        }
    }

    public void clearStatements() {
        isAlive = null;
    }

    public boolean insertCard(MtgCard card) throws SQLException {
        if (card == null) {
            return false;
        }
        if (insertCard != null) {
            insertCard.setInt(1, card.getMultiverId());
            insertCard.setString(2, card.getCardName());
            insertCard.setString(3, card.getManaCost());
            insertCard.setInt(4, card.getConvertedManaCost());
            insertCard.setString(5, card.getTypes());
            insertCard.setString(6, card.getCardText());
            insertCard.setString(7, card.getFlavorText());
            insertCard.setString(8, card.getExpansion());
            insertCard.setString(9, card.getRarity());
            insertCard.setString(10, card.getArtist());
            insertCard.setString(11, card.getImageUrl());

            int rows = insertCard.executeUpdate();
            return rows > 0;

        }
        return false;
    }
}
