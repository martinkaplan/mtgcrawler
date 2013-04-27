/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crawler;

/**
 *
 * @author martyidapple
 */
public class Starter {

    public Starter() {
    Crawler crawler =  Crawler.getInstance();
    crawler.start();
    
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      new Starter();
      
    }
}