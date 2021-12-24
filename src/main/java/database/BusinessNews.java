package database;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "businessnews")
public class BusinessNews {
    @Id
    @Column(name = "newsID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int newsID;

    @Column(name = "heading", nullable = false)
    private String heading;

    @Column(name = "text", nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "authorId")
    User author;

    public BusinessNews(){}
    public BusinessNews(String heading, String text, User author) {
        this.heading = heading;
        this.text = text;
        this.author = author;
    }

    @Override
    public String toString() {
        return "NEWS ID: " + this.newsID + ", HEADING: " + this.heading;
    }
}
