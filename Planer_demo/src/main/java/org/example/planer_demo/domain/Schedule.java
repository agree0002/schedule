package org.example.planer_demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int schedule_index;

    private int user_index;

    private String date;

    private String task;

    public void setSchedule_index(int schedule_index) {
        this.schedule_index = schedule_index;
    }

    public int getSchedule_index() {
        return schedule_index;
    }

    public void setUser_index(int user_index) {
        this.user_index = user_index;
    }

    public int getUser_index() {
        return user_index;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }

}
