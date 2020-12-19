package cl.jav.sismos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SismosAdapter extends RecyclerView.Adapter<SismosAdapter.SismosViewHolder> {
    private final List<SismosLista> sismos;

    public SismosAdapter(List<SismosLista> sismos) {
        this.sismos = sismos;
    }

    @NonNull
    @Override
    public SismosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_sismos,parent,false);
        return new SismosViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SismosViewHolder holder, int position) {
        SismosLista sl = sismos.get(position);
        holder.bind(sl);

    }

    @Override
    public int getItemCount() {
        return sismos.size();
    }

    public void update(List<SismosLista> listasismos) {
        sismos.clear();
        sismos.addAll(listasismos);
        notifyDataSetChanged();
    }

    public class SismosViewHolder extends RecyclerView.ViewHolder {
        private TextView tvFechaViewHolder;
        private TextView tvLatViewHolder;
        private TextView tvProfunViewHolder;
        private TextView tvLongViewHolder;
        private TextView tvmagViewHolder;
        private TextView tvAgemViewHolder;
        private TextView tvRefGeoViewHolder;
        private TextView tvFechaUpViewHolder;


        public SismosViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFechaViewHolder = itemView.findViewById(R.id.tvfecha);
            tvLatViewHolder = itemView.findViewById(R.id.tvlatitud);
            tvProfunViewHolder = itemView.findViewById(R.id.tvprofundidad);
            tvLongViewHolder = itemView.findViewById(R.id.tvlongitud);
            tvmagViewHolder = itemView.findViewById(R.id.tvmagnitud);
            tvAgemViewHolder = itemView.findViewById(R.id.tvagencia);
            tvRefGeoViewHolder = itemView.findViewById(R.id.tvrefgeo);
            tvFechaUpViewHolder = itemView.findViewById(R.id.tvfechapudate);
        }

        public void bind(SismosLista sl) {
            tvFechaViewHolder.setText(sl.getFecha());
            tvLatViewHolder.setText(sl.getLatitud());
            tvProfunViewHolder.setText(sl.getProfundidad());
            tvLongViewHolder.setText(sl.getLongitud());
            tvmagViewHolder.setText(sl.getMagnitud());
            tvAgemViewHolder.setText(sl.getAgencia());
            tvRefGeoViewHolder.setText(sl.getRefGeografica());
            tvFechaUpViewHolder.setText(sl.getFechaUpdate());
        }
    }
}
