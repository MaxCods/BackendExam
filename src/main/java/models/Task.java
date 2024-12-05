package models;

import java.util.GregorianCalendar;

public class Task extends AbstractModel{
    String title;
    String description;
    String date;
    status status;

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

    public static void main(String[] args) {
        status s= models.status.closed;
        System.out.println(s);
    }
}
