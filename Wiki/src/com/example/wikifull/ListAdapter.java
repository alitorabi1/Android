package com.example.wikifull;


import java.util.List;
import com.Reference.wikifull.R;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {

	private final String TAG = "*** ListAdapter ***";
	
	private LayoutInflater myInflater;
	private List<dbcontact> list;
	
	public ListAdapter(Context context) {
		myInflater = LayoutInflater.from(context);
		
		Log.i(TAG, "Adapter setuped successfully.");
		
	}
	
	public void setData(List<dbcontact> list) {
		this.list = list;
		
		Log.i(TAG, "Data passed to the adapter.");
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;        
		
		
		
		if (convertView == null) {
        	convertView 	= myInflater.inflate(R.layout.row, null);
        	holder 			= new ViewHolder();
        	
        	holder.tvId 	= (TextView) convertView.findViewById(R.id.row_id);	
        	
			holder.tvName  	= (TextView) convertView.findViewById(R.id.row_name);
			holder.tvmode 	= (TextView) convertView.findViewById(R.id.row_mode);
			holder.tvlink 	= (TextView) convertView.findViewById(R.id.row_link);
			holder.tvmatn 	= (TextView) convertView.findViewById(R.id.row_matn);
			holder.tvrez 	= (TextView) convertView.findViewById(R.id.row_rez);
			convertView.setTag(holder);
        } else {
        	holder = (ViewHolder) convertView.getTag();
        }
		
		holder.tvId.setText(list.get(position).getIdInString());
		holder.tvName.setText(list.get(position).getname());
		holder.tvmode.setText(list.get(position).getmode());
		holder.tvlink.setText(list.get(position).getlink());
		holder.tvmatn.setText(list.get(position).getmatn());
		holder.tvrez.setText(list.get(position).getrez());
		return convertView;
	}

	static class ViewHolder {
    	TextView tvId;
    	TextView tvName;
    	TextView tvmode;
    	TextView tvlink;
    	TextView tvmatn;
    	TextView tvrez;
    	
    }

}
