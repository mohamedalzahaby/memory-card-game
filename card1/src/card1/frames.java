package card1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class frames extends JFrame {
    JLabel player1;
    JLabel player2;
    JLabel whoseturn;
    JLabel winner;
    private final int numbuttons = 52;
    JButton[] button = new JButton[numbuttons] ;
    JLabel lab1 = new JLabel();
    String [] x = { "d:\\cards\\acecaro.png" , "d:\\cards\\aceheart.png" , "d:\\cards\\acespades.png" ,"d:\\cards\\acetriphle.png",
                    "d:\\cards\\2poker.png","d:\\cards\\2heart.png","d:\\cards\\2diamond.png","d:\\cards\\2spade.png",
                    "d:\\cards\\3poker.png","d:\\cards\\3heart.png","d:\\cards\\3diamond.png","d:\\cards\\3spade.png",
                    "d:\\cards\\4poker.png","d:\\cards\\4heart.png","d:\\cards\\4diamond.png","d:\\cards\\4spade.png",
                    "d:\\cards\\5poker.png","d:\\cards\\5heart.png","d:\\cards\\5diamond.png","d:\\cards\\5spade.png",
                    "d:\\cards\\6poker.png","d:\\cards\\6heart.png","d:\\cards\\6diamond.png","d:\\cards\\6spade.png",
                    "d:\\cards\\7poker.png","d:\\cards\\7heart.png","d:\\cards\\7diamond.png","d:\\cards\\7spade.png",
                    "d:\\cards\\8poker.png","d:\\cards\\8heart.png","d:\\cards\\8diamond.png","d:\\cards\\8spade.png",
                    "d:\\cards\\9poker.png","d:\\cards\\9heart.png","d:\\cards\\9diamond.png","d:\\cards\\9spade.png",
                    "d:\\cards\\10poker.png","d:\\cards\\10heart.png","d:\\cards\\10diamond.png","d:\\cards\\10spade.png",
                    "d:\\cards\\jackpoker.png" ,"d:\\cards\\jackheart.png","d:\\cards\\jackdiamond.png","d:\\cards\\jackspade.png",
                    "d:\\cards\\queenpoker.png","d:\\cards\\queenheart.png","d:\\cards\\queendiamond.png","d:\\cards\\queenspade.png",
                    "d:\\cards\\kingpoker.png" ,"d:\\cards\\kingheart.png","d:\\cards\\kingdiamond.png","d:\\cards\\kingspade.png"}; 
    
    
    private int ctr ;
    int turn =2;
    int p1turn=0;
    int p2turn=0;
    int turning;
    public frames()
    {
        setSize(800, 800);
        setTitle("memory");
        ctr = 0;
        turning =1;
        for(int i=0 ; i <numbuttons ; i++ )
        {
            int numi = i+1;
            button[i] = new JButton("card " + numi);
        }
        this.setLayout(new FlowLayout());
        
        player1 = new JLabel("starting ");
        player2 = new JLabel("starting   ");
        whoseturn = new JLabel("turn of player"+ turning);
        winner = new JLabel();
        for(int i=0 ; i <numbuttons ; i++ )
        {
            button[i].addActionListener(new ButtonWatcher() );
        }
        for(int i=0 ; i <numbuttons ; i++ )
        {
            this.getContentPane().add(button[i]);
        }
        this.getContentPane().add(player1);
        this.getContentPane().add(player2);
        this.getContentPane().add(lab1);
        lab1.setIcon(new ImageIcon(new ImageIcon("d:\\cards\\joker.jpg").getImage().getScaledInstance(300,400, Image.SCALE_DEFAULT)));
        this.getContentPane().add(whoseturn);
        this.getContentPane().add(winner);
        
        
    }
    
    
    Object p1 = null;
    Object p2;
    private class ButtonWatcher implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            
            Object buttonPressed = ae.getSource();
            for(int i=0 ; i <numbuttons ; i++ )
            {
                if(buttonPressed.equals(button[i]))
                {
                    lab1.setIcon(new ImageIcon(new ImageIcon(x[i]).getImage().getScaledInstance(300,400, Image.SCALE_DEFAULT)));
                    
                }
            }
            ctr++;
            if(ctr >2)
            {
                ctr=1;  
            }
            if(ctr ==1){p1 = ae.getSource();}

            else if(ctr ==2)
            {
                
                
                int i=0;
                while(i<52)
                {
                    int a = i+1;
                    int b = i+2;
                    int c = i+3;
                    
                    if( ( p1.equals(button[i]) && buttonPressed.equals(button[a]) ) || ( p1.equals(button[a]) && buttonPressed.equals(button[i]) ) || ( p1.equals(button[i]) && buttonPressed.equals(button[b]) ) || ( p1.equals(button[b]) && buttonPressed.equals(button[i]) ) || ( p1.equals(button[i]) && buttonPressed.equals(button[c]) ) || ( p1.equals(button[c]) && buttonPressed.equals(button[i]) ) || ( p1.equals(button[a]) && buttonPressed.equals(button[b]) ) || ( p1.equals(button[b]) && buttonPressed.equals(button[a]) ) || ( p1.equals(button[a]) && buttonPressed.equals(button[c]) ) || ( p1.equals(button[c]) && buttonPressed.equals(button[a]) ) || ( p1.equals(button[b]) && buttonPressed.equals(button[c]) ) || ( p1.equals(button[c]) && buttonPressed.equals(button[b]) )   ) 
                    {
                        turn++;
                        if(turn%2 != 0)
                        {
                            p1turn++;
                            player1.setText("First player  = "+ p1turn );
                        }
                        if(turn%2 == 0)
                        {
                            p2turn++;
                            player2.setText("Second player  = "+ p2turn );
                        }
                    }
                    else 
                    {
                        turn++;
                        if(turn%2 != 0)
                        {
                            player1.setText("First player  = "+ p1turn );
                        }
                        if(turn%2 == 0)
                        {
                            player2.setText("Second player  = "+ p2turn );
                        }
                    }
                    
                    if(p1turn == 3)
                    {
                        winner.setText("winner is first player");
                        break;
                    }
                    if(p2turn == 3)
                        {
                            winner.setText("winner is second player");
                            break;
                        }
                    
                    turning++;
                    if ( turning >2 )
                    {
                        turning = 1;
                    }
                    whoseturn.setText("turn of player "+turning);

                    i = i+4;
                }       
            }
            
            
        }
    }



}
