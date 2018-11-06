package com.example.ekm.Repository;

import com.example.ekm.Model.Trail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.contains;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrailRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TrailRepository trails;

    private Trail moisad = new Trail("Moisad", "Eesti koige ilusamad moisad");
    private Trail surnuaiad = new Trail("Surnuaiad", "Eesti koige jubedamad surnuaiad");

    @Before
    public void fillSomeDataIntoOurDb() {
        // Add new Trails to Database
        entityManager.persist(moisad);
        entityManager.persist(surnuaiad);
    }

    @Test
    public void testFindAll() throws Exception {
        List<Trail> allTrails = trails.findAll();

        assertThat(allTrails, contains(moisad));
    }
}