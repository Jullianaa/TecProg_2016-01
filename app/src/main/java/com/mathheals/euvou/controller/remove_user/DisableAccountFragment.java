/**
 * File: DisableAccountFragment.java
 * Purpose: Gives to the user the option to disable his account
 */

package com.mathheals.euvou.controller.remove_user;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mathheals.euvou.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisableAccountFragment extends android.support.v4.app.Fragment
        implements View.OnClickListener{

    /**
     * Required constructor to instantiate a fragment object
     */
    public DisableAccountFragment(){

    }

    /**
     * Creates and returns the view hierarchy associated with the fragment
     * @param inflater - Object used to inflate any views in the fragment
     * @param container - If non-null, is the parent view that the fragment should be attached to
     * @param savedInstanceState - If non-null, this fragment is being re-constructed from a
     *                           previous saved state as given here
     * @return View - View of the fragment
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the layout for this fragment

        assert inflater != null;
        assert container != null;
        assert savedInstanceState != null;

        View view = inflater.inflate(R.layout.fragment_disable_account, container, false);

        setButtons(view);

        return view;
    }

    /**
     * Disable the account when the user clicks on the yes button or comes back to the previous
     * screen if the user clicks on the no button
     * @param view - Current view where the text was edited
     */
    @Override
    public void onClick(View view){
        assert view != null;

        FragmentActivity activity = this.getActivity();

        switch(view.getId()) {
            case R.id.button_yes_id:
                showWelcomeBackMessage(activity);
                break;
            case R.id.button_no_id:
                callsDisableAccountLoginConfirmation(activity);
                break;
        }
    }

    /**
     * Set the buttons on view
     * @param view - Current view
     */
    private void setButtons(View view){
        assert view != null;

        Button yesButton = (Button)view.findViewById(R.id.button_yes_id);
        yesButton.setOnClickListener(this);

        Button noButton = (Button)view.findViewById(R.id.button_no_id);
        noButton.setOnClickListener(this);
    }

    /**
     * Displays the Disable Account Confirmation Page
     * @param activity - Base class for activity that want to use the support-based Fragment and
     *                 Loader APIs.
     */
    private void callsDisableAccountLoginConfirmation(FragmentActivity activity){
        assert activity != null;

        FragmentTransaction fragmentTransaction =
                activity.getSupportFragmentManager().beginTransaction();

        android.support.v4.app.Fragment disableAccountFragment =
                activity.getSupportFragmentManager().findFragmentByTag(
                        String.valueOf(R.string.DISABLE_ACCOUNT_FRAGMENT_TAG));
        
        fragmentTransaction.remove(disableAccountFragment);
        fragmentTransaction.add(R.id.content_frame, new DisableAccountLoginConfirmation());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    /**
     * Displays a page with a welcome back message
     * @param activity - Base class for activity that want to use the support-based Fragment and
     *                 Loader APIs.
     */
    private void showWelcomeBackMessage(FragmentActivity activity){
        assert activity != null;

        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        Context homePageContext = activity.getBaseContext();

        fragmentManager.popBackStack();
        RemoveUserViewMessages.showWelcomeBackMessage(homePageContext);
    }
}
