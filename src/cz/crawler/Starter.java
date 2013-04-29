package cz.crawler;

import cz.crawler.gui.MainFrame;

/**
 *
 * @author marty
 */
public class Starter implements Runnable {

    private String startWithGui = "-gui";
    private boolean IS_WITH_GUI = false;

    public Starter(String[] arg) {
        for (int i = 0; i < arg.length; i++) {
            if (startWithGui.equals(arg[i].toLowerCase())) {
                IS_WITH_GUI = true;
            }
        }
    }

    @Override
    public void run() {
        if (IS_WITH_GUI) {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        } else {
            Crawler crawler = Crawler.getInstance();
            crawler.start();
        }
    }

    public static void main(String[] args) {

        Starter starter = new Starter(args);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(starter);

    }
}