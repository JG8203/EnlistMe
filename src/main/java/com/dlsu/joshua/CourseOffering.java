package com.dlsu.joshua;

import java.util.List;

public class CourseOffering {
    private String subjectCode;
    private String catalogNbr;
    private String classNbr;
    private String Section;
    private boolean isClosed;
    private String scheduleDayRemarks;
    private List<ClassSession> classes;

    // Inner Class to represent individual class sessions
    public static class ClassSession {
        private String instructor;
        private String room;
        private String scheduleDayCode;
        private String scheduleDayTime;

        public String getInstructor() {
            return instructor;
        }

        public String getRoom() {
            return room;
        }

        public String getScheduleDayCode() {
            return scheduleDayCode;
        }

        public String getScheduleDayTime() {
            return scheduleDayTime;
        }
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getCatalogNbr() {
        return catalogNbr;
    }

    public String getClassNbr() {
        return classNbr;
    }

    public String getSection() {
        return Section;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public String getScheduleDayRemarks() {
        return scheduleDayRemarks;
    }

    public List<ClassSession> getClasses() {
        return classes;
    }
}
