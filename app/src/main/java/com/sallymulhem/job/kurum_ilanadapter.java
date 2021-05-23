package com.sallymulhem.job;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class kurum_ilanadapter extends RecyclerView.Adapter<kurum_ilanadapter.seelHolder> {
    private ArrayList<Kurum_ilan> kurunlist;
    private OnItemClickListener listener;
    Context context;

    public kurum_ilanadapter(ArrayList<Kurum_ilan> kurunlist, Context context) {
        this.kurunlist = kurunlist;
        this.context = context;
    }

    @NonNull
    @Override
    public seelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.ilan_item, parent, false);
        return new seelHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull seelHolder holder, int position) {
        Kurum_ilan Kurum_ilan = kurunlist.get(position);
        holder.setdata(Kurum_ilan);
    }

    @Override
    public int getItemCount() {
        return kurunlist.size();
    }




    class seelHolder extends RecyclerView.ViewHolder {
        TextView q1, q2, q3, q4, q5, q6, q7;
        ImageView image;

        public seelHolder(@NonNull View itemView) {
            super(itemView);
            q1 = (TextView)itemView.findViewById(R.id.itemsellList1);
            q2 = (TextView)itemView.findViewById(R.id.itemsellList2);
            q3 = (TextView)itemView.findViewById(R.id.itemsellList3);
            q4 = (TextView)itemView.findViewById(R.id.itemsellList4);
            q5 = (TextView)itemView.findViewById(R.id.itemsellList5);
            q6 = (TextView)itemView.findViewById(R.id.itemsellList6);

            System.out.println(q1.getText().toString());
            image = (ImageView) itemView.findViewById(R.id.itemimageViewSellResm);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION)
                        listener.onItemClıck(kurunlist.get(position));
                }
            });
        }
        //   Bitmap image=image.getDrawingCache();
        //vv =findViewById(R.id.mm);
//        Bitmap d=vv.getDrawingCache();
        //      DB =new DBHelper(this);
        // d = DB.VeriListelephoto(d);
        //vv.setImageBitmap(d);
        public void setdata(Kurum_ilan kurum_ilan) {
            this.q1.setText(kurum_ilan.getAdd());
            this.q2.setText(kurum_ilan.getAdress());
            this.q3.setText(kurum_ilan.getAcıklama());
            this.q4.setText(kurum_ilan.getPhonee());
            this.q5.setText(kurum_ilan.getOzelıkler());
            this.q6.setText(kurum_ilan.getZaman());
            //this.q7.setText(kurum_ilan.getMaas());
            this.image.setImageBitmap(kurum_ilan.getKurumResim());
        }
    }
    public interface OnItemClickListener {
        void onItemClıck(Kurum_ilan sell_java);
    }
    public void setOnItemClıckLıstener(OnItemClickListener listener) {
        this.listener = listener;

    }
}
