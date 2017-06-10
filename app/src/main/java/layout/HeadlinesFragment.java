package layout;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.training.wuyi.fragmentbasics.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HeadlinesFragment extends ListFragment {
    OnHeadlineSelectedListener mCallback;

    // Container activity must implement the interface
    public interface OnHeadlineSelectedListener{
        public void onArticleSelected(int position);
    }

    public HeadlinesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        //  Make sure that container activity has implemented the callback interface
        //  otherwise, hurl an exception
        try {
            mCallback = (OnHeadlineSelectedListener) activity;
        }catch (ClassCastException e){
            throw  new ClassCastException(activity.toString() +
            "must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        //Delivery an event to the main Activity
        mCallback.onArticleSelected(position);
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        TextView textView = new TextView(getActivity());
//        textView.setText("HeadlinesFragment weight=1");
//        textView.setTextSize(26);
//        return textView;
//    }

}
