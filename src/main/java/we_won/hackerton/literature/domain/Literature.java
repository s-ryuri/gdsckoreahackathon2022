package we_won.hackerton.literature.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import we_won.hackerton.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.EnumType.STRING;

@Table
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Literature extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "literature_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = true)
    private String site_url;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String content; //내용

    @Column(nullable = false)
    @Enumerated(STRING)
    private Category category; //시 == 1, 소설 == 2, 수필 == 3

    public Literature(final Long id,
                      final String title,
                      final String writer,
                      final String site_url,
                      final String content,
                      final Category category) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.site_url = site_url;
        this.content = content;
        this.category = category;
    }

    public enum Category {
        POETRY("poetry"),
        ESSAY("ESSAY"),
        LITERARY("LITERARY");

        private String name;

        Category(final String name) {
            this.name = name;
        }
    }
}
