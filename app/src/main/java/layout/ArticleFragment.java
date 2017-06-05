package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.training.wuyi.fragmentbasics.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleFragment extends Fragment {


    public ArticleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText("ArticleFragment weight=1");
        textView.setTextSize(26);
        return textView;
    }

}
