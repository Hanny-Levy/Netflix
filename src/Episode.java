public class Episode {
    private String name ;
    private String summary ;
    private Date broadcastTime;

    public Episode(String name, String summary,Date broadcastTime) {
        this.name = name;
        this.summary = summary;
        this.broadcastTime=broadcastTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public void print(){
        System.out.println("Name: "+ this.name);
        System.out.println("Summary: "+'\n'+ this.summary);
    }

    public void printAll(){
        print();
        System.out.print("BroadcastTime : "); broadcastTime.print();
    }

    public void setBroadcastTime(Date broadcastTime) {
        this.broadcastTime = broadcastTime;
    }

    public Date getBroadcastTime() {
        return broadcastTime;
    }


}
