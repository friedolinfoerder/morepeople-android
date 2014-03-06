package morepeople.android.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


/**
 * On this activity, the user sees the nearby searches of other users. He can search them, join them or add an own search.
 */
public class SearchActivity extends Activity {

    /**
     * @param savedInstanceState contains the previous state of the activity if it was existent before.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

}
