package ru.yakimov.webService.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.yakimov.webService.entiies.*;
import ru.yakimov.webService.utils.DateFormatter;

import java.text.ParseException;
import java.util.Locale;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkflowServiceTest {

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private DateFormatter formatter;

    @Autowired
    private WFTypeService wfTypeService;


    @Test
    public void getById() {

    }

    @Test
    public void getAll() {
    }

    @Test
    public void save() throws ParseException {
        long workflowCount = workflowService.count();

        Workflow workflow = new Workflow();
        workflow.setTitle("My workflow");

        WFType wfType = new WFType();
        wfType.setTitle("SqoopMysqlTpDir");
        wfType.setTypeClass("ru.yakimov.mysqlToDir.SqoopMysqlTpDir");

        workflow.setType(wfTypeService.save(wfType));
        workflow.setCreateDate(formatter.parse("2020-02-17", Locale.ENGLISH));
        workflow.setLastRunDate(formatter.parse("2020-02-17", Locale.ENGLISH));

        WFConfig wfConfig = new WFConfig();

        DirectoryFrom directoryFrom = new DirectoryFrom();
        directoryFrom.setPath("/tmp/tmp");

        wfConfig.addDirectoryFrom(directoryFrom);

//        !!!
        directoryFrom.setWfConfig(wfConfig);

        wfConfig.setDirTo("/path/path");

        PartitionColumn partitionColumn = new PartitionColumn();
        partitionColumn.setColumnName("USER_ID");
        partitionColumn.setType("int");

        wfConfig.addPartitionColumn(partitionColumn);

//        !!!
        partitionColumn.setWfConfig(wfConfig);

        TableConf tableConf = new TableConf();
        tableConf.setHost("localhost");
        tableConf.setPort("port");
        tableConf.setUsername("root");
        tableConf.setPassword("bhbyf.hnftdf");
        tableConf.setSchema("usersDb");
        tableConf.setTable("users");
        TablePrimaryKay tablePrimaryKay = new TablePrimaryKay();
        tablePrimaryKay.setTitlePrimaryKay("user_id");
        tablePrimaryKay.setType("int");
//        !!!
        tablePrimaryKay.setTableConf(tableConf);
        tableConf.addPrimaryKay(tablePrimaryKay);


        wfConfig.setTableConf(tableConf);
//        !!!
        tableConf.setWfConfig(wfConfig);

        workflow.setWfConfig(wfConfig);
//        !!!
        wfConfig.setWorkflow(workflow);

        Workflow savedWF = workflowService.save(workflow);

        assertEquals(++workflowCount, workflowService.count());

//        assertNotNull(savedWF.getWfConfig().getTableConf().);









    }

    @Test
    public void deleteById() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void count() {
        assertEquals(1 , workflowService.count());
    }
}