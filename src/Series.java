public class Series {
    private TvSeries [] series ;

    public Series() {
        this.series = new TvSeries[0];
    }

    public TvSeries[] getSeries() {
        return series;
    }

   public void setSeries(TvSeries[] series) {
        this.series = series;
    }

    public void addSeries(TvSeries tvSeries){
        TvSeries [] newArray = new TvSeries[this.series.length + 1];
        for (int i = 0; i < this.series.length; i++) {
            newArray[i] = this.series[i];
        }
        newArray[this.series.length] = tvSeries;
        this.series = newArray;
    }

    public void print(){
        for (int i=0 ; i<this.series.length;i++){
            int episodeNum=i+1;
            System.out.print(episodeNum +": "+this.getSeries()[i].getName()+'\n');

        }
    }


    }

