package com.example.ownroadrider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.drawerlayout.widget.DrawerLayout;


public class MainActivity extends AppCompatActivity {


    private EditText startpoint;
    private EditText endpoint;

    private ImageButton pathSearchButton;

    private ImageButton homeButton_m;
    private ImageButton mapButton;
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

        homeButton_m=findViewById(R.id.homeButton);

        homeButton_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
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


        pathSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Map_search.class);
                intent.putExtra("start",startpoint.getText().toString());
                intent.putExtra("end",endpoint.getText().toString());
                boolean stateSite = checkBoxSite.isChecked();
                boolean stateMount = checkBoxMountain.isChecked();
                boolean stateSea = checkBoxSea.isChecked();
                boolean state[] = {stateSite,stateMount,stateSea};
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
                Intent intent = new Intent(getApplicationContext(), Jinju_detail.class);
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
                            Intent intent = new Intent(getApplicationContext(), Jinju_detail.class);
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
                            Intent intent = new Intent(getApplicationContext(), TongyeongDongpirangDetailActivity.class);
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

        // 좌상단 카테고리 버튼 선택 시 표시되는 사이드 메뉴에 관한 코드부

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);  //드로어레이아웃 선택을 통해 작동
        drawer = (View)findViewById(R.id.drawer);

        ImageButton openBtn = (ImageButton)findViewById(R.id.sidemenu_btn);  // 사이드메뉴 열기 버튼

        openBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(drawer);
            }
        });

        Button closeBtn = (Button)findViewById(R.id.btn_close);  //사이드메뉴 닫기

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(drawer);
            }
        });

        // 창원
        Button btnChangwon = findViewById(R.id.side_btn_changwon);
        Button btnChangwonDream = findViewById(R.id.side_btn_changwon_dream);
        Button btnChangwonQwai = findViewById(R.id.side_btn_changwon_qwai);
        Button btnChangwonSokuri = findViewById(R.id.side_btn_changwon_sokuri);
        final boolean[] btnCwVisible = {false};
        btnChangwon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnCwVisible[0]){
                    btnChangwonDream.setVisibility(View.GONE);
                    btnChangwonQwai.setVisibility(View.GONE);
                    btnChangwonSokuri.setVisibility(View.GONE);
                    btnCwVisible[0] = false;
                }
                else{
                    btnChangwonDream.setVisibility(View.VISIBLE);
                    btnChangwonQwai.setVisibility(View.VISIBLE);
                    btnChangwonSokuri.setVisibility(View.VISIBLE);
                    btnCwVisible[0] = true;
                }
            }
        });

        btnChangwonDream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChangwonDreamparkDetailActivity.class);
                startActivity(intent);
            }
        });
        btnChangwonQwai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChangwonQwaiDetailActivity.class);
                startActivity(intent);
            }
        });
        btnChangwonSokuri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChangwonSokuriDetailActivity.class);
                startActivity(intent);
            }
        });

        //진주
        Button btnJinju = findViewById(R.id.side_btn_jinju);
        Button btnJinjuNamgang = findViewById(R.id.side_btn_jinju_namgang);
        Button btnJinjuGeumho = findViewById(R.id.side_btn_jinju_geumhoji);
        Button btnJinjuJinyang = findViewById(R.id.side_btn_jinju_jinyangho);
        final boolean[] jinjuVisible = {false};

        btnJinju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(jinjuVisible[0]){
                    btnJinjuGeumho.setVisibility(View.GONE);
                    btnJinjuJinyang.setVisibility(View.GONE);
                    btnJinjuNamgang.setVisibility(View.GONE);
                    jinjuVisible[0] = false;
                }
                else{
                    btnJinjuGeumho.setVisibility(View.VISIBLE);
                    btnJinjuNamgang.setVisibility(View.VISIBLE);
                    btnJinjuJinyang.setVisibility(View.VISIBLE);
                    jinjuVisible[0] = true;
                }
            }
        });
        btnJinjuNamgang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Jinju_detail.class);
                startActivity(i);
            }
        });
        btnJinjuGeumho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),JinjuGeumhojiDetailActivity.class);
                startActivity(i);
            }
        });
        btnJinjuJinyang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),JinjuJinyanghoDetailActivity.class);
                startActivity(i);
            }
        });

        //창녕
        Button btnChangnyeong = findViewById(R.id.side_btn_changnyeong);
        Button btnChangnyeongHwawang = findViewById(R.id.side_btn_changnyeong_hwawang);
        Button btnChangnyeongManok = findViewById(R.id.side_btn_changnyeong_manok);
        Button btnChangnyeongUpo = findViewById(R.id.side_btn_changnyeong_upo);
        final boolean changnyeongVisible[] = {false};

        btnChangnyeong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(changnyeongVisible[0]){
                    btnChangnyeongHwawang.setVisibility(View.GONE);
                    btnChangnyeongManok.setVisibility(View.GONE);
                    btnChangnyeongUpo.setVisibility(View.GONE);
                    changnyeongVisible[0] = false;
                }
                else{
                    btnChangnyeongHwawang.setVisibility(View.VISIBLE);
                    btnChangnyeongManok.setVisibility(View.VISIBLE);
                    btnChangnyeongUpo.setVisibility(View.VISIBLE);
                    changnyeongVisible[0] = true;
                }
            }
        });
        btnChangnyeongHwawang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ChangnyeongHwawangDetailActivity.class);
                startActivity(i);
            }
        });
        btnChangnyeongManok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ChangnyeongManokDetailActivity.class);
                startActivity(i);
            }
        });
        btnChangnyeongUpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ChangnyeongUpoDetailActivity.class);
                startActivity(i);
            }
        });

        //거창
        Button btnGeochang = findViewById(R.id.side_btn_geochang);
        Button btnGeochangNam = findViewById(R.id.side_btn_geochang_namduck);
        Button btnGeochangSu = findViewById(R.id.side_btn_geochang_susung);
        Button btnGeochangWol = findViewById(R.id.side_btn_geochang_wolsung);
        final boolean[] geochangVisible = {false};

        btnGeochang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(geochangVisible[0]){
                    btnGeochangNam.setVisibility(View.GONE);
                    btnGeochangSu.setVisibility(View.GONE);
                    btnGeochangWol.setVisibility(View.GONE);
                    geochangVisible[0] = false;
                }
                else{
                    btnGeochangNam.setVisibility(View.VISIBLE);
                    btnGeochangSu.setVisibility(View.VISIBLE);
                    btnGeochangWol.setVisibility(View.VISIBLE);
                    geochangVisible[0] = true;
                }
            }
        });
        btnGeochangNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),GeochangNamduckDetailActivity.class);
                startActivity(i);
            }
        });
        btnGeochangSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),GeochangSuseungDetailActivity.class);
                startActivity(i);
            }
        });
        btnGeochangWol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),GeochangWolseongDetailActivity.class);
                startActivity(i);
            }
        });

        //거제
        Button btnGeoje = findViewById(R.id.side_btn_geoje);
        Button btnGeojeBlack = findViewById(R.id.side_btn_geoje_black);
        Button btnGeojeMaemi = findViewById(R.id.side_btn_geoje_maemi);
        Button btnGeojeWind = findViewById(R.id.side_btn_geoje_wind);
        final boolean[] geojeVisible = {false};

        btnGeoje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(geojeVisible[0]){
                    btnGeojeBlack.setVisibility(View.GONE);
                    btnGeojeWind.setVisibility(View.GONE);
                    btnGeojeMaemi.setVisibility(View.GONE);
                    geojeVisible[0] = false;
                }
                else{
                    btnGeojeBlack.setVisibility(View.VISIBLE);
                    btnGeojeWind.setVisibility(View.VISIBLE);
                    btnGeojeMaemi.setVisibility(View.VISIBLE);
                    geojeVisible[0] = true;
                }
            }
        });
        btnGeojeBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),GeojeBlackrockDetailActivity.class);
                startActivity(i);
            }
        });
        btnGeojeWind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),GeojeWindDetailActivity.class);
                startActivity(i);
            }
        });
        btnGeojeMaemi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),GeojeMaemiDetailActivity.class);
                startActivity(i);
            }
        });

        //김해
        Button btnGimhae = findViewById(R.id.side_btn_gimhae);
        Button btnGimSuro = findViewById(R.id.side_btn_gimhae_suro);
        Button btnGimGa = findViewById(R.id.side_btn_gimhae_gaya);
        Button btnGimYeon = findViewById(R.id.side_btn_gimhae_yeonji);
        final boolean[] gimhaeVisible = {false};

        btnGimhae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gimhaeVisible[0]){
                    btnGimGa.setVisibility(View.GONE);
                    btnGimSuro.setVisibility(View.GONE);
                    btnGimYeon.setVisibility(View.GONE);
                    gimhaeVisible[0] = false;
                }
                else{
                    btnGimGa.setVisibility(View.VISIBLE);
                    btnGimSuro.setVisibility(View.VISIBLE);
                    btnGimYeon.setVisibility(View.VISIBLE);
                    gimhaeVisible[0] = true;
                }
            }
        });
        btnGimGa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),GimheaGayaDetailActivity.class);
                startActivity(i);
            }
        });
        btnGimYeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),GimheaYeonjiDetailActivity.class);
                startActivity(i);
            }
        });
        btnGimSuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),GimhaeSurowangDetailActivity.class);
                startActivity(i);
            }
        });

        //고성
        Button btnGoseong = findViewById(R.id.side_btn_goseong);
        Button btnGoseongDino = findViewById(R.id.side_btn_goseong_dino);
        Button btnGoseongMunsu = findViewById(R.id.side_btn_goseong_munsu);
        Button btnGoseongSang = findViewById(R.id.side_btn_goseong_sangjokam);
        final boolean[] goseongVisible = {false};

        btnGoseong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(goseongVisible[0]){
                    btnGoseongDino.setVisibility(View.GONE);
                    btnGoseongMunsu.setVisibility(View.GONE);
                    btnGoseongSang.setVisibility(View.GONE);
                    goseongVisible[0] = false;
                }
                else{
                    btnGoseongDino.setVisibility(View.VISIBLE);
                    btnGoseongSang.setVisibility(View.VISIBLE);
                    btnGoseongMunsu.setVisibility(View.VISIBLE);
                    goseongVisible[0] = true;
                }
            }
        });
        btnGoseongDino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),GoseongDinoDetailActivity.class);
                startActivity(i);
            }
        });
        btnGoseongSang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),GoseongSangjokamDetailActivity.class);
                startActivity(i);
            }
        });
        btnGoseongMunsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),GoseongMunsuDetailActivity.class);
                startActivity(i);
            }
        });

        //함안
        Button btnHaman = findViewById(R.id.side_btn_haman);
        Button btnHamanHam = findViewById(R.id.side_btn_haman_hamju);
        Button btnHamanIp = findViewById(R.id.side_btn_haman_ipgok);
        Button btnHamanMujin = findViewById(R.id.side_btn_haman_mujin);
        final boolean[] hamanVisible = {false};

        btnHaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hamanVisible[0]){
                    btnHamanHam.setVisibility(View.GONE);
                    btnHamanIp.setVisibility(View.GONE);
                    btnHamanMujin.setVisibility(View.GONE);
                    hamanVisible[0] = false;
                }
                else{
                    btnHamanHam.setVisibility(View.VISIBLE);
                    btnHamanIp.setVisibility(View.VISIBLE);
                    btnHamanMujin.setVisibility(View.VISIBLE);
                    hamanVisible[0] = true;
                }
            }
        });
        btnHamanMujin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),HamanMujinjeongDetailActivity.class);
                startActivity(i);
            }
        });
        btnHamanIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),HamanIpgokDetailActivity.class);
                startActivity(i);
            }
        });
        btnHamanHam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),HamanHamjuDetailActivity.class);
                startActivity(i);
            }
        });

        //하동
        Button btnHadong = findViewById(R.id.side_btn_hadong);
        Button btnHadongChoi = findViewById(R.id.side_btn_hadong_choi);
        Button btnHadongSsg = findViewById(R.id.side_btn_hadong_ssg);
        Button btnHadongSong = findViewById(R.id.side_btn_hadong_songrim);
        final boolean[] hadongVisible = {false};

        btnHadong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hadongVisible[0]){
                    btnHadongChoi.setVisibility(View.GONE);
                    btnHadongSsg.setVisibility(View.GONE);
                    btnHadongSong.setVisibility(View.GONE);
                    hadongVisible[0] = false;
                }
                else{
                    btnHadongChoi.setVisibility(View.VISIBLE);
                    btnHadongSong.setVisibility(View.VISIBLE);
                    btnHadongSsg.setVisibility(View.VISIBLE);
                    hadongVisible[0] = true;
                }
            }
        });
        btnHadongChoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),HadongChoiDetailActivity.class);
                startActivity(i);
            }
        });
        btnHadongSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),HadongSongrimDetailActivity.class);
                startActivity(i);
            }
        });
        btnHadongSsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),HadongSamsunggungDetailActivity.class);
                startActivity(i);
            }
        });

        //함양
        Button btnHamyang = findViewById(R.id.side_btn_hamyang);
        Button btnHamNam = findViewById(R.id.side_btn_hamyang_namgye);
        Button btnHamSang = findViewById(R.id.side_btn_hamyang_sangrim);
        Button btnHamSeo = findViewById(R.id.side_btn_hamyang_seoam);
        final boolean[] hamyangVisible = {false};

        btnHamyang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hamyangVisible[0]){
                    btnHamNam.setVisibility(View.GONE);
                    btnHamSang.setVisibility(View.GONE);
                    btnHamSeo.setVisibility(View.GONE);
                    hamyangVisible[0] = false;
                }
                else{
                    btnHamNam.setVisibility(View.VISIBLE);
                    btnHamSang.setVisibility(View.VISIBLE);
                    btnHamSeo.setVisibility(View.VISIBLE);
                    hamyangVisible[0] = true;
                }
            }
        });
        btnHamNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),HamyangNamgyeDetailActivity.class);
                startActivity(i);
            }
        });
        btnHamSeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),HamyangSeoamDetailActivity.class);
                startActivity(i);
            }
        });
        btnHamSang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),HamyangSangrimDetailActivity.class);
                startActivity(i);
            }
        });

        //합천
        Button btnHap = findViewById(R.id.side_btn_hapcheon);
        Button btnHapHong = findViewById(R.id.side_btn_hapcheon_hongryu);
        Button btnHapHae = findViewById(R.id.side_btn_hapcheon_haeinsa);
        Button btnHapVid = findViewById(R.id.side_btn_hapcheon_video);
        final boolean[] hapVisible = {false};

        btnHap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hapVisible[0]){
                    btnHapHong.setVisibility(View.GONE);
                    btnHapHae.setVisibility(View.GONE);
                    btnHapVid.setVisibility(View.GONE);
                    hapVisible[0] = false;
                }
                else{
                    btnHapHae.setVisibility(View.VISIBLE);
                    btnHapHong.setVisibility(View.VISIBLE);
                    btnHapVid.setVisibility(View.VISIBLE);
                    hapVisible[0] = true;
                }
            }
        });
        btnHapVid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),HapcheonVideoDetailActivity.class);
                startActivity(i);
            }
        });
        btnHapHae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),HapcheonHaeinsaDetailActivity.class);
                startActivity(i);
            }
        });
        btnHapHong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),HapcheonHongryuDetailActivity.class);
                startActivity(i);
            }
        });

        //밀양
        Button btnMiryang = findViewById(R.id.side_btn_miryang);
        Button btnMiryangYnr = findViewById(R.id.side_btn_miryang_ynr);
        Button btnMiryangLotus = findViewById(R.id.side_btn_miryang_lotus);
        Button btnMiryangIce = findViewById(R.id.side_btn_miryang_ice);
        final boolean[] MiryangVisible = {false};

        btnMiryang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MiryangVisible[0]){
                    btnMiryangYnr.setVisibility(View.GONE);
                    btnMiryangIce.setVisibility(View.GONE);
                    btnMiryangLotus.setVisibility(View.GONE);
                    MiryangVisible[0] = false;
                }
                else{
                    btnMiryangYnr.setVisibility(View.VISIBLE);
                    btnMiryangIce.setVisibility(View.VISIBLE);
                    btnMiryangLotus.setVisibility(View.VISIBLE);
                    MiryangVisible[0] = true;
                }
            }
        });
        btnMiryangYnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MiryangYeongnamruDetailActivity.class);
                startActivity(i);
            }
        });
        btnMiryangIce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MiryangIceDetailActivity.class);
                startActivity(i);
            }
        });
        btnMiryangLotus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MiryangLotusDetailActivity.class);
                startActivity(i);
            }
        });

        //남해
        Button btnNamhae = findViewById(R.id.side_btn_namhae);
        Button btnNamhaeBori = findViewById(R.id.side_btn_namhae_boriam);
        Button btnNamhaeGer = findViewById(R.id.side_btn_namhae_german);
        Button btnNamhaePB = findViewById(R.id.side_btn_namhae_pyeonbaek);
        final boolean[] NamhaeVisible = {false};

        btnNamhae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(NamhaeVisible[0]){
                    btnNamhaeBori.setVisibility(View.GONE);
                    btnNamhaeGer.setVisibility(View.GONE);
                    btnNamhaePB.setVisibility(View.GONE);
                    NamhaeVisible[0] = false;
                }
                else{
                    btnNamhaeBori.setVisibility(View.VISIBLE);
                    btnNamhaeGer.setVisibility(View.VISIBLE);
                    btnNamhaePB.setVisibility(View.VISIBLE);
                    NamhaeVisible[0] = true;
                }
            }
        });
        btnNamhaeBori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),NamhaeBoriamDetailActivity.class);
                startActivity(i);
            }
        });
        btnNamhaePB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),NamhaePyeonbaekDetailActivity.class);
                startActivity(i);
            }
        });
        btnNamhaeGer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),NamhaeGermanDetailActivity.class);
                startActivity(i);
            }
        });

        //사천
        Button btn4000 = findViewById(R.id.side_btn_sacheon);
        Button btn4000Cable = findViewById(R.id.side_btn_sacheon_cable);
        Button btn4000Dasol = findViewById(R.id.side_btn_sacheon_dasol);
        Button btn4000Wine = findViewById(R.id.side_btn_sacheon_wins);
        final boolean[] sacheonVisible = {false};

        btn4000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sacheonVisible[0]){
                    btn4000Cable.setVisibility(View.GONE);
                    btn4000Dasol.setVisibility(View.GONE);
                    btn4000Wine.setVisibility(View.GONE);
                    sacheonVisible[0] = false;
                }
                else{
                    btn4000Cable.setVisibility(View.VISIBLE);
                    btn4000Dasol.setVisibility(View.VISIBLE);
                    btn4000Wine.setVisibility(View.VISIBLE);
                    sacheonVisible[0] = true;
                }
            }
        });
        btn4000Cable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),SacheonSeaCableCarDetailActivity.class);
                startActivity(i);
            }
        });
        btn4000Dasol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),SacheonDasolsaDetailActivity.class);
                startActivity(i);
            }
        });
        btn4000Wine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),SacheonWineDetailActivity.class);
                startActivity(i);
            }
        });

        //산청
        Button btnSancheong = findViewById(R.id.side_btn_sancheong);
        Button btnSancheongDa = findViewById(R.id.side_btn_sancheong_daewon);
        Button btnSancheongHw = findViewById(R.id.side_btn_sancheong_hwangmae);
        Button btnSancheongYe = findViewById(R.id.side_btn_sancheong_yedam);
        final boolean[] SancheongVisible = {false};

        btnSancheong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(SancheongVisible[0]){
                    btnSancheongDa.setVisibility(View.GONE);
                    btnSancheongHw.setVisibility(View.GONE);
                    btnSancheongYe.setVisibility(View.GONE);
                    SancheongVisible[0] = false;
                }
                else{
                    btnSancheongDa.setVisibility(View.VISIBLE);
                    btnSancheongHw.setVisibility(View.VISIBLE);
                    btnSancheongYe.setVisibility(View.VISIBLE);
                    SancheongVisible[0] = true;
                }
            }
        });
        btnSancheongDa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),SancheonDaewonsaDetailActivity.class);
                startActivity(i);
            }
        });
        btnSancheongHw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),SancheonHwangmaeDetailActivity.class);
                startActivity(i);
            }
        });
        btnSancheongYe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),SancheonYedamDetailActivity.class);
                startActivity(i);
            }
        });

        //통영
        Button btnTy = findViewById(R.id.side_btn_tongyeong);
        Button btnTyDpr = findViewById(R.id.side_btn_tongyeong_dongpirang);
        Button btnTyJg = findViewById(R.id.side_btn_tongyeong_jogak);
        Button btnTyYj = findViewById(R.id.side_btn_tongyeong_yokji);
        final boolean[] TyVisible = {false};

        btnTy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TyVisible[0]){
                    btnTyJg.setVisibility(View.GONE);
                    btnTyDpr.setVisibility(View.GONE);
                    btnTyYj.setVisibility(View.GONE);
                    TyVisible[0] = false;
                }
                else{
                    btnTyJg.setVisibility(View.VISIBLE);
                    btnTyDpr.setVisibility(View.VISIBLE);
                    btnTyYj.setVisibility(View.VISIBLE);
                    TyVisible[0] = true;
                }
            }
        });
        btnTyDpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TongyeongDongpirangDetailActivity.class);
                startActivity(i);
            }
        });
        btnTyJg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TongyeongJogakDetailActivity.class);
                startActivity(i);
            }
        });
        btnTyYj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TongyeongYokjidoDetailActivity.class);
                startActivity(i);
            }
        });

        //의령
        Button btnUir = findViewById(R.id.side_btn_uiryeong);
        Button btnUirBH = findViewById(R.id.side_btn_uiryeong_bonghwang);
        Button btnUirCI = findViewById(R.id.side_btn_uiryeong_chungik);
        Button btnUirHW = findViewById(R.id.side_btn_uiryeong_hanwu);
        final boolean[] UirVisible = {false};

        btnUir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(UirVisible[0]){
                    btnUirBH.setVisibility(View.GONE);
                    btnUirCI.setVisibility(View.GONE);
                    btnUirHW.setVisibility(View.GONE);
                    UirVisible[0] = false;
                }
                else{
                    btnUirBH.setVisibility(View.VISIBLE);
                    btnUirCI.setVisibility(View.VISIBLE);
                    btnUirHW.setVisibility(View.VISIBLE);
                    UirVisible[0] = true;
                }
            }
        });
        btnUirHW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),UireongHanwusanDetailActivity.class);
                startActivity(i);
            }
        });
        btnUirBH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),UireongBonghwangDetailActivity.class);
                startActivity(i);
            }
        });
        btnUirCI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),UireongChungiksaDetailActivity.class);
                startActivity(i);
            }
        });

        //양산
        Button btnYs = findViewById(R.id.side_btn_yangsan);
        Button btnYsD = findViewById(R.id.side_btn_yangsan_dragon);
        Button btnYsN = findViewById(R.id.side_btn_yangsan_naewon);
        Button btnYsT = findViewById(R.id.side_btn_yangsan_tongdo);
        final boolean[] YsVisible = {false};

        btnYs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(YsVisible[0]){
                    btnYsN.setVisibility(View.GONE);
                    btnYsD.setVisibility(View.GONE);
                    btnYsT.setVisibility(View.GONE);
                    YsVisible[0] = false;
                }
                else{
                    btnYsD.setVisibility(View.VISIBLE);
                    btnYsN.setVisibility(View.VISIBLE);
                    btnYsT.setVisibility(View.VISIBLE);
                    YsVisible[0] = true;
                }
            }
        });
        btnYsD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),YangsanDragonDetailActivity.class);
                startActivity(i);
            }
        });
        btnYsN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),YangsanNaewonDetailActivity.class);
                startActivity(i);
            }
        });
        btnYsT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),YangsanTongdosaDetailActivity.class);
                startActivity(i);
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