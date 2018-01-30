package cfd.ram.attendance;

/**
 * Created by Aary on 29-01-2018.
 */

public class course {
    private static String course_name;
    private static String course_code;
    public course(){

    }
    public course(String course_code,String course_name){
        this.course_code=course_code;
        this.course_name=course_name;

    }
    public static String getcourse_code() {
        return course_code;
    }

    public void setcourse_code(String course_code) {
        this.course_code = course_code ;
    }

    public static String getcourse_name() {
        return course_name;
    }

    public void setcourse_name(String course_name) {
        this.course_name = course_name ;
    }

}
