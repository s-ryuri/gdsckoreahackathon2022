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

    @Column(name = "site_url")
    private String siteUrl;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String content;

    @Column(nullable = false)
    @Enumerated(STRING)
    private Category category;

    public Literature(final Long id,
                      final String title,
                      final String writer,
                      final String siteUrl,
                      final String content,
                      final Category category) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.siteUrl = siteUrl;
        this.content = content;
        this.category = category;
    }

}
