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

        find_route_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                //길찾기 버튼
                String item =data.get(position);
                Intent intent;
                String url;
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
