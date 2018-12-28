// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home.Lists.Size;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SizeListAdapter$SizeViewHolder_ViewBinding implements Unbinder {
  private SizeListAdapter.SizeViewHolder target;

  private View view2131296362;

  private View view2131296363;

  private View view2131296293;

  private View view2131296336;

  @UiThread
  public SizeListAdapter$SizeViewHolder_ViewBinding(final SizeListAdapter.SizeViewHolder target,
      View source) {
    this.target = target;

    View view;
    target.mIcon = Utils.findRequiredViewAsType(source, R.id.ivIcon, "field 'mIcon'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.ibDecreaseButton, "field 'mDecreaseButton' and method 'decreaseValue'");
    target.mDecreaseButton = Utils.castView(view, R.id.ibDecreaseButton, "field 'mDecreaseButton'", ImageButton.class);
    view2131296362 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.decreaseValue();
      }
    });
    view = Utils.findRequiredView(source, R.id.ibIncreaseButton, "field 'mIncreaseButton' and method 'increaseValue'");
    target.mIncreaseButton = Utils.castView(view, R.id.ibIncreaseButton, "field 'mIncreaseButton'", ImageButton.class);
    view2131296363 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.increaseValue();
      }
    });
    view = Utils.findRequiredView(source, R.id.btAddButton, "field 'mAddButton' and method 'showQuantityCustomer'");
    target.mAddButton = Utils.castView(view, R.id.btAddButton, "field 'mAddButton'", Button.class);
    view2131296293 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.showQuantityCustomer();
      }
    });
    target.mQuantityCustomer = Utils.findRequiredViewAsType(source, R.id.llQuantityCustomer, "field 'mQuantityCustomer'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.etNumberValue, "field 'mNumberValue' and method 'focusMe'");
    target.mNumberValue = Utils.castView(view, R.id.etNumberValue, "field 'mNumberValue'", EditText.class);
    view2131296336 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.focusMe();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SizeListAdapter.SizeViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mIcon = null;
    target.mDecreaseButton = null;
    target.mIncreaseButton = null;
    target.mAddButton = null;
    target.mQuantityCustomer = null;
    target.mNumberValue = null;

    view2131296362.setOnClickListener(null);
    view2131296362 = null;
    view2131296363.setOnClickListener(null);
    view2131296363 = null;
    view2131296293.setOnClickListener(null);
    view2131296293 = null;
    view2131296336.setOnClickListener(null);
    view2131296336 = null;
  }
}
