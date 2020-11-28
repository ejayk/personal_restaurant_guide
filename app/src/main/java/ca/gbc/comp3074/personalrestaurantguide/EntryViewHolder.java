package ca.gbc.comp3074.personalrestaurantguide;



import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class EntryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    public TextView nameTxtView, tagTxtView,addressTxtView,phoneTxtView,descriptionTxtView,ratingTxtView;
    public Button editEntry, deleteEntry;
    ItemClickListener itemClickListener;

    public EntryViewHolder(View itemView) {
        super(itemView);
        nameTxtView = (TextView) itemView.findViewById(R.id.nameTxtView);
        tagTxtView = (TextView) itemView.findViewById(R.id.tagTxtView);
        addressTxtView = (TextView) itemView.findViewById(R.id.addressTxtView);
       // phoneTxtView = (TextView) itemView.findViewById(R.id.phoneTxtView);
       // descriptionTxtView = (TextView) itemView.findViewById(R.id.descriptionTxtView);
       // ratingTxtView = (TextView) itemView.findViewById(R.id.ratingTxtView);
        deleteEntry = (Button) itemView.findViewById(R.id.deleteEntry);
        editEntry = (Button) itemView.findViewById(R.id.editEntry);
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }



/*
        nameTxtView= (TextView) itemView.findViewById(R.id.nameTxtView);

        tagTxtView= (TextView) itemView.findViewById(R.id.tagTxtView);

        editListBtn= (Button) itemView.findViewById(R.id.editEntry);
        deleteBtn=(Button)itemView.findViewById(R.id.deleteEntry);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }
}*/
}