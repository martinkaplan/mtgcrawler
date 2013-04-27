package cz.crawler;

import cz.crawler.dtb.DBConnector;
import cz.crawler.dtb.entity.MtgCard;
import java.util.Random;
import org.apache.log4j.Logger;

/**
 *
 * @author marty
 */
public class Crawler implements Runnable {

    ProjectProperties prop = ProjectProperties.getInstance();
    DBConnector dbconn = DBConnector.getInstance();
    private int lastUniverseID;
    private final static int MAX_UNIVERSE_ID = 273562;
    protected static final Logger logger = Logger.getLogger(DBConnector.class);
    private static Crawler instance;
    private Random r = new Random();

    public static Crawler getInstance() {
        if (instance == null) {
            instance = new Crawler();
        }
        return instance;
    }

    private Crawler() {
        lastUniverseID = prop.getIntProperty(ProjectProperties.I_LASTCARDID);
    }

    void start() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        MtgCard card = null;
        while (lastUniverseID < MAX_UNIVERSE_ID) {
            try {
                Thread.sleep(600 + r.nextInt(2000));
                lastUniverseID++;
                prop.setIntProperty(ProjectProperties.I_LASTCARDID, lastUniverseID);
                card = MtgCard.getCard(lastUniverseID);
                if (card != null) {
                    System.out.println("zpracovavm: " + card.getMultiverId());
                    dbconn.insertCard(card);
                }
                prop.store();
            } catch (Exception ex) {
                if (card != null) {
                    logger.error("chyba!!! pri zpracování karty: " + card.getMultiverId(), ex);
                }
                ex.printStackTrace();
                prop.store();
                System.exit(0);
            }
        }
    }
}
