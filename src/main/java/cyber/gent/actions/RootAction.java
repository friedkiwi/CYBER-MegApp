package cyber.gent.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace("/")
public class RootAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Action(value = "", results = {
            @Result(name = SUCCESS, type="redirectAction", params = {"namespace", "/energymon", "actionName", ""})
    })
    public String index() {
        return SUCCESS;
    }
}
