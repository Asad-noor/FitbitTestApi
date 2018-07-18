package au.com.faqinteractive.fitbitauth.authentication;


import au.com.faqinteractive.fitbitcommon.BasicHttpRequestBuilder;

/**
 * Created by jboggess on 9/26/16.
 */

public interface RequestSigner {

    void signRequest(BasicHttpRequestBuilder builder);

}
