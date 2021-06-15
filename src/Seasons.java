public class Seasons {
    private Season [] seasons ;
    public Seasons() {
        this.seasons = new Season[0];
    }

    public Season[] getSeasons() {
        return seasons;
    }
    public void setSeasons(Season[] seasons) {
        this.seasons = seasons;
    }

    public void addSeason(Season season){
        Season [] newArray = new Season[this.seasons.length + 1];
        for (int i = 0; i < this.seasons.length; i++) {
            newArray[i] = this.seasons[i];
        }
        newArray[this.seasons.length] = season;
        this.seasons = newArray;
    }

    public int size(){
       return this.getSeasons().length;
    }



}
