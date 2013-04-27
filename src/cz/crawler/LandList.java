package cz.crawler;

import cz.crawler.dtb.entity.Land;
import java.util.ArrayList;

public class LandList {

    private static final ArrayList<Land> landList = new ArrayList<Land>();

    static {
        //BASE
        landList.add(new Land("alt=\"Red\"", "(R)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=R&type=symbol"));
        landList.add(new Land("alt=\"Blue\"", "(U)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=U&type=symbol"));
        landList.add(new Land("alt=\"Black\"", "(B)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=B&type=symbol"));
        landList.add(new Land("alt=\"Green\"", "(G)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=G&type=symbol"));
        landList.add(new Land("alt=\"White\"", "(W)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=W&type=symbol"));
        //COMBO
        landList.add(new Land("alt=\"Blue or Red\"", "(UR)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=UR&type=symbol"));
        landList.add(new Land("alt=\"Blue or Black\"", "(UB)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=UB&type=symbol"));
        landList.add(new Land("alt=\"Black or Red\"", "(BR)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=BR&type=symbol"));
        landList.add(new Land("alt=\"Black or Green\"", "(BG)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=BG&type=symbol"));
        landList.add(new Land("alt=\"Red or Green\"", "(RG)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=RG&type=symbol"));
        landList.add(new Land("alt=\"Red or White\"", "(RW)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=RW&type=symbol"));
        landList.add(new Land("alt=\"Green or White\"", "(GW)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=GW&type=symbol"));
        landList.add(new Land("alt=\"Green or Blue\"", "(GU)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=GU&type=symbol"));
        landList.add(new Land("alt=\"White or Blue\"", "(WU)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=WU&type=symbol"));
        landList.add(new Land("alt=\"White or Black\"", "(WB)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=WB&type=symbol"));
//phyrexian
        landList.add(new Land("alt=\"Phyrexian Blue\"", "(UP)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=UP&type=symbol"));
        landList.add(new Land("alt=\"Phyrexian Green\"", "(GP)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=GP&type=symbol"));
        landList.add(new Land("alt=\"Phyrexian Black\"", "(BP)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=BP&type=symbol"));
        landList.add(new Land("alt=\"Phyrexian Red\"", "(RP)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=RP&type=symbol"));
        landList.add(new Land("alt=\"Phyrexian White\"", "(WP)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=WP&type=symbol"));

//COLOR LESS
        landList.add(new Land("alt=\"1\"", "(1)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=1&type=symbol"));
        landList.add(new Land("alt=\"2\"", "(2)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=2&type=symbol"));
        landList.add(new Land("alt=\"3\"", "(3)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=3&type=symbol"));
        landList.add(new Land("alt=\"4\"", "(4)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=4&type=symbol"));
        landList.add(new Land("alt=\"5\"", "(5)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=5&type=symbol"));
        landList.add(new Land("alt=\"6\"", "(6)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=6&type=symbol"));
        landList.add(new Land("alt=\"7\"", "(7)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=7&type=symbol"));
        landList.add(new Land("alt=\"8\"", "(8)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=8&type=symbol"));
        landList.add(new Land("alt=\"9\"", "(9)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=9&type=symbol"));
        landList.add(new Land("alt=\"10\"", "(10)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=10&type=symbol"));
        landList.add(new Land("alt=\"11\"", "(11)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=11&type=symbol"));
        landList.add(new Land("alt=\"12\"", "(12)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=12&type=symbol"));
        landList.add(new Land("alt=\"13\"", "(13)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=13&type=symbol"));
        landList.add(new Land("alt=\"14\"", "(14)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=14&type=symbol"));
        landList.add(new Land("alt=\"15\"", "(15)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=15&type=symbol"));
        landList.add(new Land("alt=\"16\"", "(16)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=16&type=symbol"));

        landList.add(new Land("alt=\"Variable Colorless\"", "(X)", "http://gatherer.wizards.com/Handlers/Image.ashx?size=medium&name=X&type=symbol"));

    }

    public static String resolveManaCost(String values) {
        StringBuilder retString = new StringBuilder();
        for (int i = 0; i < landList.size(); i++) {
            Land land = landList.get(i);
            if (values.contains(land.alt)) {
                retString.append(countOfSubStringsInString(values, land.alt))
                        .append(land.symbol).append(" ");
            }
        }
        return retString.toString().trim();
    }

    private static int countOfSubStringsInString(final String string, final String substring) {
        int count = 0;
        int idx = 0;
        while ((idx = string.indexOf(substring, idx)) != -1) {
            idx++;
            count++;
        }
        return count;
    }
}
