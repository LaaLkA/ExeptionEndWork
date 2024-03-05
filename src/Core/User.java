package Core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class User {

    private List<String> fullName;
    private String sex;
    private Date birthday;
    private Number phoneNumber;

    public User(List<String> fullName, String sex, Date birthday, Number phoneNumber){
        this.fullName = fullName;
        this.sex = sex;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
    }
    public User() {
        this.fullName = null;
        this.sex = null;
        this.birthday = null;
        this.phoneNumber = null;
    }

    public List<String> getFullName() {
//        StringBuilder fullNameString = new StringBuilder();
//        for (String namePart : fullName) {
//            fullNameString.append(namePart).append(" ");
//        }
//        return fullNameString.toString().trim();
        return fullName;
    }
    public String getSex() {
        return sex;
    }
    public String getBirthday(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(birthday);
    }
    public Number getPhoneNumber(){
        return phoneNumber;
    }
}
