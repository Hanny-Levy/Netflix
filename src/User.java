import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class User {
    private Date openingDate ;
    private Date endingDate ;
    private String name;
    private String password;
    private UserSeries userSeries;
    Scanner scanner = new Scanner(System.in);
    Scanner intInput=new Scanner(System.in);
    private Episodes lastSeen;

    public User(){

    }

    public User(ExistingUsers existingUsers) {
        this.setName(existingUsers);
        this.setPassword();
        this.setOpeningDate();
        this.setEndingDate();
        existingUsers.addUser(this);

        this.userSeries=new UserSeries(this);
        this.lastSeen=new Episodes();
    }

    public void setPassword() {
        try {
            do {
                System.out.println("Password:");
                password = scanner.nextLine();
            }
            while (!strongPassword(password));
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Enter a PASSWORD! ");
            setPassword();
        }

    }

    private boolean strongPassword(String password) {
        int i=0; boolean letter=false , number=false;
        do {
            if (password.charAt(i)>47 && password.charAt(i)<58)
                number=true;
            if ((password.charAt(i)>64&&password.charAt(i)<91)||(password.charAt(i)>96&&password.charAt(i)<123))
                letter=true;

            if (password.charAt(i) ==32)//space
                return false;
            i++;
        }
        while (password.length() >= 6&& i<password.length());
        return letter&&number;
    }

    public void setName(ExistingUsers existingUsers) {
        try {
            System.out.println("Username :");
            name = scanner.nextLine();
            while (!checkUsername(name, existingUsers)) {
                name = scanner.nextLine();
            }
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Write a valid username!");
        }

    }
    private boolean checkUsername(String name,ExistingUsers existingUsers){
        if (name.isEmpty()) return false;
        if (existingUsers.searchUser(name)){
            System.out.println("This username already exists Try another username. ");
            return false;
        }  for (int i=0 ; i<name.length();i++)
            if (name.charAt(i)==32){
                System.out.println("Invalid username , try again");
                return false;
            }
            return true;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }






    private void setOpeningDate() {
        Scanner intInput= new Scanner(System.in);
            System.out.println("Write the current day here:");
            int day = intInput.nextInt();

            System.out.println("Write the current month here:");
            int month = intInput.nextInt();
            this.openingDate = new Date(day,month,Definitions.year);

        }




    private void setEndingDate() {
        this.endingDate = new Date(this.openingDate.getDay(),this.openingDate.getMonth(),Definitions.year+1);
        this.endingDate.setFullDate();
    }


    public Date getOpeningDate() {
        return openingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }



    public UserSeries getUserSeries() {
        return userSeries;
    }

    public void setUserSeries(UserSeries userSeries) {
        this.userSeries = userSeries;
    }

    public void print(){
        System.out.print("Account opening date: "); this.openingDate.print();
        System.out.println('\n'+"Date of termination of subscription: "); this.endingDate.print();
        this.userSeries.print();
    }

    public Episode chooseEpisode(TvSeries series , int episodeNumber) {
        while (episodeNumber-1>series.getSeasons().getSeasons()[0].getEpisodes().getEpisodes().length){
            System.out.println("No episode number for this series ! Try Again");
            episodeNumber = intInput.nextInt();
        }
        Episode episode = series.getSeasons().getSeasons()[0].getEpisodes().getEpisodes()[episodeNumber- 1];
        episode.print();
        this.userSeries.getWatchedEpisodes().addEpisode(episode);
        if (episodeNumber-1==series.getSeasons().getSeasons()[0].getEpisodes().getEpisodes().length-1){
            this.userSeries.addWatchedSeries(series);
        }
        else this.userSeries.addStartWatching(series,episode);
        return episode;
    }


    public void setLastSeenEpisode(int tvSeriesIndex , Episode seenEpisode ) {
        for (int i=0 ; i<=tvSeriesIndex;i++){
            this.lastSeen.addEpisode(new Episode(" "," ",new Date(0,0,0)));
        }
        this.lastSeen.getEpisodes()[tvSeriesIndex]=seenEpisode;
    }

    public Episode getLastSeen(int tvSeriesIndex) {
        return lastSeen.getEpisodes()[tvSeriesIndex];
    }
}