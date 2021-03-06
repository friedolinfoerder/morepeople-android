package morepeople.android.app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * SearchAdapter extends BaseAdapter and provides functions for managing the searchEntryList.
 */
public class SearchAdapter extends BaseAdapter {

    private List<SearchEntry> searchEntryList;

    /**
     * Constructor of SearchAdapter class.
     * Inits new searchEntryList.
     */
    public SearchAdapter() {
        searchEntryList = new ArrayList<SearchEntry>();
    }

    /**
     * Clears the searchEntryList without notifying and therefore reloading the complete data
     */
    public void emptySilent() {
        searchEntryList.clear();
    }

    /**
     * Adds all searchEntries to the list and notifies changed data
     * @param searchEntries -> collection of searchEntries
     */
    public void addAll(Collection<SearchEntry> searchEntries) {
        searchEntryList.addAll(searchEntries);
        notifyDataSetChanged();

    }

    /**
     * Adds one searchEntry to the list and notifies changed data
     * @param searchEntry
     */
    public void add(SearchEntry searchEntry) {
        searchEntryList.add(searchEntry);
        notifyDataSetChanged();
    }

    /**
     * @return size of searchEntryList
     */
    @Override
    public int getCount() {
        return searchEntryList.size();
    }

    /**
     * Get item for specific position
     * @param i -> position
     * @return searchEntryList item at position i
     */
    @Override
    public Object getItem(int i) {
        return searchEntryList.get(i);
    }

    /**
     * Get item id for specific position
     * @param i -> position
     * @return item id
     */
    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * Get the view
     * @param i -> position
     * @param view
     * @param viewGroup
     * @return group
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Context context = viewGroup.getContext();
        LinearLayout group;
        TextView creatorView;
        TextView descriptionView;
        TextView participantsView;

        if ( view == null ) {
             group = new LinearLayout(context);
             creatorView = new TextView(context);
             descriptionView = new TextView(context);
             participantsView = new TextView(context);

            group.addView(descriptionView);
            group.addView(creatorView);
            group.addView(participantsView);

            final LinearLayout fGroup = group;
            group.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SearchEntry entry = (SearchEntry)fGroup.getTag();
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                    // set title
                    alertDialogBuilder.setTitle("Beitreten");

                    // set dialog message
                    alertDialogBuilder
                            .setMessage("Möchtest Du " + entry.description + " beitreten?")
                            .setCancelable(false)
                            .setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // TODO
                                }
                            })
                            .setNegativeButton("Nein", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // if this button is clicked, just close
                                    // the dialog box and do nothing
                                    dialog.cancel();
                                }
                            });

                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();
                }
            });
        } else {
            group = (LinearLayout) view;
            descriptionView = (TextView)group.getChildAt(0);
            creatorView = (TextView)group.getChildAt(1);
            participantsView = (TextView)group.getChildAt(2);
        }

        SearchEntry searchEntry = searchEntryList.get(i);
        creatorView.setText(searchEntry.creator);
        descriptionView.setText(searchEntry.description);
        participantsView.setText(searchEntry.participants);

        group.setTag(searchEntry);

        return group;
    }
}
