package game;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Random;
import javax.swing.*;
 
public class Pacman extends JPanel implements ActionListener, KeyListener {
        class Block{
            int x;
            int y;
            int width;
            int height;
            Image image;

            int startX;
            int startY;
            char direction = 'U';
            int velocityX = 0;
            int velocityY = 0;

            Block(Image image, int x, int y, int width, int height){
                this.image = image;
                this.x = x;
                this.y = y;
                this.width = width;
                this.height = height;
                this.startX = x;
                this.startY = y;
            }

            void updateDirection(char direction) {
                char prevDirection = this.direction;
                this.direction = direction;
                updateVelocity();
                this.x += velocityX;
                this.y += velocityY;
                for (Block wall : walls) {
                    if (collision(this, wall)) {
                        this.x -= this.velocityX;
                        this.y -= this.velocityY;
                        this.direction = prevDirection;
                        updateVelocity();
                    }
                }
            }
            
            void updateVelocity(){
                if (this.direction == 'U') {
                    this.velocityX = 0;
                    this.velocityY = -tileSize / 4;
                }
                else if(this.direction == 'D'){
                    this.velocityX = 0;
                    this.velocityY = tileSize / 4;
                }
                else if (this.direction == 'L') {
                    this.velocityX = -tileSize / 4;
                    this.velocityY = 0;
                }
                else if (this.direction == 'R'){
                    this.velocityX = tileSize / 4;
                    this.velocityY = 0;
                }
            }
            void resetGame(){
                this.x = this.startX;
                this.y = this.startY;
            }
        }
    private int countRow = 21;
    private int countColumn = 19;
    private int tileSize = 32;
    private int boardWidth = countColumn * tileSize;
    private int boardHeight = countRow * tileSize;

    //variables storing the images for the game
        private Image wallImage;// images for the Wall
    // images contains for the ghosts
        private Image blueGhostImage;
        private Image orangeGhostImage;
        private Image pinkGhostImage;
        private Image redGhostImage;
    //images contains for pacman(MoveSet)
        private Image PacmanUpImage;
        private Image PacmanDownImage;
        private Image PacmanLeftImage;
        private Image PacmanRightImage;

    //X = wall, O = skip, P = pac man, ' ' = food
    //Ghosts: b = blue, o = orange, p = pink, r = red
    private String[] tileMap = {
        "XXXXXXXXXXXXXXXXXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X                 X",
        "X XX X XXXXX X XX X",
        "X    X       X    X",
        "XXXX XXXX XXXX XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXrXX X XXXX",
        "O       bpo       O",
        "XXXX X XXXXX X XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXXXX X XXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X  X     P     X  X",
        "XX X X XXXXX X X XX",
        "X    X   X   X    X",
        "X XXXXXX X XXXXXX X",
        "X                 X",
        "XXXXXXXXXXXXXXXXXXX" 
    };

    
        
    HashSet<Block>walls;
    HashSet<Block>foods;
    HashSet<Block>ghosts;
    Block Pacman;
    
    Timer gameLoop;
    char[] directions = {'U', 'D', 'L', 'R'};
    Random rndm = new Random();
    int score = 0;
    int lives = 3;
    boolean gameOver = false;

Pacman(){
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.BLACK);
        addKeyListener(this);
        setFocusable(true);
        //loading the Images
        wallImage = new ImageIcon(getClass().getResource("./wall.png")).getImage();

        //loading the images for the Ghost
        blueGhostImage = new ImageIcon(getClass().getResource("./blueGhost.png")).getImage();
        orangeGhostImage = new ImageIcon(getClass().getResource("./orangeGhost.png")).getImage();
        pinkGhostImage = new ImageIcon(getClass().getResource("./pinkGhost.png")).getImage();
        redGhostImage = new ImageIcon(getClass().getResource("./redGhost.png")).getImage();
        
        //loading image for pacman
        PacmanUpImage = new ImageIcon(getClass().getResource("./pacmanUp.png")).getImage();
        PacmanDownImage = new ImageIcon(getClass().getResource("./pacmanDown.png")).getImage();
        PacmanLeftImage = new ImageIcon(getClass().getResource("./pacmanLeft.png")).getImage();
        PacmanRightImage = new ImageIcon(getClass().getResource("./pacmanRight.png")).getImage();

        loadMap();
        for (Block ghost : ghosts) {
            char newDirection = directions[rndm.nextInt(4)];
            ghost.updateDirection(newDirection);
        }
         //how long it takes to start timer, milliseconds gone between frames
        gameLoop = new Timer(50, this);//20fps (1000/50)
        gameLoop.start();
        
    }

    public void loadMap() {
        walls = new HashSet<>();
        foods = new HashSet<>();
        ghosts = new HashSet<>();
        for (int r = 0; r < countRow; r++) {
            String row = tileMap[r];
            for (int c = 0; c < Math.min(row.length(), countColumn); c++) { 
                char tileMapChar = row.charAt(c);
    
                int x = c * tileSize;
                int y = r * tileSize;
    
                if (tileMapChar == 'X') { // Block wall
                    Block wall = new Block(wallImage, x, y, tileSize, tileSize);
                    walls.add(wall);
                } else if (tileMapChar == 'b') { // Block blue ghost
                    Block ghost = new Block(blueGhostImage, x, y, tileSize, tileSize);
                    ghosts.add(ghost);
                } else if (tileMapChar == 'o') { // Block orange ghost
                    Block ghost = new Block(orangeGhostImage, x, y, tileSize, tileSize);
                    ghosts.add(ghost);
                } else if (tileMapChar == 'p') { // Block pink ghost
                    Block ghost = new Block(pinkGhostImage, x, y, tileSize, tileSize);
                    ghosts.add(ghost);
                } else if (tileMapChar == 'r') { // Block red ghost
                    Block ghost = new Block(redGhostImage, x, y, tileSize, tileSize);
                    ghosts.add(ghost);
                } else if (tileMapChar == 'P') { // Block for Pacman
                    Pacman = new Block(PacmanRightImage, x, y, tileSize, tileSize);
                } else if (tileMapChar == ' ') { // Block for food
                    Block food = new Block(null, x + 14, y + 14, 4, 4);
                    foods.add(food);
                }
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void move() {
        // Move Pacman
        Pacman.x += Pacman.velocityX;
        Pacman.y += Pacman.velocityY;
    
        // Teleport Pacman if it goes beyond boundaries
        if (Pacman.x < -Pacman.width) {
            Pacman.x = boardWidth;
        } else if (Pacman.x > boardWidth) {
            Pacman.x = -Pacman.width;
        }
    
        // Check for wall collision for Pacman
        for (Block wall : walls) {
            if (collision(Pacman, wall)) {
                Pacman.x -= Pacman.velocityX;
                Pacman.y -= Pacman.velocityY;
                break;
            }
        }
     
        // Move ghosts
        for (Block ghost : ghosts) {
            if (ghost.y == tileSize * 9 && ghost.direction != 'U' && ghost.direction != 'D') {
                ghost.updateDirection('U');
            }
            ghost.x += ghost.velocityX;
            ghost.y += ghost.velocityY;
    
            // Teleport ghosts if they go beyond boundaries
            if (ghost.x < -ghost.width) {
                ghost.x = boardWidth;
            } else if (ghost.x > boardWidth) {
                ghost.x = -ghost.width;
            }
    
            // Check for wall collision for ghosts
            for (Block wall : walls) {
                if (collision(ghost, Pacman)) {
                    lives -= 1;
                    if (lives == 0) {
                        gameOver = true;
                        return;
                    }
                    resetPosition();
                }
                if (collision(ghost, wall) || ghost.x <= 0 || ghost.x + ghost.width >= boardWidth) {
                    ghost.x -= ghost.velocityX;
                    ghost.y -= ghost.velocityY;
                    char newDirection = directions[rndm.nextInt(4)];
                    ghost.updateDirection(newDirection);
                }
            }
        }

        //check food collision, everytime pacman consumes food user gains 10pts
        Block foodEated = null;
        for (Block food : foods) {
            if (collision(Pacman, food)) {
                foodEated = food;
                score += 10;
            }   
        }
        foods.remove(foodEated);
    }
    
    

    public boolean collision(Block a, Block b){
        return  a.x < b.x + b.width &&
                a.x + a.width > b.x &&
                a.y < b.y + b.height &&
                a.y + a.height > b.y;
    }

    public void resetPosition(){
        Pacman.resetGame();
        Pacman.velocityX = 0;
        Pacman.velocityY = 0;
        for (Block ghost : ghosts) {
            ghost.resetGame();
            char newDirection = directions[rndm.nextInt(4)];
            ghost.updateDirection(newDirection);
        }
    }
    

    public void draw(Graphics g){
        g.drawImage(Pacman.image, Pacman.x, Pacman.y, Pacman.width, Pacman.height, null);

        for (Block ghost : ghosts) {
            g.drawImage(ghost.image, ghost.x, ghost.y, ghost.width, ghost.height, null);
        }

        for (Block wall : walls) {
            g.drawImage(wall.image, wall.x, wall.y, wall.width, wall.height, null);
        }

        g.setColor(Color.white);
        for (Block food : foods) {
            g.fillRect(food.x, food.y, food.width, food.height);
        }
        //score
        g.setFont(new Font("Arial", Font.PLAIN, 19));
        if (gameOver) {
            g.drawString("Game Over: " + String.valueOf(score), tileSize/2, tileSize/2);
        }else{
            g.drawString("x" + String.valueOf(lives) + " Score: " + String.valueOf(score), tileSize/2, tileSize/2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if (gameOver) {
            gameLoop.stop();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println(" KeyEvent: " + e.getKeyCode());
        if (gameOver) {
            loadMap();
            resetPosition();
            lives = 3;
            score = 0;
            gameOver = false;
            gameLoop.start();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            Pacman.updateDirection('U');
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            Pacman.updateDirection('D');
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            Pacman.updateDirection('L');
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            Pacman.updateDirection('R');
        }

        if (Pacman.direction == 'U') {
            Pacman.image = PacmanUpImage;
        }
        else if(Pacman.direction == 'D'){
            Pacman.image = PacmanDownImage;
        }
        else if(Pacman.direction == 'L'){
            Pacman.image = PacmanLeftImage;
        }
        else if(Pacman.direction == 'R'){
            Pacman.image = PacmanRightImage;
        }
    }
}
