import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Main netflix = new Main();
        User user= new User();
        boolean exit=false;
        while (!exit){
        try {
            netflix.menu();
            int choice = scanner.nextInt();
            switch (choice) {
                case Definitions.OPEN_ACCOUNT: {
                    System.out.println("Choose username and password : " + '\n' + "**PASSWORD Must contain at least 6 characters including one letter and one number** "+'\n');
                    user = new User(netflix.getExistingUsers());
                    netflix.existingUsers.addUser(user);
                    System.out.println("Signed up successfully !");
                }break;
                case Definitions.LOGIN_ACCOUNT: {
                    try {
                        netflix.existingUsers.loggIn();
                        netflix.userMenu(user);

                    } catch (InputMismatchException e) {
                        netflix.userMenu(user);
                    }break;

                }
                case Definitions.EXIT:
                    exit=true;
                    break;
                default:
                    netflix.menu();
                    break;
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input ! try again");
            scanner.nextLine();
        }

        }



    }





    private Series netflixSeries;
    private ExistingUsers existingUsers;
    Scanner intInput=new Scanner(System.in);
    Scanner stringInput=new Scanner(System.in);
    public Main(){
       netflixSeries=new Series();
       setNetflixSeries();
       existingUsers=new ExistingUsers();


    }

    public void setTvShow1(){
        TvSeries lucifer= new TvSeries("Lucifer","Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals."+'\n'
                +"But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",new Date(25,1,2016),"Crime, Fantasy, Sci-Fi");Episode luciEpisode1= new Episode("Pilot","Upon leaving hell, Lucifer Morningstar retreats to Los Angeles for a more exciting life. When the murder of a friend connects him with LAPD detective Chloe Decker, Lucifer becomes intrigued with the idea of punishing criminals, sending the devil himself into a struggle between good and evil.",new Date(25,1,2016));
        Episode luciEpisode2=new Episode("Lucifer, Stay. Good Devil.","When a movie star's son is killed after being chased by the paparazzi, Chloe takes a deep look into the case with a little help from Lucifer."+'\n'
                + "Meanwhile, Maze and Amenadiel continue to encourage Lucifer to go back to hell.",new Date(1,2,2016));
        Episode luciEpisode3=new Episode("The Would-Be Prince of Darkness","When a 22-year-old future superstar quarterback wakes up to find a dead girl floating in his swimming pool, he turns to his friend, Lucifer, for help." +'\n'
                +"Lucifer enlists Chloe to investigate the case, which leads to the world of big money sports and people who will literally kill to be number one.",new Date(8,02,2016));
        Season luciferSeason1= new Season();
        luciferSeason1.addEpisode(luciEpisode1);
        luciferSeason1.addEpisode(luciEpisode2);
        luciferSeason1.addEpisode(luciEpisode3);
        lucifer.addSeason(luciferSeason1);
        this.netflixSeries.addSeries(lucifer);
    }

    public void setTvShow2(){
        TvSeries the100 = new TvSeries("The 100","Based on the books by Kass Morgan, this show takes place 100 years in the future, when the Earth has been abandoned due to radioactivity." +'\n'
                +"The last surviving humans live on an ark orbiting the planet — but the ark won't last forever." +'\n'
                +"So the repressive regime picks 100 expendable juvenile delinquents to send down to Earth to see if the planet is still habitable.",new Date(19,3,2014),"Drama, Fantasy, Sci-Fi");Episode the100Episode1= new Episode("Pilot","97 years after a nuclear war, human kind is living in space. 100 juvenile delinquents are sent down to Earth to see if the planet is habitable.",new Date(19,3,2014));
        Episode the100Episode2= new Episode("Earth Skills","Discovering that Jasper may still be alive, Clarke, Bellamy, Finn, Wells and Murphy head out to find him."+'\n'
                + "On the Ark, Abby is determined to prove Earth is habitable, and enlists a mechanic to craft an escape pod.", new Date(26,3,2014));
        Episode the100Episode3= new Episode("Earth Kills","As a dangerous, acidic fog approaches, Clarke, Finn and Wells set out in search of a seaweed-like plant to make an antibiotic poultice for Jasper's wounds, while a vulnerable young girl follows when Bellamy takes a group out hunting for food.", new Date(2,4,2014));
        Season the100Season1= new Season();
        the100Season1.addEpisode(the100Episode1);
        the100Season1.addEpisode(the100Episode2);
        the100Season1.addEpisode(the100Episode3);
        the100.addSeason(the100Season1);
        this.netflixSeries.addSeries(the100);
    }

    public void setTvShow3(){
        TvSeries prisonBreak= new TvSeries("Prison Break","Due to a political conspiracy, an innocent man is sent to death row and his only hope is his brother," +'\n'
                +"who makes it his mission to deliberately get himself sent to the same prison in order to break the both of them out, from the inside out.",new Date(29,8,2005),"Action, Adventure, Crime, Drama");
        Episode prisonEpisode1= new Episode("Pilot","Michael Scofield, a structural engineer, attempts to rob a bank in order to get incarcerated at Fox River State Penitentiary, where his brother Lincoln Burrows, accused of murdering the Vice President's brother, is scheduled to be executed."+'\n'
                + "At Fox River, Michael approaches a number of inmates, all of whom play an important role in his plan to free his brother from the inside. Meanwhile, agents Kellerman and Hale are determined to make sure the execution goes through as planned." +'\n'
                +"Lincoln's son LJ gets into trouble.",new Date(29,8,2005));
        Episode prisonEpisode2= new Episode("Allen","Michael seeks help of his fellow prison inhabitants to execute his escape plans.",new Date(29,8,2005));
        Episode prisonEpisode3=new Episode("Cell Test","When Michael reveals his escape plan to Sucre, Sucre chooses to be no part of it," +'\n'
                + " and requests a cell transfer. Michael gets a new cellmate called Haywire.",new Date(5,9,2005));
        Season prisonSeason1=new Season();
        prisonSeason1.addEpisode(prisonEpisode1);
        prisonSeason1.addEpisode(prisonEpisode2);
        prisonSeason1.addEpisode(prisonEpisode3);
        prisonBreak.addSeason(prisonSeason1);
        this.netflixSeries.addSeries(prisonBreak);
    }

    public void setNetflixSeries() {
        setTvShow1();
        setTvShow2();
        setTvShow3();
    }

    public Series getNetflixSeries() {
        return this.netflixSeries;
    }

    public void menu(){
        System.out.println("Welcome to Netflix:");
        System.out.println("To open an account, press "+Definitions.OPEN_ACCOUNT+ '\n'+
                "To log in to an existing account, press "+Definitions.LOGIN_ACCOUNT);
        System.out.println("To exit Press "+Definitions.EXIT);

    }

    public ExistingUsers getExistingUsers() {
        return existingUsers;
    }

    public void setNetflixSeries(Series netflixSeries) {
        this.netflixSeries = netflixSeries;
    }

    public void setExistingUsers(ExistingUsers existingUsers) {
        this.existingUsers = existingUsers;
    }

    public void userMenu(User user){
        int choice;
        do {
            System.out.println("Press " + Definitions.VIEW_ALL_SERIES + " to view the list of all series.");
            System.out.println("Press " + Definitions.STARTED_TO_WATCH_SERIES + " to display the list of series you started watching");
            System.out.println("Press " + Definitions.VIEW_MEMBER + " to view subscription information");
            System.out.println("Press " + Definitions.CHOOSE_SERIES_TO_WATCH + " to select a series to watch");
            System.out.println("Press " + Definitions.LOG_OFF + " to log off");
            choice = intInput.nextInt();
            switch (choice) {
                case Definitions.VIEW_ALL_SERIES: {
                    System.out.println("Our series:");
                    this.netflixSeries.print();
                }
                break;
                case Definitions.STARTED_TO_WATCH_SERIES: {
                    System.out.println("Series started to watch:");
                    if (user.getUserSeries().getStartWatching().getSeries().length==0)
                        System.out.println("none");
                    for (int i = 0; i < user.getUserSeries().getStartWatching().getSeries().length; i++) {
                        System.out.println(user.getUserSeries().getStartWatching().getSeries()[i].getName());
                        int seriesIndex = this.searchSeries(user.getUserSeries().getStartWatching().getSeries()[i].getName());
                        System.out.println("Recently Watched Episode :");
                        user.getLastSeen(seriesIndex).printAll();
                    }
                }

                break;
                case Definitions.VIEW_MEMBER:
                    user.print();
                    break;
                case Definitions.CHOOSE_SERIES_TO_WATCH: {
                    System.out.println("Write the name of the series you would like to watch :");
                    String name = stringInput.nextLine();
                    if (this.searchSeries(name) == -1) {
                        System.out.println("The series " + name + " does not exist!");
                        this.menu();
                        break;
                    } else {
                        TvSeries tvSeries = this.netflixSeries.getSeries()[searchSeries(name)];
                        tvSeries.getSeasons().getSeasons()[0].print();
                        int num = intInput.nextInt();
                        Episode episode = user.chooseEpisode(tvSeries, num);
                        user.setLastSeenEpisode(this.searchSeries(name), episode);
                        System.out.println("Select an episode from the list by its number : "+'\n');
                    }
                }
                break;
                default: break;
            }
        }while (choice!=Definitions.LOG_OFF);

    }
    public int searchSeries(String name){
        for (int i=0 ; i<this.netflixSeries.getSeries().length; i++)
            if (this.netflixSeries.getSeries()[i].getName().equals(name))
                return i;

            return -1;
    }
}
