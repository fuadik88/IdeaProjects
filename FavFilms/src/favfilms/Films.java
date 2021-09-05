package favfilms;

import java.time.LocalDate;

public class Films {
    private final String title;
    private final String description;
    private final LocalDate releaseDate;

    public Films(String title, String description, LocalDate releaseDate){
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
}
