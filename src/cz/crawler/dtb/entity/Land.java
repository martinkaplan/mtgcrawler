package cz.crawler.dtb.entity;

/**
 *
 * @author martin.kaplan
 */
public class Land {

    public final String imageURL;
    public final String alt;
    public final String symbol;

    public Land(String alt, String symbol, String imageURL) {
        this.imageURL = imageURL;
        this.alt = alt;
        this.symbol = symbol;
    }
}
