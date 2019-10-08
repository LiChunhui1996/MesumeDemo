package lch.museum_second.domain;

public class Treasure {

    private Integer id;
    private String name;
    private String ownTime;
    private String findPlace;
    private String web;
    private String story;
    private String craft;
    private String study;

    @Override
    public String toString() {
        return "Treasure{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ownTime='" + ownTime + '\'' +
                ", findPlace='" + findPlace + '\'' +
                ", web='" + web + '\'' +
                ", story='" + story + '\'' +
                ", craft='" + craft + '\'' +
                ", study='" + study + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnTime() {
        return ownTime;
    }

    public void setOwnTime(String ownTime) {
        this.ownTime = ownTime;
    }

    public String getFindPlace() {
        return findPlace;
    }

    public void setFindPlace(String findPlace) {
        this.findPlace = findPlace;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }
}
