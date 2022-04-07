package gent.cyber.megapp.authentication;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticatedActionSupport extends ActionSupport {
    public String getUsername() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDetails.getUsername() != null) {
            return userDetails.getUsername();
        }
        return "Anonymous";
    }

    public boolean isAuthenticated() {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (userDetails.getUsername() != null)
                return true;
            else
                return false;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
