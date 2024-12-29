package finale;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Interfaced implements MouseListener, KeyListener, Serializable{

    JFrame frame = new JFrame();
    JLayeredPane layeredpane = new JLayeredPane();
    ImageIcon gameicon;

    ImageIcon[] size900700 = new ImageIcon[22];
    JLabel label900700 = new JLabel();
    JPanel panel900700 = new JPanel();

    ImageIcon[] size20070 = new ImageIcon[12];
    JLabel[] label20070 = new JLabel[7];
    JPanel[] panel20070 = new JPanel[7];

    ImageIcon[] size30070 = new ImageIcon[14];
    JLabel[] label30070 = new JLabel[9];
    JPanel[] panel30070 = new JPanel[9];

    ImageIcon[] size40050 = new ImageIcon[24];
    JLabel[] label40050 = new JLabel[3];
    JPanel[] panel40050 = new JPanel[3];

    ImageIcon[] size15050 = new ImageIcon[6];
    JLabel label15050 = new JLabel();
    JPanel panel15050 = new JPanel();

    ImageIcon[] tutorialncredit = new ImageIcon[8];
    ImageIcon[] nextpic = new ImageIcon[2];
    JLabel next = new JLabel();
    JPanel nextpanel = new JPanel();
    boolean tutorialscene = false;

    ImageIcon[] creditandtutorialpic = new ImageIcon[4];
    JLabel credits = new JLabel();
    JPanel creditspanel = new JPanel();
    JLabel tutorial = new JLabel();
    JPanel tutorialpanel = new JPanel();

    int tutorialpage = 0;
    boolean tutorialpageagain;
    
    ImageIcon[] characterface = new ImageIcon[4];

    int currentscene = 1;
    int currentmenu = 0;
    int playerspawn, enemyspawn;
    int currentx = 0, currenty = 0;
    boolean northface = true, westface = false, eastface = false, southface = false;
    boolean currentingame = false;
    boolean secondboot = false;
    boolean issecondmove = false;
    boolean movementsecond = false, jumpscaresecond = false, walkinendingsecond = false, enemysoundssecond = false;
    boolean jumpscareagain = false;
    boolean playerdie = false;

    int enemysound = 0, enemysoundgo = 0;
    int countings = 0, countingreset = 0;
    boolean callagain = false;
    int endlesscounting = 0;

    boolean endlessmode = false;
    
    JLabel playerpospic = new JLabel();
    JPanel playerpos = new JPanel();

    Movements move = new Movements();
    PlayerData playerdata = new PlayerData();

    JLabel endlessmodescore = new JLabel();
    ImageIcon endlessmodemovementpic;
    JLabel endlessmodemovement = new JLabel();

    int[] hover20070 = {1,3,5,7,10};
    int[] hover30070 = {1,4,7,10,13,1,4,7,10};
    int[] buttons = {0,2,4,6,9};
    int[] buttons2 = {0,3,6,9,12,2,5,8,11};

    int[][] rows = {{0}};
    int[][] colums = {{0}};

    File file = new File("SurvivetheNight\\src\\finale\\GameAssets\\background.wav");
    AudioInputStream backgroundmenu;
    FloatControl volumeControl;
    Clip clipmenu = AudioSystem.getClip();

    File endingfile = new File("SurvivetheNight\\src\\finale\\GameAssets\\endingsound.wav");
    AudioInputStream endingsound;
    FloatControl endingcontrol;
    Clip endingclip = AudioSystem.getClip();

    File walkingfile = new File("SurvivetheNight\\src\\finale\\GameAssets\\Walkingsound.wav");
    AudioInputStream walkingsound;
    FloatControl walkingcontrol;
    Clip walkingclip = AudioSystem.getClip();

    File walkingendingfile = new File("SurvivetheNight\\src\\finale\\GameAssets\\Walkingending.wav");
    AudioInputStream walkingendingsound;
    FloatControl walkingendingcontrol;
    Clip walkingendingclip = AudioSystem.getClip();

    File doorslamfile = new File("SurvivetheNight\\src\\finale\\GameAssets\\doorslam.wav");
    AudioInputStream doorslamsound;
    FloatControl doorcontrol;
    Clip doorslamclip = AudioSystem.getClip();

    File jumpscarefile = new File("SurvivetheNight\\src\\finale\\GameAssets\\jumpscare.wav");
    AudioInputStream jumpscaresound;
    FloatControl jumpscarecontrol;
    Clip jumpscareclip = AudioSystem.getClip();

    File eyesfile = new File("SurvivetheNight\\src\\finale\\GameAssets\\eyessound.wav");
    AudioInputStream eyessound;
    FloatControl eyescontrol;
    Clip eyesclip = AudioSystem.getClip();

    FloatControl one,two,three,four,five,six,seven,eight,nine,ten;

    File leftside1file = new File("SurvivetheNight\\src\\finale\\GameAssets\\Laughing Left side (1 block).wav");
    AudioInputStream leftside1sound;
    Clip leftside1clip = AudioSystem.getClip();

    File leftside2file = new File("SurvivetheNight\\src\\finale\\GameAssets\\Laughing Left side (2 block).wav");
    AudioInputStream leftside2sound;
    Clip leftside2clip = AudioSystem.getClip();

    File leftside3file = new File("SurvivetheNight\\src\\finale\\GameAssets\\Laughing Left side (3 block).wav");
    AudioInputStream leftside3sound;
    Clip leftside3clip = AudioSystem.getClip();

    File rightside1file = new File("SurvivetheNight\\src\\finale\\GameAssets\\Laughing Righs side (1 block).wav");
    AudioInputStream rightside1sound;
    Clip rightside1clip = AudioSystem.getClip();

    File rightside2file = new File("SurvivetheNight\\src\\finale\\GameAssets\\Laughing Right side (2 block) (1).wav");
    AudioInputStream rightside2sound;
    Clip rightside2clip = AudioSystem.getClip();

    File rightside3file = new File("SurvivetheNight\\src\\finale\\GameAssets\\Laughing Right side (3 block).wav");
    AudioInputStream rightside3sound;
    Clip rightside3clip = AudioSystem.getClip();

    File frontback1file = new File("SurvivetheNight\\src\\finale\\GameAssets\\frontback block 1.wav");
    AudioInputStream frontback1sound;
    Clip frontback1clip = AudioSystem.getClip();

    File frontback2file = new File("SurvivetheNight\\src\\finale\\GameAssets\\frontback block 2.wav");
    AudioInputStream frontback2sound;
    Clip frontback2clip = AudioSystem.getClip();

    File frontback3file = new File("SurvivetheNight\\src\\finale\\GameAssets\\frontback block 3.wav");
    AudioInputStream frontback3sound;
    Clip frontback3clip = AudioSystem.getClip();

    Random random = new Random();

    TimerTask jumpscare, gameover, backmenu, backmenu2 ,movementcooldown, almostescape, gameover2, gameover3, 
    eyesframe, escaped, enemysoundstart, enemysoundstop;
    Timer timer = new Timer();
    
    
    Interfaced() throws LineUnavailableException, UnsupportedAudioFileException, IOException{

        frames();

    }

    //helperfunction

    private int setSpawn(int x){


        return random.nextInt(x);

    }
    
    //GUI

    private void frames() throws LineUnavailableException, UnsupportedAudioFileException, IOException{


        
        if(!(secondboot)){

            deserialization();

        }

        //music
        if(!(secondboot)){

            backgroundmenu = AudioSystem.getAudioInputStream(file);
            clipmenu.open(backgroundmenu);
            clipmenu.loop(Clip.LOOP_CONTINUOUSLY);
            volumeControl = (FloatControl) clipmenu.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(playerdata.CurrentVolume);

        }
        
        clipmenu.start();

        /*
         * 0 page 1
         * 1 page 2
         * 2 page 3
         * 3 page 4
         * 4 page 5
         * 5 page 6
         * 6 page 7
         * 7 credits
         * 
        */

        if(!(secondboot)){

            for(int x = 1; x<=8; x++){

                if(x == 8){

                    tutorialncredit[x-1] = new ImageIcon("SurvivetheNight\\src\\finale\\GameAssets\\TutorialnCredit\\credits.png");

                } else {

                    tutorialncredit[x-1] = new ImageIcon("SurvivetheNight\\src\\finale\\GameAssets\\TutorialnCredit\\tutorial"+ x +".png");

                }

            }

            /*
             * 0 credit
             * 1 credit hiover
             * 2 tutorial 
             * 3 tutorial hover
             * 
            */

            creditandtutorialpic[0] = new ImageIcon("SurvivetheNight\\src\\finale\\GameAssets\\20070\\Credits.png");
            creditandtutorialpic[1] = new ImageIcon("SurvivetheNight\\src\\finale\\GameAssets\\20070\\Creditshover.png");
            creditandtutorialpic[2] = new ImageIcon("SurvivetheNight\\src\\finale\\GameAssets\\20070\\Tutorial.png");
            creditandtutorialpic[3] = new ImageIcon("SurvivetheNight\\src\\finale\\GameAssets\\20070\\Tutorialhover.png");


            credits = new JLabel();
            creditspanel = new JPanel();

            credits.setIcon(creditandtutorialpic[0]);
            credits.setBounds(0, 0, 200, 70);

            creditspanel.setLayout(null);
            creditspanel.add(credits);

            creditspanel.setVisible(false);
            creditspanel.setBounds(250, 510, 200, 70);
            layeredpane.add(creditspanel, Integer.valueOf(1));

            creditspanel.addMouseListener(this);

            tutorial = new JLabel();
            tutorialpanel = new JPanel();

            tutorial.setIcon(creditandtutorialpic[2]);
            tutorial.setBounds(0, 0, 200, 70);

            tutorialpanel.setLayout(null);
            tutorialpanel.add(tutorial);

            tutorialpanel.setVisible(false);
            tutorialpanel.setBounds(460, 510, 200, 70);
            layeredpane.add(tutorialpanel, Integer.valueOf(1));

            tutorialpanel.addMouseListener(this);

            nextpic[0] = new ImageIcon("SurvivetheNight\\src\\finale\\GameAssets\\15050\\Next.png");
            nextpic[1] = new ImageIcon("SurvivetheNight\\src\\finale\\GameAssets\\15050\\Nexthover.png");

            next.setIcon(nextpic[0]);
            next.setBounds(0, 0, 150, 50);

            nextpanel.setLayout(null);
            nextpanel.setBounds(650, 550, 150, 50);
            nextpanel.add(next);
            layeredpane.add(nextpanel, Integer.valueOf(1));
            nextpanel.setVisible(false);
            nextpanel.addMouseListener(this);

            

        }

        /*
        imagemenu, 0
        imagedifficulty, 1
        imagesetting, 2
        endlessmode, 3
        imagemenu (easy com), 4
        imagemenu (medium com), 5
        imagemenu (hard com), 6
        imagemenu (easy medium com), 7
        imagemenu (medium hard com), 8
        imagemenu (hard easy com), 9
        imagemenu (easy medium hard com), 10
        imagemenu (all dif completed), 11
        imagemenu (all dif and 50 badge completed)  12
        eyes, 13
        endscreen?, 14
        black, 15
        jumpscare, 16
        gamemover, 17
        escaped, 18
        imageeasy, 19
        imagemediumhard, 20
        imagenightmare, 21
        */

        //set900700 (background)

        if(!(secondboot)){

            for(int x = 1; x<=22; x++){

                size900700[x-1] = new ImageIcon("SurvivetheNight\\src\\finale\\GameAssets\\900700\\" + x + ".png");
    
            }


        }
        

        /*
        startbut, 0
        startbuthover, 1
        settingbut, 2
        settingbuthover, 3
        quitbut, 4
        quitbuthover, 5
        volumeupbut, 6
        volumeupbuthover, 7
        volumeuplocked, 8
        volumedownbut, 9
        volumedownbuthover, 10
        volumedownlocked 11
        */

        //20070 (buttons)

        if(!(secondboot)){

            for(int x = 1; x<=12; x++){

                size20070[x-1] = new ImageIcon("SurvivetheNight\\src\\finale\\GameAssets\\20070\\" + x + ".png");
    
            }


        }
        

        /*
        easydiffpanel, 0
        easydiffhover, 1
        easydifflocked 2
        mediumdiffpanel, 3
        mediumdiffhover, 4
        mediumdifflocked, 5
        harddiffpanel, 6
        harddiffhover, 7
        harddifflocked, 8
        nightmarediffpanel, 9
        nightmarediffhover, 10
        nightmaredifflocked 11
        endlessmode, 12
        endlessmodehover 13
        */

        //30070 (buttons)

        if(!(secondboot)){

            for(int x = 1; x<=14; x++){

                size30070[x-1] = new ImageIcon("SurvivetheNight\\src\\finale\\GameAssets\\30070\\"+ x +".png");
    
            }


        }
        

        /*
        mutebuton, 0
        mutbuthoveron, 1
        mutebutoff, 2
        mutbuthoveroff, 3
        movement 1 4
        movement 2 5
        movement 3 6
        movement 4 7
        movement 5 8
        movement 6 9
        movement 7 10
        movement 8 11
        movement 9 12
        movement 10 13
        movement 11 14
        movement 12 15
        movement 13 16
        movement 14 17
        movement 15 18
        movement 16 19
        movement 17 20
        movement 18 21
        movement 19 22
        movement 20 23
        */

        //400 50 (Buttons)

        if(!(secondboot)){

            for(int x = 1; x<=24; x++){

                size40050[x-1] = new ImageIcon("SurvivetheNight\\src\\finale\\GameAssets\\40050\\"+ x +".png");
    
            }


        }
        

        /*
         *  backbut, 0
            backbuthover, 1
            backbutendless, 2
            backbutendlesshover, 3
            settingback 4
            settingbackhover 5
         * 
         * 
         * 
        */

        //150 50(buttons)

        if(!(secondboot)){

            for(int x = 1; x<=6; x++){

                size15050[x-1] = new ImageIcon("SurvivetheNight\\src\\finale\\GameAssets\\15050\\"+ x +".png");
    
            }

        }

        //characterface 

        /*
         * 0 north
         * 1 west
         * 2 east
         * 3 south
         */

        if(!(secondboot)){

            for(int x = 1; x<=4; x++){

                characterface[x-1] = new ImageIcon("SurvivetheNight\\src\\finale\\GameAssets\\Playerface\\"+ x +".png");
    
            }

        }

        endlessmodemovementpic = new ImageIcon("SurvivetheNight\\src\\finale\\GameAssets\\EndlessMovement.png");

        //menuscreen

        int counting = playerdata.isEasyendless() + playerdata.isMediumendless() + playerdata.isHardendless() + playerdata.isNightmareendless() + playerdata.isAll50complete();

        switch(counting){

            case 5:
            label900700.setIcon(size900700[12]);
            currentmenu = 12;
            break;

            case 4:
            label900700.setIcon(size900700[11]);
            currentmenu = 11;
            break;

            case 3:
            label900700.setIcon(size900700[10]);
            currentmenu = 10;
            break;

            case 2:

                if(playerdata.isEasyendless() + playerdata.isMediumendless() == 2){

                    label900700.setIcon(size900700[7]);
                    currentmenu = 7;
                    break;

                } else if(playerdata.isEasyendless() + playerdata.isHardendless() == 2){

                    label900700.setIcon(size900700[9]);
                    currentmenu = 9;
                    break;

                } else if(playerdata.isMediumendless() + playerdata.isHardendless() == 2){

                    label900700.setIcon(size900700[8]);
                    currentmenu = 8;
                    break;

                }

            case 1:

                if(playerdata.isEasyendless() == 1){

                    label900700.setIcon(size900700[4]);
                    currentmenu = 4;
                    break;

                } else if(playerdata.isMediumendless() == 1){

                    label900700.setIcon(size900700[5]);
                    currentmenu = 5;
                    break;


                } else if(playerdata.isHardendless() == 1){

                    label900700.setIcon(size900700[6]);
                    currentmenu = 6;
                    break;


                }

            case 0:
            label900700.setIcon(size900700[0]);
            break;

        }

        if(!(secondboot)){

            playerpos.setLayout(null);
            playerpospic.setIcon(characterface[1]);
            playerpospic.setBounds(0, 0, 50, 50);
            playerpos.add(playerpospic);

            label900700.setBounds(0,0,900,700);

            panel900700.setBounds(0,0,900,700);
            panel900700.setLayout(null);
            panel900700.add(label900700);

        }

        panel900700.setVisible(true);

        //layeredpane

        if(!(secondboot)){

            layeredpane.setBounds(0, 0, 900, 800);
            layeredpane.add(panel900700, Integer.valueOf(0));

        }
   
        //buttons panels(200 70)

        /*
        startpanel 0
        settingpanel 1
        quitpanel 2
        volume up panel 3
        volume down panel 4
        volume up panel sfx 5
        volume down panel sfx 6
        */

        

        if(!(secondboot)){

            int y20070 = 350;
            int x20070 = 240;

            for(int x = 0; x<5; x++){

                label20070[x] = new JLabel();
                panel20070[x] = new JPanel();

                label20070[x].setIcon(size20070[buttons[x]]);
                label20070[x].setBounds(0, 0, 200, 70);

                panel20070[x].setLayout(null);
                panel20070[x].add(label20070[x]);

                if(x<3){

                    panel20070[x].setVisible(true);
                    panel20070[x].setBounds(50, y20070, 200, 70);
                    layeredpane.add(panel20070[x], Integer.valueOf(1));
                    y20070+=100;

                } else {

                    panel20070[x].setVisible(false);
                    panel20070[x].setBounds(x20070, 170, 200, 70);
                    layeredpane.add(panel20070[x], Integer.valueOf(1));
                    x20070+=210;

                }

                panel20070[x].addMouseListener(this);

            }

            if(playerdata.lowvolume){

                label20070[4].setIcon(size20070[11]);

            } else if(playerdata.fullvolume){

                label20070[3].setIcon(size20070[8]);

            }

            label20070[5] = new JLabel();
            panel20070[5] = new JPanel();

            label20070[5].setIcon(size20070[6]);
            label20070[5].setBounds(0, 0, 200, 70);

            panel20070[5].setLayout(null);
            panel20070[5].add(label20070[5]);

            panel20070[5].setVisible(false);
            panel20070[5].setBounds(250, 350, 200, 70);
            layeredpane.add(panel20070[5], Integer.valueOf(1));

            panel20070[5].addMouseListener(this);

            label20070[6] = new JLabel();
            panel20070[6] = new JPanel();

            label20070[6].setIcon(size20070[9]);
            label20070[6].setBounds(0, 0, 200, 70);

            panel20070[6].setLayout(null);
            panel20070[6].add(label20070[6]);

            panel20070[6].setVisible(false);
            panel20070[6].setBounds(460, 350, 200, 70);
            layeredpane.add(panel20070[6], Integer.valueOf(1));

            panel20070[6].addMouseListener(this);

            if(playerdata.lowvolumesfx){

                label20070[6].setIcon(size20070[11]);

            } else if(playerdata.fullvolumesfx){

                label20070[5].setIcon(size20070[8]);

            } 

        } else {

            for(int x = 0; x<3; x++){

                panel20070[x].setVisible(true);
                label900700.setIcon(size900700[currentmenu]);

            }

        }

        //buttons panels(300 70)

        /*
        easydiffpanel, 0
        mediumdiffpanel, 1
        harddiffpanel, 2
        nightmarediffpanel, 3
        endlessmodepanel, 4
        easyendlesspanel, 5
        mediumendlesspanel, 6
        hardendlesspanel, 7
        nightmareendlesspanel, 8
        */

        if(!(secondboot)){

            int x30070 = 150;
            int[] buttons2 = {0,3,6,9,12,2,5,8,11};

            endlessmodemovement.setText("");
            endlessmodemovement.setHorizontalTextPosition(JLabel.CENTER);
            endlessmodemovement.setVerticalTextPosition(JLabel.CENTER);
            endlessmodemovement.setBounds(350,20,150,70);
            endlessmodemovement.setVisible(false);
            endlessmodemovement.setBackground(Color.darkGray);
            endlessmodemovement.setOpaque(true);
            endlessmodemovement.setIcon(endlessmodemovementpic);
            layeredpane.add(endlessmodemovement, Integer.valueOf(2));

            endlessmodescore.setHorizontalTextPosition(JLabel.CENTER);
            endlessmodescore.setVerticalTextPosition(JLabel.CENTER);
            endlessmodescore.setBounds(490,23,60,65);
            endlessmodescore.setVisible(false);
            endlessmodescore.setBackground(Color.black);
            endlessmodescore.setOpaque(true);
            endlessmodescore.setForeground(Color.white);
            endlessmodescore.setFont(new Font("Cambria", Font.BOLD, 20));
            layeredpane.add(endlessmodescore, Integer.valueOf(3));

            for(int x = 0; x<9; x++){

            label30070[x] = new JLabel();
            panel30070[x] = new JPanel();

            label30070[x].setIcon(size30070[buttons2[x]]);
            label30070[x].setBounds(0,0,300,70);

            panel30070[x].setLayout(null);
            panel30070[x].add(label30070[x]);

            if(x<5){

                if(x == 3){

                    if(playerdata.isAlldifficultcomp() != 1){

                        label30070[x].setIcon(size30070[11]);
                        

                    }


                }

                panel30070[x].setBounds(300, x30070, 300, 70);
                panel30070[x].setVisible(false);
                layeredpane.add(panel30070[x], Integer.valueOf(1));
                x30070+=100;

            } else {

                if(x == 5){

                    x30070 = 150;

                }

                switch(x){

                    case 5:

                    if(playerdata.isEasyendless() == 1){

                        label30070[x].setIcon(size30070[0]);

                    }
                    break;
                    case 6:

                    if(playerdata.isMediumendless() == 1){

                        label30070[x].setIcon(size30070[3]);

                    }
                    break;
                    case 7:

                    if(playerdata.isHardendless() == 1){

                        label30070[x].setIcon(size30070[6]);

                    }
                    break;
                    case 8:

                    if(playerdata.isNightmareendless() == 1){

                        label30070[x].setIcon(size30070[9]);

                    }
                    break;


                }

                panel30070[x].setBounds(300, x30070, 300, 70);
                panel30070[x].setVisible(false);
                layeredpane.add(panel30070[x], Integer.valueOf(1));
                x30070+=100;

            }

            panel30070[x].addMouseListener(this);

            }

            //buttons/display panel (400 50)

            /*
            * mutepanel 0
            * movement display 1
            * mutepanelsfx 2
            */

            int[] buttons3 = {0,23};
            int x40050 = 245;
            int y40050 = 250;

            for(int x = 0; x<2; x++){

            label40050[x] = new JLabel();
            panel40050[x] = new JPanel();

            if(playerdata.currentmute){

                label40050[x].setIcon(size40050[0]);
    
            } else {
    
                label40050[x].setIcon(size40050[2]);
            }

            label40050[x].setBounds(0,0,400,50);

            panel40050[x].setLayout(null);
            panel40050[x].setBounds(x40050, y40050, 400, 50);
            panel40050[x].add(label40050[x]);
            layeredpane.add(panel40050[x], Integer.valueOf(1));
            panel40050[x].setVisible(false);

            if(x == 0){

                panel40050[x].addMouseListener(this);

            }

            x40050+=5;
            y40050-=220;

            }

            label40050[2] = new JLabel();
            panel40050[2] = new JPanel();

            label40050[2].setBounds(0,0,400,50);

            panel40050[2].setLayout(null);
            panel40050[2].setBounds(245, 425, 400, 50);
            panel40050[2].add(label40050[2]);
            layeredpane.add(panel40050[2], Integer.valueOf(1));
            panel40050[2].setVisible(false);

            if(playerdata.currentmutesfx){

                label40050[2].setIcon(size40050[0]);
    
            } else {
    
                label40050[2].setIcon(size40050[2]);

            }

            panel40050[2].addMouseListener(this);

            if(playerdata.currentmute){

                label20070[4].setIcon(size20070[11]);
                label20070[3].setIcon(size20070[8]);
                volumeControl.setValue(-80.0f);
                

            }

            if(playerdata.currentmutesfx){

                label20070[6].setIcon(size20070[11]);
                label20070[5].setIcon(size20070[8]);
                playerdata.CurrentSFXVolume = -80.0f;
                


            }

            //15050 button (panel)
            label15050.setIcon(size15050[0]);
            label15050.setBounds(0, 0, 150, 50);

            panel15050.setLayout(null);
            panel15050.setBounds(50, 100, 150, 50);
            panel15050.add(label15050);
            layeredpane.add(panel15050, Integer.valueOf(1));
            panel15050.setVisible(false);
            panel15050.addMouseListener(this);

            //gameicon
            gameicon = new ImageIcon("SurvivetheNight\\src\\finale\\GameAssets\\GameIcon.png");

            //frame
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.setTitle("Survive the Night");
            frame.setLayout(null);
            frame.setSize(900,700);
            frame.setIconImage(gameicon.getImage());
            frame.setVisible(true);
            frame.setResizable(false);
            frame.addKeyListener(this);
            frame.add(layeredpane);


        } else {

            if(playerdata.isEasyendless() == 1){

                label30070[5].setIcon(size30070[0]);

            } 
            
            if(playerdata.isMediumendless() == 1){

                label30070[6].setIcon(size30070[3]);


            } 
            
            if(playerdata.isHardendless() == 1){

                label30070[7].setIcon(size30070[6]);


            } 
            
            if(playerdata.isNightmareendless() == 1){

                label30070[8].setIcon(size30070[9]);

            } 
            
            if(playerdata.isAlldifficultcomp() == 1){

                label30070[3].setIcon(size30070[9]);

            }


        }

    }

    //Serialization/deserialization

    public void serialization(){

        FileOutputStream PlayerDatas;

        try {

            PlayerDatas = new FileOutputStream("SurvivetheNight\\src\\finale\\Playerdata.ser");
            ObjectOutputStream out = new ObjectOutputStream(PlayerDatas);
            out.writeObject(playerdata);
            out.close();
            PlayerDatas.close();

        } catch (IOException e) {
            
            e.printStackTrace();

        }

    }

    private void deserialization(){

        PlayerData deserialization = null;
        FileInputStream playerdatainput;

        try {

            playerdatainput = new FileInputStream("SurvivetheNight\\src\\finale\\Playerdata.ser");
            ObjectInputStream in = new ObjectInputStream(playerdatainput);
            deserialization = (PlayerData) in.readObject();
            in.close();
            playerdatainput.close();

        } catch (IOException | ClassNotFoundException e) {
            
            e.printStackTrace();

        }

        playerdata = deserialization;

    }

    //functionalities

    public void soundcue(){

        System.out.println("Soundcue Start");

        int rowsncol = 0;
        int playerx = 0;
        int playery = 0;
        int enemyx = 0;
        int enemyy = 0;
        boolean leftear = false, rightear = false;
        double distance = 0;

        enemysoundstart = new TimerTask() {

            @Override
            public void run() {

                System.out.println("Enemy Sounds at " + enemysound);

                enemysoundgo = enemysound;

                switch(enemysound){

                    case 1:
                    leftside1clip.start();
                    break;

                    case 2:
                    leftside2clip.start();
                    break;

                    case 3:
                    leftside3clip.start();
                    break;

                    case 4:
                    rightside1clip.start();
                    break;

                    case 5:
                    rightside2clip.start();
                    break;

                    case 6:
                    rightside3clip.start();
                    break;

                    case 7:
                    frontback1clip.start();
                    break;

                    case 8:
                    frontback2clip.start();
                    break;

                    case 9:
                    frontback3clip.start();
                    break;

                    case 10:

                    break;

                }

                timer.schedule(enemysoundstop, 5000);
                
            }
            
        };

        enemysoundstop = new TimerTask() {

            @Override
            public void run() {

                System.out.println("Enemy Stops " + enemysound);

                if(currentingame){

                switch(enemysoundgo){

                    case 1:
                    leftside1clip.stop();
                    leftside1clip.setFramePosition(0);
                    break;

                    case 2:
                    leftside2clip.stop();
                    leftside2clip.setFramePosition(0);
                    break;

                    case 3:
                    leftside3clip.stop();
                    leftside3clip.setFramePosition(0);
                    break;

                    case 4:
                    rightside1clip.stop();
                    rightside1clip.setFramePosition(0);
                    break;

                    case 5:
                    rightside2clip.stop();
                    rightside2clip.setFramePosition(0);
                    break;

                    case 6:
                    rightside3clip.stop();
                    rightside3clip.setFramePosition(0);
                    break;

                    case 7:
                    frontback1clip.stop();
                    frontback1clip.setFramePosition(0);
                    break;

                    case 8:
                    frontback2clip.stop();
                    frontback2clip.setFramePosition(0);
                    break;

                    case 9:
                    frontback3clip.stop();
                    frontback3clip.setFramePosition(0);
                    break;

                    case 10:

                    break;


                }

                }

                callagain = false;
                
            }
            
        };

        if(!(callagain)){

            System.out.println("Sound countdown again");

            timer.schedule(enemysoundstart, 8000);

        }


        if(move.easygame){

            rows = new int[][] {{0,1,2,3,4}, {5,6,7,8,9}, {10,11,12,13,14}, {15,16,17,18,19}, {20,21,22,23,24}};
            colums = new int[][] {{0,5,10,15,20}, {1,6,11,16,21}, {2,7,12,17,22}, {3,8,13,18,23}, {4,9,14,19,24}};

            rowsncol = 5;

        } else if(move.mediumgame || move.hardgame){

            rows = new int[][] {{0,1,2,3}, {4,5,6,7}, {8,9,10,11}, {12,13,14,15}};
            colums = new int[][] {{0,4,8,12}, {1,5,9,13}, {2,6,10,14}, {3,7,11,15}};

            rowsncol = 4;

        } else if(move.nightmaregame){

            rows = new int[][] {{0,1,2}, {3,4,5}, {6,7,8}};
            colums = new int[][] {{0,3,6}, {1,4,7}, {2,5,8}};

            rowsncol = 3;

        }


            //player

            for(int x = 0; x<rowsncol; x++){

                for(int y = 0; y<rowsncol; y++){

                    if(move.playerlocation == rows[x][y]){

                        playerx = x + 1;

                    }

                    if(move.playerlocation == colums[x][y]){

                        playery = x + 1;

                    }

                    if(move.enemylocation == rows[x][y]){

                        enemyx = x + 1;

                    }

                    if(move.enemylocation == colums[x][y]){

                        enemyy = x + 1;


                    }

                }

            }

            // distance < 2 = one block away, distance >= 2 and distance < 3 = two blocks away, else is three blck away
            distance = Math.sqrt(Math.pow((enemyx - playerx),2) + Math.pow((enemyy - playery),2));

            System.out.println("Player" + playerx + playery);
            System.out.println("Player" + enemyx + enemyy);

            if(northface){

                if(playery<enemyy){

                    rightear = true;

                } else if(playery>enemyy) {

                    leftear = true;

                }

            } else if(westface){

                if(playerx<enemyx){

                    leftear = true;

                } else if(playerx>enemyx){

                    rightear = true;
                    
                }

            } else if(eastface){

                if(playerx<enemyx){

                    rightear = true;

                } else if(playerx>enemyx){

                    leftear = true;
                    
                }

            } else if(southface){

                if(playery>enemyy){

                    rightear = true;

                } else if (playery<enemyy){

                    leftear = true;
                    
                }

            }

        /*
         * 1 left ear 1 block
         * 2 left ear 2 bloc
         * 3 left ear 3 block
         * 4 right ear 1 block
         * 5 right ear 2 block
         * 6 right ear 3 block
         * 7 front/back block 1
         * 8 front/back block 2
         * 9 front/bacl block 3
         */

        if(distance<2){

            System.out.println("Distance: 1 block");

            if(leftear){

                enemysound = 1;
                System.out.println("left ear");

            } else if(rightear){

                enemysound = 4;
                System.out.println("right ear");

            } else {

                enemysound = 7;
                System.out.println("fromt ear");


            }


        } else if(distance>=2 && distance < 3){

            System.out.println("Distance: 2 block");
            
            if(leftear){

                enemysound = 2;
                System.out.println("left ear");

            } else if (rightear) {

                enemysound = 5;
                System.out.println("right ear");

            } else {

                enemysound = 8;
                System.out.println("front ear");


            }


        } else {

            System.out.println("Distance: 3 block");

            if(leftear){

                enemysound = 3;
                System.out.println("left ear");


            } else if(rightear) {

                enemysound = 6;
                System.out.println("right ear");

            } else {

                enemysound = 9;
                System.out.println("front ear");


            }


        }

        if(playerdie || !(currentingame)){

            enemysound = 10;

        }

        if(!(enemysoundssecond)){

            try {

                leftside1sound = AudioSystem.getAudioInputStream(leftside1file);
                leftside1clip.open(leftside1sound);
                one = (FloatControl) leftside1clip.getControl(FloatControl.Type.MASTER_GAIN);
                leftside2sound = AudioSystem.getAudioInputStream(leftside2file);
                leftside2clip.open(leftside2sound);
                two = (FloatControl) leftside2clip.getControl(FloatControl.Type.MASTER_GAIN);
                leftside3sound = AudioSystem.getAudioInputStream(leftside3file);
                leftside3clip.open(leftside3sound);
                three = (FloatControl) leftside3clip.getControl(FloatControl.Type.MASTER_GAIN);

                rightside1sound = AudioSystem.getAudioInputStream(rightside1file);
                rightside1clip.open(rightside1sound);
                four = (FloatControl) rightside1clip.getControl(FloatControl.Type.MASTER_GAIN);
                rightside2sound = AudioSystem.getAudioInputStream(rightside2file);
                rightside2clip.open(rightside2sound);
                five = (FloatControl) rightside2clip.getControl(FloatControl.Type.MASTER_GAIN);
                rightside3sound = AudioSystem.getAudioInputStream(rightside3file);
                rightside3clip.open(rightside3sound);
                six = (FloatControl) rightside3clip.getControl(FloatControl.Type.MASTER_GAIN);

                frontback1sound = AudioSystem.getAudioInputStream(frontback1file);
                frontback1clip.open(frontback1sound);
                seven = (FloatControl) frontback1clip.getControl(FloatControl.Type.MASTER_GAIN);
                frontback2sound = AudioSystem.getAudioInputStream(frontback2file);
                frontback2clip.open(frontback2sound);
                eight = (FloatControl) frontback2clip.getControl(FloatControl.Type.MASTER_GAIN);
                frontback3sound = AudioSystem.getAudioInputStream(frontback3file);
                frontback3clip.open(frontback3sound);
                nine = (FloatControl) frontback3clip.getControl(FloatControl.Type.MASTER_GAIN);
                
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    
                e.printStackTrace();
        
            }

        }

        
        one.setValue(playerdata.CurrentSFXVolume);
        two.setValue(playerdata.CurrentSFXVolume);
        three.setValue(playerdata.CurrentSFXVolume);

        four.setValue(playerdata.CurrentSFXVolume);
        five.setValue(playerdata.CurrentSFXVolume);
        six.setValue(playerdata.CurrentSFXVolume);

        seven.setValue(playerdata.CurrentSFXVolume);
        eight.setValue(playerdata.CurrentSFXVolume);
        nine.setValue(playerdata.CurrentSFXVolume);

        enemysoundssecond = true;

        if(!(callagain)){

            callagain = true;

        }
        

    }

    public void escape(){

        label900700.setIcon(size900700[15]);
        panel40050[1].setVisible(false);
        playerpos.setVisible(false);
        secondboot = true;
        jumpscareagain = false;
        issecondmove = false;
        currentingame = false;

        almostescape = new TimerTask() {

            @Override
            public void run() {

                label900700.setIcon(size900700[14]);
                walkingendingclip.start();

                if(playerdie){

                    timer.schedule(gameover2, 10000);

                } else {

                    timer.schedule(escaped, 10000);

                }

            }
            
        };

        timer.schedule(almostescape, 6000);

        escaped = new TimerTask(){

            @Override
            public void run() {

                if(move.easygame){

                    playerdata.setEasyendless(1);

                } else if (move.mediumgame){

                    playerdata.setMediumendless(1);

                } else if (move.hardgame){

                    playerdata.setHardendless(1);

                } else if (move.nightmaregame){

                    playerdata.setNightmareendless(1);

                }

                if((playerdata.isEasyendless() + playerdata.isMediumendless() + playerdata.isHardendless()) == 3){

                    System.out.println("Nightmare mode unlocked");
                    playerdata.setAlldifficultcomp(1);

                }

                label900700.setIcon(size900700[18]);
                walkingendingclip.stop();
                walkingendingclip.setFramePosition(0);
                endingclip.start();
                timer.schedule(backmenu2, 15000);

                move.easygame = move.mediumgame = move.hardgame = move.nightmaregame = false;

            }

        };

        backmenu2 = new TimerTask() {

            @Override
            public void run() {

                clipmenu.setFramePosition(0);

                if(!(playerdie)){

                    endingclip.stop();
                    endingclip.setFramePosition(0);

                } else {

                    eyesclip.stop();
                    eyesclip.setFramePosition(0);

                }
                
                try {

                    frames();

                } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                    
                    e.printStackTrace();
                }

                
            }
            
        };

        gameover2 = new TimerTask(){

            @Override
            public void run() {

                label900700.setIcon(size900700[15]);
                walkingendingclip.stop();
                walkingendingclip.setFramePosition(0);
                doorslamclip.start();
                timer.schedule(eyesframe, 5000);

                move.easygame = move.mediumgame = move.hardgame = move.nightmaregame = false;
                
            }

        };

        eyesframe = new TimerTask() {

            @Override
            public void run() {

                label900700.setIcon(size900700[13]);
                doorslamclip.stop();
                eyesclip.start();
                doorslamclip.setFramePosition(0);
                timer.schedule(gameover3, 5000);
                
            }
            
        };

        gameover3 = new TimerTask() {

            @Override
            public void run() {

                label900700.setIcon(size900700[17]);
                timer.schedule(backmenu2, 5000);
                
            }
            
        };

        if(!(walkinendingsecond)){

            try {

                walkingendingsound = AudioSystem.getAudioInputStream(walkingendingfile);
                walkingendingclip.open(walkingendingsound);
                walkingendingcontrol = (FloatControl) walkingendingclip.getControl(FloatControl.Type.MASTER_GAIN);
                endingsound = AudioSystem.getAudioInputStream(endingfile);
                endingclip.open(endingsound);
                endingcontrol = (FloatControl) endingclip.getControl(FloatControl.Type.MASTER_GAIN);
                doorslamsound = AudioSystem.getAudioInputStream(doorslamfile);
                doorslamclip.open(doorslamsound);
                doorcontrol = (FloatControl) doorslamclip.getControl(FloatControl.Type.MASTER_GAIN);
                eyessound = AudioSystem.getAudioInputStream(eyesfile);
                eyesclip.open(eyessound);
                eyescontrol = (FloatControl) eyesclip.getControl(FloatControl.Type.MASTER_GAIN);
        
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    
                e.printStackTrace();
        
            }

        }

        walkinendingsecond = true;

        walkingendingcontrol.setValue(playerdata.CurrentVolume);
        endingcontrol.setValue(playerdata.CurrentVolume);
        doorcontrol.setValue(playerdata.CurrentVolume);
        eyescontrol.setValue(playerdata.CurrentVolume);

    }

    public void jumpscare(){

        secondboot = true;

        int jumpscaretime = random.nextInt(5000) + 1;

        if(!(jumpscareagain)){

            jumpscare = new TimerTask() {

                @Override
                public void run() {
    
                    label900700.setIcon(size900700[16]);
                    panel40050[1].setVisible(false);
                    endlessmodemovement.setVisible(false);
                    endlessmodescore.setVisible(false);
                    jumpscareclip.start();
                    walkingclip.stop();

                    if(endlessmode){

                        if(move.easygame){

                            if(playerdata.geteasyhighscore()<endlesscounting){

                                System.out.println("New Highscore!");

                                playerdata.seteasyscore(endlesscounting);

                            }

                            if(endlesscounting>=50){

                                playerdata.seteasy50(1);

                            }

                        } else if(move.mediumgame){

                            if(playerdata.getmediumhighscore()<endlesscounting){

                                System.out.println("New Highscore!");

                                playerdata.setmediumscore(endlesscounting);

                            }

                            if(endlesscounting>=50){

                                playerdata.setmedium50(1);

                            }


                        } else if(move.hardgame){

                            if(playerdata.gethardhighscore()<endlesscounting){

                                System.out.println("New Highscore!");

                                playerdata.sethardscore(endlesscounting);

                            }

                            if(endlesscounting>=50){

                                playerdata.sethard50(1);

                            }

                            
                        } else if(move.nightmaregame){

                            if(playerdata.geteasyhighscore()<endlesscounting){

                                System.out.println("New Highscore!");

                                playerdata.sethardscore(endlesscounting);

                            }

                            if(endlesscounting>=50){

                                playerdata.setnightmare50(1);

                            }

                            
                        }

                        if(playerdata.iseasy50() + playerdata.ismedium50() + playerdata.ishard50() + playerdata.isnightmare50() == 4){

                            playerdata.setAll50complete(1);

                        }

                    }
    
                    endlessmode = move.easygame = move.mediumgame = move.hardgame = move.nightmaregame = false;
                    endlesscounting = 0;
                    currentingame = false;
                    jumpscareagain = false;
                    issecondmove = false;
                    playerdie = false;
                    playerpos.setVisible(false);

                    timer.schedule(gameover, 5000);
                    
                }
                
            };
    
            timer.schedule(jumpscare, jumpscaretime);

        }

        gameover = new TimerTask(){

            @Override
            public void run() {

                label900700.setIcon(size900700[17]);
                timer.schedule(backmenu, 5000);
                
            }
            
        };

        backmenu = new TimerTask(){

            @Override
            public void run() {

                try {

                    frames();

                } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                    
                    e.printStackTrace();
                }

                clipmenu.setFramePosition(0);
                jumpscareclip.setFramePosition(0);
                jumpscareclip.stop();

            }

        };

        if(!(jumpscaresecond)){

            try {

                jumpscaresound = AudioSystem.getAudioInputStream(jumpscarefile);
                jumpscareclip.open(jumpscaresound);
                jumpscarecontrol = (FloatControl) jumpscareclip.getControl(FloatControl.Type.MASTER_GAIN);
        
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    
                e.printStackTrace();
        
            }

        }

        jumpscaresecond = true;
        jumpscareagain = true;

        jumpscarecontrol.setValue(playerdata.CurrentVolume);

    }

    public void cooldownmovement(){

        move.disablemovement = true;

        movementcooldown = new TimerTask() {

            @Override
            public void run() {

                System.out.println("Schedule stop!");

                move.disablemovement = false;
                walkingclip.stop();
                walkingclip.setFramePosition(0);
               
            }
            
        };

        timer.schedule(movementcooldown, 2500);

        if(!(movementsecond)){

            try {

                walkingsound = AudioSystem.getAudioInputStream(walkingfile);
                walkingclip.open(walkingsound);
                walkingcontrol = (FloatControl) walkingclip.getControl(FloatControl.Type.MASTER_GAIN);
        
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    
                e.printStackTrace();
        
            }

        }

        movementsecond = true;

        walkingcontrol.setValue(playerdata.CurrentSFXVolume);

        walkingclip.start();

        System.out.println("Walking sound go!");

    }

    public void playerposupdate(int playerspawn){

        if(move.easygame){

            move.numberoftiles = 25;
            move.currentarray = 4;
    
        }  else if (move.mediumgame || move.hardgame){
    
            move.numberoftiles = 16;
            move.currentarray = 3;
    
        } else if(move.nightmaregame){
    
            move.numberoftiles = 9;
            move.currentarray = 2;
    
        }

        for(int x = 0; x<move.numberoftiles; x++){

            if(currentx>move.currentarray){

                currentx = 0;
                currenty++;

            }

            if(x == playerspawn){

                playerpos.setBounds(move.xpos[currentx], move.ypos[currenty], 50, 50);

                    layeredpane.add(playerpos, Integer.valueOf(2));

                    if(northface){

                        playerpospic.setIcon(characterface[0]);
                        System.out.println(northface + "North");

                    } else if(westface){

                        playerpospic.setIcon(characterface[1]);
                        System.out.println(westface+ "West");

                    } else if(eastface){

                        playerpospic.setIcon(characterface[2]);
                        System.out.println(eastface+ "East");

                    } else if(southface){

                        playerpospic.setIcon(characterface[3]);
                        System.out.println(southface+ "South");

                    }
                    
                    playerpos.setVisible(true);
                
                break;

            }

            currentx++;

        }

        currentx = currenty = 0;

        if(issecondmove){

            cooldownmovement();

        }

    }

    public void Arenaverdict(char x){

        int beforeplayerpos = move.playerlocation;
        int beforeenemypos = move.enemylocation;
        int newplayerposition = -1;
        int newenemyposition = -1;
        int curcorner = 1;
        int playerpositionnum = 0;
        int playerpositionnum1 = 0;
        int enemymovements = 0;
        int limit = 0;

        northface = westface = eastface = southface = false;

        if(move.easygame){

            limit = 23;

            playerpositionnum = 9;
            playerpositionnum1 = 3;
            enemymovements = 1;


        } else if(move.mediumgame || move.hardgame){

            limit = 15;

            playerpositionnum = 4;
            playerpositionnum1 = 2;

            if(move.mediumgame){

                if(endlessmode){

                    if(random.nextInt(1,101) <= 20){

                        enemymovements = 2;
    
                    } else {
    
                        enemymovements = 1;
    
                    }

                } else {

                    if(random.nextInt(1,101) <= 50){

                        enemymovements = 2;
    
                    } else {
    
                        enemymovements = 1;
    
                    }


                }

            } else {

                if(endlessmode){

                    enemymovements = 2;

                } else {

                    if(random.nextInt(1,101) <= 20){

                        enemymovements = 3;
    
                    } else {
    
                        enemymovements = 2;
    
                    }

                }


            }

            
        } else if (move.nightmaregame) {

            limit = 8;

            playerpositionnum = 3;
            playerpositionnum1 = 1;

            int randomness = random.nextInt(1,101);

            if(endlessmode){

                if(randomness <=10){

                    enemymovements = 2;

                } else {

                    enemymovements = 1;

                }


            } else {

                if(randomness < 10){

                    enemymovements = 3;
    
                } else if(randomness>=10 && randomness<70){
    
                    enemymovements = 2;
    
                } else {
    
                    enemymovements = 1;
    
                }


            }

            

        }

        switch (x){

            case 'w':
            northface = true;
            System.out.println("Hello" + x);
            break;

            case 'a':
            westface = true;
            System.out.println("Hello" + x);
            break;

            case 'd':
            eastface = true;
            System.out.println("Hello" + x);
            break;

            case 's':
            southface = true;
            System.out.println("Hello" + x);
            break;

        }

        //player
        for(int y = 0; y<playerpositionnum; y++){

            System.out.println("");

            if(y<playerpositionnum1){

                //1 left 2 right 3 up 4 down

                if(move.playerlocation == move.sideleft[y]){

                    newplayerposition = move.sidemovement(x, 1, beforeplayerpos);
                    break;


                } else if(move.playerlocation == move.sideright[y]){

                    newplayerposition = move.sidemovement(x, 2, beforeplayerpos);
                    break;


                } else if(move.playerlocation == move.sideup[y]){

                    newplayerposition = move.sidemovement(x, 3, beforeplayerpos);
                    break;


                } else if(move.playerlocation == move.sidedown[y]){

                    newplayerposition = move.sidemovement(x, 4, beforeplayerpos);
                    break;


                }

            }

            if(y<4){

                if(move.nightmaregame){

                    // 1 up left 2 up right 3 down left 4 down right

                    if(move.playerlocation == move.corner[y]){
                    
                    newplayerposition = move.cornermovement(x, curcorner, beforeplayerpos);
                    break;

                }

                    curcorner++;

                    if(y == 2){

                        if(move.playerlocation == move.corner[y+1]){
                        
                            newplayerposition = move.cornermovement(x, curcorner, beforeplayerpos);
                            break;

                        }

                    }

                } else {

                    if(move.playerlocation == move.corner[y]){
                    
                        newplayerposition = move.cornermovement(x, curcorner, beforeplayerpos);
                        break;

                    }

                    curcorner++;

                }

            } 

            if(move.nightmaregame){

                if(move.playerlocation == move.center[0]){

                    newplayerposition = move.centermovement(x, beforeplayerpos);
    
                    break;
    
                }


            } else {

                if(move.playerlocation == move.center[y]){

                    newplayerposition = move.centermovement(x, beforeplayerpos);
    
                    break;
    
                }


            }

            

        }

        curcorner = 1;

        if(newplayerposition == beforeplayerpos || newplayerposition == -1){

            newplayerposition = beforeplayerpos;

        } else {

        //enemy

        int moving;

        for(int z = 0; z<enemymovements; z++){

            System.out.println("Movements: "+ enemymovements);

            do{

                for(int y = 0; y<playerpositionnum; y++){
    
                    if(y<playerpositionnum1){
    
                        moving = random.nextInt(3)+1;
    
                        //1 left 2 right 3 up 4 down
    
                        if(move.enemylocation == move.sideleft[y]){
    
                            newenemyposition = move.sidemovement(moving, 1, beforeenemypos);
                            break;
    
                        } else if(move.enemylocation == move.sideright[y]){
    
                            newenemyposition = move.sidemovement(moving, 2, beforeenemypos);
                            break;
    
    
                        } else if(move.enemylocation == move.sideup[y]){
    
                            newenemyposition = move.sidemovement(moving, 3, beforeenemypos);
                            break;
    
    
                        } else if(move.enemylocation == move.sidedown[y]){
    
                            newenemyposition = move.sidemovement(moving, 4, beforeenemypos);
                            break;
    
    
                        }
    
                    }
    
                    if(y<4){

                        moving = random.nextInt(2)+1;

                        if(move.nightmaregame){

                            // 1 up left 2 up right 3 down left 4 down right
    
                            if(move.enemylocation == move.corner[y]){
                            
                            newenemyposition = move.cornermovement(moving, curcorner, beforeenemypos);
                            break;
    
                        }
    
                        curcorner++;

                        if(y == 2){

                            if(move.enemylocation == move.corner[y+1]){
                            
                                newenemyposition = move.cornermovement(moving, curcorner, beforeenemypos);
                                break;
        
                            }

                        }

                        } else {

                            if(move.enemylocation == move.corner[y]){
                            
                                newenemyposition = move.cornermovement(moving, curcorner, beforeenemypos);
                                break;
        
                            }
        
                            curcorner++;

                        }
    
                    } 

                    if(move.nightmaregame){

                        if(move.enemylocation == move.center[0]){
    
                            moving = random.nextInt(4)+1;
        
                            newenemyposition = move.centermovement(moving, beforeenemypos);
        
                            break;
        
                        }


                    } else {

                        if(move.enemylocation == move.center[y]){
    
                            moving = random.nextInt(4)+1;
        
                            newenemyposition = move.centermovement(moving, beforeenemypos);
        
                            break;
        
                        }

                    }
    
                    
    
                }
    
                curcorner = 1;
    
            } while(beforeenemypos == newenemyposition || move.lastpositionmove == newenemyposition || newenemyposition<0 || newenemyposition>limit);

            move.lastpositionmove = beforeenemypos;
    
            if(beforeenemypos == newplayerposition && beforeplayerpos == newenemyposition || newplayerposition == newenemyposition){
    
                System.out.println("Died!");
                playerdie = true;
    
                if(!(move.numberofmovements <= 9) || endlessmode){
    
                    jumpscare();
    
                } 
                
            }

            if(enemymovements == 1){

                if(newplayerposition == -1){

                    newplayerposition = beforeplayerpos;
        
                } else if(newenemyposition == -1){
        
                    newenemyposition = beforeenemypos;
        
                } else {
        
                    issecondmove = true;
                    move.playerlocation = newplayerposition;
                    move.enemylocation = newenemyposition;
        
                }

                playerposupdate(newplayerposition);

            } else {

                if( z+1 == enemymovements ){

                    if(newplayerposition == -1){

                        newplayerposition = beforeplayerpos;
            
                    } else if(newenemyposition == -1){
            
                        newenemyposition = beforeenemypos;
            
                    } else {
            
                        issecondmove = true;
                        move.playerlocation = newplayerposition;
                        move.enemylocation = newenemyposition;
            
                    }

                    playerposupdate(newplayerposition);

                } else {

                    System.out.println("Again");

                    if (newenemyposition == -1){

                        newenemyposition = beforeenemypos;
    
                    }

                    beforeenemypos = newenemyposition;

                }

            }

        }

        if(!(endlessmode)){

            move.numberofmovements--;

            if(move.numberofmovements<4){

                escape();
    
            } else {
    
                label40050[1].setIcon(size40050[move.numberofmovements]);
    
            }

        } else {

            endlesscounting++;
            endlessmodescore.setText(String.valueOf(endlesscounting));

        }

        soundcue();

        System.out.println("---------------------------------------");

        }

    }
    
    //setup arena

    public void easyArena(){

        

            label900700.setIcon(size900700[19]);

            if(!(endlessmode)){

            panel40050[1].setVisible(true);
            label40050[1].setIcon(size40050[23]);

            } else {

            endlessmodescore.setText(String.valueOf(endlesscounting));
            endlessmodescore.setVisible(true);
            endlessmodemovement.setVisible(true);
            System.out.println("HighScore: " + playerdata.geteasyhighscore());
            System.out.println(endlesscounting);

            }
        
            move.easygame = true;
            currentingame = true;

            if(!(endlessmode)){

                move.numberofmovements = 23;

            }
            
            move.xypositionsetup();
            clipmenu.stop();

            if(!(endlessmode)){

                for(int y = 0; y<5; y++){

                    panel30070[y].setVisible(false);
        
                }

            } else {

                for(int y = 5; y<9; y++){

                    panel30070[y].setVisible(false);
        
                }

            }

            panel15050.setVisible(false);

            do{

                playerspawn = setSpawn(25);
                enemyspawn = setSpawn(25);

            } while (playerspawn == enemyspawn);

            move.setPlayerLocation(playerspawn);
            move.setEnemyLocation(enemyspawn);

            playerposupdate(playerspawn);

            soundcue();

            System.out.println(playerspawn);



        

        

    }

    public void mediumArena(){

        label900700.setIcon(size900700[20]);
        
            if(!(endlessmode)){

                panel40050[1].setVisible(true);
                label40050[1].setIcon(size40050[23]);

            } else {

                endlessmodescore.setText(String.valueOf(endlesscounting));
                endlessmodescore.setVisible(true);
                endlessmodemovement.setVisible(true);
    
            }

        move.mediumgame = true;
        currentingame = true;

            if(!(endlessmode)){

                move.numberofmovements = 23;

            }

        move.xypositionsetup();
        clipmenu.stop();

            if(!(endlessmode)){

                for(int y = 0; y<5; y++){

                    panel30070[y].setVisible(false);
        
                }

            } else {

                for(int y = 5; y<9; y++){

                    panel30070[y].setVisible(false);
        
                }

            }

            panel15050.setVisible(false);

        do{

            playerspawn = setSpawn(16);
            enemyspawn = setSpawn(16);

        } while (playerspawn == enemyspawn);

        move.setPlayerLocation(playerspawn);
        move.setEnemyLocation(enemyspawn);

        playerposupdate(playerspawn);

        soundcue();

        System.out.println(playerspawn);

    }

    public void hardArena(){

        label900700.setIcon(size900700[20]);

            if(!(endlessmode)){

                panel40050[1].setVisible(true);
                label40050[1].setIcon(size40050[23]);

            } else {

                endlessmodescore.setText(String.valueOf(endlesscounting));
                endlessmodescore.setVisible(true);
                endlessmodemovement.setVisible(true);
    
            }
        
        move.hardgame = true;
        currentingame = true;

            if(!(endlessmode)){

                move.numberofmovements = 23;

            }

        move.xypositionsetup();
        clipmenu.stop();

            if(!(endlessmode)){

                    for(int y = 0; y<5; y++){

                        panel30070[y].setVisible(false);
            
                    }

                } else {

                    for(int y = 5; y<9; y++){

                        panel30070[y].setVisible(false);
            
                    }

                }

                panel15050.setVisible(false);

        do{

            playerspawn = setSpawn(16);
            enemyspawn = setSpawn(16);

        } while (playerspawn == enemyspawn);

        move.setPlayerLocation(playerspawn);
        move.setEnemyLocation(enemyspawn);

        playerposupdate(playerspawn);

        soundcue();

        System.out.println(playerspawn);

    }

    public void nightmareArena(){

        label900700.setIcon(size900700[21]);

            if(!(endlessmode)){

                panel40050[1].setVisible(true);
                label40050[1].setIcon(size40050[23]);

            } else {

                endlessmodescore.setText(String.valueOf(endlesscounting));
                endlessmodescore.setVisible(true);
                endlessmodemovement.setVisible(true);
    
            }

        move.nightmaregame = true;
        currentingame = true;

            if(!(endlessmode)){

                move.numberofmovements = 23;

            }

        move.xypositionsetup();
        clipmenu.stop();

            if(!(endlessmode)){

                for(int y = 0; y<5; y++){

                    panel30070[y].setVisible(false);
        
                }

            } else {

                for(int y = 5; y<9; y++){

                    panel30070[y].setVisible(false);
        
                }

            }

            panel15050.setVisible(false);

        do{

            playerspawn = setSpawn(9);
            enemyspawn = setSpawn(9);

        } while (playerspawn == enemyspawn);

        move.setPlayerLocation(playerspawn);
        move.setEnemyLocation(enemyspawn);

        playerposupdate(playerspawn);

        soundcue();

        System.out.println(playerspawn);

    }

    //ovveride

    @Override
    public void mouseClicked(MouseEvent e) {

       if(e.getSource() == nextpanel){

            label900700.setIcon(tutorialncredit[tutorialpage]);
            tutorialpage++;

            if(tutorialpage == 7){

                nextpanel.setVisible(false);
                tutorialpage = 0;

            }

        } else if (e.getSource() == panel20070[5] || e.getSource() == panel20070[6]) {

            if(e.getSource() == panel20070[5]){

                if(playerdata.currentmutesfx != true){

                    playerdata.CurrentSFXVolume += 1.0f;
    
                    if(playerdata.lowvolumesfx == true){
    
                    label20070[6].setIcon(size20070[9]);
                    playerdata.lowvolumesfx = false;

                    } else if(playerdata.CurrentSFXVolume>=3){
    
                    playerdata.CurrentSFXVolume = 3;
                    label20070[5].setIcon(size20070[8]);
                    playerdata.fullvolumesfx = true;
    
                    } 

                System.out.println("Current SFX Volume: " + playerdata.CurrentSFXVolume);
                }


            } else {

                if(playerdata.currentmutesfx != true){

                    playerdata.CurrentSFXVolume -= 1.0f;
    
                    if(playerdata.fullvolumesfx == true){
    
                    label20070[5].setIcon(size20070[6]);
                    playerdata.fullvolumesfx = false;
    
                    }
    
                    if(playerdata.CurrentSFXVolume<-35.0f){
    
                    playerdata.CurrentSFXVolume = -35.0f;
                    label20070[6].setIcon(size20070[11]);
                    playerdata.lowvolumesfx = true;

                    } 

                System.out.println("Current Volume: " + playerdata.CurrentSFXVolume);

                }
            
            }

        } else if(e.getSource() == panel40050[2]){

                if(playerdata.currentmutesfx){

                    playerdata.currentmutesfx = false;
                    System.out.println("Curremt  Mute OFF");

                    if(playerdata.fullvolumesfx == true){

                        label20070[6].setIcon(size20070[9]);

                    } else if (playerdata.lowvolumesfx == true){

                        label20070[5].setIcon(size20070[6]);

                    } else {

                        label20070[6].setIcon(size20070[9]);
                        label20070[5].setIcon(size20070[6]);

                    }

                    label40050[2].setIcon(size40050[3]);

                    playerdata.CurrentSFXVolume = playerdata.LastSFXVolume;

                } else {

                    playerdata.LastSFXVolume = playerdata.CurrentSFXVolume;
                    playerdata.currentmutesfx = true;
                    playerdata.CurrentSFXVolume = -80.0f;
                    System.out.println("Curremt  Mute SFX ON");
                    label40050[2].setIcon(size40050[1]);
                    label20070[5].setIcon(size20070[8]);
                    label20070[6].setIcon(size20070[11]);

                }


        } else if(e.getSource() == creditspanel){

            label900700.setIcon(tutorialncredit[7]);
            panel15050.setVisible(true);
            panel15050.setBounds(50,50,150,50);

            for(int y = 0; y<=4;){

                panel40050[2].setVisible(false);
                panel20070[5].setVisible(false);
                panel20070[6].setVisible(false);
                creditspanel.setVisible(false);
                tutorialpanel.setVisible(false);

                if(y == 0){

                    panel40050[y].setVisible(false);
                    y++;
                    continue;

                } else {

                    if(1 == y){

                        y+=2;


                    }

                    panel20070[y].setVisible(false);
                    y++;
                    continue;

                }

            }

            

        } else if (e.getSource() == tutorialpanel){

            label900700.setIcon(tutorialncredit[0]);
            panel15050.setVisible(true);
            nextpanel.setVisible(true);
            panel15050.setBounds(50,30,150,50);
            tutorialpage = 1;

            for(int y = 0; y<=4;){

                panel40050[2].setVisible(false);
                panel20070[5].setVisible(false);
                panel20070[6].setVisible(false);
                creditspanel.setVisible(false);
                tutorialpanel.setVisible(false);

                if(y == 0){

                    panel40050[y].setVisible(false);
                    y++;
                    continue;

                } else {

                    if(1 == y){

                        y+=2;


                    }

                    panel20070[y].setVisible(false);
                    y++;
                    continue;

                }

            }

            
        }

        System.out.println("shut");

        for(int x = 0; x<9; x++){

            if(x<1){

                if(e.getSource() == panel40050[x]){

                    if(playerdata.currentmute){

                        volumeControl.setValue(playerdata.LastVolume);
                        playerdata.currentmute = false;
                        System.out.println("Curremt  Mute OFF");

                        if(playerdata.fullvolume == true){

                            label20070[4].setIcon(size20070[9]);

                        } else if (playerdata.lowvolume == true){

                            label20070[3].setIcon(size20070[6]);

                        } else {

                            label20070[4].setIcon(size20070[9]);
                            label20070[3].setIcon(size20070[6]);

                        }

                        label40050[x].setIcon(size40050[3]);
                        break;

                    } else {

                        playerdata.LastVolume = playerdata.CurrentVolume;
                        volumeControl.setValue(-80.0f);
                        playerdata.currentmute = true;
                        System.out.println("Curremt  Mute ON");
                        label40050[x].setIcon(size40050[1]);
                        label20070[3].setIcon(size20070[8]);
                        label20070[4].setIcon(size20070[11]);
                        break;

                    }

                } else if(e.getSource() == panel15050){

                    switch(currentscene){

                        //settingsback
                        case 1:
                        
                            for(int y = 0; y<=4;){

                                panel40050[2].setVisible(false);
                                panel20070[5].setVisible(false);
                                panel20070[6].setVisible(false);
    
                                if(y == 0){
    
                                    panel40050[y].setVisible(false);
                                    y++;
                                    continue;
    
                                } else {
    
                                    if(1 == y){
    
                                        y+=2;
    
    
                                    }
    
                                    panel20070[y].setVisible(false);
                                    y++;
                                    continue;
    
                                }
    
                            }
                        

                        for(int y = 0; y<3; y++){

                            panel20070[y].setVisible(true);

                        }

                        nextpanel.setVisible(false);
                        tutorialpage = 0;

                        currentscene = 1;
                        label900700.setIcon(size900700[currentmenu]);
                        panel15050.setVisible(false);
                        panel15050.setBounds(50,100,150,50);

                        creditspanel.setVisible(false);
                        tutorialpanel.setVisible(false);
                        break;
                        
                        
                        //difficultback
                        case 2:
                        for(int y = 0; y<5; y++){

                            panel30070[y].setVisible(false);

                        }

                        for(int y = 0; y<3; y++){

                            panel20070[y].setVisible(true);

                        }

                        currentscene = 1;
                        panel15050.setVisible(false);
                        label900700.setIcon(size900700[currentmenu]);
                        break;

                        //endlessback
                        case 3:
                        for(int y = 0; y<9; y++){

                            panel30070[y].setVisible(true);

                            if(y>=5){

                                panel30070[y].setVisible(false);

                            }

                        }

                        label900700.setIcon(size900700[1]);
                        currentscene = 2;
                        break;

                    }
                    break;

                }

            }
            
            if(x<5){

                if(e.getSource() == panel20070[x]){

                    switch(x){

                        case 0:
                        for(int y = 0; y<5; y++){

                            if(y<3){

                                panel20070[y].setVisible(false);

                            }

                            panel15050.setVisible(true);
                            panel30070[y].setVisible(true);
                            currentscene = 2;

                        }

                        label900700.setIcon(size900700[1]);
                        break;

                        case 1:
                        for(int y = 0; y<=4; ){

                            if(y == 0){

                                panel20070[0].setVisible(false);
                                panel20070[1].setVisible(false);
                                panel20070[2].setVisible(false);

                                panel40050[y].setVisible(true);
                                panel40050[2].setVisible(true);
                                panel20070[5].setVisible(true);
                                panel20070[6].setVisible(true);

                                creditspanel.setVisible(true);
                                tutorialpanel.setVisible(true);

                                y++;
                                System.out.println(y);
                                continue;

                            } else {

                                if(1 == y){

                                    y+=2;


                                }

                                panel20070[y].setVisible(true);
                                y++;
                                continue;

                            }

                        }

                        label900700.setIcon(size900700[2]);
                        panel15050.setVisible(true);
                        currentscene = 1;
                        break;

                        case 2:
                        serialization();
                        System.exit(0);
                        break;

                        case 3:

                        if(playerdata.currentmute != true){

                            playerdata.CurrentVolume += 1.0f;
            
                            if(playerdata.lowvolume == true){
            
                            label20070[4].setIcon(size20070[9]);
                            playerdata.lowvolume = false;

                            } else if(playerdata.CurrentVolume>=3){
            
                            playerdata.CurrentVolume = 3;
                            label20070[3].setIcon(size20070[8]);
                            playerdata.fullvolume = true;
            
                            } 
            
                        volumeControl.setValue(playerdata.CurrentVolume);
                        System.out.println("Current Volume: " + playerdata.CurrentVolume);
                        }
                        break;

                        case 4:

                        if(playerdata.currentmute != true){

                            playerdata.CurrentVolume -= 1.0f;
            
                            if(playerdata.fullvolume == true){
            
                            label20070[3].setIcon(size20070[6]);
                            playerdata.fullvolume = false;
            
                            }
            
                            if(playerdata.CurrentVolume<-35.0f){
            
                            playerdata.CurrentVolume = -35.0f;
                            label20070[4].setIcon(size20070[11]);
                            playerdata.lowvolume = true;

                            } 
            
                        volumeControl.setValue(playerdata.CurrentVolume);
                        System.out.println("Current Volume: " + playerdata.CurrentVolume);
            
                        }

                        break;

                    }

                    break;

                }

                

            } 

            if(e.getSource() == panel30070[x]){

                switch(x){

                    case 0:
                    easyArena();
                    break;

                    case 1:
                    mediumArena();
                    break;

                    case 2:
                    hardArena();
                    break;

                    case 3:
                    if(playerdata.isAlldifficultcomp() == 1){

                        nightmareArena();

                    }
                    break;

                    case 4:

                    for(int y = 5; y<=8; y++){

                        panel30070[y].setVisible(true);

                    }

                    for(int y = 0; y<5; y++){

                        panel30070[y].setVisible(false);
                        currentscene = 2;

                    }

                    panel15050.setVisible(true);
                    label900700.setIcon(size900700[3]);
                    currentscene = 3;

                    break;

                    case 5:
                    if(playerdata.isEasyendless() == 1){

                        endlessmode = true;
                        easyArena();

                    }
                    break;
                    
                    case 6:
                    if(playerdata.isMediumendless() == 1){

                        endlessmode = true;
                        mediumArena();

                    }

                    break;

                    case 7:
                    if(playerdata.isHardendless() == 1){

                        endlessmode = true;
                        hardArena();

                    }

                    break;

                    case 8:
                    if(playerdata.isNightmareendless() == 1){

                        endlessmode = true;
                        nightmareArena();

                    }
                    break;

                }

                break;

            }

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        System.out.println("entered");

        if(e.getSource() == nextpanel){

            next.setIcon(nextpic[1]);

        } else if(e.getSource() == panel20070[5]){

            if(playerdata.currentmutesfx || playerdata.fullvolumesfx){


            } else {

                label20070[5].setIcon(size20070[7]);


            }


        } else if(e.getSource() == panel20070[6]){

            if(playerdata.currentmutesfx || playerdata.lowvolumesfx){


            } else {

                label20070[6].setIcon(size20070[10]);

            }

        } else if (e.getSource() == panel40050[2]){

            if(playerdata.currentmutesfx){

                label40050[2].setIcon(size40050[1]);

            } else {

                label40050[2].setIcon(size40050[3]);

            }

        } else if(e.getSource() == creditspanel){

            credits.setIcon(creditandtutorialpic[1]);

        } else if(e.getSource() == tutorialpanel){

            tutorial.setIcon(creditandtutorialpic[3]);

        }

        for(int x = 0; x<9; x++){

            if(x<1){

                if(e.getSource() == panel40050[x]){

                    if(playerdata.currentmute){

                        label40050[x].setIcon(size40050[1]);
                        break;


                    } else {

                        label40050[x].setIcon(size40050[3]);
                        break;

                    }

                } else if(e.getSource() == panel15050){

                    label15050.setIcon(size15050[1]);
                    break;

                }


            }
            
            if(x<5){

                //200 70

                if(e.getSource() == panel20070[x]){

                    if(playerdata.currentmute && (x == 3 || x == 4)){

                        break;

                    }

                    if(x == 3 && playerdata.fullvolume || x == 4 && playerdata.lowvolume){

                        break;


                    }

                    label20070[x].setIcon(size20070[hover20070[x]]);
                    break;

                }

                

            }

            if(e.getSource() == panel30070[x]){

                if(playerdata.isAlldifficultcomp() != 1 && x == 3){

                    continue;

                } 

                if(x>=5){

                    switch(x){

                        case 5:
                        if(playerdata.isEasyendless() != 1){

                            continue;

                        } else {

                            label30070[x].setIcon(size30070[hover30070[x-5]]);
                            
                            continue;

                        }
                        

                        case 6:
                        if(playerdata.isMediumendless() != 1){

                            continue;

                        } else {

                            label30070[x].setIcon(size30070[hover30070[x-5]]);
                            
                            continue;

                        }


                        case 7:
                        if(playerdata.isHardendless() != 1){

                            continue;

                        } else {

                            label30070[x].setIcon(size30070[hover30070[x-5]]);
                            
                            continue;

                        }

                        

                        case 8:
                        if(playerdata.isNightmareendless() != 1){

                            continue;

                        } else {

                            label30070[x].setIcon(size30070[hover30070[x-5]]);
                            continue;

                        }

                        

                    }


                }

                label30070[x].setIcon(size30070[hover30070[x]]);
                break;

            }

        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

       if(e.getSource() == nextpanel){

            next.setIcon(nextpic[0]);

        } else if(e.getSource() == panel20070[5]){

            if(playerdata.currentmutesfx || playerdata.fullvolumesfx){


            } else {

                label20070[5].setIcon(size20070[6]);


            }

        } else if(e.getSource() == panel20070[6]){

            if(playerdata.currentmutesfx || playerdata.lowvolumesfx){


            } else {

                label20070[6].setIcon(size20070[9]);

            }

        } else if (e.getSource() == panel40050[2]){

            if(playerdata.currentmutesfx){

                label40050[2].setIcon(size40050[0]);

            } else {

                label40050[2].setIcon(size40050[2]);


            }

        } else if(e.getSource() == creditspanel){

            credits.setIcon(creditandtutorialpic[0]);

        } else if(e.getSource() == tutorialpanel){

            tutorial.setIcon(creditandtutorialpic[2]);


        }

        for(int x = 0; x<9; x++){

            if(x<1){

                if(e.getSource() == panel40050[x]){

                    if(playerdata.currentmute){

                        label40050[x].setIcon(size40050[0]);
                        break;


                    } else {

                        label40050[x].setIcon(size40050[2]);
                        break;

                    }

                } else if(e.getSource() == panel15050){

                    label15050.setIcon(size15050[0]);
                    break;

                }


            }
            
            if(x<5){

                //200 70

                if(e.getSource() == panel20070[x]){

                    if(playerdata.currentmute && (x == 3 || x == 4)){

                        break;

                    }

                    if(x == 3 && playerdata.fullvolume || x == 4 && playerdata.lowvolume){

                        break;


                    }

                    label20070[x].setIcon(size20070[buttons[x]]);
                    break;

                }

                

            } 

            if(e.getSource() == panel30070[x]){

                if(playerdata.isAlldifficultcomp() != 1 && x == 3){

                    continue;

                }

                if(x>=5){

                    switch(x){

                        case 5:

                        if(playerdata.isEasyendless() != 1){

                            continue;

                        } else {

                            System.out.println("i was here");

                            label30070[x].setIcon(size30070[buttons2[x-5]]);
                            continue;

                        }

                        case 6:
                        if(playerdata.isMediumendless() != 1){

                            continue;

                        } else {

                            label30070[x].setIcon(size30070[buttons2[x-5]]);
                            continue;

                        }

                        case 7:
                        if(playerdata.isHardendless() != 1){

                            continue;

                        } else {

                            label30070[x].setIcon(size30070[buttons2[x-5]]);
                            continue;

                        }

                        case 8:
                        if(playerdata.isNightmareendless() != 1){

                            continue;

                        } else {

                            label30070[x].setIcon(size30070[buttons2[x-5]]);
                            continue;

                        }

                    }

                }

                label30070[x].setIcon(size30070[buttons2[x]]);
                break;

            }

        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {

        if(currentingame && !(move.disablemovement)){

            if(e.getKeyChar() == 'w' || e.getKeyChar() == 'a' || e.getKeyChar() == 's' || e.getKeyChar() == 'd'){

                System.out.println("Key type: " + e.getKeyChar());

                Arenaverdict(e.getKeyChar());

            }

        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(currentingame && e.getKeyCode() == 27){

            System.out.println(countings++);

        } else if(!(currentingame) && e.getKeyCode() == 27){

            System.out.println(countingreset++);

        }

        if(countings == 50){

            if(endlessmode){

                endlessmodemovement.setVisible(false);
                endlessmodescore.setVisible(false);
                playerpos.setVisible(false);
                clipmenu.setFramePosition(0);

                secondboot = true;
                endlessmode = false;
                jumpscareagain = false;
                issecondmove = false;
                currentingame = false;
                endlesscounting = 0;
                enemysound = 10;

            } else {

                panel40050[1].setVisible(false);
                playerpos.setVisible(false);
                clipmenu.setFramePosition(0);
                secondboot = true;
                jumpscareagain = false;
                issecondmove = false;
                currentingame = false;
                enemysound = 10;
        
            }

            switch(enemysoundgo){

                case 1:
                leftside1clip.stop();
                leftside1clip.setFramePosition(0);
                break;

                case 2:
                leftside2clip.stop();
                leftside2clip.setFramePosition(0);
                break;

                case 3:
                leftside3clip.stop();
                leftside3clip.setFramePosition(0);
                break;

                case 4:
                rightside1clip.stop();
                rightside1clip.setFramePosition(0);
                break;

                case 5:
                rightside2clip.stop();
                rightside2clip.setFramePosition(0);
                break;

                case 6:
                rightside3clip.stop();
                rightside3clip.setFramePosition(0);
                break;

                case 7:
                frontback1clip.stop();
                frontback1clip.setFramePosition(0);
                break;

                case 8:
                frontback2clip.stop();
                frontback2clip.setFramePosition(0);
                break;

                case 9:
                frontback3clip.stop();
                frontback3clip.setFramePosition(0);
                break;

                case 10:

                break;

            }

            move.easygame = move.mediumgame = move.hardgame = move.nightmaregame = false;
            countings = 0;

            try {

                frames();

            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {

                e1.printStackTrace();
            }

        } else if(countingreset == 100){

            playerdata.setEasyendless(0);
            playerdata.setMediumendless(0);
            playerdata.setHardendless(0);
            playerdata.setNightmareendless(0);
            playerdata.setAlldifficultcomp(0);
            playerdata.setAll50complete(0);
            playerdata.seteasy50(0);
            playerdata.setmedium50(0);
            playerdata.sethard50(0);
            playerdata.setnightmare50(0);
            playerdata.seteasyscore(0);
            playerdata.setmediumscore(0);
            playerdata.sethardscore(0);
            playerdata.setnightmarescore(0);
            playerdata.currentmute = playerdata.fullvolume = playerdata.lowvolume = false;
            playerdata.currentmutesfx = playerdata.fullvolumesfx = playerdata.lowvolumesfx = false;
            playerdata.CurrentVolume = -10.0f;
            playerdata.LastVolume = 0;
            playerdata.CurrentSFXVolume = -10.0f;
            playerdata.LastSFXVolume = 0;

            serialization();
            System.exit(0);

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        countings = 0;
        countingreset = 0;
        
    }

}
