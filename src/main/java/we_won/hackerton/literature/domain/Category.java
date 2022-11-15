package we_won.hackerton.literature.domain;

public enum Category {
    POETRY("poetry"),
    ESSAY("ESSAY"),
    LITERARY("LITERARY");

    private String name;

    Category(final String name) {
        this.name = name;
    }
}
