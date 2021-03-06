/**
 * File: RemoveUserFragment.java
 * Purpose: Set the remove user fragment on view
 */

package com.mathheals.euvou.controller.remove_user;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mathheals.euvou.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RemoveUserFragment extends android.support.v4.app.Fragment
        implements View.OnClickListener{

    /**
     * Required empty public constructor
     */
    public RemoveUserFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        assert inflater != null;

        View removeUserFragmentView = inflater.inflate(R.layout.fragment_remove_user,
                container, false);
        assert removeUserFragmentView != null;

        Button deactivateButton = (Button) removeUserFragmentView
                .findViewById(R.id.button_disable_account_id);
        assert deactivateButton != null;

        deactivateButton.setOnClickListener(this);

        return removeUserFragmentView;
    }

    /**
     * Method invoked when view is clicked
     * @param view View that was clicked
     */
    @Override
    public void onClick(View view){
        assert view != null;

        FragmentActivity activity = this.getActivity();
        assert activity != null;

        android.support.v4.app.FragmentTransaction fragmentTransaction =
                activity.getSupportFragmentManager().beginTransaction();
        assert fragmentTransaction != null;

        switch(view.getId()){
            case R.id.button_disable_account_id:

                fragmentTransaction.replace(R.id.content_frame, new OhGoshFragment());
                fragmentTransaction.add(R.id.content_frame, new DisableAccountFragment(),
                        String.valueOf(R.string.DISABLE_ACCOUNT_FRAGMENT_TAG));

                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.addToBackStack
                        (String.valueOf(R.string.DISABLE_ACCOUNT_FRAGMENT_TAG));
                fragmentTransaction.commit();

                break;

            default:
                //nothing to do
                break;
        }
    }
}
