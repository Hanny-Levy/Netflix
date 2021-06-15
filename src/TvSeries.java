public class TvSeries extends Episode {
    private String genre ;
    private Seasons seasons ;

    public TvSeries(String name, String summary, Date broadcastTime, String genre) {
        super(name, summary, broadcastTime);
        this.genre = genre;
        this.seasons = new Seasons();
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public Seasons getSeasons() {
        return seasons;
    }

    public void setSeasons(Seasons seasons) {
        this.seasons = seasons;
    }

    public void addSeason(Season season){
        this.seasons.addSeason(season);
    }
    public void print(){
        super.print();
        System.out.println("Genre: "+ this.genre);
        Season season = new Season();
        for (int i =0 ; i<this.seasons.getSeasons().length;i++){
            season = this.seasons.getSeasons()[i];
            int episodeNum=i+1;
            System.out.println("Season number: "+ episodeNum);
            season.print();
        }

    }

}
