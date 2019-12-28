package audioplayer;

import jaco.mp3.player.MP3Player;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.file.Paths;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class gui extends javax.swing.JFrame {
    MP3Player player;
    File songFile;
    String currentDirectory="home.user";
    String currentPath;
    String imagePath;
    boolean repeat=false;
    boolean windowCollapsed=false;
    int xMouse,yMouse;
    public int count=0;
    boolean changer=true;
    
    //User's variables create
    public int UserId=0;
    public User UserLog;
    public String UsersMusic[]=new String[1000000];
    
    //May delete
    public int UserC=0;
    User UsL;
    
    String[] SongP = new String[1000000];
    String[] song = new String[1000000];
    int wSong=1;
    
    public gui() {
        
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("EL.png")));
        player=mp3Player();
        
        currentPath=Paths.get(".").toAbsolutePath().normalize().toString();
        imagePath = "\\images";
        jLabel6.setVisible(false);
        
        Pn_ForLogin.setVisible(false);
        lbl_Change.setVisible(false);
        lbl_ChangeUserN.setVisible(false);
        lbl_ChangeUserP.setVisible(false);
        lbl_DeleteUser.setVisible(false);
        lbl_LogOut.setVisible(false);
        
        try{ 
            File file = new File("Login.txt");
            if (file.createNewFile())
                System.out.println("Login file is created!");
            else 
                System.out.println("Login file already exists.");
            
            file = new File("User");
            if (!file.exists()) {
                if (file.mkdir()) {
                    System.out.println("User directory is created!");
                } else {
                    System.out.println("Failed to create User directory!");
                }
            }
            
            file = new File("User/user1.txt");
            if (file.createNewFile())
                System.out.println("User1 file is created!");
            else 
                System.out.println("User1 file already exists.");
            
            file = new File("User/user2.txt");
            if (file.createNewFile())
                System.out.println("User2 file is created!");
            else 
                System.out.println("User2 file already exists.");
            
            file = new File("User/user3.txt");
            if (file.createNewFile())
                System.out.println("User3 file is created!");
            else 
                System.out.println("User1 file already exists.");
            
            file = new File("User/user4.txt");
            if (file.createNewFile())
                System.out.println("User4 file is created!");
            else 
                System.out.println("User4 file already exists.");
            
            file = new File("User/user5.txt");
            if (file.createNewFile())
                System.out.println("User5 file is created!");
            else 
                System.out.println("User5 file already exists.");
            
        
        FileReader fr=new FileReader ("Login.txt");
        BufferedReader br=new BufferedReader(fr);
        while(br.ready()){
            br.readLine();
            UserC++;
        }
        br.close();
        }catch(Exception e){
            System.out.println("General error "+e);
        }

    }
    public void Checker(String name,String pass){
        lbl_UsersName.setText(name);
        Pn_Login.setVisible(false);
        UserLog=new User(name, pass, UserId);
    }
    
    public void Shower(){
        try{
            if (UserId==1 ){
                FileReader fr=new FileReader ("User/user1.txt");
                BufferedReader br=new BufferedReader(fr);
                int countN=0;
                while(br.ready()){
                    br.readLine();
                    countN++;
                }
                br.close();
                fr=new FileReader("User/user1.txt");
                br=new BufferedReader(fr);
                String[] lineS=new String[1000];
                String[] SongNGetter;
                int L;
                for (int i = 0; i < countN; i++){
                    lineS[i]=br.readLine();
                    UsersMusic[i]=lineS[i];
                    SongNGetter=lineS[i].split("\\\\");
                    L=0;
                    for (int a = 1; a < SongNGetter.length; a++) {
                        L++;
                    }
                    System.out.println(SongNGetter[L]);
                    
                    //Need to add to playlist
                    player.addToPlayList(new File(lineS[i]));
                    currentDirectory = lineS[i];
                    count++;
                    
                    TxA_SongsName.setText(TxA_SongsName.getText()+count+"."+SongNGetter[L]+"\n");
                    song[wSong]=SongNGetter[L];
                    SongP[wSong]=lineS[i];
                    System.out.println(song[wSong]);
                    System.out.println(count);
                }
                br.close();
            }else if (UserId==2){
                FileReader fr=new FileReader ("User/user2.txt");
                BufferedReader br=new BufferedReader(fr);
                int countN=0;
                while(br.ready()){
                    br.readLine();
                    countN++;
                }
                br.close();
                fr=new FileReader("User/user2.txt");
                br=new BufferedReader(fr);
                String[] lineS=new String[1000];
                String[] SongNGetter;
                int L;
                for (int i = 0; i < countN; i++){
                    lineS[i]=br.readLine();
                    UsersMusic[i]=lineS[i];
                    SongNGetter=lineS[i].split("\\\\");
                    L=0;
                    for (int a = 1; a < SongNGetter.length; a++) {
                        L++;
                    }
                    System.out.println(SongNGetter[L]);
                    
                    //Need to add to playlist
                    player.addToPlayList(new File(lineS[i]));
                    currentDirectory = lineS[i];
                    count++;
                    
                    TxA_SongsName.setText(TxA_SongsName.getText()+count+"."+SongNGetter[L]+"\n");
                    song[wSong]=SongNGetter[L];
                    SongP[wSong]=lineS[i];
                    System.out.println(song[wSong]);
                    System.out.println(count);
                }
                br.close();
            }else if (UserId==3){
                FileReader fr=new FileReader ("User/user3.txt");
                BufferedReader br=new BufferedReader(fr);
                int countN=0;
                while(br.ready()){
                    br.readLine();
                    countN++;
                }
                br.close();
                fr=new FileReader("User/user3.txt");
                br=new BufferedReader(fr);
                String[] lineS=new String[1000];
                String[] SongNGetter;
                int L;
                for (int i = 0; i < countN; i++){
                    lineS[i]=br.readLine();
                    UsersMusic[i]=lineS[i];
                    SongNGetter=lineS[i].split("\\\\");
                    L=0;
                    for (int a = 1; a < SongNGetter.length; a++) {
                        L++;
                    }
                    System.out.println(SongNGetter[L]);
                    
                    //Need to add to playlist
                    player.addToPlayList(new File(lineS[i]));
                    currentDirectory = lineS[i];
                    count++;
                    
                    TxA_SongsName.setText(TxA_SongsName.getText()+count+"."+SongNGetter[L]+"\n");
                    song[wSong]=SongNGetter[L];
                    SongP[wSong]=lineS[i];
                    System.out.println(song[wSong]);
                    System.out.println(count);
                }
                br.close();
            }else if (UserId==4){
                FileReader fr=new FileReader ("User/user4.txt");
                BufferedReader br=new BufferedReader(fr);
                int countN=0;
                while(br.ready()){
                    br.readLine();
                    countN++;
                }
                br.close();
                fr=new FileReader("User/user4.txt");
                br=new BufferedReader(fr);
                String[] lineS=new String[1000];
                String[] SongNGetter;
                int L;
                for (int i = 0; i < countN; i++){
                    lineS[i]=br.readLine();
                    UsersMusic[i]=lineS[i];
                    SongNGetter=lineS[i].split("\\\\");
                    L=0;
                    for (int a = 1; a < SongNGetter.length; a++) {
                        L++;
                    }
                    System.out.println(SongNGetter[L]);
                    
                    //Need to add to playlist
                    player.addToPlayList(new File(lineS[i]));
                    currentDirectory = lineS[i];
                    count++;
                    
                    TxA_SongsName.setText(TxA_SongsName.getText()+count+"."+SongNGetter[L]+"\n");
                    song[wSong]=SongNGetter[L];
                    SongP[wSong]=lineS[i];
                    System.out.println(song[wSong]);
                    System.out.println(count);
                }
                br.close();
            }else if (UserId==5){
                FileReader fr=new FileReader ("User/user5.txt");
                BufferedReader br=new BufferedReader(fr);
                int countN=0;
                while(br.ready()){
                    br.readLine();
                    countN++;
                }
                br.close();
                fr=new FileReader("User/user5.txt");
                br=new BufferedReader(fr);
                String[] lineS=new String[1000];
                String[] SongNGetter;
                int L;
                for (int i = 0; i < countN; i++){
                    lineS[i]=br.readLine();
                    UsersMusic[i]=lineS[i];
                    SongNGetter=lineS[i].split("\\\\");
                    L=0;
                    for (int a = 1; a < SongNGetter.length; a++) {
                        L++;
                    }
                    System.out.println(SongNGetter[L]);
                    
                    //Need to add to playlist
                    player.addToPlayList(new File(lineS[i]));
                    currentDirectory = lineS[i];
                    count++;
                    
                    TxA_SongsName.setText(TxA_SongsName.getText()+count+"."+SongNGetter[L]+"\n");
                    song[wSong]=SongNGetter[L];
                    SongP[wSong]=lineS[i];
                    System.out.println(song[wSong]);
                    System.out.println(count);
                }
                br.close();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "General error");
            System.out.println("Error "+e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pn_Login = new javax.swing.JDialog();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lUsername = new javax.swing.JTextField();
        lPassword = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();
        Pn_SingUp = new javax.swing.JDialog();
        jButton2 = new javax.swing.JButton();
        sPassword = new javax.swing.JPasswordField();
        sUsername = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        sPassword1 = new javax.swing.JPasswordField();
        jLabel26 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_UsersName = new javax.swing.JLabel();
        Pn_ForLogin = new javax.swing.JPanel();
        lbl_LogOut = new javax.swing.JLabel();
        lbl_DeleteUser = new javax.swing.JLabel();
        lbl_ChangeUserP = new javax.swing.JLabel();
        lbl_ChangeUserN = new javax.swing.JLabel();
        lbl_Change = new javax.swing.JLabel();
        lbl_Login = new javax.swing.JLabel();
        lbl_SignUp = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxA_SongsName = new javax.swing.JTextArea();
        lbl_Background = new javax.swing.JLabel();
        Pn_Background = new javax.swing.JPanel();

        Pn_Login.setIconImages(null);
        Pn_Login.setMinimumSize(new java.awt.Dimension(400, 300));
        Pn_Login.setResizable(false);
        Pn_Login.getContentPane().setLayout(null);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("LOGIN PANEL");
        Pn_Login.getContentPane().add(jLabel20);
        jLabel20.setBounds(0, 0, 400, 14);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("USERNAME");
        Pn_Login.getContentPane().add(jLabel21);
        jLabel21.setBounds(0, 60, 400, 14);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("PASSWORD");
        Pn_Login.getContentPane().add(jLabel22);
        jLabel22.setBounds(0, 110, 400, 14);

        lUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lUsernameActionPerformed(evt);
            }
        });
        Pn_Login.getContentPane().add(lUsername);
        lUsername.setBounds(90, 80, 210, 20);
        Pn_Login.getContentPane().add(lPassword);
        lPassword.setBounds(90, 130, 210, 20);

        jButton3.setText("LOGIN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Pn_Login.getContentPane().add(jButton3);
        jButton3.setBounds(90, 170, 210, 70);

        Pn_SingUp.setIconImages(null);
        Pn_SingUp.setMinimumSize(new java.awt.Dimension(400, 300));
        Pn_SingUp.setResizable(false);
        Pn_SingUp.getContentPane().setLayout(null);

        jButton2.setText("SIGN UP");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Pn_SingUp.getContentPane().add(jButton2);
        jButton2.setBounds(90, 190, 210, 60);
        Pn_SingUp.getContentPane().add(sPassword);
        sPassword.setBounds(90, 110, 210, 20);

        sUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sUsernameActionPerformed(evt);
            }
        });
        Pn_SingUp.getContentPane().add(sUsername);
        sUsername.setBounds(90, 60, 210, 20);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("PASSWORD");
        Pn_SingUp.getContentPane().add(jLabel23);
        jLabel23.setBounds(0, 90, 400, 14);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("USERNAME");
        Pn_SingUp.getContentPane().add(jLabel24);
        jLabel24.setBounds(0, 40, 400, 14);

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("SIGN UP PANEL");
        Pn_SingUp.getContentPane().add(jLabel25);
        jLabel25.setBounds(0, 0, 400, 14);
        Pn_SingUp.getContentPane().add(sPassword1);
        sPassword1.setBounds(90, 160, 210, 20);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("PASSWORD");
        Pn_SingUp.getContentPane().add(jLabel26);
        jLabel26.setBounds(0, 140, 400, 14);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setMaximumSize(new java.awt.Dimension(700, 400));
        setMinimumSize(new java.awt.Dimension(700, 400));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel13);
        jLabel13.setBounds(620, 0, 40, 14);

        jLabel2.setBackground(new java.awt.Color(25, 25, 25));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 16, 0, 30);

        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel16);
        jLabel16.setBounds(305, 360, 15, 15);

        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel15);
        jLabel15.setBounds(385, 360, 15, 15);

        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9);
        jLabel9.setBounds(450, 360, 15, 15);

        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel8);
        jLabel8.setBounds(660, 0, 40, 14);

        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 310, 150, 10);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NOW PLAYING:");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 620, 14);

        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(415, 360, 15, 15);

        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel4MouseReleased(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(335, 350, 35, 35);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/audioplayer/pause.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.setMaximumSize(new java.awt.Dimension(27, 16));
        jLabel6.setMinimumSize(new java.awt.Dimension(27, 16));
        jLabel6.setPreferredSize(new java.awt.Dimension(27, 16));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(335, 350, 35, 35);

        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel10);
        jLabel10.setBounds(226, 360, 15, 15);

        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel11);
        jLabel11.setBounds(251, 360, 15, 15);

        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel12);
        jLabel12.setBounds(275, 360, 15, 15);

        lbl_UsersName.setForeground(new java.awt.Color(204, 204, 204));
        lbl_UsersName.setText("Guest");
        getContentPane().add(lbl_UsersName);
        lbl_UsersName.setBounds(60, 360, 40, 14);

        Pn_ForLogin.setBackground(new java.awt.Color(56, 56, 56));
        Pn_ForLogin.setLayout(null);

        lbl_LogOut.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_LogOut.setForeground(new java.awt.Color(255, 255, 255));
        lbl_LogOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_LogOut.setText("LOG OUT");
        lbl_LogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_LogOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_LogOutMouseEntered(evt);
            }
        });
        Pn_ForLogin.add(lbl_LogOut);
        lbl_LogOut.setBounds(30, 0, 90, 30);

        lbl_DeleteUser.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_DeleteUser.setForeground(new java.awt.Color(255, 255, 255));
        lbl_DeleteUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_DeleteUser.setText("Reset playlist");
        lbl_DeleteUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_DeleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_DeleteUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_DeleteUserMouseEntered(evt);
            }
        });
        Pn_ForLogin.add(lbl_DeleteUser);
        lbl_DeleteUser.setBounds(130, 10, 80, 17);

        lbl_ChangeUserP.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_ChangeUserP.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ChangeUserP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ChangeUserP.setText("password");
        lbl_ChangeUserP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_ChangeUserP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ChangeUserPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_ChangeUserPMouseEntered(evt);
            }
        });
        Pn_ForLogin.add(lbl_ChangeUserP);
        lbl_ChangeUserP.setBounds(150, 40, 57, 17);

        lbl_ChangeUserN.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_ChangeUserN.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ChangeUserN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ChangeUserN.setText("Username");
        lbl_ChangeUserN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_ChangeUserN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ChangeUserNMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_ChangeUserNMouseEntered(evt);
            }
        });
        Pn_ForLogin.add(lbl_ChangeUserN);
        lbl_ChangeUserN.setBounds(80, 40, 59, 17);

        lbl_Change.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbl_Change.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Change.setText("Change:");
        Pn_ForLogin.add(lbl_Change);
        lbl_Change.setBounds(20, 40, 48, 17);

        getContentPane().add(Pn_ForLogin);
        Pn_ForLogin.setBounds(470, 340, 230, 60);

        lbl_Login.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_Login.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Login.setText("LOGIN");
        lbl_Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_LoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_LoginMouseEntered(evt);
            }
        });
        getContentPane().add(lbl_Login);
        lbl_Login.setBounds(480, 350, 100, 40);

        lbl_SignUp.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_SignUp.setForeground(new java.awt.Color(255, 255, 255));
        lbl_SignUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_SignUp.setText("SIGN UP");
        lbl_SignUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_SignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_SignUpMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_SignUp);
        lbl_SignUp.setBounds(590, 350, 100, 40);

        jScrollPane1.setOpaque(false);

        TxA_SongsName.setEditable(false);
        TxA_SongsName.setBackground(new java.awt.Color(50, 50, 50));
        TxA_SongsName.setForeground(new java.awt.Color(255, 255, 255));
        TxA_SongsName.setRows(50);
        TxA_SongsName.setBorder(null);
        TxA_SongsName.setFocusable(false);
        TxA_SongsName.setHighlighter(null);
        TxA_SongsName.setMinimumSize(new java.awt.Dimension(165, 85));
        TxA_SongsName.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(TxA_SongsName);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 50, 150, 230);

        lbl_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/audioplayer/rimscar1.png"))); // NOI18N
        lbl_Background.setText("jLabel27");
        lbl_Background.setMaximumSize(new java.awt.Dimension(700, 400));
        lbl_Background.setMinimumSize(new java.awt.Dimension(700, 400));
        getContentPane().add(lbl_Background);
        lbl_Background.setBounds(0, 0, 700, 400);
        getContentPane().add(Pn_Background);
        Pn_Background.setBounds(0, 0, 700, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        //mouse pressed PLAY
        jLabel4.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseReleased
        //mouse released PLAY
        jLabel4.setForeground(Color.DARK_GRAY);
    }//GEN-LAST:event_jLabel4MouseReleased

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        /*
        String Songs=TxA_SongsName.getText();
        String[] SongN;
        try{
            for (int b =1;b<=count;b++){
                SongN=Songs.split("\n");
                if(UsL.getId()==1){
                    for (int i = 0; i < SongN.length; i++) {
                        FileWriter fstream = new FileWriter("User/user1.txt",true);
                        BufferedWriter out = new BufferedWriter(fstream);
                        out.write(SongN[i]);
                        out.newLine();
                        out.close();
                        System.out.println("Playlist saved");
                    }
                }else if(UsL.getId()==2){
                    for (int i = 0; i < SongN.length; i++) {
                        FileWriter fstream = new FileWriter("User/user2.txt",true);
                        BufferedWriter out = new BufferedWriter(fstream);
                        out.write(SongN[i]);
                        out.newLine();
                        out.close();
                        System.out.println("Playlist saved");
                    }
                }else if(UsL.getId()==3){
                    for (int i = 0; i < SongN.length; i++) {
                        FileWriter fstream = new FileWriter("User/user3.txt",true);
                        BufferedWriter out = new BufferedWriter(fstream);
                        out.write(SongN[i]);
                        out.newLine();
                        out.close();
                        System.out.println("Playlist saved");
                    }
                }else if(UsL.getId()==4){
                    for (int i = 0; i < SongN.length; i++) {
                        FileWriter fstream = new FileWriter("User/user4.txt",true);
                        BufferedWriter out = new BufferedWriter(fstream);
                        out.write(SongN[i]);
                        out.newLine();
                        out.close();
                        System.out.println("Playlist saved");
                    }
                }else if(UsL.getId()==5){
                    for (int i = 0; i < SongN.length; i++) {
                        FileWriter fstream = new FileWriter("User/user5.txt",true);
                        BufferedWriter out = new BufferedWriter(fstream);
                        out.write(SongN[i]);
                        out.newLine();
                        out.close();
                        System.out.println("Playlist saved");
                    }
                }
            }
        }catch(Exception e){
            System.out.println("General error "+e);
        }
        */
        System.exit(0);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        player.play();
        jLabel1.setText("NOW PLAYING: "+wSong);
        System.out.println("PLAY="+count);
        jLabel6.setVisible(true);
        jLabel4.setVisible(false);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        player.pause();
        jLabel4.setVisible(true);
        jLabel6.setVisible(false);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        if(repeat==false){
            repeat=true;
            player.setRepeat(repeat);
        }
        else if (repeat){
            repeat=false;
            player.setRepeat(repeat);
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        boolean isNeeded=false;
        String f;
        f=(lbl_UsersName.getText());
        if (f.equals("Guest")){
            isNeeded=false;
            JOptionPane.showMessageDialog(this, "You must login to add songs.");}
        else
            isNeeded=true;
        if (isNeeded){
        JFileChooser openFileChooser = new JFileChooser(currentDirectory);
        openFileChooser.setFileFilter(new FileTypeFilter(".mp3", "Open .mp3 files only!"));
        int result = openFileChooser.showOpenDialog(null);
        if(result==JFileChooser.APPROVE_OPTION){
            songFile=openFileChooser.getSelectedFile();
            player.addToPlayList(songFile);
            System.out.println(songFile);
            currentDirectory = songFile.getAbsolutePath();
            count++;
            TxA_SongsName.setText(TxA_SongsName.getText()+count+"."+songFile.getName()+"\n");
            song[wSong]=songFile.getName();
            SongP[wSong]=songFile.getAbsolutePath();
            System.out.println(song[wSong]);
            System.out.println(count);
        }
            
            
            int countFw=0,Nline=0;
            if(!(lbl_UsersName.getText().equals("Guest"))){
                try{
                    FileReader fr=new FileReader ("Login.txt");
                    BufferedReader br=new BufferedReader(fr);
                    while(br.ready()){
                        br.readLine();
                        countFw++;
                    }
                    br.close();
                    fr=new FileReader("Login.txt");
                    br=new BufferedReader(fr);
                    String line, user;
                    while ((line = br.readLine()) != null) {
                        user = line.split(" ")[1].toLowerCase();
                        if (user.equals(lbl_UsersName.getText())){
                            Nline++;
                            break;
                        }
                    }
                    
                    try{
                        String song=songFile.getAbsolutePath();
                        if(UserId==1){
                            FileWriter fstream = new FileWriter("User/user1.txt",true);
                            BufferedWriter out = new BufferedWriter(fstream);
                            out.write(song);
                            out.newLine();
                            out.close();
                            System.out.println("Saveed");
                        }else if(UserId==2){
                            FileWriter fstream = new FileWriter("User/user2.txt",true);
                            BufferedWriter out = new BufferedWriter(fstream);
                            out.write(song);
                            out.newLine();
                            out.close();
                            System.out.println("Saveed");
                        }else if(UserId==3){
                            FileWriter fstream = new FileWriter("User/user3.txt",true);
                            BufferedWriter out = new BufferedWriter(fstream);
                            out.write(song);
                            out.newLine();
                            out.close();
                            System.out.println("Saveed");
                        }else if(UserId==4){
                            FileWriter fstream = new FileWriter("User/user4.txt",true);
                            BufferedWriter out = new BufferedWriter(fstream);
                            out.write(song);
                            out.newLine();
                            out.close();
                            System.out.println("Saveed");
                        }else if(UserId==5){
                            FileWriter fstream = new FileWriter("User/user5.txt",true);
                            BufferedWriter out = new BufferedWriter(fstream);
                            out.write(song);
                            out.newLine();
                            out.close();
                            System.out.println("Saveed");
                        }
                    }catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Generall error "+e);
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Generall error "+e);
                }
            }
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        volumeDownControl(0.1);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        volumeUpControl(0.1);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        volumeControl(1.0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        volumeControl(0.0);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        player.skipForward();
        player.pause();
        if (wSong<count)
            wSong++;
        else
            wSong=wSong;
        jLabel4.setVisible(true);
        jLabel6.setVisible(false);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        player.skipBackward();
        player.pause();
        if (wSong<=1)
            wSong=1;
        else wSong--;
        jLabel4.setVisible(true);
        jLabel6.setVisible(false);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void lbl_LoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_LoginMouseClicked
        Pn_Login.pack();
        Pn_Login.setVisible(true);
        
    }//GEN-LAST:event_lbl_LoginMouseClicked

    private void lbl_SignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_SignUpMouseClicked
        Pn_SingUp.pack();
        Pn_SingUp.setVisible(true);
        
    }//GEN-LAST:event_lbl_SignUpMouseClicked

    private void lUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lUsernameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Sign up
        String Username,Password,PasswordR,User;
        Username=sUsername.getText();
        Password=sPassword.getText();
        PasswordR=sPassword1.getText();
        boolean ErrorUser=true;
        try{
            FileReader fr=new FileReader ("Login.txt");
            BufferedReader br=new BufferedReader(fr);
            
            if(UserC>=5){
                JOptionPane.showMessageDialog(this, "You can create only 5 users!");
                ErrorUser=false;
            }if(Username.length()<3 || Password.length()<3){
                JOptionPane.showMessageDialog(this, "Username and password must be at least 3 Character long");
                ErrorUser=false;
            }if(!Password.equals(PasswordR)){
                JOptionPane.showMessageDialog(this, "Passwords do not match.");
                ErrorUser=false;
            }else{
                if(Username.equals("") || Password.equals("")){
                    ErrorUser=false;
                    JOptionPane.showMessageDialog(this, "Write username or password");
                }else
                if(ErrorUser){
                    String[] lineS;
                    for (int i = 1; i <= UserC; i++){
                        lineS=br.readLine().split(" ");
                        if(Username.equals(lineS[1])){
                        JOptionPane.showMessageDialog(this,"Username was already taken");
                        sUsername.setText("");
                        ErrorUser = false;
                    }
                }
                br.close();
                if(!(sPassword.equals(sPassword1)) && ErrorUser){
                    User=" "+Username+" "+Password;
                    FileWriter fstream = new FileWriter("Login.txt",true);
                    BufferedWriter out = new BufferedWriter(fstream);
                    out.write(User);
                    out.newLine();
                    out.close();
                    System.out.println("Doneee");
                    JOptionPane.showMessageDialog(this,"You are saved in the server");
                    UserC++;
                    Pn_SingUp.setVisible(false);
                    Pn_Login.pack();
                    Pn_Login.setVisible(true);
                    sUsername.setText("");
                    sPassword.setText("");
                    sPassword1.setText("");
                }else if(sPassword.equals(sPassword1)){
                    JOptionPane.showMessageDialog(this, "The passwords you inputted do not match.");
                }
            }
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "General error "+e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void sUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sUsernameActionPerformed

    private void lbl_LoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_LoginMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_LoginMouseEntered

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Login
        try{
            String Username,Password;
            Username=lUsername.getText();
            Password=lPassword.getText();
            boolean accept=false;
            boolean isLoginSuccess = false;
            String Songs=TxA_SongsName.getText();
            String line, user, pass;
            
            FileReader fr=new FileReader ("Login.txt");
            BufferedReader br=new BufferedReader(fr);
            File file=new File("Login.txt");
            
            if(file.length() == 0){
                JOptionPane.showMessageDialog(this, "Create a user");
                Pn_SingUp.pack();
                Pn_SingUp.setVisible(true);
                Pn_Login.setVisible(false);
            }else if(Username.equals("") || Password.equals(""))
                JOptionPane.showMessageDialog(this, "Incomplete credentials");
            else{
                while ((line = br.readLine()) != null) {
                     user = line.split(" ")[1].toLowerCase();
                     pass = line.split(" ")[2].toLowerCase();
                     UserId++;
                     if (user.equals(Username) && pass.equals(Password)) {
                         accept=true;
                         Checker(Username,Password);
                         Shower();
                         lUsername.setText("");
                         lPassword.setText("");
                         System.out.println(UserId);
                         Pn_ForLogin.setVisible(true);
                         Pn_ForLogin.setVisible(true);
                         lbl_Change.setVisible(true);
                         lbl_ChangeUserN.setVisible(true);
                         lbl_ChangeUserP.setVisible(true);
                         lbl_DeleteUser.setVisible(true);
                         lbl_LogOut.setVisible(true);
                         lbl_Login.setVisible(false);
                         lbl_SignUp.setVisible(false);
                         break;
                     } 
                }
                if(!accept)
                    JOptionPane.showMessageDialog(this, "False username or password");
            }


        int Nline=0;
        if(!(lbl_UsersName.getText().equals("Guest"))){
            String userN;
            while ((line = br.readLine()) != null) {
                userN = line.split(" ")[1].toLowerCase();
                if (userN.equals(lbl_UsersName.getText())){
                    Nline++;
                    break;
                }
            }
        }
        
        int countSsong=0;
        String Song;
        String[] Ssong;
        if(Nline==1){
            fr=new FileReader("User/user1.txt");
            br=new BufferedReader(fr);
            while (br.ready()){
                Song = br.readLine();
                new MP3Player(new File(""+song));
                count++;
                Ssong=Song.split("\\");

                for (int i = 0; i < Ssong.length; i++)
                    countSsong++;

                TxA_SongsName.setText(TxA_SongsName.getText()+count+"."+Ssong[countSsong]+"\n");
            }
            br.close();
        }else if(Nline==2){
            fr=new FileReader("User/user2.txt");
            br=new BufferedReader(fr);
            while (br.ready()){
                Song = br.readLine();
                new MP3Player(new File(""+song));
                TxA_SongsName.setText(TxA_SongsName.getText()+count+"."+songFile.getName()+"\n");
            }
            br.close();
        }else if(Nline==3){
            fr=new FileReader("User/user3.txt");
            br=new BufferedReader(fr);
            while (br.ready()){
                Song = br.readLine();
                new MP3Player(new File(""+song));
                TxA_SongsName.setText(TxA_SongsName.getText()+count+"."+songFile.getName()+"\n");
            }
            br.close();
        }else if(Nline==4){
            fr=new FileReader("User/user4.txt");
            br=new BufferedReader(fr);
            while (br.ready()){
                Song = br.readLine();
                new MP3Player(new File(""+song));
                TxA_SongsName.setText(TxA_SongsName.getText()+count+"."+songFile.getName()+"\n");
            }
            br.close();
        }else if(Nline==5){
            fr=new FileReader("User/user5.txt");
            br=new BufferedReader(fr);
            while (br.ready()){
                Song = br.readLine();
                new MP3Player(new File(""+song));
                TxA_SongsName.setText(TxA_SongsName.getText()+count+"."+songFile.getName()+"\n");
            }
            br.close();
            }
        }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Generall error "+e);
                System.out.println("Here");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void lbl_LogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_LogOutMouseClicked
        // Log out
        try{
            String Dir=System.getProperty("user.dir");
            Dir+="\\AudioPlayer.jar";
            new ProcessBuilder("cmd","/c start /min "+Dir+" ^& exit").start();
            System.exit(0);
        }catch(Exception e){
            System.out.println("Error "+e);
        }
    }//GEN-LAST:event_lbl_LogOutMouseClicked

    private void lbl_LogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_LogOutMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_LogOutMouseEntered

    private void lbl_ChangeUserNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ChangeUserNMouseClicked
        // Change username
        if(changer){
            try{
                String[] lineSo;
                boolean f=true;

                String UserName=JOptionPane.showInputDialog("Enter new username");
                FileReader fr=new FileReader ("Login.txt");
                BufferedReader br=new BufferedReader(fr);
                if(UserName.length()<3){
                    JOptionPane.showMessageDialog(this, "Username and password must be at least 3 Character long");
                    f=false;
                }else if(UserName.equals("")){
                    JOptionPane.showMessageDialog(this, "Write username or password");
                    f=false;
                }else{
                    for (int i = 1; i <= UserId; i++){
                        lineSo=br.readLine().split(" ");
                        if(UserName.equals(lineSo[1])){
                            JOptionPane.showMessageDialog(this,"Username was already taken");
                            f=false;
                        }   
                    }
                }

                String newString=" "+UserName+" "+UserLog.getPassword();
                if(f){
                    File fileToBeModified = new File("Login.txt");
                    String oldString = " "+UserLog.getUsername()+" "+UserLog.getPassword();
                    String oldContent="";
                    BufferedReader reader = null;
                    FileWriter writer = null;
                    reader = new BufferedReader(new FileReader(fileToBeModified));
                    String line = reader.readLine();
                    while (line != null) 
                    {
                        oldContent = oldContent + line + System.lineSeparator();
                        line = reader.readLine();
                    }
                    String newContent = oldContent.replaceAll(oldString, newString);
                    writer = new FileWriter("Login.txt");
                    writer.write(newContent);

                    reader.close();
                    writer.close();

                    JOptionPane.showMessageDialog(this,"Username changed");
                    lbl_UsersName.setText(UserName);
                    changer=false;
                }
            }catch (Exception e){
                System.out.println("General error "+e);
            }
        }else
            JOptionPane.showMessageDialog(this, "You can change username/password only once when you logined, to change username/password you have to logout");
    }//GEN-LAST:event_lbl_ChangeUserNMouseClicked

    private void lbl_ChangeUserNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ChangeUserNMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_ChangeUserNMouseEntered

    private void lbl_DeleteUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_DeleteUserMouseClicked
        // Delete playlist
        try{
            File file1;
            if (UserId==1){
                    file1 = new File("User/user1.txt");
                    if(file1.exists()){
                        file1.delete();
                        file1.createNewFile();
                    }
                }else if (UserId==2){
                    file1 = new File("User/user2.txt");
                    if(file1.exists()){
                        file1.delete();
                        file1.createNewFile();
                    }
                }else if (UserId==3){
                    file1 = new File("User/user3.txt");
                    if(file1.exists()){
                        file1.delete();
                        file1.createNewFile();
                    }
                }else if (UserId==4){
                    file1 = new File("User/user4.txt");
                    if(file1.exists()){
                        file1.delete();
                        file1.createNewFile();
                    }
                }else if (UserId==5){
                    file1 = new File("User/user5.txt");
                    if(file1.exists()){
                        file1.delete();
                        file1.createNewFile();
                    }
                }
            JOptionPane.showMessageDialog(this, "To complate the task the program have to restart ");
            String Dir=System.getProperty("user.dir");
            Dir+="\\AudioPlayer.jar";
            new ProcessBuilder("cmd","/c start /min "+Dir+" ^& exit").start();
            System.exit(0);
        }catch(Exception e){
            System.out.println("General error "+e);
        }
    }//GEN-LAST:event_lbl_DeleteUserMouseClicked

    private void lbl_DeleteUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_DeleteUserMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_DeleteUserMouseEntered

    private void lbl_ChangeUserPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ChangeUserPMouseClicked
        // Change password
        if(changer){
            try{
                String password=JOptionPane.showInputDialog("Enter new password");
                String newString1=" "+UserLog.getUsername()+" "+password;

                File fileToBeModified = new File("Login.txt");
                String oldString1 = " "+UserLog.getUsername()+" "+UserLog.getPassword();
                String oldContent1 ="";
                BufferedReader reader = null;
                FileWriter writer = null;
                reader = new BufferedReader(new FileReader(fileToBeModified));
                String line1 = reader.readLine();
                while (line1 != null) 
                {
                    oldContent1 = oldContent1 + line1 + System.lineSeparator();
                    line1 = reader.readLine();
                }
                String newContent1 = oldContent1.replaceAll(oldString1, newString1);
                writer = new FileWriter("Login.txt");
                writer.write(newContent1);

                reader.close();
                writer.close();

                JOptionPane.showMessageDialog(this,"Password changed");
                changer=false;
            }catch (Exception e){
                System.out.println("General error "+e);
            }
        }else
            JOptionPane.showMessageDialog(this, "You can change username/password only once when you logined, to change username/password you have to logout");
    }//GEN-LAST:event_lbl_ChangeUserPMouseClicked

    private void lbl_ChangeUserPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ChangeUserPMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_ChangeUserPMouseEntered

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseEntered

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Background;
    private javax.swing.JPanel Pn_ForLogin;
    private javax.swing.JDialog Pn_Login;
    private javax.swing.JDialog Pn_SingUp;
    private javax.swing.JTextArea TxA_SongsName;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField lPassword;
    private javax.swing.JTextField lUsername;
    private javax.swing.JLabel lbl_Background;
    private javax.swing.JLabel lbl_Change;
    private javax.swing.JLabel lbl_ChangeUserN;
    private javax.swing.JLabel lbl_ChangeUserP;
    private javax.swing.JLabel lbl_DeleteUser;
    private javax.swing.JLabel lbl_LogOut;
    private javax.swing.JLabel lbl_Login;
    private javax.swing.JLabel lbl_SignUp;
    private javax.swing.JLabel lbl_UsersName;
    private javax.swing.JPasswordField sPassword;
    private javax.swing.JPasswordField sPassword1;
    private javax.swing.JTextField sUsername;
    // End of variables declaration//GEN-END:variables
    
    private MP3Player mp3Player(){
        MP3Player mp3Player = new MP3Player();
        return mp3Player;
    }
    
    private void volumeDownControl(Double valueToPlusMinus){
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        for (Mixer.Info mixerInfo : mixers){
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            Line.Info[] lineInfos=mixer.getTargetLineInfo();
            for(Line.Info lineInfo : lineInfos){
                Line line = null;
                boolean opened = true;
                
                try{
                line = mixer.getLine(lineInfo);
                opened=line.isOpen() || line instanceof Clip;
                if(!opened)
                    line.open();
                FloatControl volControl = (FloatControl) line.getControl (FloatControl.Type.VOLUME);
                float currentVolume = volControl.getValue();
                Double volumeToCut = valueToPlusMinus;
                float changedCalc = (float) ((float)currentVolume-(double)volumeToCut);
                volControl.setValue(changedCalc);
                
            }catch (LineUnavailableException lineException){
            }catch (IllegalArgumentException illException){
            }finally{
                    if (line != null && !opened){
                        line.close();
                    }
                }
                
        }
    }
}
    private void volumeUpControl(Double valueToPlusMinus){
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        for (Mixer.Info mixerInfo : mixers){
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            Line.Info[] lineInfos=mixer.getTargetLineInfo();
            for(Line.Info lineInfo : lineInfos){
                Line line = null;
                boolean opened = true;
                
                try{
                line = mixer.getLine(lineInfo);
                opened=line.isOpen() || line instanceof Clip;
                if(!opened)
                    line.open();
                FloatControl volControl = (FloatControl) line.getControl (FloatControl.Type.VOLUME);
                float currentVolume = volControl.getValue();
                Double volumeToCut = valueToPlusMinus;
                float changedCalc = (float) ((float)currentVolume+(double)volumeToCut);
                volControl.setValue(changedCalc);
                
            }catch (LineUnavailableException lineException){
            }catch (IllegalArgumentException illException){
            }finally{
                    if (line != null && !opened){
                        line.close();
                    }
                }
                
        }
    }
}
    private void volumeControl(Double valueToPlusMinus){
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        for (Mixer.Info mixerInfo : mixers){
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            Line.Info[] lineInfos=mixer.getTargetLineInfo();
            for(Line.Info lineInfo : lineInfos){
                Line line = null;
                boolean opened = true;
                
                try{
                line = mixer.getLine(lineInfo);
                opened=line.isOpen() || line instanceof Clip;
                if(!opened)
                    line.open();
                FloatControl volControl = (FloatControl) line.getControl (FloatControl.Type.VOLUME);
                float currentVolume = volControl.getValue();
                Double volumeToCut = valueToPlusMinus;
                float changedCalc = (float) ((double)volumeToCut);
                volControl.setValue(changedCalc);
                
            }catch (LineUnavailableException lineException){
            }catch (IllegalArgumentException illException){
            }finally{
                    if (line != null && !opened){
                        line.close();
                    }
                }
                
        }
    }
}
}
