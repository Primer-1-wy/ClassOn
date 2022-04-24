package com.company;

public class subject {
    private String SubjectID;
    private String SubjectName;

    public subject(String subjectID, String subjectName) {
        SubjectID = subjectID;
        SubjectName = subjectName;
    }
    public subject() {}

    public String getSubjectID() {return SubjectID;}
    public void setSubjectID(String subjectID) {SubjectID = subjectID;}
    public String getSubjectName() {return SubjectName;}
    public void setSubjectName(String subjectName) {SubjectName = subjectName;}

    @Override
    public String toString() {
        return
                "SubjectID='" + SubjectID + '\'' +
                ", SubjectName='" + SubjectName + '\'' ;
    }
}
