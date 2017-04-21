import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")
public class ${NAME} extends RecyclerView.Adapter<${NAME}.ViewHolder> {

    private static final String TAG = ${NAME}.class.getSimpleName();
	
    private final OnItemClickListener mListener;
    private Context mContext;
    private List<${LIST_MODEL}> mList;

    public ${NAME}(Context context, List<${LIST_MODEL}> list, OnItemClickListener onItemClickListener) {
        this.mContext = context;
        this.mList = list;
        this.mListener = onItemClickListener;
    }
	
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.${item_layout}, parent, false);
        return new ViewHolder(view);
    }
	
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ${LIST_MODEL} item = mList.get(position);
        holder.bindOrder(item);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(${LIST_MODEL} item);
    }
	
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
		
        private ${LIST_MODEL} mItem;
		
		//TODO Bind views
		public ViewHolder(View itemView) {
			super(itemView);
            itemView.setOnClickListener(this);
            
			ButterKnife.bind(this, itemView);
        }
		
		//TODO setup views
		public void bindOrder(${LIST_MODEL} item) {
			mItem = item;
        }

        @Override
        public void onClick(View v) {
            mListener.onItemClick(mItem);
        }
    }
}