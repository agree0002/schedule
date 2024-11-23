package org.example.planer_demo.Controller;

public class ScheduleForm {
    int schedule_index;
    int user_index;
    String date;
    String task;

    public int getSchedule_index() {
        return schedule_index;
    }

    public void setSchedule_index(int schedule_index) {
        this.schedule_index = schedule_index;
    }

    public int getUser_index() {
        return user_index;
    }

    public void setUser_index(int user_index) {
        this.user_index = user_index;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}