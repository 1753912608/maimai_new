package maimai_new.demo.dao;

public class comment {
    private String comment_dynamic_id;
    private String comment_user_id;
    private String comment_time;
    private String comment_content;

    public comment(String comment_dynamic_id, String comment_user_id, String comment_time,
                   String comment_content) {
        this.comment_dynamic_id = comment_dynamic_id;
        this.comment_user_id = comment_user_id;
        this.comment_time = comment_time;
        this.comment_content = comment_content;
    }

    public void setComment_dynamic_id(String comment_dynamic_id) {
        this.comment_dynamic_id = comment_dynamic_id;
    }

    public void setComment_user_id(String comment_user_id) {
        this.comment_user_id = comment_user_id;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getComment_dynamic_id() {
        return comment_dynamic_id;
    }

    public String getComment_user_id() {
        return comment_user_id;
    }

    public String getComment_time() {
        return comment_time;
    }

    public String getComment_content() {
        return comment_content;
    }
}
