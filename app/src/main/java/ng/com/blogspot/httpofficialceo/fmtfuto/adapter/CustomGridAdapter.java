package ng.com.blogspot.httpofficialceo.fmtfuto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ng.com.blogspot.httpofficialceo.fmtfuto.R;


/**
 * Created by official on 10/21/17.
 */

public class CustomGridAdapter extends BaseAdapter {
    private Context context;
    private String iconName[];
    private int iconImage[];

   public CustomGridAdapter (Context mContext, String []iconName, int[] iconImage){
        this.context = mContext;
        this.iconName = iconName;
        this.iconImage = iconImage;

    }


    @Override
    public int getCount() {
        return iconName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_icon, parent, false);
        TextView textView = convertView.findViewById(R.id.grid_txt);
        ImageView imageView = convertView.findViewById(R.id.grid_img);
        textView.setText(iconName[position]);
        Glide.with(context).load(iconImage[position]).into(imageView);

        return convertView;
    }
}
