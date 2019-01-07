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
import android.support.v7.widget.LinearLayoutManager;
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
import id.inharmonia.app.Animation.BounceActivity;
import id.inharmonia.app.Cart.CartActivity;
import id.inharmonia.app.Main.Pages.Home.List.MenuList;
import id.inharmonia.app.Main.Pages.Home.Adapter.MenuListAdapter;
import id.inharmonia.app.R;
import id.inharmonia.app.Search.SearchActivity;

public class HomeFragment extends Fragment {

    @BindView(R.id.rv_list_menu)
    RecyclerView rv_list_menu;

    @BindView(R.id.cv_button_search)
    CardView cv_button_search;

    @BindView(R.id.ib_button_cart)
    ImageButton ib_button_cart;

    @BindView(R.id.tv_cart_total)
    TextView tv_cart_total;

    @BindView(R.id.cl_promo_slide)
    CarouselView cl_promo_slide;

    List<MenuList> list_menu;
    MenuList item_menu;
    int[] sample_image = {R.drawable.in_blank_landscape, R.drawable.in_blank_landscape, R.drawable.in_blank_landscape, R.drawable.in_blank_landscape, R.drawable.in_blank_landscape};

    public HomeFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this, view);

        cl_promo_slide.setPageCount(sample_image.length);
        cl_promo_slide.setImageListener(imageListener);

        rv_list_menu.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv_list_menu.setFocusable(false);

        list_menu = new ArrayList<>();

        item_menu = new MenuList("Dokumen", R.drawable.in_thumb_documents_square, true);
        list_menu.add(item_menu);
        item_menu = new MenuList("Gambar", R.drawable.in_thumb_pictures_square, true);
        list_menu.add(item_menu);
        item_menu = new MenuList("Flyer", R.drawable.in_thumb_flyer_square, false);
        list_menu.add(item_menu);
        item_menu = new MenuList("Undangan", R.drawable.in_thumb_invitation_square, false);
        list_menu.add(item_menu);
        item_menu = new MenuList("Spanduk", R.drawable.in_thumb_spanduk_square, false);
        list_menu.add(item_menu);
        item_menu = new MenuList("Stand Banner", R.drawable.in_thumb_stand_banner_square, false);
        list_menu.add(item_menu);
        item_menu = new MenuList("Kartu Nama", R.drawable.in_thumb_namecard_square, false);
        list_menu.add(item_menu);
        item_menu = new MenuList("Lainnya", R.drawable.in_more_square, true);
        list_menu.add(item_menu);

        rv_list_menu.setAdapter(new MenuListAdapter(getActivity(), list_menu, R.layout.rv_item_menu, this));

        return view;
    }

    public void update_cart() {
        final Animation animate_button = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce);

        BounceActivity interpolator = new BounceActivity(0.2, 20);
        animate_button.setInterpolator(interpolator);

        tv_cart_total.setVisibility(View.VISIBLE);
        tv_cart_total.startAnimation(animate_button);
        tv_cart_total.setText(String.format("%s", (Integer.parseInt(tv_cart_total.getText().toString()) + 1)));
        popup_message("Pesanan berhasil ditambahkan ke keranjang");
    }

    public void popup_message(String messages) {
        AlertDialog.Builder popup_message = new AlertDialog.Builder(getActivity(), R.style.DialogTheme);
        View popup_view_message = getLayoutInflater().inflate(R.layout.dialog_popup_message, null);
        popup_message.setView(popup_view_message);

        TextView the_message = popup_view_message.findViewById(R.id.tv_message);
        the_message.setText(messages);

        popup_message.setPositiveButton("Ok Sip", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }

        });

        Dialog dialog_popup_message = popup_message.create();
        dialog_popup_message.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog_popup_message.setCancelable(true);

        dialog_popup_message.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog_popup_message.show();
    }

    @OnClick(R.id.cv_button_search)
    public void open_search() {
        getActivity().startActivity(new Intent(getActivity(), SearchActivity.class));
    }

    @OnClick(R.id.ib_button_cart)
    public void open_cart() {
        getActivity().startActivity(new Intent(getActivity(), CartActivity.class));
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sample_image[position]);
        }
    };

}
