import com.hillel.config.SpringConfig;
import com.hillel.service.impl.CacheImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class CacheImplTest {

    private static final Logger testInfoWriter = LoggerFactory.getLogger("infoWriter");
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    CacheImpl cacheImpl;


    @BeforeEach
    void before() {
        cacheImpl = context.getBean("CacheImpl", CacheImpl.class);
        testInfoWriter.info("The test begins");
    }

    @AfterEach
    void after() {
        cacheImpl.clear();
        testInfoWriter.info("The test is over");
        testInfoWriter.info("==========================================================");
    }

    @Test
    void isCacheExist() {
        Assertions.assertNull(cacheImpl.getLocalCache());
        cacheImpl.createCache();
        Assertions.assertNotNull(cacheImpl.getLocalCache());
        cacheImpl.put("Test", "1", new Object());
        cacheImpl.put("Test1", "2", new Object());
        Assertions.assertTrue(cacheImpl.isCacheExist("Test"));
        Assertions.assertTrue(cacheImpl.isCacheExist("Test1"));
    }

    @Test
    void put() {
        Assertions.assertNull(cacheImpl.getLocalCache());
        cacheImpl.put("Test", "1", new Object());
        cacheImpl.put("Test", "2", new Object());
        Assertions.assertNotNull(cacheImpl.getLocalCache());
        Assertions.assertTrue(cacheImpl.isCacheExist("Test"));
    }

    @Test
    void get() {
        Assertions.assertNull(cacheImpl.getLocalCache());
        cacheImpl.put("Test", "1", new Object());
        cacheImpl.put("Test", "2", new Object());
        Assertions.assertNotNull(cacheImpl.getLocalCache());
        Assertions.assertTrue(cacheImpl.isCacheExist("Test"));
        Assertions.assertNotNull(cacheImpl.get("Test", "2"));
        Assertions.assertNotNull(cacheImpl.get("Test", "1"));
    }

    @Test
    void clearWhole() {
        Assertions.assertNull(cacheImpl.getLocalCache());
        cacheImpl.put("Test", "1", new Object());
        cacheImpl.put("Test", "2", new Object());
        Assertions.assertNotNull(cacheImpl.getLocalCache());
        cacheImpl.clear();
        Assertions.assertTrue(cacheImpl.getLocalCache().isEmpty());
    }

    @Test
    void clearSpecific() {
        cacheImpl.createCache();
        Assertions.assertFalse(cacheImpl.isCacheExist("Test"));
        cacheImpl.put("Test", "1", new Object());
        Assertions.assertTrue(cacheImpl.isCacheExist("Test"));
        cacheImpl.clear("Test");
        Assertions.assertFalse(cacheImpl.isCacheExist("Test"));
    }

}
