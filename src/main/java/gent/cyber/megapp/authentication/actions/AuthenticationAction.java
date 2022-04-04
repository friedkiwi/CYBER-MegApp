package gent.cyber.megapp.authentication.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import java.util.logging.Logger;

@Namespace("/auth")
public class AuthenticationAction extends ActionSupport {
    private transient final Logger log = Logger.getLogger(this.getClass().getName());
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;

    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    @Action(value = "index", results = {
            @Result(name = SUCCESS, type = "redirectAction", params = {"namespace", "auth", "actionName", "login"})
    })
    public String index() {
        return SUCCESS;
    }

    @Action(value = "login", results = {
            @Result(name = SUCCESS, location = "/WEB-INF/auth/login.jsp")
    })
    public String login() {
        return SUCCESS;
    }

    @Action(value = "welcome", results = {
            @Result(name = SUCCESS, type="redirectAction", params = {"namespace", "energymon", "actionName", "index"})
    })
    public String welcome() {
        return SUCCESS;
    }

    @Action(value = "accessDenied", results = {
            @Result(name = SUCCESS, location = "/WEB-INF/auth/accessDenied.jsp")
    })
    public String accessDenied() {
        return SUCCESS;
    }

    /* getters and setters */

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
