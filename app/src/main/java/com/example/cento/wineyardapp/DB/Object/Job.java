package com.example.cento.wineyardapp.DB.Object;

/**
 * Created by Cento on 19.04.2017.
 */

public class Job {
    private int id;
    private int winelotId;
    private Worker worker;
    private String description;
    private String deadline;

    public int getWinelotId() {
        return winelotId;
    }

    public void setWinelotId(int winelotId) {
        this.winelotId = winelotId;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
