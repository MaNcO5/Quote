package com.example.manco.myapplication.HttpController;
/**
 * Created by Marjan, Tim, Robin, Khaled on 2016-10-17.
 */

public abstract class CustomRunnable<T> implements Runnable {
    public T data;
    public String url;

    @Override
    abstract public void run();
}
