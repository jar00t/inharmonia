package id.inharmonia.app.Main.Pages.Home;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.Animations.BounceAnimation;
import id.inharmonia.app.Cart.CartActivity;
import id.inharmonia.app.Main.Pages.Home.Lists.MainMenu.MainMenu;
import id.inharmonia.app.Main.Pages.Home.Lists.MainMenu.MainMenuAdapter;
import id.inharmonia.app.R;
import id.inharmonia.app.Search.SearchActivity;

public class HomeFragment extends Fragment {

    @BindView(R.id.rv_menu_list)
    RecyclerView mRecyclerView;

    @BindView(R.id.cvSearchOpener)
    CardView mSearchOpener;

    @BindView(R.id.ibCartButton)
    ImageButton mCartButton;

    @BindView(R.id.tvCartTotal)
    TextView mCartTotal;

    @BindView(R.id.clPromoSlide)
    CarouselView mPromoSlider;

    List<MainMenu> mMenuList;
    MainMenu mMenuItem;
    int[] sampleImages = {R.drawable.in_blank_landscape, R.drawable.in_blank_landscape, R.drawable.in_blank_landscape, R.drawable.in_blank_landscape, R.drawable.in_blank_landscape};

    public HomeFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this, view);

        mPromoSlider.setPageCount(sampleImages.length);
        mPromoSlider.setImageListener(imageListener);

        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        mRecyclerView.setFocusable(false);

        mMenuList = new ArrayList<>();

        mMenuItem = new MainMenu("Dokumen", R.drawable.in_thumb_documents_square, true);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("Gambar", R.drawable.in_thumb_pictures_square, true);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("Flyer", R.drawable.in_thumb_flyer_square, false);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("Undangan", R.drawable.in_thumb_invitation_square, false);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("Spanduk", R.drawable.in_thumb_spanduk_square, false);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("Stand Banner", R.drawable.in_thumb_stand_banner_square, false);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("Kartu Nama", R.drawable.in_thumb_namecard_square, false);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("Lainnya", R.drawable.in_more_square, true);
        mMenuList.add(mMenuItem);

        mRecyclerView.setAdapter(new MainMenuAdapter(getActivity(), mMenuList, R.layout.rv_menu_item_row, this));

        return view;
    }

    public void updateCart() {
        final Animation buttonAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce);

        BounceAnimation interpolator = new BounceAnimation(0.2, 20);
        buttonAnim.setInterpolator(interpolator);

        mCartTotal.setVisibility(View.VISIBLE);
        mCartTotal.startAnimation(buttonAnim);
        mCartTotal.setText(String.format("%s", (Integer.parseInt(mCartTotal.getText().toString()) + 1)));
        msgPopup("Pesanan berhasil ditambahkan ke keranjang");
    }

    public void msgPopup(String messages) {
        AlertDialog.Builder msgPopup = new AlertDialog.Builder(getActivity(), R.style.DialogTheme);
        View msgPopupView = getLayoutInflater().inflate(R.layout.dialog_message_popup, null);
        msgPopup.setView(msgPopupView);

        TextView mMessages = msgPopupView.findViewById(R.id.tvMessages);
        mMessages.setText(messages);

        msgPopup.setPositiveButton("Ok Sip", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }

        });

        Dialog dialogMsgPopup = msgPopup.create();
        dialogMsgPopup.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogMsgPopup.setCancelable(true);

        dialogMsgPopup.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialogMsgPopup.show();
    }

    @OnClick(R.id.cvSearchOpener)
    public void openSearch() {
        getActivity().startActivity(new Intent(getActivity(), SearchActivity.class));
    }

    @OnClick(R.id.ibCartButton)
    public void openCart() {
        getActivity().startActivity(new Intent(getActivity(), CartActivity.class));
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

}
