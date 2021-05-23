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

public class kulanc_ialnadepter extends RecyclerView.Adapter<kulanc_ialnadepter.seelHolder> {
    private ArrayList<kulanc_ilan> kulancılist;
    private kulanc_ialnadepter.OnItemClickListener listener;
    Context context;

    public kulanc_ialnadepter(ArrayList<kulanc_ilan> kulancılist, Context context) {
        this.kulancılist = kulancılist;
        this.context = context;
    }

    @NonNull
    @Override
    public kulanc_ialnadepter.seelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.kulanci_item, parent, false);
        return new kulanc_ialnadepter.seelHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull seelHolder holder, int position) {
        kulanc_ilan kulanc_ilan = kulancılist.get(position);
        holder.setdata(kulanc_ilan);
    }


    @Override
    public int getItemCount() {
        return kulancılist.size();
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
                        listener.onItemClıck(kulancılist.get(position));
                }
            });
        }
        //   Bitmap image=image.getDrawingCache();
        //vv =findViewById(R.id.mm);
//        Bitmap d=vv.getDrawingCache();
        //      DB =new DBHelper(this);
        // d = DB.VeriListelephoto(d);
        //vv.setImageBitmap(d);
        public void setdata(kulanc_ilan kulanc_ilan) {
            this.q1.setText(kulanc_ilan.getAd());
            this.q2.setText(kulanc_ilan.getBolum());
            this.q3.setText(kulanc_ilan.getDeneymler());
            this.q4.setText(kulanc_ilan.getKurslar());
            this.q5.setText(kulanc_ilan.getTel());
            this.q6.setText(kulanc_ilan.getYas());
            //this.q7.setText(kurum_ilan.getMaas());
            this.image.setImageBitmap(kulanc_ilan.getKurumResim());
        }
    }
    public interface OnItemClickListener {
        void onItemClıck(kulanc_ilan kulancı_ılan);
    }
    public void setOnItemClıckLıstener(kulanc_ialnadepter.OnItemClickListener listener) {
        this.listener = listener;

    }
}
