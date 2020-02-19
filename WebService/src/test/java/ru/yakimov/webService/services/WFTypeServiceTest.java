package ru.yakimov.webService.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.yakimov.webService.entiies.WFType;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WFTypeServiceTest {

    @Autowired
    private WFTypeService wfTypeService;


    @Test
    @Transactional
    public void save() {
        WFType wfType = new WFType();
        wfType.setTitle("SqoopMysqlTpDir");
        wfType.setTypeClass("ru.yakimov.mysqlToDir.SqoopMysqlTpDir");
        wfType = wfTypeService.save(wfType);
        assertEquals(wfType.getTitle(), wfTypeService.getById(wfType.getId()).getTitle());
    }

    @Test
    @Transactional
    public void getById() {
        WFType wfType = new WFType();
        wfType.setTitle("SqoopMysqlTpDir");
        wfType.setTypeClass("ru.yakimov.mysqlToDir.SqoopMysqlTpDir");
        wfType = wfTypeService.save(wfType);
        assertEquals(wfType.getTitle(), wfTypeService.getById(wfType.getId()).getTitle());
    }

    @Test
    public void getAll() {
        assertEquals(wfTypeService.getAll().size(), wfTypeService.count());
    }

    @Test
    @Transactional
    public void deleteById() {
        WFType wfType = new WFType();
        wfType.setTitle("SqoopMysqlTpDir");
        wfType.setTypeClass("ru.yakimov.mysqlToDir.SqoopMysqlTpDir");
        WFType savesType = wfTypeService.save(wfType);
        wfTypeService.deleteById(savesType.getId());
        assertThrows(JpaObjectRetrievalFailureException.class,
                ()->wfTypeService.getById(savesType.getId())
        );
    }

    @Test
    @Transactional
    public void delete() {
        WFType wfType = new WFType();
        wfType.setTitle("SqoopMysqlTpDir");
        wfType.setTypeClass("ru.yakimov.mysqlToDir.SqoopMysqlTpDir");
        WFType savesType = wfTypeService.save(wfType);
        wfTypeService.delete(savesType);
        assertThrows(JpaObjectRetrievalFailureException.class,
                ()->wfTypeService.getById(savesType.getId())
        );

    }

    @Test
    public void count() {
        assertEquals(wfTypeService.getAll().size(), wfTypeService.count());
    }
}