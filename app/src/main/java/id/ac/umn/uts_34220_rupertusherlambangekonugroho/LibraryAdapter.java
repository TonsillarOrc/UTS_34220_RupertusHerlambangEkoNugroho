package id.ac.umn.uts_34220_rupertusherlambangekonugroho;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder> {
    private LinkedList<SumberVideo> mDaftarVideo;
    private LayoutInflater mInflater;
    private Context mContext;

    public LibraryAdapter(Context context, LinkedList<SumberVideo> mDaftarVideo){
        this.mDaftarVideo = mDaftarVideo;
        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    @NonNull
    @Override
    public LibraryAdapter.LibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
        View view = mInflater.inflate(R.layout.list_video, parent, false);
        return new LibraryViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull LibraryAdapter.LibraryViewHolder holder, @SuppressLint("RecyclerView") int position) {
        SumberVideo mSumberVideo = mDaftarVideo.get(position);
        holder.tvJudul.setText(mSumberVideo.getJudul());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDaftarVideo.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDaftarVideo.size();
    }

    public class LibraryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvJudul;
        private ImageButton btnDelete;
        private SumberVideo mSumberVideo;
        private int mPosisi;
        private LibraryAdapter mAdapter;
        public LibraryViewHolder(@NonNull View itemView, LibraryAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            tvJudul = (TextView) itemView.findViewById(R.id.tvJudul);
            btnDelete = (ImageButton) itemView.findViewById(R.id.btnDelete);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            mPosisi = getLayoutPosition();
            mSumberVideo = mDaftarVideo.get(mPosisi);
            Intent detailIntent = new Intent(mContext, VideoDetail.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("VideoDetail", mSumberVideo);
            detailIntent.putExtras(bundle);
            String namaVideo = tvJudul.getText().toString();
            detailIntent.putExtra("NamaVideo", namaVideo);
            mContext.startActivity(detailIntent);
        }
    }
}
