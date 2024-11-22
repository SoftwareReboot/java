package game;

import javax.swing.JFrame;

public class app {
    public static void main(String[] args) {
        int countRow = 21;
        int countColumn = 19;
        int tileSize = 32;
        int boardWidth = countColumn * tileSize;
        int boardHeight = countRow * tileSize;
        
        JFrame fr = new JFrame(" Pac Man ");
        //fr.setVisible(true);
        fr.setSize(boardWidth, boardHeight);
        fr.setLocationRelativeTo(null);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Pacman pm = new Pacman();
        fr.add(pm);
        fr.pack();
        pm.requestFocus();
        fr.setVisible(true);
    }
}
