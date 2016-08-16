package io.monkton.derivedkitsample;

import io.monkton.derivedkit.CredentialSet;
import io.monkton.derivedkit.ui.DerivedCredentialLoginActivity;

/**
 * Created by harold on 8/16/16.
 */
public class AuthenticateActivity extends DerivedCredentialLoginActivity {

    /**
     * Process the authentication request from DerivedKit
     *
     * @param credentialSet
     */
    @Override
    protected void handleAuthentication(CredentialSet credentialSet) {
        /* Handle the credentials here... */
    }

}
