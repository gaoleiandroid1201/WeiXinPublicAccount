package com.gaolei.weinxinpublicaccount;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class WXMessageAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<WXMessageObject> list;

    public WXMessageAdapter(List<WXMessageObject> list, Context context) {
        inflater = LayoutInflater.from(context);
        this.list=list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.wxmessage_item, null);
            holder.message_title = (TextView) convertView
                    .findViewById(R.id.message_title);
            holder.message_digest = (TextView) convertView
                    .findViewById(R.id.message_digest);
            holder.message_time = (TextView) convertView
                    .findViewById(R.id.message_time);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (list.size() > 0) {
            final WXMessageObject object = list.get(position);
            holder.message_title.setText(object.getContent().news_item.get(0).getTitle());
            holder.message_digest.setText(object.getContent().news_item.get(0).getDigest());
            Log.d("gaolei", "object.getUpdate_time()----------------------" + object.getUpdate_time());
            //从微信服务器返回的时间为秒 所以*1000转化为毫秒
            holder.message_time.setText(CommonUtils.getUtilInstance()
                    .transformMillisToDate(object.getUpdate_time()*1000));

        }
        return convertView;

    }

    class ViewHolder {
        TextView message_title,message_digest,message_time;
    }
}