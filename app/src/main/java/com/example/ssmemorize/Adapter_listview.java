/*package com.example.ssmemorize;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter_listview extends BaseAdapter {

    private TextView tv_english;
    private TextView tv_korean;

    ArrayList<listview_myword_item> listview_MyWord = new ArrayList<listview_myword_item>();
    // 생성자
    public Adapter_listview(){
    }

    @Override
    public int getCount() {
        return Memorize_3_3.myword_elementaryList.size();
    }

    @Override
    public Object getItem(int i) {
        return listview_MyWord.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final int pos = position;
        final Context context = viewGroup.getContext();

        // 레이아웃 listview_myword 가져오기
        if(view==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_myword,viewGroup,false);
        }

        // 화면에 표시될 view로부터 위젯에 대한 참조 획득
        tv_english = view.findViewById(R.id.tv_myword_eng);
        tv_korean = view.findViewById(R.id.tv_myword_kor);

        listview_myword_item listview = listview_MyWord.get(position);

        // 데이터 값 띄우기
        tv_english.setText(listview.getEnglish());
        tv_korean.setText(listview.getKorean());

        return view;
    }

    // 데이터 추가
    public void addItem(String eng, String kor){
        listview_myword_item item = new listview_myword_item();

        item.setEnglish(eng);
        item.setKorean(kor);

        listview_MyWord.add(item);
    }
}*/
