package soexample.umeng.com.zhoukao1;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import soexample.umeng.com.zhoukao1.fragment.LeftFragment;
import soexample.umeng.com.zhoukao1.fragment.RightFragment;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.view_vp)
    public ViewPager view_vp;
    @BindView(R.id.tablayout)
    public TabLayout tablayout;
    private String[] mTitle = {"首页", "我的"};
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragments.add(new LeftFragment());
        fragments.add(new RightFragment());
        view_vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle[position];
            }
        });
        tablayout.setupWithViewPager(view_vp);
    }

    //刷新右边
    public void itemClick() {
        Fragment fragment=fragments.get(1);
        if(fragment instanceof RightFragment){
            ((RightFragment)fragment).itemClick();
        }
    }
}
