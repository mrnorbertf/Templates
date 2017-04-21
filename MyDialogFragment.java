package ${PACKAGE_NAME};

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ${NAME} extends DialogFragment {
    public static final String TAG = ${NAME}.class.getName();


    public interface ${Name}DialogListener {
        void on${Name}PositiveClick(DialogFragment dialog);

        void on${Name}NegativeClick(DialogFragment dialog);
    }

    // Use this instance of the interface to deliver action events
    ${Name}DialogListener mListener;

    public ${NAME}() {
    }

    public static ${NAME} newInstance(String title) {
        ${NAME} frag = new ${NAME}();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            mListener = (${Name}DialogListener) getTargetFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException("Calling fragment must implement DialogClickListener interface");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        String title = getArguments().getString("title");
        builder.setTitle(title);

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View view = inflater.inflate(R.layout.${item_layout}, null);
        ButterKnife.bind(this, view);
       
        builder.setView(view)
                // Add action buttons
                .setPositiveButton(R.string.dialog_input_ok, (dialog, id) -> {
                    mListener.on${Name}PositiveClick(${NAME}.this);
                })
                .setNegativeButton(R.string.dialog_input_cancel, (dialog, id) -> {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    mListener.on${Name}NegativeClick(${NAME}.this);
                });
        return builder.create();

    }

}
/**
*how to show me
        FragmentManager fm = getFragmentManager();
        ${NAME} m${NAME} = ${NAME}.newInstance(getString(R.string.title));
        m${NAME}.setTargetFragment(this, 0);
        m${NAME}.show(fm, ${NAME}.TAG);
*
*/