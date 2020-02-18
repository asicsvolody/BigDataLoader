package ru.yakimov.webService.entiies;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

@Entity
@Table(name = "TABLE_PRIMARY_KAY")
public class TablePrimaryKay implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VERSION")
    private int version;

    @Column(name = "TITLE_PRIMARY_KAY")
    private String titlePrimaryKay;

    @Column(name = "PRIMARY_KAY_TYPE")
    private String type;

    @ManyToOne
    @JoinColumn(name = "TABLE_CONF_ID", referencedColumnName = "id", nullable = false)
    private TableConf tableConf;

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

    public String getTitlePrimaryKay() {
        return titlePrimaryKay;
    }

    public void setTitlePrimaryKay(String titlePrimaryKay) {
        this.titlePrimaryKay = titlePrimaryKay;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TableConf getTableConf() {
        return tableConf;
    }

    public void setTableConf(TableConf tableConf) {
        this.tableConf = tableConf;
    }
}
