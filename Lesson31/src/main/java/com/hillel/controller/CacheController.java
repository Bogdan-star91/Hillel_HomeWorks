package com.hillel.controller;

import com.hillel.config.SpringConfig;
import com.hillel.service.impl.CacheImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

/**
 * @author Bohdan Hrytsai
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class CacheController {

    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    CacheImpl cacheImpl = context.getBean("CacheImpl", CacheImpl.class);

    private static final Logger informer = LoggerFactory.getLogger("informer");

    @GetMapping("/post")
    public String post(String cacheName, String key, Object o) {
        informer.info("Running 'post(String cacheName, String key, Object o)' method");
        boolean result = cacheImpl.post(cacheName, key, o);
        return "post " + o.toString() + " in cache " + cacheName + "; result : " + result;
    }

    @GetMapping("/get")
    public String get(String cacheName, String key) {
        informer.info("Running 'get(String cacheName, String key)' method");

        return "Retrieved " + cacheImpl.get(cacheName, key).toString() + " from " + cacheName;
    }

    @GetMapping("/clear()")
    public String clear() {
        informer.info("Running 'clear()' method");
        if (cacheImpl.clear()) {
            return "Successfully cleared the whole cache";
        } else return "Couldn't clear the whole cache";
    }

    @GetMapping("/clear")
    public String clear(String cacheName) {
        informer.info("Running 'clear(String cacheName)' method");
        if (cacheImpl.clear(cacheName)) {
            return cacheName + " cleared successfully";
        } else return "Couldn't clear " + cacheName;
    }

    @GetMapping("/isCacheExist")
    public boolean isCacheExist(String cacheName) {
        informer.info("Running 'isCacheExist(String cacheName)' method");
        return cacheImpl.isCacheExist(cacheName);
    }
}
