package br.com.teravalt.myrestapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.teravalt.myrestapp.R;
import br.com.teravalt.myrestapp.model.Android;

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.AndroidViewHolder>{

    private List<Android> androids;

    public AndroidAdapter(List<Android> a){
        this.androids = a;
    }

    @Override
    public AndroidViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View meuLayout = inflater.inflate(R.layout.android_row, parent,false);
        return new AndroidViewHolder(meuLayout);
    }

    @Override
    public void onBindViewHolder(AndroidViewHolder holder, int position) {
        holder.tvTitulo.setText(androids.get(position).getNome());
        holder.tvSubtitulo.setText("Versão: "+androids.get(position).getVersao()+" - API: "+androids.get(position).getApi());


        Picasso.with(holder.itemView.getContext())
                .load(androids.get(position).getUrlImagem())
                .placeholder(R.drawable.carregando)
                .error(R.drawable.ops2)
                .into(holder.ivImagem);
    }

    @Override
    public int getItemCount() {
        return androids.size();
    }

    public class AndroidViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivImagem;
        public TextView tvTitulo;
        public TextView tvSubtitulo;

        public AndroidViewHolder(View itemView) {
            super(itemView);

            ivImagem = (ImageView) itemView.findViewById(R.id.ivImagem);
            tvTitulo = (TextView) itemView.findViewById(R.id.tvTitulo);
            tvSubtitulo = (TextView) itemView.findViewById(R.id.tvSubTitulo);
        }
    }

}
