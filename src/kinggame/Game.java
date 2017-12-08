/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinggame;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author yehya_000
 */
public class Game extends JFrame implements MouseMotionListener{

    private Decks players = new Decks();
    private int turn = 0;
    JLabel wal = new JLabel();
    JLabel winner = new JLabel();
ArrayList <Cards> cards1=new ArrayList<Cards>();
ArrayList <Cards> cards2=new ArrayList<Cards>();
ArrayList<Integer> p1c= new ArrayList<Integer>(25);
ArrayList<Integer> p2c= new ArrayList<Integer>(25);
    Cards card;
    private void setCor()
    {
        int x = 0;
        for(int i = 0; i<25;i++)
        {
            p1c.add(i, x);
            p2c.add(i, x);
            x+=60;
        }
    }
    private void removeAlike()
    {
        int counter = 0;
        for(int i = 1;i<12;i++)
        {
            
            counter = 0;
            
                for(int j = 0; j < cards1.size();j++)
                {
                
                 if(i==cards1.get(j).value)
                 {
                     counter++;
                     
                
                 }
                }
             if(counter==4)
            {
                
               
               for(int h = 0; h<cards1.size();h++){
                
                   if(i==cards1.get(h).value)
                   {
                       cards1.get(0+h).label.setVisible(false);
                       cards1.remove(0+h);
                       h--;
                   }
                }
                counter=0; 
            }
            
        }
        
        
        
        
        
        
         for(int i = 1;i<12;i++)
        {
            
            counter = 0;
            
                for(int j = 0; j < cards2.size();j++)
                {
                
                 if(i==cards2.get(j).value)
                 {
                     counter++;
                     
                
                 }
                }
             if(counter==4)
            {
                
               
               for(int h = 0; h<cards2.size();h++){
                
                   if(i==cards2.get(h).value)
                   {
                       cards2.get(0+h).label.setVisible(false);
                      
                       cards2.remove(0+h);
                       h--;
                   }
                }
                counter=0; 
            }
            
        }
    }
    private void fix()
    {
        for(int i = 0; i < cards1.size();i++)
        {
            cards1.get(i).label.setBounds(p1c.get(i), 10, 60, 70);
        }
        for(int i = 0; i < cards2.size();i++)
        {
            cards2.get(i).label.setBounds(p2c.get(i), 600, 60, 70);
        }
        remove(wal);
        wal.setIcon(new ImageIcon(new ImageIcon("D:\\test\\wall.jpg").getImage().getScaledInstance(1350, 800,2000)));
            wal.setBounds(0,0, 1350, 800);
            add(wal);
            if(cards1.size()==0)
            {
                 winner.setIcon(new ImageIcon(new ImageIcon("D:\\test\\winner1.jpg").getImage().getScaledInstance(1350, 800,2000)));
            winner.setBounds(0,0, 1350, 800);
            winner.setVisible(true);
            }
            if(cards2.size()==0)
            {
                winner.setIcon(new ImageIcon(new ImageIcon("D:\\test\\winner2.jpg").getImage().getScaledInstance(1350, 800,2000)));
            winner.setBounds(0,0, 1350, 800);
            winner.setVisible(true);
            }
        
    }
    public Game()
    {
        add(winner);
        winner.setVisible(false);
        setCor();
        setTitle("King");
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        setSize(env.getMaximumWindowBounds().width, env.getMaximumWindowBounds().height);
       
        setLayout(null);
        
        
        
        for(int i = 0; i < players.deck1.size(); i++)
        {
            Cards crd = new Cards();
        crd.value = players.deck1.get(i);
        crd.setimg();
        JLabel j=new JLabel();
            j.setIcon(new ImageIcon(new ImageIcon(crd.path).getImage().getScaledInstance(60, 70,50)));
            add(j);
            j.addMouseMotionListener(this);
            
            crd.label=j;
            cards1.add(crd);
            
        }
       
         for(int i = 0; i < players.deck2.size(); i++)
        {
            Cards crd = new Cards();
        crd.value = players.deck2.get(i);
        crd.setimg();
        JLabel j=new JLabel();
            j.setIcon(new ImageIcon(new ImageIcon(crd.path).getImage().getScaledInstance(60, 70,50)));
            add(j);
            j.addMouseMotionListener(this);
            
            crd.label=j;
            cards2.add(crd);
            
        }
         removeAlike();
          JLabel l=new JLabel();
           l.setIcon(new ImageIcon(new ImageIcon("D:\\test\\hole.jpg").getImage().getScaledInstance(1350, 100,2000)));
           
            l.setBounds(0,0, 1350, 800);
            
            
             add(l);
         fix();
         
         
         
             
             
         
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void mouseDragged(MouseEvent e) {
        
      
        for (Cards p:cards1)
        {
        if (p.label.equals(e.getSource()))
        {
           if(turn ==0)
            p.label.setBounds(e.getXOnScreen()-20,e.getYOnScreen()-160, 240, 320);
         
          if(p.label.getBounds().y>200 && p.label.getBounds().y<300)
          {
              Cards crd = new Cards();
              crd.value = p.value;
              crd.setimg();
        JLabel j=new JLabel();
            j.setIcon(new ImageIcon(new ImageIcon(crd.path).getImage().getScaledInstance(60, 70,50)));
            add(j);
            j.addMouseMotionListener(this);
            
            crd.label=j;
              cards2.add(crd);
              cards2.get(cards2.size()-1).label.setVisible(true);
              p.label.setVisible(false);
              cards1.remove(p);
              removeAlike();
              fix();
              turn  = 1;
              break;
              
              
        
            
            
              
          }
         
        
           
            
        }
        
        }
         for (Cards p:cards2)
        {
        if (p.label.equals(e.getSource()))
        {
           if(turn==1)
            p.label.setBounds(e.getXOnScreen()-20,e.getYOnScreen()-160, 240, 320);
        
         if(p.label.getBounds().y>200 && p.label.getBounds().y<300)
          {
              
              Cards crd = new Cards();
              crd.value = p.value;
              crd.setimg();
        JLabel j=new JLabel();
            j.setIcon(new ImageIcon(new ImageIcon(crd.path).getImage().getScaledInstance(60, 70,50)));
            add(j);
            j.addMouseMotionListener(this);
            
            crd.label=j;
              cards1.add(crd);
              cards1.get(cards1.size()-1).label.setVisible(true);
              p.label.setVisible(false);
              cards2.remove(p);
              removeAlike();
              fix();
              turn =0;
              break;
             
          }
        
           
            
        }
        
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

   
    
}
