package mgit.recyclercardview1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyCustomeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        adapter=new MyCustomeAdapter(this,Data.getData());//binding recycler view with custome adapter
        recyclerView.setAdapter(adapter);//the adapter which we have created is binded with recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       switch(id){
           case R.id.linearViewHorizontal:
               LinearLayoutManager mLinearLayoutManagerHorizontal=new LinearLayoutManager(this);
               mLinearLayoutManagerHorizontal.setOrientation(LinearLayoutManager.HORIZONTAL);
               recyclerView.setLayoutManager(mLinearLayoutManagerHorizontal);
               break;
           case R.id.linearViewVertical:
               LinearLayoutManager mLinearLayoutManagerVertical=new LinearLayoutManager(this);
               mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
               recyclerView.setLayoutManager(mLinearLayoutManagerVertical);
               break;
           case R.id.gridView:
               GridLayoutManager mGridLayoutManager=new GridLayoutManager(this,2);//2 cards in a row
               recyclerView.setLayoutManager(mGridLayoutManager);
               break;
           case R.id.staggeredViewHorizontal:
               StaggeredGridLayoutManager mStaggeredLayoutManagerHorizontal=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);//2 cards in a row
               recyclerView.setLayoutManager(mStaggeredLayoutManagerHorizontal);
               break;
           case R.id.staggeredViewVertical:
               StaggeredGridLayoutManager mStaggeredLayoutManagerVertical=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);//2 cards in a row
               recyclerView.setLayoutManager(mStaggeredLayoutManagerVertical);
               break;
       }
        return super.onOptionsItemSelected(item);
    }
}
