package com.example.manco.myapplication.HttpController;


public abstract class CustomRunnable<T> implements Runnable {
    public T data;
    public String url;

    @Override
    abstract public void run();
}
