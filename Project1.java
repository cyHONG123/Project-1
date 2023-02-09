import javax.swing.*;

import java.util.Random;
import java.awt.*;
import java.awt.event.*;
public class Project1 extends JPanel {
    int upperbond = 4;
    int emptynum;
    int starta =2;
    int gameover;
    int validmoves;
    String text;
    Timer timer;
    int max;
    Random ram = new Random();


    int[][] board = new int[4][4];

    public void createrandom() {
        int startram = ram.nextInt(10);
        int q1 = ram.nextInt(4);
        int q2 = ram.nextInt(4);
        if(board[q1][q2]==0) {
            if(startram <=1) {
                board[q1][q2] = 4;
            };
            if(startram >=1) {
                board[q1][q2] = 2;
            }
            validmoves++;
            checksolution();
            System.out.println("valid move!");
        } else{
            createrandom();
        }
    }
    public void drawMaxnum(Graphics g) {
        g.setColor(Color.blue);
        g.drawString("Largest number: " + max, 700, 250);
        g.drawString("Valid move: " + validmoves , 700, 200);
        g.drawString("Press R to restart", 700, 300);
        g.drawString("Press Q to quit" , 700, 350);
    }
    public void drawEndgame(Graphics g) {
        g.setColor(Color.black);
        g.drawString("Game Over", 400, 500);
    }
    public void checksolution() {
        int zero =0;
        max = board[0][0];
        for(int i =0; i<4; i++) {
            for(int j =0; j<4; j++) {
                if(board[i][j]>max) {
                    max=board[i][j];
                }
                if(board[i][j]==0) {
                    zero++;
                }
            }
        }
        System.out.println("Largest number: " + max);
        System.out.println("Valid moves: " + validmoves);
        if(zero==0) {
            System.out.println("Game Over");
            gameover++;
            System.out.println("Largest number: " + max);
            System.out.println("Valid moves: " + validmoves);
        }
    }
    public void getText(String text) {
        this.text = text;
    }

    public void drawBoard(Graphics g) {
        if(starta ==2) {
            spawnRandom();
            starta=0;
        }
        Font font1 = new Font("Consolas", Font.ITALIC, 35);
        g.setFont(font1);
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                if(board[a][b]!=0) {
                    int v = board[a][b];
                    String k = String.valueOf(v);
                    g.setColor(Color.red);
                    g.drawString(k, 115 + 100 * a, 80 + 100 * b);
                }

            }
        }
    }
    public void up() {
        int move=0;
       for (int a=0; a<4; a++) {
           for(int b =0; b<4; b++) {
               int src =b;
               while(b-1<4&&b-1>-1&&(board[a][b-1]==0||board[a][b]==board[a][b-1])){
                   if(board[a][b-1]==0) {
                       board[a][b-1]=board[a][b];
                       board[a][b]=0;
                       b--;
                       move++;
                   } else if(board[a][b]==board[a][b-1]) {
                       board[a][b-1]=board[a][b]*2;
                       board[a][b]=0;
                       b--;
                       move++;
                       break;
                   }
               }
               b=src;
           }
       }
        if (move>0) {
            createrandom();
            move = 0;}
        System.out.println("Pressed UP!");
    }

    public void right() {
        int move=0;
        for (int a=0; a<4; a++) {
            for(int b =3; b>-1; b--) {
                int src =b;
                while(b+1<4&&b+1>-1&&(board[b+1][a]==0||board[b][a]==board[b+1][a])){
                    if(board[b+1][a]==0) {
                        board[b+1][a]=board[b][a];
                        board[b][a]=0;
                        b++;
                        move++;
                    } else if(board[b][a]==board[b+1][a]) {
                        board[b+1][a]=board[b][a]*2;
                        board[b][a]=0;
                        b++;
                        move++;
                        break;
                    }
                }
                b=src;
            }
        }
        if (move>0) {
            createrandom();
            move = 0;}
        System.out.println("Pressed RIGHT!");
    }
    public void setOrigin() {
        for(int m =0; m<4; m++) {
            for(int k =0; k<4; k++) {
                board[m][k] =0;
            }
        }
        starta=2;
        spawnRandom();
    }
    public void left() {
        int move=0;
        for (int a=0; a<4; a++) {
            for(int b =0; b<4; b++) {
                int src =b;
                while(b-1<4&&b-1>-1&&(board[b-1][a]==0||board[b][a]==board[b-1][a])){
                    if(board[b-1][a]==0) {
                        board[b-1][a]=board[b][a];
                        board[b][a]=0;
                        b--;
                        move++;
                    } else if(board[b][a]==board[b-1][a]) {
                        board[b-1][a]=board[b][a]*2;
                        board[b][a]=0;
                        b--;
                        move++;
                        break;
                    }
                }
                b=src;
            }
        }
        if (move>0) {
            createrandom();
            move = 0;}
        System.out.println("Pressed LEFT!");
    }
    public void down() {
        int move=0;
        for (int a=0; a<4; a++) {
            for(int b =3; b>-1; b--) {
                int src =b;
                while(b+1<4&&b+1>-1&&(board[a][b+1]==0||board[a][b]==board[a][b+1])){
                    if(board[a][b+1]==0) {
                        board[a][b+1]=board[a][b];
                        board[a][b]=0;
                        b++;
                        move++;
                    } else if(board[a][b]==board[a][b+1]) {
                        board[a][b+1]=board[a][b]*2;
                        board[a][b]=0;
                        b++;
                        move++;
                        break;
                    }
                }
                b=src;
            }
        }
        if (move>0) {
            createrandom();
            move = 0;}
        System.out.println("Pressed DOWN!");
    }
    public void spawnRandom(){
        while (starta != 0) {
            int randomnum = ram.nextInt(4);
            int randomnum2 = ram.nextInt(4);
            int startnum = ram.nextInt(10);
            int a = randomnum;
            int b = randomnum2;
            if (board[a][b] == 0) {
                if(startnum <=1) {
                    board[a][b] = 4;
                };
                if(startnum >=1) {
                    board[a][b] = 2;
                }
                starta--;
            }
        }
    }
    public void start(){
        starta=2;
        spawnRandom();
        repaint();

    }




    public Project1() {
        this.setPreferredSize(new Dimension(1200, 700));
        setFocusable(true);
        addKeyListener(new KeyListener() {
            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_A) {
                    if(gameover==0){left();}
                }
                if (key == KeyEvent.VK_D) {
                    if(gameover==0){right();}
                }
                if (key == KeyEvent.VK_W) {
                    if(gameover==0){up();}
                }
                if (key == KeyEvent.VK_S) {
                    if(gameover==0){down();}
                }
                if (key == KeyEvent.VK_Q) {
                    System.exit(0);
                }
                if (key == KeyEvent.VK_R) {
                    gameover=0;
                    validmoves=0;
                    setOrigin();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            public void keyTyped(KeyEvent e) {

            }
        });
        timer = new Timer(100, this::actionPerformed);
        timer.start();
    }
    public void actionPerformed(ActionEvent e ) {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.black);
        g.drawLine(80,20,480,20);
        g.drawLine(80,120,480,120);
        g.drawLine(80,220,480,220);
        g.drawLine(80,320,480,320);
        g.drawLine(80,420,480,420);
        g.drawLine(80,20,80,420);
        g.drawLine(180,20,180,420);
        g.drawLine(280,20,280,420);
        g.drawLine(380,20,380,420);
        g.drawLine(480,20,480,420);
        drawBoard(g);
        drawMaxnum(g);
        if (gameover>0) {
        drawEndgame(g);
        };

       repaint();



    }



    public static void main(String[] args) {
        Project1 d1 = new Project1();
        JFrame f = new JFrame();
        f.setSize(1200, 700);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(d1);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }


}


