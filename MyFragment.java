package ${PACKAGE_NAME};

import ${PACKAGE_NAME}.DatePicker.DatePickerFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Fedor on 22.03.2017.
 */
public class ${NAME} extends Fragment {

    public final static String TAG = "${NAME}";
    public final static String ARG_MODEL = "${NAME} model data";

    private OnShowCurrentFragmentListener mOnShowCurrentFragmentListener;

    public static ${NAME} newInstance(${Model} model) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_MODEL, model);

        ${NAME} fragment = new ${NAME}();
        fragment.setArguments(args);

        return fragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mOnShowCurrentFragmentListener = (OnShowCurrentFragmentListener) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        ${Model} model = (${Model}) getArguments().getSerializable(ARG_MODEL);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.${Layout}, container, false);

        ButterKnife.bind(this, v);

        return v;
    }
}
