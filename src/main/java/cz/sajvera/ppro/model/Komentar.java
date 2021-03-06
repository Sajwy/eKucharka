package cz.sajvera.ppro.model;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Komentar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private int id;

    @Column(columnDefinition="TEXT")
    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datumPridani = new Date();

    private String autor;

    @ManyToOne
    private Recept recept;

    public Komentar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDatumPridani() {
        return datumPridani;
    }

    public String getDatumPridaniString() {
        SimpleDateFormat format = new SimpleDateFormat("dd. MM. yyyy HH:mm:ss");
        return format.format(this.datumPridani);
    }

    public void setDatumPridani(Date datumPridani) {
        this.datumPridani = datumPridani;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Recept getRecept() {
        return recept;
    }

    public void setRecept(Recept recept) {
        this.recept = recept;
        recept.getKomentare().add(0, this);
    }
}