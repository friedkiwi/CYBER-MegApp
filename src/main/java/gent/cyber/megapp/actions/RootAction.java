package gent.cyber.megapp.actions;


import gent.cyber.megapp.authentication.AuthenticatedActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace("/")
public class RootAction extends AuthenticatedActionSupport {
    private static final long serialVersionUID = 1L;

    @Action(value = "", results = {
            @Result(name = SUCCESS, location = "/WEB-INF/root.jsp")
    })
    public String index() {
        return SUCCESS;
    }
}
