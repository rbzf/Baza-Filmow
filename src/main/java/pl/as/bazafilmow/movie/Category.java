package pl.as.bazafilmow.movie;

public enum Category {
    COMEDY("komedia"),
    THRILLER("thriller"),
    DRAMA("dramat"),
    DOCUMENTARY("dokument"),
    HORROR("horror");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
