package id.inharmonia.app.Main.Pages.Home.Lists.Size;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.R;

public class SizeListAdapter extends RecyclerView.Adapter<SizeListAdapter.SizeViewHolder> {

    final Context mContext;
    private List<SizeList> mSizeList;
    private int mLayoutType;

    public SizeListAdapter(Context mContext, List<SizeList> mSizeList, int mLayoutType) {
        this.mContext = mContext;
        this.mSizeList = mSizeList;
        this.mLayoutType = mLayoutType;
    }

    @NonNull
    @Override
    public SizeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(mLayoutType, parent, false);
        return new SizeViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull SizeViewHolder holder, int position) {
        holder.mIcon.setImageResource(mSizeList.get(position).getSizeIcon());
    }

    @Override
    public int getItemCount() {
        return mSizeList.size();
    }

    public class SizeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivIcon)
        ImageView mIcon;

        @BindView(R.id.ibDecreaseButton)
        ImageButton mDecreaseButton;

        @BindView(R.id.ibIncreaseButton)
        ImageButton mIncreaseButton;

        @BindView(R.id.tvNumberValue)
        TextView mNumberValue;

        SizeViewHolder(final View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.ibDecreaseButton)
        public void decreaseValue() {
            int oldValue = Integer.parseInt(mNumberValue.getText().toString());
            int newValue = oldValue - 1;
            if (newValue <= 0) {
                mNumberValue.setText("0");
            } else {
                mNumberValue.setText(String.valueOf(newValue));
            }
        }

        @OnClick(R.id.ibIncreaseButton)
        public void increaseValue() {
            int oldValue = Integer.parseInt(mNumberValue.getText().toString());
            int newValue = oldValue + 1;
            if (newValue <= 0) {
                mNumberValue.setText("0");
            } else {
                mNumberValue.setText(String.valueOf(newValue));
            }
        }

    }

}
