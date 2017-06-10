package com.training.wuyi.fragmentbasics;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import layout.ArticleFragment;
import layout.HeadlinesFragment;

public class StartFrameActivity extends AppCompatActivity
        implements HeadlinesFragment.OnHeadlineSelectedListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);

        //make sure that the layout version of Activity includes fragment_container FrameLayout
        if(findViewById(R.id.fragment_container)!=null){

            //but,if we resume from the previous state,we will return without nothing,
            //otherwise we will get a overlapped Fragment.
            if(savedInstanceState != null){
                return;
            }

            //  Create a new Fragment that is put into Activity
            ArticleFragment firstFragment = new ArticleFragment();
            HeadlinesFragment secondFragment = new HeadlinesFragment();

            //  if the Activity is started by a special directive,
            //  please deliver extras of Intent to the Fragment in the form of a parameter
            firstFragment.setArguments(getIntent().getExtras());
            //  add the Fragment into "fragment_container" Fragment
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,firstFragment).commit();
        }
    }

    public void onArticleSelected(int position){
        //  User selects a title of one article from HeadlinesFragment
        //  Do something here to show the article

        ArticleFragment articleFrag  = (ArticleFragment)getSupportFragmentManager().findFragmentById(R.id.article_fragment);

        if(articleFrag != null){
            //  If articleFrag is available, it says that we are processing two-pane layout
            //  Use the method of ArticleFragment to update the content
            articleFrag.updateArticleView(position);
        }else{
            //otherwise, we are processing one-pane layout. Now we need to swap
            //frags...

            //  Create Fragment and delivery the parameter to the article included.
            ArticleFragment newFragment = new ArticleFragment();
            Bundle args = new Bundle();
            args.putInt(ArticleFragment.ARG_POSITION,position);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            //  Whatever fragment_container view is ,we should replace it.
            //  And add the transaction back into the stack to let user to navigate back.
            //  In the app that has several Activities, combine them orderly,which is called back stack
            transaction.replace(R.id.fragment_container,newFragment);
            transaction.addToBackStack(null);

            //  Commit the transaction
            transaction.commit();
        }

    }
}
