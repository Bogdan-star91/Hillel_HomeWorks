package com.game.service;

public interface FileWorker {
    boolean isCreated();
    boolean write(String data);

    boolean create(String fileName);
}
