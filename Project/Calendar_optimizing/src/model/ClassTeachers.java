package model;

import java.util.Objects;

public class ClassTeachers {
    private int classId;
    private int teacherId;

    public ClassTeachers() {
    }

    public ClassTeachers(int classId, int teacherId) {
        this.classId = classId;
        this.teacherId = teacherId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassTeachers that = (ClassTeachers) o;
        return classId == that.classId && teacherId == that.teacherId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, teacherId);
    }
}
