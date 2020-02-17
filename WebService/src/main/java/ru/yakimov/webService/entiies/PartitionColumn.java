package ru.yakimov.webService.entiies;

import javax.persistence.*;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

@Entity
@Table(name = "PARTITION_COLUMN")
public class PartitionColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VERSION")
    private int version;

    @Column(name = "COLUMN_NAME")
    private String columnName;

    @Column(name = "COLUMN_TYPE")
    private String type;

    @ManyToOne
    @JoinColumn(name = "WF_CONFIG_ID")
    private  WFConfig wfConfig;

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

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public WFConfig getWfConfig() {
        return wfConfig;
    }

    public void setWfConfig(WFConfig wfConfig) {
        this.wfConfig = wfConfig;
    }
}
