package we_won.hackerton.literature.application.dto;

import lombok.Builder;
import lombok.Getter;
import we_won.hackerton.literature.domain.Category;
import we_won.hackerton.literature.domain.Literature;

@Getter
public class LiteratureResponse {

    private final Long id;

    private final String title;

    private final String writer;

    private final String siteUrl;

    private final String content;

    private final Category category;

    @Builder
    public LiteratureResponse(final Literature literature) {
        this.id = literature.getId();
        this.title = literature.getTitle();
        this.writer = literature.getWriter();
        this.siteUrl = literature.getSiteUrl();
        this.content = literature.getContent();
        this.category = literature.getCategory();
    }

}
