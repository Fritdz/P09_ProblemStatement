package sg.edu.rp.c346.id20033454.p09_problemstatement;

import java.io.Serializable;

public class Song implements Serializable {

    private int id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(String title, String singers, int year, int stars) {
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }

    @Override
    public String toString() {
        String starString = "";
        if (stars==1){
            starString="*";
        }else if (stars==2){
            starString="**";
        }else if (stars==3){
            starString="***";
        }else if (stars==4){
            starString="****";
        }else if (stars==5){
            starString="*****";
        }
        String output = "";
        output += title + "\n" + singers + "-" + year + "\n" + starString;
        return output;
    }
}
