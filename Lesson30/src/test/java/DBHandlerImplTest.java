import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class DBHandlerImplTest {

    private static SessionFactory sessionFactory = null;
    private static Student testStudent = new Student("Bohdan Test", 2002, 1);

    @Test
    public void addStudent() {

        DBHandlerImpl service = new DBHandlerImpl();
        Session session = sessionFactory.openSession();

        assertTrue(service.addStudent(testStudent));


        session.beginTransaction();
        session.delete( testStudent );
        session.getTransaction().commit();
        session.close();

    }


    @Test
    public void getAll() {
        DBHandlerImpl service = new DBHandlerImpl();
        Session session = sessionFactory.openSession();
        service.addStudent(testStudent);

        assertNotNull(service.getAll());
        assertNotEquals(1, service.getAll().size());

        session.beginTransaction();
        session.delete( testStudent );
        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void getByName() {

        DBHandlerImpl service = new DBHandlerImpl();
        Session session = sessionFactory.openSession();
        service.addStudent(testStudent);

        assertEquals(3, service.getByName("Bohdan Test").size());

        session.beginTransaction();
        session.delete( testStudent );
        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void getByIds() {

        List<Integer> ids = new ArrayList<>();
        ids.add(10);

        DBHandlerImpl service = new DBHandlerImpl();

        assertEquals(0, service.getByIds(ids).size());

    }
    @BeforeEach
    public void setUp() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @AfterEach
    public void tearDown() {
        sessionFactory.close();
    }
}
