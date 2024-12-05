package models;

import java.util.GregorianCalendar;

public class TaskInput {
    long id;
    String title;
    String description;
    String date;
    status status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public models.status getStatus() {
        return status;
    }

    public void setStatus(models.status status) {
        this.status = status;
    }
}
