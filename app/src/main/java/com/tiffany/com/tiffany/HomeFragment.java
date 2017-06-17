package com.tiffany.com.tiffany;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.tiffany.com.tiffany.adapter.HomeListAdapter;
import com.tiffany.com.tiffany.adapter.MedicineListAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by moses on 09/06/2017.
 */

public class HomeFragment extends Fragment {
    protected View contentView;


    private ConvenientBanner convenientBanner;
    private ArrayList<Integer> localImages = new ArrayList<Integer>();
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        contentView = inflater.inflate(R.layout.home_fragment, container, false);
        View  banner_view = inflater.inflate(R.layout.home_banner, container, false);
        convenientBanner = (ConvenientBanner) banner_view.findViewById(R.id.convenientBanner);
        //获取本地的图片
        for (int position = 0; position < 3; position++) {
            localImages.add(getResId("ic_test_" + position, R.mipmap.class));
        }

//开始自动翻页
        convenientBanner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new LocalImageHolderView();
            }
        },localImages)
                //设置指示器是否可见
                .setPointViewVisible(true)
                //设置自动切换（同时设置了切换时间间隔）
                .startTurning(2000)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
//                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                //设置指示器的方向（左、中、右）
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
                //设置点击监听事件
//                .setOnItemClickListener(this)
                //设置手动影响（设置了该项无法手动切换）
                .setManualPageable(true);


        //设置翻页的效果，不需要翻页效果可用不设
        //setPageTransformer(Transformer.DefaultTransformer);   // 集成特效之后会有白屏现象，新版已经分离，如果要集成特效的例子可以看Demo的点击响应。



        ListView listView = (ListView) contentView.findViewById(R.id.home_listView);
        listView.setAdapter(new HomeListAdapter(getContext(),null));
        listView.addHeaderView(convenientBanner);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getActivity(),MedicineActivity.class);
                intent.putExtra("com.tiffany.android_intent.age", i);
                startActivity(intent);
//                switch (i){
//                    case 1:{
//                        break;
//                    }
//                    case 2:{
//                        break;
//                    }
//                    case 3:{
//                        break;
//                    }
//                    case 4:{
//                        break;
//                    }
//                    case 5:{
//                        break;
//                    }
//                    case 6:{
//                        break;
//                    }
//                    case 7:{
//                        break;
//                    }
//                    case 8:{
//                        break;
//                    }
//                    case 9:{
//                        break;
//                    }
//                }
            }
        });
        return contentView;
    }

    /**
     * 通过文件名获取资源id 例子：getResId("icon", R.drawable.class);
     *
     * @param variableName
     * @param c
     * @return
     */
    public static int getResId(String variableName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}

