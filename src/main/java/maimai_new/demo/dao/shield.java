package maimai_new.demo.dao;

public class shield {
    private String shield_user_id;
    private String shield_other_user_id;

    public shield(String shield_user_id, String shield_other_user_id) {
        this.shield_user_id = shield_user_id;
        this.shield_other_user_id = shield_other_user_id;
    }

    public void setShield_user_id(String shield_user_id) {
        this.shield_user_id = shield_user_id;
    }

    public void setShield_other_user_id(String shield_other_user_id) {
        this.shield_other_user_id = shield_other_user_id;
    }

    public String getShield_user_id() {
        return shield_user_id;
    }

    public String getShield_other_user_id() {
        return shield_other_user_id;
    }
}
