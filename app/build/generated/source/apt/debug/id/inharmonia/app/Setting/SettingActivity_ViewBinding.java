// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Setting;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SettingActivity_ViewBinding implements Unbinder {
  private SettingActivity target;

  private View view2131296358;

  @UiThread
  public SettingActivity_ViewBinding(SettingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SettingActivity_ViewBinding(final SettingActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.ibBackButton, "field 'mBackButton' and method 'exit'");
    target.mBackButton = Utils.castView(view, R.id.ibBackButton, "field 'mBackButton'", ImageButton.class);
    view2131296358 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.exit();
      }
    });
    target.mPageName = Utils.findRequiredViewAsType(source, R.id.tvPageName, "field 'mPageName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SettingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackButton = null;
    target.mPageName = null;

    view2131296358.setOnClickListener(null);
    view2131296358 = null;
  }
}
