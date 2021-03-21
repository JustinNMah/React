package react;
import java.awt.event.ActionEvent; //importing stuff
import java.awt.event.ActionListener;
import java.awt.Graphics2D;
import java.lang.Math.*;
import java.text.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 333532182
 */
public class react extends javax.swing.JFrame {
//Initializing variables
DecimalFormat df = new DecimalFormat("###.##");
int count = 0;
int randTime = (int)Math.ceil(Math.random()*5+1); //Random number used to randomize the time the images show during the game
int btnCount = 0;
int btnVar = 0;
int newRand = 0;
float flt10MS = 0;
BufferedImage image;
String [] arrScores = {"","","","","",""};
    /**
     * Creates new form react
     */
    public react() {
        initComponents();
        this.lblError.setVisible(false);
        home();
        
//Error handling for every image
        try {
            image = ImageIO.read(new File(getClass().getResource("/Images/frites.jpg").toURI()));
        } 
        catch(IOException | URISyntaxException | NullPointerException e) {
            System.out.println ("Check your /Images/ folder for frites.jpg");
            this.lblError.setVisible(true);
        }
        try {
            image = ImageIO.read(new File(getClass().getResource("/Images/mang.jpg").toURI()));
        } 
        catch(IOException | URISyntaxException | NullPointerException e) {
            System.out.println ("Check your /Images/ folder for mang.jpg");
            this.lblError.setVisible(true);
        }
        try {
            image = ImageIO.read(new File(getClass().getResource("/Images/orang.jpg").toURI()));
        } 
        catch(IOException | URISyntaxException | NullPointerException e) {
            System.out.println ("Check your /Images/ folder for orang.jpg");
            this.lblError.setVisible(true);
        }
        try {
            image = ImageIO.read(new File(getClass().getResource("/Images/pep.png").toURI()));
        } 
        catch(IOException | URISyntaxException | NullPointerException e) {
            System.out.println ("Check your /Images/ folder for pep.png");
            this.lblError.setVisible(true);
        }
        try {
            image = ImageIO.read(new File(getClass().getResource("/Images/pizza.png").toURI()));
        } 
        catch(IOException | URISyntaxException | NullPointerException e) {
            System.out.println ("Check your /Images/ folder for pizza.png");
            this.lblError.setVisible(true);
        }
    }
    /**
     * Just a function to return to the home screen
     */
    public void home(){
        this.btnReact1.setVisible(false);
        this.btnReact2.setVisible(false);
        this.btnReact3.setVisible(false);
        this.btnReact1.setEnabled(false);
        this.btnReact2.setEnabled(false);
        this.btnReact3.setEnabled(false);
        this.lblPear.setVisible(false);
        this.lblTitle.setVisible(false);
        this.lblTimer.setVisible(false);
        this.pnlBack.setVisible(true);
        this.btnStart.setVisible(true);
        this.btnStart.setEnabled(true);
        this.btnHighscore.setVisible(true);
        this.lblHigh1.setVisible(false);
        this.lblHigh2.setVisible(false);
        this.lblHigh3.setVisible(false);
        this.lblHighscoreTitle.setVisible(false);
        this.lblInput.setVisible(false);
        this.txtInput.setVisible(false);
        this.txtInput.setEnabled(true);
        this.btnEnter.setVisible(false);
        this.btnBack.setVisible(false);
        this.lblThree.setVisible(false);
        this.lblNewScore.setVisible(false);
        this.lblScoresAdded.setVisible(false);
        this.lblHighscore.setText("Highscore " + arrScores[1]);
        if (arrScores[1].equals("")){
            this.lblHighscore.setVisible(false);
        }
        count = 0;
        randTime = (int)Math.ceil(Math.random()*5+1);
        btnCount = 0;
        btnVar = 0;
        newRand = 0;
        flt10MS = 0;
    }
    /**
     * Function to use when the player gets a new highscore
     */
    public void highscoreScreen(){
        this.btnReact1.setVisible(false);
        this.btnReact2.setVisible(false);
        this.btnReact3.setVisible(false);
        this.btnReact1.setEnabled(false);
        this.btnReact2.setEnabled(false);
        this.btnReact3.setEnabled(false);
        this.lblPear.setVisible(false);
        this.lblTitle.setVisible(false);
        this.lblTimer.setVisible(true);
        this.pnlBack.setVisible(true);
        this.btnStart.setVisible(false);
        this.btnHighscore.setVisible(false);
        this.lblHigh1.setVisible(false);
        this.lblHigh2.setVisible(false);
        this.lblHigh3.setVisible(false);
        this.lblHighscoreTitle.setVisible(false);
        this.lblInput.setVisible(true);
        this.txtInput.setVisible(true);
        this.txtInput.setEnabled(true);
        this.btnEnter.setVisible(true);
        this.btnEnter.setEnabled(true);
        this.btnBack.setVisible(false);
        this.lblNewScore.setVisible(true);
    }
    
    /**
     * This function inserts a score and a name into the score array.  It pushes back the other scores behind it.
     * @param index The index at which the score should be inserted
     * @param score The score being inserted
     * @param name The name accompanying the score
     */
    public void arrayInsert(int index, String score, String name){
        for (int i = 5; i > index; i--){
            arrScores[i] = arrScores[i-2];
        }
        arrScores[index] = score;
        arrScores[index-1] = name;
    }
    
    //Stopwatch that counts every 10 miliseconds
    javax.swing.Timer stopwatch = new javax.swing.Timer(10, new ActionListener() {
          public void actionPerformed(ActionEvent start) {
              flt10MS += 0.01;
              
          }
       });
    
    /**
     * A timer which controls the timing of the game
     */
    javax.swing.Timer t = new javax.swing.Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            count += 1; //Counts every second
            if (count == randTime){ //Once the counter reaches the random number determined earlier, the images appear
                stopwatch.start(); //The stopwatch also starts
                
                //A random number is created from 1 - 5
                int intVar = (int)(Math.random()*5);;
                    //A image is chosen based on the random number
                    switch (intVar) {
                        case 1:
                            lblPear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frites.jpg")));
                            break;
                        case 2:
                            lblPear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mang.jpg")));
                            break;
                        case 3:
                            lblPear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orang.jpg")));
                            break;
                        case 4:
                            lblPear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pep.png")));
                            break;
                        case 0:
                            lblPear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pizza.png")));
                            break;
                    }
                    
                //A random button is chosen to be the correct button
                int intBtn = (int)(Math.random()*3); 
                switch (intBtn){
                    case 0:
                        btnVar = 1;
                        //The correct button has the same image as lblPear
                        switch (intVar) {
                            case 1:
                                btnReact1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frites.jpg")));
                                break;
                            case 2:
                                btnReact1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mang.jpg")));
                                break;
                            case 3:
                                btnReact1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orang.jpg")));
                                break;
                            case 4:
                                btnReact1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pep.png")));
                                break;
                            case 0:
                                btnReact1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pizza.png")));
                                break;

                        }
                        btnReact1.setEnabled(true);
                        break;
                    case 1:
                        btnVar = 2;
                        switch (intVar) {
                            case 1:
                                btnReact2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frites.jpg")));
                                break;
                            case 2:
                                btnReact2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mang.jpg")));
                                break;
                            case 3:
                                btnReact2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orang.jpg")));
                                break;
                            case 4:
                                btnReact2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pep.png")));
                                break;
                            case 0:
                                btnReact2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pizza.png")));
                                break;
                        }
                        btnReact2.setEnabled(true);
                        break;
                    case 2:
                        btnVar = 3;
                        switch (intVar) {
                            case 1:
                                btnReact3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frites.jpg")));
                                break;
                            case 2:
                                btnReact3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mang.jpg")));
                                break;
                            case 3:
                                btnReact3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orang.jpg")));
                                break;
                            case 4:
                                btnReact3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pep.png")));
                                break;
                            case 0:
                                btnReact3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pizza.png")));
                                break;
                        }
                        btnReact3.setEnabled(true);
                        break;
                }
                
                //The next block of code assigns random icons to the other buttons.  The buttons cannot have the same icons.
                if (btnVar == 1){ //In the case that the first button is correct
                    intBtn = (int)(Math.random()*5);
                    while (intBtn == intVar){
                       intBtn = (int)(Math.random()*5); //Ensures that the image is different
                    }
                    switch (intBtn){
                        case 1:
                            btnReact3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frites.jpg")));
                            break;
                        case 2:
                            btnReact3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mang.jpg")));
                            break;
                        case 3:
                            btnReact3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orang.jpg")));
                            break;
                        case 4:
                            btnReact3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pep.png")));
                            break;
                        case 0:
                            btnReact3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pizza.png")));
                            break;
                    }
                    btnReact3.setEnabled(true);
                    newRand = (int)(Math.random()*5);
                    while (newRand == intVar||newRand == intBtn){
                       newRand = (int)(Math.random()*5);
                    }                    
                    switch (newRand){
                        case 1:
                            btnReact2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frites.jpg")));
                            break;
                        case 2:
                            btnReact2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mang.jpg")));
                            break;
                        case 3:
                            btnReact2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orang.jpg")));
                            break;
                        case 4:
                            btnReact2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pep.png")));
                            break;
                        case 0:
                            btnReact2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pizza.png")));
                            break;
                            
                    }
                }
                else if (btnVar == 2){ //In the case that the second button is correct
                    intBtn = (int)(Math.random()*5);
                    while (intBtn == intVar){
                       intBtn = (int)(Math.random()*5);
                    }
                    switch (intBtn){
                        case 1:
                            btnReact3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frites.jpg")));
                            break;
                        case 2:
                            btnReact3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mang.jpg")));
                            break;
                        case 3: 
                            btnReact3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orang.jpg")));
                            break;
                        case 4:
                            btnReact3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pep.png")));
                            break;
                        case 0:
                            btnReact3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pizza.png")));
                            break;                            
                    }
                    while (intBtn == intVar){
                       intBtn = (int)(Math.random()*5);
                    }
                    newRand = (int)(Math.random()*5);
                    while (newRand == intVar||newRand == intBtn){
                       newRand = (int)(Math.random()*5);
                    }                    
                    switch (newRand){
                        case 1:
                            btnReact1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frites.jpg")));
                            break;
                        case 2:
                            btnReact1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mang.jpg")));
                            break;
                        case 3:
                            btnReact1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orang.jpg")));
                            break;
                        case 4:
                            btnReact1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pep.png")));
                            break;
                        case 0:
                            btnReact1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pizza.png")));
                            break;                            
                    }
                }
                else if (btnVar == 3){ //In the case that the third button is correct
                    intBtn = (int)(Math.random()*5);
                    while (intBtn == intVar){
                       intBtn = (int)(Math.random()*5);
                    }
                    switch (intBtn){
                        case 1:
                            btnReact2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frites.jpg")));
                            break;
                        case 2:
                            btnReact2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mang.jpg")));
                            break;
                        case 3: 
                            btnReact2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orang.jpg")));
                            break;
                        case 4:
                            btnReact2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pep.png")));
                            break;
                        case 0:
                            btnReact2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pizza.png")));
                            break;                            
                    }
                    while (intBtn == intVar){
                       intBtn = (int)(Math.random()*5);
                    }
                    newRand = (int)(Math.random()*5);
                    while (newRand == intVar||newRand == intBtn){
                       newRand = (int)(Math.random()*5);
                    }                    
                    switch (newRand){
                        case 1:
                            btnReact1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/frites.jpg")));
                            break;
                        case 2:
                            btnReact1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mang.jpg")));
                            break;
                        case 3:
                            btnReact1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/orang.jpg")));
                            break;
                        case 4:
                            btnReact1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pep.png")));
                            break;
                        case 0:
                            btnReact1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pizza.png")));
                            break;                            
                    }
                }
                
            }
        }
       });
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        pnlBack = new javax.swing.JPanel();
        lblError = new javax.swing.JLabel();
        btnEnter = new javax.swing.JButton();
        btnHighscore = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        lblNewScore = new javax.swing.JLabel();
        lblThree = new javax.swing.JLabel();
        lblHigh2 = new javax.swing.JLabel();
        lblHigh1 = new javax.swing.JLabel();
        lblInput = new javax.swing.JLabel();
        txtInput = new javax.swing.JTextField();
        lblPear = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        btnReact1 = new javax.swing.JButton();
        btnReact2 = new javax.swing.JButton();
        btnReact3 = new javax.swing.JButton();
        lblTimer = new javax.swing.JLabel();
        lblHighscore = new javax.swing.JLabel();
        lblHigh3 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblHighscoreTitle = new javax.swing.JLabel();
        lblScoresAdded = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        pnlBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setText("Error: Check Console");
        pnlBack.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 100, 20));

        btnEnter.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnEnter.setText("Enter");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });
        pnlBack.add(btnEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 190, 70));

        btnHighscore.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnHighscore.setText("Highscore");
        btnHighscore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHighscoreActionPerformed(evt);
            }
        });
        pnlBack.add(btnHighscore, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 300, 190, 110));

        lblNewScore.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblNewScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewScore.setText("New Highscore");
        jLayeredPane1.add(lblNewScore);
        lblNewScore.setBounds(270, -10, 300, 120);

        lblThree.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThree.setText("It must be at least three letters long");
        jLayeredPane1.add(lblThree);
        lblThree.setBounds(470, 140, 300, 40);

        lblHigh2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblHigh2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHigh2.setMaximumSize(new java.awt.Dimension(18, 43));
        lblHigh2.setMinimumSize(new java.awt.Dimension(18, 43));
        jLayeredPane1.add(lblHigh2);
        lblHigh2.setBounds(100, 210, 640, 50);

        lblHigh1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblHigh1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHigh1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblHigh1.setMaximumSize(new java.awt.Dimension(18, 43));
        lblHigh1.setMinimumSize(new java.awt.Dimension(18, 43));
        jLayeredPane1.add(lblHigh1);
        lblHigh1.setBounds(100, 140, 640, 50);

        lblInput.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblInput.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInput.setText("Enter Your Initials: ");
        jLayeredPane1.add(lblInput);
        lblInput.setBounds(70, 160, 360, 90);
        lblInput.getAccessibleContext().setAccessibleDescription("");

        txtInput.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        txtInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInputActionPerformed(evt);
            }
        });
        jLayeredPane1.add(txtInput);
        txtInput.setBounds(430, 190, 340, 60);

        lblPear.setBackground(new java.awt.Color(255, 255, 255));
        lblPear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPear.setToolTipText("");
        jLayeredPane1.add(lblPear);
        lblPear.setBounds(0, 10, 850, 210);

        btnStart.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnStart);
        btnStart.setBounds(325, 80, 190, 110);

        pnlBack.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 850, 250));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Click the button with the correct picture");
        pnlBack.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 850, 30));

        btnReact1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReact1ActionPerformed(evt);
            }
        });
        pnlBack.add(btnReact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 160, 130));

        btnReact2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReact2ActionPerformed(evt);
            }
        });
        pnlBack.add(btnReact2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 160, 130));

        btnReact3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReact3ActionPerformed(evt);
            }
        });
        pnlBack.add(btnReact3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, 160, 130));

        lblTimer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTimer.setForeground(new java.awt.Color(0, 153, 0));
        lblTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimer.setText("0.00");
        lblTimer.setToolTipText("");
        pnlBack.add(lblTimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 840, 30));

        lblHighscore.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblHighscore.setForeground(new java.awt.Color(0, 102, 102));
        pnlBack.add(lblHighscore, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 30));

        lblHigh3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblHigh3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHigh3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblHigh3.setMaximumSize(new java.awt.Dimension(18, 43));
        lblHigh3.setMinimumSize(new java.awt.Dimension(18, 43));
        pnlBack.add(lblHigh3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 640, 50));

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        pnlBack.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(729, 0, 120, 40));

        lblHighscoreTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblHighscoreTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHighscoreTitle.setText("Highscores");
        pnlBack.add(lblHighscoreTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 173, -1));

        lblScoresAdded.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblScoresAdded.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblScoresAdded, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45)
                .addComponent(lblScoresAdded, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * What the program does when the second button is pressed
     * @param evt Checks if the second button was pressed
     */
    private void btnReact2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReact2ActionPerformed
        t.stop();
        stopwatch.stop();
        count = 0;
        if (btnVar == 2){ //Checks if button is correct
            this.lblTimer.setText(df.format(flt10MS));
            if (arrScores[5].equals("")){ //Checks if the score is a new highscore
                highscoreScreen();
            }
            else if (flt10MS < Float.parseFloat(arrScores[5])){
                highscoreScreen();
            }
            else{ //Sets what can and cannot be clicked/seen
                this.btnStart.setVisible(true);
                this.btnStart.setEnabled(true);
                this.btnReact1.setEnabled(false);
                this.btnReact2.setEnabled(false);
                this.btnReact3.setEnabled(false);
                this.lblPear.setIcon(null);
                this.lblPear.setVisible(false);
                btnVar = 0;
                
            }
        }
        else { //Incorrect button
            lblTimer.setText("Try Again");
            this.btnStart.setVisible(true);
            this.btnStart.setEnabled(true);
            this.btnReact1.setEnabled(false);
            this.btnReact2.setEnabled(false);
            this.btnReact3.setEnabled(false);
            this.lblPear.setIcon(null);
            this.lblPear.setVisible(false);
            btnVar = 0;
        }
    }//GEN-LAST:event_btnReact2ActionPerformed

    /**
     * What the program does when the third button is pressed
     * @param evt Checks if the third button was pressed
     */
    private void btnReact3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReact3ActionPerformed
//Same as Button 2 but for Button 3 instead
        count = 0;
        t.stop();
        stopwatch.stop();
        if (btnVar == 3){
            this.lblTimer.setText(df.format(flt10MS));
            if (arrScores[5].equals("")){
                highscoreScreen();
            }
            else if (flt10MS < Float.parseFloat(arrScores[5])){
                highscoreScreen();
            }
            else{
                this.btnStart.setVisible(true);
                this.btnStart.setEnabled(true);
                this.btnReact1.setEnabled(false);
                this.btnReact2.setEnabled(false);
                this.btnReact3.setEnabled(false);
                this.lblPear.setIcon(null);
                this.lblPear.setVisible(false);
                btnVar = 0;
            }
        }
        else {
            lblTimer.setText("Try Again");
            this.btnStart.setVisible(true);
            this.btnStart.setEnabled(true);
            this.btnReact1.setEnabled(false);
            this.btnReact2.setEnabled(false);
            this.btnReact3.setEnabled(false);
            this.lblPear.setIcon(null);
            this.lblPear.setVisible(false);
            btnVar = 0;
        }
    }//GEN-LAST:event_btnReact3ActionPerformed

    /**
     * Button which starts the game
     * @param evt When the button "Start" is pressed
     */
    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
        t.start();
        this.btnReact1.setVisible(true);
        this.btnReact2.setVisible(true);
        this.btnReact3.setVisible(true);
        this.lblPear.setVisible(true);
        this.lblTitle.setVisible(true);
        this.lblTimer.setVisible(true);
        this.pnlBack.setVisible(true);
        this.btnStart.setVisible(false);
        this.btnStart.setEnabled(false);
        this.btnReact1.setEnabled(true);
        this.btnReact2.setEnabled(true);
        this.btnReact3.setEnabled(true);
        this.btnReact1.setIcon(null);
        this.btnReact2.setIcon(null);
        this.btnReact3.setIcon(null);
        this.lblPear.setIcon(null);
        this.lblTimer.setText("0.00");
        this.lblHighscore.setVisible(true);
        this.btnHighscore.setVisible(false);
        this.btnBack.setVisible(true);
        this.btnBack.setEnabled(true);
        flt10MS = 0;  
    }//GEN-LAST:event_btnStartActionPerformed

    /**
     * What the program does when the first button is pressed
     * @param evt Checks if the first button was pressed
     */
    private void btnReact1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReact1ActionPerformed
//Same as other buttons
        count = 0;
        t.stop();
        stopwatch.stop();
        if (btnVar == 1){
            this.lblTimer.setText(df.format(flt10MS));
            if (arrScores[5].equals("")){
                highscoreScreen();
            }
            else if (flt10MS < Float.parseFloat(arrScores[5])){
                highscoreScreen();
            }
            else{
                this.btnStart.setVisible(true);
                this.btnStart.setEnabled(true);
                this.btnReact1.setEnabled(false);
                this.btnReact2.setEnabled(false);
                this.btnReact3.setEnabled(false);
                this.lblPear.setIcon(null);
                this.lblPear.setVisible(false);
                btnVar = 0;
            }
        }
        else {
            lblTimer.setText("Try Again");
            this.btnStart.setVisible(true);
            this.btnStart.setEnabled(true);
            this.btnReact1.setEnabled(false);
            this.btnReact2.setEnabled(false);
            this.btnReact3.setEnabled(false);
            this.lblPear.setIcon(null);
            this.lblPear.setVisible(false);
            btnVar = 0;
        }
    }//GEN-LAST:event_btnReact1ActionPerformed

    /**
     * Brings user to highscore menu
     * @param evt When button "Highscore" is pressed
     */
    private void btnHighscoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHighscoreActionPerformed
//Sets visibility so that the highscore menu shows up properly
        this.btnReact1.setVisible(false);
        this.btnReact2.setVisible(false);
        this.btnReact3.setVisible(false);
        this.btnReact1.setEnabled(false);
        this.btnReact2.setEnabled(false);
        this.btnReact3.setEnabled(false);
        this.lblPear.setVisible(false);
        this.lblTitle.setVisible(false);
        this.lblTimer.setVisible(false);
        this.pnlBack.setVisible(true);
        this.btnStart.setVisible(false);
        this.btnStart.setEnabled(false);
        this.btnHighscore.setVisible(false);
        this.lblHigh1.setVisible(true);
        this.lblHigh2.setVisible(true);
        this.lblHigh3.setVisible(true);
        this.lblHighscoreTitle.setVisible(true);
        this.lblInput.setVisible(false);
        this.txtInput.setVisible(false);
        this.txtInput.setEnabled(true);
        this.btnEnter.setVisible(false);
        this.btnBack.setVisible(true);
        this.lblThree.setVisible(false);
        this.lblNewScore.setVisible(false);
        
        //Displays Top 3 Highscores
        this.lblHigh1.setText(arrScores[0]+" - "+arrScores[1]);
        this.lblHigh2.setText(arrScores[2]+" - "+arrScores[3]);
        this.lblHigh3.setText(arrScores[4]+" - "+arrScores[5]);
        
        //Adds Top 3 Highscores and displays it
        if (!arrScores[5].equals("")){
            this.lblScoresAdded.setVisible(true);
            this.lblScoresAdded.setText("Sum of top 3 scores: "+df.format((Float.parseFloat(arrScores[1])+Float.parseFloat(arrScores[3])+Float.parseFloat(arrScores[5]))));
        }
    }//GEN-LAST:event_btnHighscoreActionPerformed

    private void txtInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInputActionPerformed
  
    /**
     * Brings the user back to the home screen
     * @param evt When the button "Back" is pressed
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        t.stop();
        stopwatch.stop();
        home();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * Controls how highscores are entered into the system
     * @param evt When the enter button is clicked in the new highscore menu
     */
    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
//Gets name put into the text box
        String scoreName = this.txtInput.getText();
        if (scoreName.length() < 3){ //The name must be at least three letters long
            this.lblThree.setVisible(true);
        }
        else{
            scoreName = this.txtInput.getText().substring(0,3).toUpperCase();//Takes only first three letters of name
            
            //Inserting the score and name into the highscore array
            if (arrScores[1].equals("")){
                arrayInsert(1, df.format(flt10MS), scoreName);
            }       
            else if (flt10MS < Float.parseFloat(arrScores[1])){
                arrayInsert(1, df.format(flt10MS), scoreName);
            }
            else if (arrScores[3].equals("")){
                arrayInsert(3, df.format(flt10MS), scoreName);
            }       
            else if (flt10MS < Float.parseFloat(arrScores[3])){
                arrayInsert(3, df.format(flt10MS), scoreName);
            }
            else if (arrScores[5].equals("")){
                arrayInsert(5, df.format(flt10MS), scoreName);
            }       
            else if (flt10MS < Float.parseFloat(arrScores[5])){
                arrayInsert(5, df.format(flt10MS), scoreName);
            }
            home();
        }
    }//GEN-LAST:event_btnEnterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(react.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(react.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(react.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(react.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new react().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnHighscore;
    private javax.swing.JButton btnReact1;
    private javax.swing.JButton btnReact2;
    private javax.swing.JButton btnReact3;
    private javax.swing.JButton btnStart;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblHigh1;
    private javax.swing.JLabel lblHigh2;
    private javax.swing.JLabel lblHigh3;
    private javax.swing.JLabel lblHighscore;
    private javax.swing.JLabel lblHighscoreTitle;
    private javax.swing.JLabel lblInput;
    private javax.swing.JLabel lblNewScore;
    private javax.swing.JLabel lblPear;
    private javax.swing.JLabel lblScoresAdded;
    private javax.swing.JLabel lblThree;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBack;
    private javax.swing.JTextField txtInput;
    // End of variables declaration//GEN-END:variables
}
