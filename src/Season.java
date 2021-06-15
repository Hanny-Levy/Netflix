public class Season {
    private Episodes episodes ;

    public Season() {
        this.episodes = new Episodes();

    }

    public void setEpisodes(Episodes episodes) {
        this.episodes = episodes;
    }

    public Episodes getEpisodes() {
        return episodes;
    }

    public void addEpisode(Episode episode){
        this.episodes.addEpisode(episode);
    }

    public void print(){
        System.out.println("The Episodes in this season :");
        Episode episode=new Episode(null,null,new Date(0,0,0));
      for (int i=0 ; i<this.episodes.getEpisodes().length;i++){
          episode=this.episodes.getEpisodes()[i];
          int episodeNum=i+1;
          System.out.println("Episode number "+ episodeNum +":");
          episode.printAll();
          System.out.println();
      }

    }

}
