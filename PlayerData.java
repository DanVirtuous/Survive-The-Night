package finale;
import java.io.Serializable;

public class PlayerData implements Serializable{

    private int easyendless = 1, mediumendless = 1, hardendless = 0, nightmareendless = 0, alldiffcomplete = 0, all50complete = 0;
    private int easy50 = 0, medium50 = 0, hard50 = 0, nightmare50 = 0;
    private int endlesseasyscore = 0, endlessmediumscore = 0, endlesshardscore = 0, endlessnightmarescore = 0;
    boolean currentmute = false, fullvolume = false, lowvolume = false;
    boolean currentmutesfx = false, fullvolumesfx = false, lowvolumesfx = false;
    float CurrentVolume = -10.0f;
    float LastVolume = 0;
    float CurrentSFXVolume = -10.0f;
    float LastSFXVolume = 0;

    public int isEasyendless(){

        return easyendless;

    }

    public int isMediumendless(){

        return mediumendless;
        
    }

    public int isHardendless(){

        return hardendless;
        
    }

    public int isNightmareendless(){

        return nightmareendless;
        
    }

    public int isAlldifficultcomp(){

        return alldiffcomplete;
        
    }

    public int isAll50complete(){

        return all50complete;
    }

    public int iseasy50(){

        return easy50;
    }

    public int ismedium50(){

        return medium50;
    }

    public int ishard50(){

        return hard50;
    }

    public int isnightmare50(){

        return nightmare50;
    }

    public int geteasyhighscore(){

        return endlesseasyscore;
    }

    public int getmediumhighscore(){

        return endlessmediumscore;
    }

    public int gethardhighscore(){

        return endlesshardscore;
    }

    public int getnightmarehighscore(){

        return endlessnightmarescore;
    }

    public void setEasyendless(int x){

        this.easyendless = x;


    }

    public void setMediumendless(int x){

        this.mediumendless = x;


    }

    public void setHardendless(int x){

        this.hardendless = x;


    }

    public void setNightmareendless(int x){

        this.nightmareendless = x;


    }

    public void setAlldifficultcomp(int x){

        this.alldiffcomplete = x;


    }

    public void setAll50complete(int x){

        this.all50complete = x;


    }

    public void seteasy50(int x){

        this.easy50 = x;


    }

    public void setmedium50(int x){

        this.medium50 = x;


    }

    public void sethard50(int x){

        this.hard50 = x;


    }

    public void setnightmare50(int x){

        this.nightmare50 = x;


    }

    public void seteasyscore(int x){

        this.endlesseasyscore = x;


    }

    public void setmediumscore(int x){

        this.endlessmediumscore = x;


    }

    public void sethardscore(int x){

        this.endlesshardscore = x;


    }

    public void setnightmarescore(int x){

        this.endlessnightmarescore = x;


    }

}
