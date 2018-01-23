package ng.com.blogspot.httpofficialceo.fmtfuto;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;


public class StaffFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);

        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView staffPicture;
        public TextView staffName;
        public TextView staffPosition;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_staff, parent, false));
            staffPicture = (CircleImageView) itemView.findViewById(R.id.picture);

            staffPicture.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    return;
                }
            });
            staffName = (TextView) itemView.findViewById(R.id.name);
            staffPosition = (TextView) itemView.findViewById(R.id.position);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent myIntent = new Intent(v.getContext(), LecturerDetails.class);
                    context.startActivity(myIntent);
                }
            });
        }
    }

    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 15;

        private final String[] staffName;
        private final String[] staffPossition;
        private final Drawable[] staffPicture;

        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            staffName = resources.getStringArray(R.array.names);
            staffPossition = resources.getStringArray(R.array.positions);
            TypedArray a = resources.obtainTypedArray(R.array.staffPictures);
            staffPicture = new Drawable[a.length()];
            for (int i = 0; i < staffPicture.length; i++) {
                staffPicture[i] = a.getDrawable(i);
            }
            a.recycle();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);

        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.staffPicture.setImageDrawable(staffPicture[position % staffPicture.length]);
            holder.staffName.setText(staffName[position % staffName.length]);
            holder.staffPosition.setText(staffPossition[position % staffPossition.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }


}

