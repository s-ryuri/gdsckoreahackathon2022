package we_won.hackerton.literature.domain;

import we_won.hackerton.common.exception.NotFoundException;

public enum Category {
    POETRY("poetry"),
    ESSAY("essay"),
    LITERARY("literary");

    private String name;

    Category(final String name) {
        this.name = name;
    }

    public static Category get(String category) {
        try {
            return Category.valueOf(category);
        } catch (Exception e) {
            throw new NotFoundException("해당 category는 존재하지 않습니다.");
        }
    }

}
