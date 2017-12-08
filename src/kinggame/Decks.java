/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinggame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author yehya_000
 */
public class Decks {
    
      
     private ArrayList<Integer> cards = new ArrayList<Integer>(40);
      public  ArrayList<Integer> deck1 = new ArrayList<Integer>(20);
      public ArrayList<Integer> deck2 = new ArrayList<Integer>(20);
      public int a;
      
    public Decks() {
        Random rand= new Random();
        int counter = 0;
        for(int i = 0; i <10;i++){
      
          for(int j= 0; j <4;j++){
          cards.add(counter, i+1);
          counter++;
          }
          
          
      }
      
      for(int i = 0; i <150;i++)
       Collections.swap(cards,rand.nextInt(39),rand.nextInt(39));
      int d1= 0, d2=0;
      for(int i = 0; i <40;i++)
      {
          if(i%2==0){
              deck1.add(d1, cards.get(i));
              d1++;
          }
          else{
              deck2.add(d2, cards.get(i));
              d2++;
          }
      }
      if(rand.nextInt(2)==1)
          deck1.add(rand.nextInt(9)+1,11);
      else deck2.add(rand.nextInt(9)+1,11);
        
        
    }
            
      
    
}
