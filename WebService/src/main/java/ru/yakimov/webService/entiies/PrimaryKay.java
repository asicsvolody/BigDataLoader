package ru.yakimov.webService.entiies;

import javax.persistence.*;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

@Entity
@Table(name = "PRIMARY_KAY")
public class PrimaryKay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VERSION")
    private int version;

    @Column(name = "PRIMARY_KAY")
    private String primaryKay;

    @Column(name = "COLUMN_TYPE")
    private String type;

    @ManyToOne
    @JoinColumn(name = "TABLE_ID")
    private DBTable DBTable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getPrimaryKay() {
        return primaryKay;
    }

    public void setPrimaryKay(String primaryKay) {
        this.primaryKay = primaryKay;
    }

    public DBTable getDBTable() {
        return DBTable;
    }

    public void setDBTable(DBTable DBTable) {
        this.DBTable = DBTable;
    }
}
