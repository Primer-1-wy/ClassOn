package week5;


public class Subject {
    private String SubjectID;
    private String SubjectName;
    private String year;//年份
    private String StuYear;//学年
    public Subject(String subjectID, String subjectName) {
        SubjectID = subjectID;
        SubjectName = subjectName;
    }
    public Subject() {}

    public String getSubjectID() {return SubjectID;}
    public void setSubjectID(String subjectID) {SubjectID = subjectID;}
    public String getSubjectName() {return SubjectName;}
    public void setSubjectName(String subjectName) {SubjectName = subjectName;}
    public String getYear() {return year;}
    public void setYear(String year) {this.year = year;}
    public String getStuYear() {return StuYear;}
    public void setStuYear(String stuYear) {StuYear = stuYear;}

    @Override
    public String toString() {
        return
                "SubjectID='" + SubjectID + '\'' +
                ", SubjectName='" + SubjectName + '\'' +
                ", year='" + year + '\'' +
                ", StuYear='" + StuYear ;
    }
}
