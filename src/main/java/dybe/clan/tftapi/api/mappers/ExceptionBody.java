package dybe.clan.tftapi.api.mappers;

public class ExceptionBody {
    public String name;

    public String description;

    public ExceptionBody(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}
