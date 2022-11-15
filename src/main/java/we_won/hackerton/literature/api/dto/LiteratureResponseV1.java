package we_won.hackerton.literature.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import we_won.hackerton.literature.application.dto.LiteratureResponse;
import we_won.hackerton.literature.domain.Category;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class LiteratureResponseV1 {

    private Long id;

    private String title;

    private String writer;

    private String siteUrl;

    private String content;

    private Category category;

    public LiteratureResponseV1(LiteratureResponse literatureResponse) {
        this.id = literatureResponse.getId();
        this.title = literatureResponse.getTitle();
        this.writer = literatureResponse.getWriter();
        this.siteUrl = literatureResponse.getSiteUrl();
        this.content = literatureResponse.getContent();
        this.category = literatureResponse.getCategory();
    }
}
