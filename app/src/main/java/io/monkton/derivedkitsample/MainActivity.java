package io.monkton.derivedkitsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import io.monkton.derivedkit.CredentialSet;
import io.monkton.derivedkit.DerivedActionCallback;
import io.monkton.derivedkit.DerivedController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Perform the authentication action
     * @param view
     */
    public void doAuthenticate(final View view) {
        DerivedController.getInstance().authenticate(this);
    }

    /**
     * Perform the signature action
     * @param view
     */
    public void doSign(final View view) {
        DerivedController.getInstance().sign(this, "Test Sign".getBytes());
    }

    /**
     * Handles the authentication result if applicable. This is how call backs from the Derived
     * app are intercepted when the result is posted.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Call base activity handler
        super.onActivityResult(requestCode, resultCode, data);

        // Check to see if there is a callback from the activity result. This is our hook into the
        // Android runtime to have seamless interaction with DerivedKit
        boolean wasHandledByDerivedKit = DerivedController.getInstance().checkOnActivityResult(this, requestCode, resultCode, data, new DerivedActionCallback() {

            @Override
            public void authenticated(boolean wasSuccess, CredentialSet credentials) {
                handleAuthentication(credentials);
            }

            @Override
            public void signed(boolean wasSuccess, CredentialSet signedDataSet) {
                handleSigned(signedDataSet);
            }
        });

    }

    /**
     * Process the authentication request from DerivedKit
     *
     * @param credentials
     */
    private void handleAuthentication(CredentialSet credentials) {
        /* Handle the credentials here... */
    }

    /**
     * Process the signature request from DerivedKit
     *
     * @param signedDataSet the signed data
     */
    private void handleSigned(CredentialSet signedDataSet) {
        /* Handle the signed data here... */
    }
}
