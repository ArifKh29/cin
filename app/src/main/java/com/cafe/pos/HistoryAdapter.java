package com.cafe.pos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>{
    Context context;
    LayoutInflater inflater;
    private ArrayList<HistoryMdl> dataList;
    private RecyclerViewListener listener;

    public HistoryAdapter(Context ctx, ArrayList<HistoryMdl> dataList, RecyclerViewListener listener){
        this.inflater = LayoutInflater.from(ctx);
        this.dataList = dataList;
        this.listener = listener;
    }



    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflater.inflate(R.layout.history_list,parent,false);
//        FoodViewHolder vHolder = new FoodViewHolder(view);

        return new HistoryViewHolder(view);
//        return vHolder;
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, final int position) {
        holder.txtTgl.setText(dataList.get(position).getTanggal());
        holder.txtIdtrx.setText(dataList.get(position).getIdtrx()+" - "+dataList.get(position).getNama());
        holder.txtTotalTransaksi.setText(dataList.get(position).getJumlah());
//        holder.txtFood.setText(dataList.get(position).getNama()+" "+dataList.get(position).getKet());
//        holder.txtHarga.setText(dataList.get(position).getHarga()+" x "+dataList.get(position).getJumlah()+"pcs");
//        holder.txtKet.setText(dataList.get(position).getKet());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class HistoryViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtTgl, txtIdtrx, txtTotalTransaksi;
        private CardView cvmain;
        public HistoryViewHolder(View itemView) {
            super(itemView);
            txtTgl = (TextView) itemView.findViewById(R.id.txtTgl);
            txtIdtrx = (TextView) itemView.findViewById(R.id.txtIdtrx);
            txtTotalTransaksi = (TextView) itemView.findViewById(R.id.txtTotalTransaksi);
            cvmain = (CardView) itemView.findViewById(R.id.cv_cart);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());
//            ((BtmSheetModal) context).customBottomDialog(dataList.get(getAdapterPosition()).getNama());
        }
    }


    public interface RecyclerViewListener{
        void onClick(View v, int position );
    }
}
