import java.util.Scanner;

public class UserSeries {

    private Series watchedSeries ;
    private Series  startWatching ;
    private Episodes watchedEpisodes ;
    private User user;




    public UserSeries(User user) {
    this.watchedSeries=new Series();
    this.startWatching=new Series();
    this.watchedEpisodes=new Episodes();
    this.user=user;

    }



    public void addWatchedSeries(TvSeries watchedSeries) {
        this.watchedSeries.addSeries(watchedSeries);
    }

    public int sizeWatchedSeries(){
        return this.watchedSeries.getSeries().length;
    }
    public void addStartWatching(TvSeries startWatching,Episode episode) {
        this.startWatching.addSeries(startWatching);

    }



    public int sizeStartWatching(){
        return this.startWatching.getSeries().length;
   }

    public void addWatchedEpisodes(Episode watchedEpisode) {
        this.watchedEpisodes.addEpisode(watchedEpisode);
    }

    public int sizeWatchedEpisodes(){
        return this.watchedEpisodes.getEpisodes().length;
    }

    public Series getWatchedSeries() {
        return watchedSeries;
    }

    public Series getStartWatching() {
        return startWatching;
    }


    public Episodes getWatchedEpisodes() {
        return watchedEpisodes;

    }

    public void setUser(User user) {
        this.user = user;
    }


    public User getUser() {
        return user;
    }


    public void print(){
        System.out.println("The number of series you started watching so far: " + this.sizeStartWatching());
        System.out.println("The number of series you've seen so far: " + this.sizeWatchedSeries());
        System.out.println("The number of episodes you have seen so far: " + this.sizeWatchedEpisodes());
    }

    }




