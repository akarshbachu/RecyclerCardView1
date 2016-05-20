package mgit.recyclercardview1;

import java.util.ArrayList;

/**
 * Created by bachu_000 on 24-03-2016.
 */
public class Data {
    public static ArrayList<Information> getData(){
        ArrayList<Information> data=new ArrayList<Information>();
        int[] images={
                R.drawable.asp,
                R.drawable.cplusplus,
                R.drawable.cprogramming,
                R.drawable.chash,
                R.drawable.codeicon,
                R.drawable.codeicon2,
                R.drawable.java,
                R.drawable.js,
                R.drawable.php,
                R.drawable.python
        };
        String[] Categories={"asp","cplusplus","cprogramming","chash","codeicon","codeicon2","java","js","php","python"};
        for(int i=0;i< images.length;i++){
            Information current=new Information();
            current.title=Categories[i];
            current.imageId=images[i];
            data.add(current);
        }
        return data;
    }
}
