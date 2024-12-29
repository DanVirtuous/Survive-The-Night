package finale;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public  class Movements{

    boolean easygame = false, mediumgame = false, hardgame = false, nightmaregame = false;

    Movements() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        System.out.println("Ready");
        
    }

    int enemylocation;
    int playerlocation;
    int numberofmovements;
    boolean currentcenter = false, currentcorner = false, currentside = false;
    int lastpositionmove = -1;
    boolean disablemovement = false;

    //easy attributes

    int[] sideleft = {0};
    int[] sideright = {0};
    int[] sideup = {0};
    int[] sidedown = {0};
    int[] center = {0};
    int[] corner = {0};

    int[] xpos = {0};
    int[] ypos = {0};

    int vertical = 0;

    int numberoftiles = 0;
    int currentarray = 0;

    public void xypositionsetup(){

        if(easygame){

            sideleft = new int[] {5,10,15};
            sideright = new int[] {9,14,19};
            sideup = new int[] {1,2,3};
            sidedown = new int[] {21,22,23};
            center = new int[] {6,7,8,11,12,13,16,17,18};
            corner = new int[] {0,4,20,24};

            xpos = new int[] {203,310,425,535,645};
            ypos = new int[] {125,238,348,458,568};

            vertical = 5;

        } else if (mediumgame || hardgame){

            sideleft = new int[] {4,8};
            sideright = new int[] {7,11};
            sideup = new int[] {1,2};
            sidedown = new int[] {13,14};
            center = new int[] {5,6,9,10};
            corner = new int[] {0,3,12,15};

            xpos = new int[] {220,360,500,635};
            ypos = new int[] {140,280,420,555};

            vertical = 4;

        } else if(nightmaregame){

            sideleft = new int[] {3};
            sideright = new int[] {5};
            sideup = new int[] {1};
            sidedown = new int[] {7};
            center = new int[] {4};
            corner = new int[] {0,2,6,8};

            xpos = new int[] {242,432,612};
            ypos = new int[] {160,350,530};

            vertical = 3;

        }

    }


    public void setPlayerLocation(int x){

        this.playerlocation = x;


    }

    public void setEnemyLocation(int x){

        this.enemylocation = x;


    }
    
    //player
    public int centermovement(char type, int position){

        System.out.println("before movement: " + position);

        switch(type){

            case 'w':
            System.out.println("after movement: " + (position-vertical));
            return position-vertical;

            case 'a':
            System.out.println("after movement: " + (position-1));
            return position-1;

            case 's':
            System.out.println("after movement: " + (position+vertical));
            return position+vertical;

            case 'd':
            System.out.println("after movement: " + (position+1));
            return position+1;

        }

        

        return -1;

    }

    //enemy
    public int centermovement(int type, int position){

        System.out.println("Enemy before movement: " + position);

        switch(type){

            case 1:
            System.out.println("Enemy after movement: " + (position-vertical));
            return position-vertical;

            case 2:
            System.out.println("Enemy after movement: " + (position-1));
            return position-1;

            case 3:
            System.out.println("Enemy after movement: " + (position+vertical));
            return position+vertical;

            case 4:
            System.out.println("Enemy after movement: " + (position+1));
            return position+1;

        }

        return -1;

    }

    //player
    public int sidemovement(char type, int currentside, int position){

        System.out.println("before movement: " + position);

        switch(currentside){

            case 1:

                switch(type){

                    case 'w':

                    System.out.println("after movement: " + (position-vertical));
                        return position-vertical; 
                        
                    case 's':

                    System.out.println("after movement: " + (position+vertical));
                        return position+vertical; 
                        
                        
                    case 'd':

                    System.out.println("after movement: " + (position+1));
                        return position+1; 
                        
                        
                }
            
            break;

            case 2:

                switch(type){

                    case 'w':

                    System.out.println("after movement: " + (position-vertical));
                        return position-vertical; 
                        
                        

                    case 's':

                    System.out.println("after movement: " + (position+vertical));
                        return position+vertical;
                        
                        
                    case 'a':

                    System.out.println("after movement: " + (position-1));
                        return position-1;
                        
                        
                }

            break;

            case 3:

                switch(type){

                    case 'a':

                    System.out.println("after movement: " + (position-1));
                        return position-1;

                    case 's':

                    System.out.println("after movement: " + (position+vertical));
                        return position+vertical;
                        
                    case 'd':

                    System.out.println("after movement: " + (position+1));
                        return position+1;
                        
                }

            break;

            case 4:

                switch(type){

                    case 'w':

                    System.out.println("after movement: " + (position-vertical));
                        return position-vertical;

                    case 'a':

                    System.out.println("after movement: " + (position-1));
                        return position-1;
                        
                        
                    case 'd':

                    System.out.println("after movement: " + (position+1));
                        return position+1;
                        
                        
                }

            break;

        }

        System.out.println("after movement: " + position);

        return -1;

    }

    //enemy 
    public int sidemovement(int type, int currentside, int position){

        System.out.println("Enemy before movement: " + position);

        switch(currentside){

            case 1:

                switch(type){

                    case 1:

                    System.out.println("Enemy after movement: " + (position-vertical));
                        return position-vertical; 
                        
                    case 2:

                    System.out.println("Enemy after movement: " + (position+vertical));
                        return position+vertical; 
                        
                        
                    case 3:

                    System.out.println("Enemy after movement: " + (position+1));
                        return position+1; 
                        
                        
                }
            
            break;

            case 2:

                switch(type){

                    case 1:

                    System.out.println("Enemy after movement: " + (position-vertical));
                        return position-vertical; 
                        
                        

                    case 2:

                    System.out.println("Enemy after movement: " + (position+vertical));
                        return position+vertical;
                        
                        
                    case 3:

                    System.out.println("Enemy after movement: " + (position-1));
                        return position-1;
                        
                        
                }

            break;

            case 3:

                switch(type){

                    case 1:

                    System.out.println("Enemy after movement: " + (position-1));
                        return position-1;

                    case 2:

                    System.out.println("Enemy after movement: " + (position+vertical));
                        return position+vertical;
                        
                    case 3:

                    System.out.println("Enemy after movement: " + (position+1));
                        return position+1;
                        
                }

            break;

            case 4:

                switch(type){

                    case 1:

                    System.out.println("Enemy after movement: " + (position-vertical));
                        return position-vertical;
                        
                        

                    case 2:

                    System.out.println("Enemy after movement: " + (position-1));
                        return position-1;
                        
                        
                    case 3:

                    System.out.println("Enemy after movement: " + (position+1));
                        return position+1;
                        
                        
                }

            break;

        }

        System.out.println("Enemy after movement: " + position);

        return -1;

    }

    //player
    public int cornermovement(char type, int currentcorner, int position){

        System.out.println("before movement: " + position);

        int result;

        switch(currentcorner){

            case 1:

                result = (type == 's') ? position+vertical : position+1;

                if(type == 'w' || type == 'a'){

                    System.out.println("after movement: " + result);

                    return position;

                }

                System.out.println("after movement: " + result);
                return result;

            case 2:

                result = (type == 'a') ? position-1 : position+vertical;

                if(type == 'w' || type == 'd'){

                    System.out.println("after movement: " + result);

                    return position;

                }

                System.out.println("after movement: " + result);
                return result;

            
            case 3:

                result = (type == 'w') ? position-vertical : position+1;

                if(type == 'a' || type == 's'){

                    System.out.println("after movement: " + result);

                    return position;

                }

                System.out.println("after movement: " + result);
                return result;

            case 4:

                result = (type == 'w') ? position-vertical : position-1;

                if(type == 's' || type == 'd'){

                    System.out.println("after movement: " + result);

                    return position;

                }

                System.out.println("after movement: " + result);
                return result;

        }

        System.out.println("after movement: " + position);

        return -1;


    }

    //enemy
    public int cornermovement(int type, int currentcorner, int position){

        System.out.println("Enemy before movement: " + position);

        int result;

        switch(currentcorner){

            case 1:

                result = (type == 1) ? position+vertical : position+1;

                System.out.println("Enemy after movement: " + result);
                return result;

            case 2:

                result = (type == 1) ? position-1 : position+vertical;

                System.out.println("Enemy after movement: " + result);
                return result;

            
            case 3:

                result = (type == 1) ? position-vertical : position+1;

                System.out.println("Enemy after movement: " + result);
                return result;

            case 4:

                result = (type == 1) ? position-vertical : position-1;

                System.out.println("Enemy after movement: " + result);
                return result;

        }

        System.out.println("Enemy after movement: " + position);

        return -1;


    }

    

}
