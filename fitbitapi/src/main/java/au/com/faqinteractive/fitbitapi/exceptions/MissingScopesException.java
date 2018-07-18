package au.com.faqinteractive.fitbitapi.exceptions;



import java.util.Collection;
import java.util.Set;

import au.com.faqinteractive.fitbitauth.authentication.Scope;

/**
 * Created by jboggess on 9/19/16.
 */
public class MissingScopesException extends FitbitAPIException {

    private Collection<Scope> scopes;

    public MissingScopesException(Set<Scope> scopes) {
        this.scopes = scopes;
    }

    public Collection<Scope> getScopes() {
        return scopes;
    }
}
