package model;

import java.util.List;

public class Classroom {
    String id, name;
    List<Chromosome> schedules;

    public Classroom(String id, String name, List<Chromosome> schedules) {
        this.id = id;
        this.name = name;
        this.schedules = schedules;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Chromosome> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Chromosome> schedules) {
        this.schedules = schedules;
    }
}
