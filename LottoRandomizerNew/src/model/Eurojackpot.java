/*
 * The eurojackpot-class that handles graphics and randomizing
 * of 10 rows of eurojackpot-numbers in a way that all 50 numbers
 * are available in the 10 rows and every number is 
 * represented once
 */
package model;

import grafik.West;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author Reza
 */
public class Eurojackpot {
    
    private West we= new West();
    private int[] eurojackpotNumber= new int[50];
    private JLabel[] rowNumberArray= new JLabel[10];
    private JLabel[] eurojackpotNumberArray= new JLabel[50];
    private JLabel[] tillaggNumberArray= new JLabel[20];
    private int[] tillaggNumber= new int[20];
    private Random ran = new Random();
    
     public Eurojackpot(){
         
     }
     
    //Constructor
    public Eurojackpot(West west){
       
        this.we = west;
        
        //clean the west panel, used for cleaning after multiple clicks
        we.removeAll();
        we.updateUI();
       
        randomizeEurojackpotNumbers();
        randomizetillaggNumbers();
        
        //setting the layout of this panel
        GridBagLayout gr = new GridBagLayout();
        west.setLayout(gr);
        
        //x,y of the label
        GridBagConstraints con ;
        
        //setting x,y,insets, font of the labelarray for the row-numbers, adding the labelarray to the panel
        //x,y of the label + color
        for(int x = 0 ; x < rowNumberArray.length ; x++){
            rowNumberArray[x] = new JLabel();
            con = new GridBagConstraints();
            con.gridx = 1;
            con.gridy = (x+1);
            con.insets = new Insets(10, 200, 10, 50);
            we.add(rowNumberArray[x],con);
            rowNumberArray[x].setFont(new Font("SansSerif", Font.BOLD, 35));
            rowNumberArray[x].setText("Rad " + Integer.toString(x+1) + ":");
            rowNumberArray[x].setBackground(Color.ORANGE);
            rowNumberArray[x].setOpaque(true);
        }
        
        
        int arrayIndex = 0;
        
        //setting x,y,insets, font of the labelarray for the eurojackpot-numbers + adding the labelarray to the panel
        //x,y of the label + color
        for(int w=0; w<10; w++){
            
            for(int i=0; i<5; i++){

                eurojackpotNumberArray[arrayIndex] = new JLabel();
                con = new GridBagConstraints();
                con.gridx = (3+i);
                con.gridy = (w+1);
                con.insets = new Insets(10, 20, 10, 50);
                
                we.add(eurojackpotNumberArray[arrayIndex],con);
                eurojackpotNumberArray[arrayIndex].setFont(new Font("SansSerif", Font.BOLD, 25));
                eurojackpotNumberArray[arrayIndex].setText(Integer.toString(eurojackpotNumber[arrayIndex]));
                eurojackpotNumberArray[arrayIndex].setForeground(Color.RED);
                eurojackpotNumberArray[arrayIndex].setOpaque(true);
                arrayIndex++;
            }
            
        }
        
        arrayIndex = 0;
        
        //setting x,y,insets, font of the labelarray for the tillagg-numbers + adding the labelarray to the panel
        //x,y of the label + color
        for(int w=0; w<10; w++){
            
            for(int i=0; i<2; i++){

                tillaggNumberArray[arrayIndex] = new JLabel();
                con = new GridBagConstraints();
                con.gridx = (10+i);
                con.gridy = (w+1);
                con.insets = new Insets(10, 20, 10, 50);
                
                we.add(tillaggNumberArray[arrayIndex],con);
                tillaggNumberArray[arrayIndex].setFont(new Font("SansSerif", Font.BOLD, 25));
                tillaggNumberArray[arrayIndex].setText(Integer.toString(tillaggNumber[arrayIndex]));
                //tillaggNumberArray[arrayIndex].setBackground(Color.RED);
                tillaggNumberArray[arrayIndex].setForeground(Color.BLUE);
                tillaggNumberArray[arrayIndex].setOpaque(true);
                arrayIndex++;
            }
            
        }
        
    }
    
    //method for filling the eurojackpotnumber-array
    //and making sure that every number (1-50) are represented once
    public void randomizeEurojackpotNumbers(){
        
        for (int i = 0 ; i < 50 ; i++){
            eurojackpotNumber[i] = 0;
        }
        
        
        for(int x = 0 ; x<50 ; x++){
            
            int ra = ran.nextInt(50);
            eurojackpotNumber[x] = (ra + 1);
        }
        
        int x= 0;
        while( x<50 ){
            
            for(int i = 0 ; i<50 ; i++){
                
                if(eurojackpotNumber[x] == eurojackpotNumber[i] && i!=x){
                    int ra = ran.nextInt(50);
                    eurojackpotNumber[x] = (ra + 1);
                    x=0;
                }
            }
            x++;
        }
        
        sortEurojackpotNumberArray();
    }
    
   
    //Sorting every eurojackpot-row in acsending order
    public void sortEurojackpotNumberArray(){
        
        int temp = 0;
        
        for (int i = 0; i < 5; i++) {
            
            for (int j = i; j > 0; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 5; i < 10; i++) {
            
            for (int j = i; j > 5; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 10; i < 15; i++) {
            
            for (int j = i; j > 10; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 15; i < 20; i++) {
            
            for (int j = i; j > 15; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 20; i < 25; i++) {
            
            for (int j = i; j > 20; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 25; i < 30; i++) {
            
            for (int j = i; j > 25; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 30; i < 35; i++) {
            
            for (int j = i; j > 30; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 35; i < 40; i++) {
            
            for (int j = i; j > 35; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 40; i < 45; i++) {
            
            for (int j = i; j > 40 ; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
        temp = 0;
        
        for (int i = 45; i < 50; i++) {
            
            for (int j = i; j > 45; j--) {
                
                if (eurojackpotNumber[j] < eurojackpotNumber [j - 1]) {
                 
                    temp = eurojackpotNumber[j];
                    eurojackpotNumber[j] = eurojackpotNumber[j - 1];
                    eurojackpotNumber[j - 1] = temp;
                   }
            }
        }
        
    }
    
    //method for filling the tillaggnumber-array
    //and making sure that the 2 tillagg-numbers are not the same
    //and that every number 1-10 are included twice
     public void randomizetillaggNumbers(){
        
        int[] tillaggNumberFirst10= new int[10];
        int[] tillaggNumberSecond10= new int[10];
        
        for (int i = 0 ; i < 20 ; i++){
            tillaggNumber[i] = 0 ;
        }
        
        for (int i = 0 ; i < 10 ; i++){
            tillaggNumberFirst10[i] = 0 ;
        }
        
        for (int i = 0 ; i < 10 ; i++){
            tillaggNumberSecond10[i] = 0 ;
        }
        
        
        for(int x = 0 ; x<10 ; x++){
            int ra = ran.nextInt(10);
            tillaggNumberFirst10[x] = (ra + 1);
        }
        
        int index1 = 0;
        while( index1<10 ){
            
            for(int i = 0 ; i<10 ; i++){
                
                if((tillaggNumberFirst10[index1] == tillaggNumberFirst10[i]) && (i!=index1)){
                    int ra = ran.nextInt(10);
                    tillaggNumberFirst10[index1] = (ra + 1);
                    index1=0;
                }
            }
            index1++;
            
        }
        
        
        for(int x = 0 ; x<10 ; x++){
            int ra = ran.nextInt(10);
            tillaggNumberSecond10[x] = (ra + 1);
        }
        
        int index2= 0;
        while( index2<10 ){
            
            for(int i = 0 ; i<10 ; i++){
                
                if(tillaggNumberSecond10[index2] == tillaggNumberSecond10[i] && i!=index2){
                    int ra = ran.nextInt(10);
                    tillaggNumberSecond10[index2] = (ra + 1);
                    index2=0;
                }
            }
            index2++;
        }
        
        for (int i = 0 ; i < 10 ; i++){
            tillaggNumber[i] = tillaggNumberFirst10[i];
        }
        
        for (int i = 10 ; i < 20 ; i++){
            tillaggNumber[i] = tillaggNumberSecond10[i-10];
        }
        
        sortTillaggNumberArray();
    }
    
     //Sorting the 10 pairs of 2 tillagg-numbers in acsending order
    public void sortTillaggNumberArray(){
        
        int temp = 0;
        
        for (int i = 0; i < 2; i++) {
            
            for (int j = i; j > 0; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 2; i < 4; i++) {
            
            for (int j = i; j > 2; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 4; i < 6; i++) {
            
            for (int j = i; j > 4; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 6; i < 8; i++) {
            
            for (int j = i; j > 6; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 8; i < 10; i++) {
            
            for (int j = i; j > 8; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 10; i < 12; i++) {
            
            for (int j = i; j > 10; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 12; i < 14; i++) {
            
            for (int j = i; j > 12; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 14; i < 16; i++) {
            
            for (int j = i; j > 14; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 16; i < 18; i++) {
            
            for (int j = i; j > 16; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
        for (int i = 18; i < 20; i++) {
            
            for (int j = i; j > 18; j--) {
                
                if (tillaggNumber[j] < tillaggNumber [j - 1]) {
                 
                    temp = tillaggNumber[j];
                    tillaggNumber[j] = tillaggNumber[j - 1];
                    tillaggNumber[j - 1] = temp;
                   }
            }
        }
        
        checkTillaggArrayForDublicatePair();
    }
    
    //If there is one or more dublicates of one pair
    //the randomize method is called to make a new randomize
    public void checkTillaggArrayForDublicatePair(){
        
        String[] strArray = new String[10];
        
        for (int w = 0 ; w < 10 ; w++){
            strArray[w] = "";
        }
        
        int strIndex = 0;
        for (int x = 0 ; x < 20 ; x+=2){
            strArray[strIndex] = Integer.toString(tillaggNumber[x]) + "+" + Integer.toString(tillaggNumber[x+1]);
            strIndex++;
        }
        
        for (int y = 0 ; y < 10 ; y++){
            for (int z = 0 ; z < 10 ; z++){
                if (y==0){
                    //System.out.println(strArray[z]);
                }
                
                if((strArray[y].equalsIgnoreCase(strArray[z]) && (y != z))){
                    //System.out.println(strArray[y] + "," + strArray[z]);
                    randomizetillaggNumbers();
                }
            }
        }
        
    }
    
    
}
