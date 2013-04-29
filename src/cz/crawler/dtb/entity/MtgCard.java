package cz.crawler.dtb.entity;

import cz.crawler.LandList;
import java.net.SocketTimeoutException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author marty
 */
public class MtgCard {

    public static String ENTER = "\r\n";
    private final int multiverId;
    private final String cardName;
    private final String manaCost;
    private final int convertedManaCost;
    private final String types;
    private final String cardText;
    private final String flavorText;
    private final String expansion;
    private final String rarity;
    private final String artist;
    private final String imageUrl;

    /**
     *
     * @param multiverId
     * @param cardName
     * @param manaCost
     * @param convertedManaCost
     * @param types
     * @param cardText
     * @param flavorText
     * @param expansion
     * @param rarity
     * @param cardNumber
     * @param artist
     * @param imageUrl
     */
    private MtgCard(int multiverId, String cardName, String manaCost, String convertedManaCost, String types, String cardText, String flavorText, String expansion, String rarity, String artist) {
        this.multiverId = multiverId;
        this.cardName = cardName;
        this.manaCost = manaCost;
        this.convertedManaCost = parseManaCost(convertedManaCost);
        this.types = types;
        this.cardText = cardText;
        this.flavorText = flavorText;
        this.expansion = expansion;
        this.rarity = rarity;
        this.artist = artist;
        this.imageUrl = "http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=" + multiverId + "&type=card";
    }

    private static Document askForPage(int multiverseId) throws Exception {
        try {
            Document doc = Jsoup.connect("http://gatherer.wizards.com/Pages/Card/Details.aspx?multiverseid=" + multiverseId).timeout(4000).get();
            return doc;
        } catch (SocketTimeoutException e) {
            System.out.println("Sockettimetout ex - calling yourselfs again");
            return askForPage(multiverseId);
        } catch (Exception e) {
            throw e;
        }
    }

    public static MtgCard getCard(int multiverseId) throws Exception {
        MtgCard karta;
        Document doc;
        try {
            doc = askForPage(multiverseId);
            karta = new MtgCard(multiverseId,
                    doc.select("#ctl00_ctl00_ctl00_MainContent_SubContent_SubContent_nameRow").select(".value").text(),
                    LandList.resolveManaCost(doc.select("#ctl00_ctl00_ctl00_MainContent_SubContent_SubContent_manaRow").select(".value").toString()),
                    doc.select("#ctl00_ctl00_ctl00_MainContent_SubContent_SubContent_cmcRow").select(".value").text(),
                    doc.select("#ctl00_ctl00_ctl00_MainContent_SubContent_SubContent_typeRow").select(".value").text(),
                    doc.select("#ctl00_ctl00_ctl00_MainContent_SubContent_SubContent_textRow").select(".value").select(".cardtextbox").text(),
                    doc.select("#ctl00_ctl00_ctl00_MainContent_SubContent_SubContent_flavorRow").select(".value").select(".cardtextbox").text(),
                    doc.select("#ctl00_ctl00_ctl00_MainContent_SubContent_SubContent_currentSetSymbol").select("a").text(),
                    doc.select("#ctl00_ctl00_ctl00_MainContent_SubContent_SubContent_rarityRow").select(".value").text(),
                    doc.select("#ctl00_ctl00_ctl00_MainContent_SubContent_SubContent_artistRow").select(".value").text());

            return karta;
        } catch (Exception e) {
            throw e;
        }
    }

    public int getMultiverId() {
        return multiverId;
    }

    public String getCardName() {
        return cardName;
    }

    public String getManaCost() {
        return manaCost;
    }

    public int getConvertedManaCost() {
        return convertedManaCost;
    }

    public String getTypes() {
        return types;
    }

    public String getCardText() {
        return cardText;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public String getExpansion() {
        return expansion;
    }

    public String getRarity() {
        return rarity;
    }

    public String getArtist() {
        return artist;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return multiverId + cardName + "[" + expansion + "]" + manaCost + ";"
                + convertedManaCost + ";" + types + ";" + cardText + ";" + ENTER
                + flavorText + ";" + rarity + ";" + artist + ";" + imageUrl;
    }

    private int parseManaCost(String convertedManaCost) {
        try {
            return Integer.parseInt(convertedManaCost);
        } catch (Exception e) {
            return 0;
        }
    }
}
