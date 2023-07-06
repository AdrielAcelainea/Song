package sg.edu.rp.c346.id22016845.song;

public class Song {
    private int _id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(int id,String title,String singers,int year,int stars){
        this._id=id;
        this.title=title;
        this.singers=singers;
        this.year=year;
        this.stars=stars;
    }
    public int get_id(){return _id;}
    public String getTitle(){return title;}
    public String getSingers(){return singers;}
    public int getYear(){return year;}
    public int getStars(){return stars;}
}
