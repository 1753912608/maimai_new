package maimai_new.demo.dao;

public class user {
    private String user_id;
    private String user_password;
    private String user_mail;
    private String user_sex;
    private String user_birth;
    private String user_real_name;
    private String user_work_direction;
    private String user_company;
    private String user_position;
    private String user_tag;
    private String user_education;
    private int user_expect_salary;
    private String user_work_base;
    private String user_resume_url;

    public user(String user_id, String user_password, String user_mail, String user_sex,
                String user_birth, String user_real_name, String user_work_direction,
                String user_company, String user_position, String user_tag,
                String user_education, int user_expect_salary, String user_work_base,
                String user_resume_url) {
        this.user_id = user_id;
        this.user_password = user_password;
        this.user_mail = user_mail;
        this.user_sex = user_sex;
        this.user_birth = user_birth;
        this.user_real_name = user_real_name;
        this.user_work_direction = user_work_direction;
        this.user_company = user_company;
        this.user_position = user_position;
        this.user_tag = user_tag;
        this.user_education = user_education;
        this.user_expect_salary = user_expect_salary;
        this.user_work_base = user_work_base;
        this.user_resume_url = user_resume_url;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public void setUser_birth(String user_birth) {
        this.user_birth = user_birth;
    }

    public void setUser_real_name(String user_real_name) {
        this.user_real_name = user_real_name;
    }

    public void setUser_work_direction(String user_work_direction) {
        this.user_work_direction = user_work_direction;
    }

    public void setUser_company(String user_company) {
        this.user_company = user_company;
    }

    public void setUser_position(String user_position) {
        this.user_position = user_position;
    }

    public void setUser_tag(String user_tag) {
        this.user_tag = user_tag;
    }

    public void setUser_education(String user_education) {
        this.user_education = user_education;
    }

    public void setUser_expect_salary(int user_expect_salary) {
        this.user_expect_salary = user_expect_salary;
    }

    public void setUser_work_base(String user_work_base) {
        this.user_work_base = user_work_base;
    }

    public void setUser_resume_url(String user_resume_url) {
        this.user_resume_url = user_resume_url;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public String getUser_birth() {
        return user_birth;
    }

    public String getUser_real_name() {
        return user_real_name;
    }

    public String getUser_work_direction() {
        return user_work_direction;
    }

    public String getUser_company() {
        return user_company;
    }

    public String getUser_position() {
        return user_position;
    }

    public String getUser_tag() {
        return user_tag;
    }

    public String getUser_education() {
        return user_education;
    }

    public int getUser_expect_salary() {
        return user_expect_salary;
    }

    public String getUser_work_base() {
        return user_work_base;
    }

    public String getUser_resume_url() {
        return user_resume_url;
    }
}
