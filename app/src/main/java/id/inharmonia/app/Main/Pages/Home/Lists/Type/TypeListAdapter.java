package id.inharmonia.app.Main.Pages.Home.Lists.Type;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.Main.Pages.Home.Popups.SizeQuantityPopup;
import id.inharmonia.app.R;

public class TypeListAdapter extends RecyclerView.Adapter<TypeListAdapter.TypeViewHolder> {

    final Context mContext;
    private List<TypeList> mTypeList;
    private int mLayoutType;

    public TypeListAdapter(Context mContext, List<TypeList> mTypeList, int mLayoutType) {
        this.mContext = mContext;
        this.mTypeList = mTypeList;
        this.mLayoutType = mLayoutType;
    }

    @NonNull
    @Override
    public TypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(mLayoutType, parent, false);
        return new TypeViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull TypeViewHolder holder, int position) {
        holder.mTitle.setText(mTypeList.get(position).getTypeName());
        holder.mIcon.setImageResource(mTypeList.get(position).getTypeIcon());
    }

    @Override
    public int getItemCount() {
        return mTypeList.size();
    }

    public class TypeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvTitle)
        TextView mTitle;

        @BindView(R.id.ivIcon)
        ImageView mIcon;

        @BindView(R.id.cvMenuItem)
        CardView mTypeItem;

        TypeViewHolder(final View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            Typeface harabara_mais_font = Typeface.createFromAsset(itemView.getContext().getApplicationContext().getAssets(),  "fonts/harabara-mais.ttf");
            mTitle.setTypeface(harabara_mais_font);
        }

        @OnClick(R.id.cvMenuItem)
        public void showAll() {
            SizeQuantityPopup mSizeQuantityPopup = new SizeQuantityPopup();
            mSizeQuantityPopup.show(((FragmentActivity)mContext).getSupportFragmentManager(), mSizeQuantityPopup.getTag());
        }

    }

}
