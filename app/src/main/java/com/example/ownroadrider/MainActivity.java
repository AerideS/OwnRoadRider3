package com.example.ownroadrider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.drawerlayout.widget.DrawerLayout;


public class MainActivity extends AppCompatActivity {


    private EditText startpoint;
    private EditText endpoint;

    private ImageButton pathSearchButton;

    private ImageButton homeButton_m;
    private ImageButton categoryButton_m;
    private ImageButton mapButton;
    private ImageButton detailSearchButton_m;
    private ImageButton mypageButton_m;

    private RadioGroup themeRg; // 테마 선택 라디오 그룹
    private ImageButton landscape1;
    private ImageButton landscape2;
    private ImageButton landscape3;

    private CheckBox checkBoxSite;
    private CheckBox checkBoxMountain;
    private CheckBox checkBoxSea;

    DrawerLayout drawerLayout;
    View drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_drawer);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawer = (View)findViewById(R.id.drawer);

        Button open_btn = (Button)findViewById(R.id.sidemenu_btn);

        open_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(drawer);
            }
        });

//        Button close_btn = (Button)findViewById(btn_close);

        homeButton_m=findViewById(R.id.homeButton);

        homeButton_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //카테고리
        categoryButton_m=findViewById(R.id.categoryButton);

        categoryButton_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        //맵
        mapButton=findViewById(R.id.mapButton);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Map_view.class);
                startActivity(intent);
            }
        });

        //검색
        detailSearchButton_m=findViewById(R.id.detailSearchButton);

        detailSearchButton_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AdvancedSearchActivity.class);
                startActivity(intent);
            }
        });
        //마이페이지
        mypageButton_m=findViewById(R.id.mypageButton);

        mypageButton_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyPageActivity.class);
                startActivity(intent);
            }
        });

        startpoint = findViewById(R.id.startPointSearch);
        endpoint = findViewById(R.id.finishPointSearch);
        pathSearchButton = findViewById(R.id.pathSearchButton);

        checkBoxSite = (CheckBox)findViewById(R.id.checkBoxSite);
        checkBoxMountain = (CheckBox)findViewById(R.id.checkBoxMountain);
        checkBoxSea = (CheckBox)findViewById(R.id.checkBoxSea);

        boolean stateSite = checkBoxSite.isChecked();
        boolean stateMount = checkBoxMountain.isChecked();
        boolean stateSea = checkBoxSea.isChecked();
        boolean state[] = {stateSite,stateMount,stateSea};
        pathSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Map_search.class);
                intent.putExtra("start",startpoint.getText().toString());
                intent.putExtra("end",endpoint.getText().toString());
                intent.putExtra("state",state);
                startActivity(intent);
            }
        });

        themeRg = findViewById(R.id.themeRadioGroup);           //라디오 그룹
        landscape1 = findViewById(R.id.landscapeImageButton1);
        landscape2 = findViewById(R.id.landscapeImageButton2);
        landscape3 = findViewById(R.id.landscapeImageButton3);

        landscape1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Jinju_inform.class);
                startActivity(intent);
            }
        });
        landscape2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GoseongSangjokamDetailActivity.class);
                startActivity(intent);
            }
        });
        landscape3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChangwonDreamparkDetailActivity.class);
                startActivity(intent);
            }
        });

        themeRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {           //테마1일때 클릭 안되는 문제
            @Override                                                                           //테마1인거 밖으로 빼야 작동 잘 됨
            public void onCheckedChanged(RadioGroup radioGroup, int checked) {
                if(checked == R.id.theme1){
                    landscape1.setImageResource(R.drawable.namgang);
                    landscape2.setImageResource(R.drawable.goseong_sangjokam1);
                    landscape3.setImageResource(R.drawable.changwon_dreampark1);
                    landscape1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), Jinju_inform.class);
                            startActivity(intent);
                        }
                    });
                    landscape2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), GoseongSangjokamDetailActivity.class);
                            startActivity(intent);
                        }
                    });
                    landscape3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), ChangwonDreamparkDetailActivity.class);
                            startActivity(intent);
                        }
                    });
                }
                else if(checked == R.id.theme2){
                    landscape1.setImageResource(R.drawable.tongyeong_dongpirang);
                    landscape2.setImageResource(R.drawable.sachoen_seacablecar);
                    landscape3.setImageResource(R.drawable.hapcheon_haeinsa);
                    landscape1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), TyDprDetailActivity.class);
                            startActivity(intent);
                        }
                    });
                    landscape2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), SacheonSeaCableCarDetailActivity.class);
                            startActivity(intent);
                        }
                    });
                    landscape3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), HapcheonHaeinsaDetailActivity.class);
                            startActivity(intent);
                        }
                    });
                } else if (checked==R.id.theme3) {
                    landscape1.setImageResource(R.drawable.geoje_wind1);
                    landscape2.setImageResource(R.drawable.gimhae_surowang1);
                    landscape3.setImageResource(R.drawable.hadong_samsunggung1);
                    landscape1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), GeojeWindDetailActivity.class);
                            startActivity(intent);
                        }
                    });
                    landscape2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), GimhaeSurowangDetailActivity.class);
                            startActivity(intent);
                        }
                    });
                    landscape3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), HadongSamsunggungDetailActivity.class);
                            startActivity(intent);
                        }
                    });
                } else if (checked==R.id.theme4) {
                    landscape1.setImageResource(R.drawable.haman_mujinjeong1);
                    landscape2.setImageResource(R.drawable.miryang_lotus1);
                    landscape3.setImageResource(R.drawable.namhae_boriam1);
                    landscape1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), HamanMujinjeongDetailActivity.class);
                            startActivity(intent);
                        }
                    });
                    landscape2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), MiryangLotusDetailActivity.class);
                            startActivity(intent);
                        }
                    });
                    landscape3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), NamhaeBoriamDetailActivity.class);
                            startActivity(intent);
                        }
                    });
                }
            }
        });

    }

    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };

}