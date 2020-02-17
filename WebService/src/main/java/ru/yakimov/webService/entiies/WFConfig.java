package ru.yakimov.webService.entiies;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

@Entity
@Table(name = "WF_CONFIG")
public class WFConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VERSION")
    private int version;

    @OneToMany(mappedBy = "DIRECTORY_FROM", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DirectoryFrom> dirFrom;

    private String dirTo;

    @OneToMany(mappedBy = "PARTITION_COLUMN", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<PartitionColumn> partitions;

    @OneToOne(mappedBy = "PARTITION_COLUMN", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
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

    public List<DirectoryFrom> getDirFrom() {
        return dirFrom;
    }

    public void setDirFrom(List<DirectoryFrom> dirFrom) {
        this.dirFrom = dirFrom;
    }

    public String getDirTo() {
        return dirTo;
    }

    public void setDirTo(String dirTo) {
        this.dirTo = dirTo;
    }

    public List<PartitionColumn> getPartitions() {
        return partitions;
    }

    public void setPartitions(List<PartitionColumn> partitions) {
        this.partitions = partitions;
    }

    public ru.yakimov.webService.entiies.DBTable getDBTable() {
        return DBTable;
    }

    public void setDBTable(ru.yakimov.webService.entiies.DBTable DBTable) {
        this.DBTable = DBTable;
    }
}
