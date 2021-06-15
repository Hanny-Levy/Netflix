public class Episodes  {
    private Episode[] episodes ;

    public Episodes() {
        this.episodes = new Episode[0];
    }
    public void setEpisodes(Episode[] episodes) {
        this.episodes = episodes;
    }

    public void addEpisode(Episode episode){
        Episode[] newArray = new Episode[this.episodes.length + 1];
        for (int i = 0; i < this.episodes.length; i++) {
            newArray[i] = this.episodes[i];
        }
        newArray[this.episodes.length] = episode;
        this.episodes = newArray;
    }

    public Episode[] getEpisodes() {
        return episodes;
    }



}

