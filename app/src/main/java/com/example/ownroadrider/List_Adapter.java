package com.example.ownroadrider;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class List_Adapter extends BaseAdapter{
    Context context;
    LayoutInflater layoutInflater;
    static ArrayList<String> data;

    private String[] vertex = {"창원", "진주", "통영", "사천", "김해","밀양", "거제", "양산", "의령",
            "함양", "창녕", "고성", "남해", "하동", "산청", "함안", "거창", "합천"};

    public int stringToInt(String s) {              // String to Int
        int x = 0;
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i].equals(s)) x = i;
        }
        return x;
    }



    double[][] region_position = {
            {35.1320, 128.7163},        //창원
            {35.1805, 128.1087},        //진주
            {34.8497, 128.4339},        //통영
            {35.0903, 128.0705},        //사천
            {35.2332, 128.8819},        //김해
            {35.4913, 128.7481},        //밀양
            {34.8918, 128.6206},        //거제
            {35.3385, 129.0265},        //양산
            {35.3227, 128.2878},        //의령
            {35.5202, 127.7259},        //함양
            {35.5414, 128.5004},        //창녕
            {34.9754, 128.3234},        //고성
            {34.8953, 127.8828},        //남해
            {35.0642, 127.7556},        //하동
            {35.4138, 127.8741},        //산청
            {35.2795, 128.4075},        //함안
            {35.6875, 127.9056},        //거창
            {35.5667, 128.1684}         //합천
    };
    String[] url_city={"%ec%b0%bd%ec%9b%90","%ec%a7%84%ec%a3%bc","%ED%86%B5%EC%98%81","%EC%82%AC%EC%B2%9C","%EA%B9%80%ED%95%B4","%EB%B0%80%EC%96%91","%EA%B1%B0%EC%A0%9C"
    ,"%EC%96%91%EC%82%B0","%EC%9D%98%EB%A0%B9","%ED%95%A8%EC%96%91","%ED%95%A8%EC%96%91","%EA%B3%A0%EC%84%B1","%EB%82%A8%ED%95%B4","%ED%95%98%EB%8F%99","%EC%82%B0%EC%B2%AD",
            "%ED%95%A8%EC%95%88","%EA%B1%B0%EC%B0%BD","%ED%95%A9%EC%B2%9C"};


    public List_Adapter(Context context, ArrayList<String> data){
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.tour_list, null);

        TextView title = view.findViewById(R.id.title);
        title.setText(data.get(position));

        Button find_route_d = view.findViewById(R.id.find_route);
        Button find_inform = view.findViewById(R.id.find_inform);
        title.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });

        if(title.getText().toString().equals("길찾기")){
            find_route_d.setText("길찾기");
            find_inform.setVisibility(View.INVISIBLE);

        }
        find_route_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                //길찾기 버튼
                String item =data.get(position);
                Intent intent;
                String url;
                String url_s;
                List<ResolveInfo> list;
                switch (item){
                    case"창원":
                        url = "nmap://actionPath?parameter=value&appname=ownroadrider";

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

                        list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                        if (list == null || list.isEmpty()) {
                            try {
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("nmap://navigation?dlat=35.1322&dlng=128.7167&dname=%ec%b0%bd%ec%9b%90+%eb%93%9c%eb%a6%bc%ed%8c%8c%ed%81%ac&appname=com.example.ownroadrider")));
                            }catch (Exception e){
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                            }
                        } else {
                            context.startActivity(intent);
                        }
                        break;
                    case"진주":
                         url = "nmap://actionPath?parameter=value&appname=ownroadrider";

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

                        list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                        if (list == null || list.isEmpty()) {
                            try {
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("nmap://navigation?dlat=35.1887&dlng=128.0765&dname=%ec%a7%84%ec%a3%bc%ec%84%b1&appname=com.example.ownroadrider")));
                            } catch (Exception e){
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                            }
                        } else {
                            context.startActivity(intent);
                        }
                        break;
                    case"통영":
                        url = "nmap://actionPath?parameter=value&appname=ownroadrider";

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

                        list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                        if (list == null || list.isEmpty()) {
                            try{
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("nmap://navigation?dlat=34.8446&dlng=128.4258&dname=%%eb%8f%99%ed%94%bc%eb%9e%91&appname=com.example.ownroadrider")));
                            }catch (Exception e){
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                            }
                        } else {
                            context.startActivity(intent);
                        }
                        break;
                    case"사천":
                        url = "nmap://actionPath?parameter=value&appname=ownroadrider";

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

                        list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                        if (list == null || list.isEmpty()) {
                            try{
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("nmap://navigation?dlat=34.9337&dlng=128.0532&dname=%ec%82%ac%ec%b2%9c+%ed%95%b4%ec%83%81%ec%bc%80%ec%9d%b4%eb%b8%94%ec%b9%b4%0d%0a&appname=com.example.ownroadrider")));
                            } catch (Exception e){
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                            }
                        } else {
                            context.startActivity(intent);
                        }
                        break;
                    case"김해":
                         url = "nmap://actionPath?parameter=value&appname=ownroadrider";

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

                        list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                        if (list == null || list.isEmpty()) {
                            try{
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("nmap://navigation?dlat=35.2353&dlng=128.8783&dname=%ec%88%98%eb%a1%9c%ec%99%95%eb%a6%89&appname=com.example.ownroadrider")));
                            } catch (Exception e){
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                            }
                        } else {
                            context.startActivity(intent);
                        }
                        break;
                    case"밀양":
                        url = "nmap://actionPath?parameter=value&appname=ownroadrider";

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

                        list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                        if (list == null || list.isEmpty()) {
                            try{
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("nmap://navigation?dlat=35.5328&dlng=128.7029&dname=%eb%b0%80%ec%96%91+%ec%97%b0%ea%bd%83%eb%a7%88%ec%9d%84&appname=com.example.ownroadrider")));
                            } catch (Exception e){
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                            }
                        } else {
                            context.startActivity(intent);
                        }
                        break;
                    case"거제":
                        url = "nmap://actionPath?parameter=value&appname=ownroadrider";

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

                        list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                        if (list == null || list.isEmpty()) {
                            try{
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("nmap://navigation?dlat=34.7745&dlng=128.6632&dname=%eb%b0%94%eb%9e%8c%ec%9d%98+%ec%96%b8%eb%8d%95%0d%0a%0d%0a&appname=com.example.ownroadrider")));
                            } catch (Exception e){
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                            }
                        } else {
                            context.startActivity(intent);
                        }
                        break;
                    case"양산":
                        url = "nmap://actionPath?parameter=value&appname=ownroadrider";

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

                        list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                        if (list == null || list.isEmpty()) {
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                        } else {
                            context.startActivity(intent);
                        }
                        break;
                    case"의령":
                        url = "nmap://actionPath?parameter=value&appname=ownroadrider";

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

                        list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                        if (list == null || list.isEmpty()) {
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                        } else {
                            context.startActivity(intent);
                        }
                        break;
                    case"함양":
                        url = "nmap://actionPath?parameter=value&appname=ownroadrider";

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

                        list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                        if (list == null || list.isEmpty()) {
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                        } else {
                            context.startActivity(intent);
                        }
                        break;
                    case"창녕":
                        url = "nmap://actionPath?parameter=value&appname=ownroadrider";

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

                        list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                        if (list == null || list.isEmpty()) {
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                        } else {
                            context.startActivity(intent);
                        }
                        break;
                    case"고성":
                        url = "nmap://actionPath?parameter=value&appname=ownroadrider";

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

                        list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                        if (list == null || list.isEmpty()) {
                            try {
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("nmap://navigation?dlat=34.908&dlng=128.1486&dname=%ea%b3%a0%ec%84%b1+%ea%b3%b5%eb%a3%a1%eb%b0%95%eb%ac%bc%ea%b4%80&appname=com.example.ownroadrider")));
                            } catch (Exception e){
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                            }
                        } else {
                            context.startActivity(intent);
                        }
                        break;
                    case"남해":
                        url = "nmap://actionPath?parameter=value&appname=ownroadrider";

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

                        list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                        if (list == null || list.isEmpty()) {
                            try {
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("nmap://navigation?dlat=34.7518&dlng=127.9824&dname=%eb%82%a8%ed%95%b4+%eb%b3%b4%eb%a6%ac%ec%95%94&appname=com.example.ownroadrider")));
                            } catch (Exception e){
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                            }
                        } else {
                            context.startActivity(intent);
                        }
                        break;
                    case"하동":
                        url = "nmap://actionPath?parameter=value&appname=ownroadrider";

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

                        list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                        if (list == null || list.isEmpty()) {
                            try{
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("nmap://navigation?dlat=35.2409&dlng=127.7013&dname=%ed%95%98%eb%8f%99+%ec%82%bc%ec%84%b1%ea%b6%81&appname=com.example.ownroadrider")));
                            } catch (Exception e){
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                            }
                        } else {
                            context.startActivity(intent);
                        }
                        break;
                    case"산청":
                        url = "nmap://actionPath?parameter=value&appname=ownroadrider";

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

                        list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                        if (list == null || list.isEmpty()) {
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                        } else {
                            context.startActivity(intent);
                        }
                        break;
                    case"함안":
                        url = "nmap://actionPath?parameter=value&appname=ownroadrider";

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

                        list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                        if (list == null || list.isEmpty()) {
                            try{
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("nmap://navigation?dlat=35.2554&dlng=128.4230&dname=%ed%95%a8%ec%95%88+%eb%ac%b4%ec%a7%84%ec%a0%95&appname=com.example.ownroadrider")));
                            }catch (Exception e){
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                            }
                        } else {
                            context.startActivity(intent);
                        }
                        break;
                    case"거창":
                        url = "nmap://actionPath?parameter=value&appname=ownroadrider";

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

                        list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                        if (list == null || list.isEmpty()) {
                            try{
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("nmap://navigation?dlat=35.8570&dlng=127.7463&dname=%ea%b1%b0%ec%b0%bd+%eb%8d%95%ec%9c%a0%ec%82%b0&appname=com.example.ownroadrider")));
                            }catch (Exception e){
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                            }
                        } else {
                            context.startActivity(intent);
                        }
                        break;
                    case"합천":
                        url = "nmap://actionPath?parameter=value&appname=ownroadrider";

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);

                        list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                        if (list == null || list.isEmpty()) {
                            try{
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("nmap://navigation?dlat=35.8006&dlng=128.0974&dname=%ed%95%b4%ec%9d%b8%ec%82%ac%0d%0a&appname=com.example.ownroadrider")));
                            }catch (Exception e){
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                            }
                        } else {
                            context.startActivity(intent);
                        }
                        break;
                    case "길찾기":
                        int rot_num=data.size()-2;
                        switch(rot_num){
                            case 1:
                                url = "nmap://actionPath?parameter=value&appname=ownroadrider";
                                url_s="nmap://navigation?v1lat="+
                                        String.valueOf(region_position[stringToInt(data.get(position-2))][0])
                                        +"&v1lng="+String.valueOf(region_position[stringToInt(data.get(position-2))][1])+"&v1name="
                                        +url_city[stringToInt(data.get(position-2))]+"&dlat="+
                                        String.valueOf(region_position[stringToInt(data.get(position-1))][0])
                                        +"&dlng="+String.valueOf(region_position[stringToInt(data.get(position-1))][1])+"&dname="
                                        +url_city[stringToInt(data.get(position-1))]+"&appname=com.example.ownroadrider";

                                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                                intent.addCategory(Intent.CATEGORY_BROWSABLE);

                                list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                                if (list == null || list.isEmpty()) {
                                    try{
                                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url_s)));
                                    }catch (Exception e){
                                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                                    }
                                } else {
                                    context.startActivity(intent);
                                }
                                break;
                            case 2:
                                url = "nmap://actionPath?parameter=value&appname=ownroadrider";
                                url_s="nmap://navigation?v1lat="+
                                        String.valueOf(region_position[stringToInt(data.get(position-3))][0])
                                        +"&v1lng="+String.valueOf(region_position[stringToInt(data.get(position-3))][1])+"&v1name="
                                        +url_city[stringToInt(data.get(position-3))]+"&v2lat"+
                                        String.valueOf(region_position[stringToInt(data.get(position-2))][0])
                                        +"&v2lng="+String.valueOf(region_position[stringToInt(data.get(position-2))][1])+"&v2name="
                                        +url_city[stringToInt(data.get(position-2))]+
                                        "&dlat="+
                                        String.valueOf(region_position[stringToInt(data.get(position-1))][0])
                                        +"&dlng="+String.valueOf(region_position[stringToInt(data.get(position-1))][1])+"&dname="
                                        +url_city[stringToInt(data.get(position-1))]+"&appname=com.example.ownroadrider";

                                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                                intent.addCategory(Intent.CATEGORY_BROWSABLE);

                                list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                                if (list == null || list.isEmpty()) {
                                    try{
                                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url_s)));
                                    }catch (Exception e){
                                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                                    }
                                } else {
                                    context.startActivity(intent);
                                }
                                break;
                            case 3:
                                url = "nmap://actionPath?parameter=value&appname=ownroadrider";
                                url_s="nmap://navigation?v1lat="+
                                        String.valueOf(region_position[stringToInt(data.get(position-4))][0])
                                        +"&v1lng="+String.valueOf(region_position[stringToInt(data.get(position-4))][1])+"&v1name="
                                        +url_city[stringToInt(data.get(position-4))]+"&v2lat"+
                                        String.valueOf(region_position[stringToInt(data.get(position-3))][0])
                                        +"&v2lng="+String.valueOf(region_position[stringToInt(data.get(position-3))][1])+"&v2name="
                                        +url_city[stringToInt(data.get(position-3))]+
                                        "&v3lat="+String.valueOf(region_position[stringToInt(data.get(position-2))][0])
                                        +"&v3lng="+String.valueOf(region_position[stringToInt(data.get(position-2))][1])+"&v3name="
                                        +url_city[stringToInt(data.get(position-2))]+
                                        "&dlat="+
                                        String.valueOf(region_position[stringToInt(data.get(position-1))][0])
                                        +"&dlng="+String.valueOf(region_position[stringToInt(data.get(position-1))][1])+"&dname="
                                        +url_city[stringToInt(data.get(position-1))]+"&appname=com.example.ownroadrider";

                                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                                intent.addCategory(Intent.CATEGORY_BROWSABLE);

                                list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                                if (list == null || list.isEmpty()) {
                                    try{
                                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url_s)));
                                    }catch (Exception e){
                                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                                    }
                                } else {
                                    context.startActivity(intent);
                                }
                                break;
                            case 4:
                                url = "nmap://actionPath?parameter=value&appname=ownroadrider";
                                url_s="nmap://navigation?v1lat="+
                                        String.valueOf(region_position[stringToInt(data.get(position-5))][0])
                                        +"&v1lng="+String.valueOf(region_position[stringToInt(data.get(position-5))][1])+"&v1name="
                                        +url_city[stringToInt(data.get(position-5))]+"&v2lat"+
                                        String.valueOf(region_position[stringToInt(data.get(position-4))][0])
                                        +"&v2lng="+String.valueOf(region_position[stringToInt(data.get(position-4))][1])+"&v2name="
                                        +url_city[stringToInt(data.get(position-4))]+
                                        "&v3lat="+String.valueOf(region_position[stringToInt(data.get(position-3))][0])
                                        +"&v3lng="+String.valueOf(region_position[stringToInt(data.get(position-3))][1])+"&v3name="
                                        +url_city[stringToInt(data.get(position-3))]+
                                        "&v4lat="+ String.valueOf(region_position[stringToInt(data.get(position-2))][0])
                                        +"&v4lng="+String.valueOf(region_position[stringToInt(data.get(position-2))][1])+"&v4name="
                                        +url_city[stringToInt(data.get(position-2))]+"&dlat"+
                                        String.valueOf(region_position[stringToInt(data.get(position-1))][0])
                                        +"&dlng="+String.valueOf(region_position[stringToInt(data.get(position-1))][1])+"&dname="
                                        +url_city[stringToInt(data.get(position-1))]+"&appname=com.example.ownroadrider";

                                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                                intent.addCategory(Intent.CATEGORY_BROWSABLE);

                                list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                                if (list == null || list.isEmpty()) {
                                    try{
                                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url_s)));
                                    }catch (Exception e){
                                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap")));
                                    }
                                } else {
                                    context.startActivity(intent);
                                }
                                break;
                        }

                    default:
                        throw new IllegalStateException("Unexpected value: " + item);
                }
                }

        });

        find_inform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item =data.get(position);
                Intent intent;
                String url;
                List<ResolveInfo> list;
                switch (item){
                    case"창원":
                        intent=new Intent(view.getContext(),ChangwonDreamparkDetailActivity.class);
                        context.startActivity(intent);
                        break;
                    case"진주":
                        intent=new Intent(view.getContext(),Jinju_detail.class);
                        context.startActivity(intent);
                        break;
                    case"통영":
                        intent=new Intent(view.getContext(), TongyeongDongpirangDetailActivity.class);
                        context.startActivity(intent);
                        break;
                    case"사천":
                        intent=new Intent(view.getContext(),SacheonSeaCableCarDetailActivity.class);
                        context.startActivity(intent);
                        break;
                    case"김해":
                        intent=new Intent(view.getContext(),GimhaeSurowangDetailActivity.class);
                        context.startActivity(intent);
                        break;
                    case"밀양":
                        intent=new Intent(view.getContext(),MiryangLotusDetailActivity.class);
                        context.startActivity(intent);
                        break;
                    case"거제":
                        intent=new Intent(view.getContext(),GeojeWindDetailActivity.class);
                        context.startActivity(intent);
                        break;
                    case"양산":
                        break;
                    case"의령":
                        break;
                    case"함양":
                        break;
                    case"창녕":
                        break;
                    case"고성":
                        intent=new Intent(view.getContext(),GoseongDinoDetailActivity.class);
                        context.startActivity(intent);
                        break;
                    case"남해":
                        intent=new Intent(view.getContext(),NamhaeBoriamDetailActivity.class);
                        context.startActivity(intent);
                        break;
                    case"하동":
                        intent=new Intent(view.getContext(),HadongSamsunggungDetailActivity.class);
                        context.startActivity(intent);
                        break;
                    case"산청":
                        break;
                    case"함안":
                        intent=new Intent(view.getContext(),HamanMujinjeongDetailActivity.class);
                        context.startActivity(intent);
                        break;
                    case"거창":
                        intent=new Intent(view.getContext(),GeochangNamduckDetailActivity.class);
                        context.startActivity(intent);
                        break;
                    case"합천":
                        intent=new Intent(view.getContext(),HapcheonHaeinsaDetailActivity.class);
                        context.startActivity(intent);
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + item);
                }
            }


        });

        return view;
    }


}
