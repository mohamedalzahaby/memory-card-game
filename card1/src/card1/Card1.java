package card1;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Card1{
    public static void main(String[] args) 
    {
        JOptionPane.showMessageDialog(null, "Welcome to memory game", "memory game",JOptionPane.DEFAULT_OPTION );
        JOptionPane.showMessageDialog(null, "the game depends on memorising the position of cards. \n cards are hidden inside buttons and each player should search for two buttons with the same card number  ", "memory game",JOptionPane.DEFAULT_OPTION );
        JOptionPane.showMessageDialog(null, "players use to get points each time they find out similar cards \n the player who reach 3 points first is the winner", "memory game",JOptionPane.DEFAULT_OPTION );
        frames f = new frames();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    
    }
    
}
