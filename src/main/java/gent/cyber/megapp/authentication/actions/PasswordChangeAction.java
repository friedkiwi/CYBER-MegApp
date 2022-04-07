package gent.cyber.megapp.authentication.actions;

import gent.cyber.megapp.authentication.AuthenticatedActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace("/auth")
public class PasswordChangeAction extends AuthenticatedActionSupport {
    private String oldPassword;
    private String newPassword;
    private String newPasswordRepeat;


    @Action(value = "changePassword", results = {
            @Result(name = SUCCESS, location = "/WEB-INF/auth/changePassword.jsp")
    })
    public String changePassword() {
        return SUCCESS;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordRepeat() {
        return newPasswordRepeat;
    }

    public void setNewPasswordRepeat(String newPasswordRepeat) {
        this.newPasswordRepeat = newPasswordRepeat;
    }
}
