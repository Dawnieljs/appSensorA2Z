package dev.br.daniel.ifsc.sensora2z.ui.cadsensora2z;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import dev.br.daniel.ifsc.sensora2z.databinding.FragmentConSensorA2zBinding;
import dev.br.daniel.ifsc.sensora2z.model.SensorA2Z;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link SensorA2Z}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ConSensorAZRecyclerViewAdapter extends RecyclerView.Adapter<ConSensorAZRecyclerViewAdapter.ViewHolder> {

    private final List<SensorA2Z> mValues;

    public ConSensorAZRecyclerViewAdapter(List<SensorA2Z> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentConSensorA2zBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getSerie());
        holder.mContentView.setText(mValues.get(position).getMarca());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public SensorA2Z mItem;

        public ViewHolder(FragmentConSensorA2zBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}