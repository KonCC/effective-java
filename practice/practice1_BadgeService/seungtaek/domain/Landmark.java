package domain;

public class Landmark {

    private Long id; // PK
    private LandmarkType name;

    public Landmark(LandmarkType name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public LandmarkType getName() {
        return name;
    }
}
