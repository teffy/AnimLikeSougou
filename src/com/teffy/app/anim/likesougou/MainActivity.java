package com.teffy.app.anim.likesougou;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        MainFragment mainFragment = new MainFragment();
        getFragmentManager().beginTransaction().add(R.id.root_content, mainFragment).commit();
    }
}
