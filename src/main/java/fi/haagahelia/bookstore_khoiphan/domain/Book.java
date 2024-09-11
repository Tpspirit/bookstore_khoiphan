package fi.haagahelia.bookstore_khoiphan.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private int publicationYear;
    private long isbn;

    public Book(){

    }

    public Book(String author, String title, Long isbn, int publicationYear){
        super();
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
    }

    public Long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public int getPublicationYear(){
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear){
        this.publicationYear = publicationYear;
    }

    public long getIsbn(){
        return isbn;
    }

    public void setIsbn(long isbn){
        this.isbn = isbn;
    }

    @Override
    public String toString(){
        return "Book [id= " + id + ", author=" + author + ", title=" + title + ", isbn=" + isbn + ", year=" + publicationYear + "]";
    }

}
