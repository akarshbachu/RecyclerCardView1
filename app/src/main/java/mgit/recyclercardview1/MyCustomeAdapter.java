package mgit.recyclercardview1;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by bachu_000 on 24-03-2016.
 */
public class MyCustomeAdapter extends RecyclerView.Adapter<MyCustomeAdapter.MyViewHolder> {

    Context context;
    ArrayList<Information> data;
    LayoutInflater inflater;
    int previousPosition=0;

    public MyCustomeAdapter(Context context, ArrayList<Information> data) {
        this.context=context;
        this.data=data;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public MyCustomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view=inflater.inflate(R.layout.list_item_row,parent,false);
        MyViewHolder holder=new MyViewHolder(view);//this will contain view of every row

        return holder;//we have to return myview holder object
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int position) {

        //for each row we are setting text and image
        myViewHolder.textView.setText(data.get(position).title);
        myViewHolder.imageView.setImageResource(data.get(position).imageId);

       //this code is to animation not mandatory
        if(position > previousPosition){
        //that mean we are scrolling down
            AnimationUtil.animate(myViewHolder,true);
        }
        else{
            AnimationUtil.animate(myViewHolder,false);//we are scrolling up
        }
        previousPosition=position;

        final int currentPosition=position;
        final Information infoData=data.get(position); //we are getting the current pos and passing to information, this is done to insert new data at that position
        myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Position clicked:"+position,Toast.LENGTH_SHORT).show();
                addItem(currentPosition, infoData);
            }

        });
        myViewHolder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                removeItem(infoData);
                return true;
            }
        });

    }

    private void removeItem(Information infoData) {
        int currPosition=data.indexOf(infoData);
        data.remove(currPosition);
        notifyItemRemoved(currPosition);
    }

    //this method is to add new card or duplicate and insert as new card.
    private void addItem(int position,Information infoData) {
        data.add(position,infoData); // it is going to add infoData to that position
        notifyItemInserted(position);
    }

    @Override
    public int getItemCount() {
        return data.size();//returns the size of  our data

    }

    //inner class this is the type of class which we have extended in MyCustomerAdapter class.

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.txv_row);
            imageView=(ImageView) itemView.findViewById(R.id.img_row);
        }
    }
}

