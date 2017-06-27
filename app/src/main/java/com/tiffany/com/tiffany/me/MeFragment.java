package com.tiffany.com.tiffany.me;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tiffany.com.tiffany.MainActivity;
import com.tiffany.com.tiffany.R;

/**
 * Created by moses on 09/06/2017.
 */

public class MeFragment extends Fragment implements View.OnClickListener {
    protected View contentView;
    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        contentView = inflater.inflate(R.layout.me_fragment, container, false);
        context = getContext();
//        ListView listView = (ListView) contentView.findViewById(R.id.me_listView);
//        listView.setAdapter(new MedicineListAdapter(getContext(),null));

        TextView phone = (TextView) contentView.findViewById(R.id.phone_number);
        phone.setOnClickListener(this);

        ImageView img = (ImageView) contentView.findViewById(R.id.img_number);
        img.setOnClickListener(this);

        View backView = contentView.findViewById(R.id.back_view);
        backView.setOnClickListener(this);
        return contentView;
    }

    @Override
    public void onClick(View view) {
        if(view == contentView){
            Toast.makeText(context,"么么哒, 您想干啥？",Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + "09959704959");
        intent.setData(data);
        startActivity(intent);
    }
}
