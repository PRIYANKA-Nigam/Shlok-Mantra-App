package com.example.shlokmantraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView textView;
ImageView imageView; Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        imageView=findViewById(R.id.imageView);
        String s= getIntent().getStringExtra("name");
        textView.setText(s);
        if(s.equalsIgnoreCase("Lord Shiva")){
            imageView.setImageResource(R.drawable.shiva);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(MainActivity2.this,ShivaActivity.class);
                    startActivity(intent);
                }
            });
        }
        if(s.equalsIgnoreCase("Other Mantra")){
            imageView.setImageResource(R.drawable.all_god);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(MainActivity2.this,NewMantraActivity.class);
                    startActivity(intent);
                }
            });
        }
        if (s.equalsIgnoreCase("Lord Ganesh")){
            imageView.setImageResource(R.drawable.ganesha);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(MainActivity2.this,GaneshaActivity.class);
                    startActivity(intent);
                }
            });
        }
        if (s.equalsIgnoreCase("Lord Hanumaan")){
            imageView.setImageResource(R.drawable.hanuman);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity2.this,HanumanActivity.class));
                }
            });
        }
        if (s.equalsIgnoreCase("Lord Ram")){
            imageView.setImageResource(R.drawable.rama);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity2.this,RamaActivity.class));
                }
            });
        } if (s.equalsIgnoreCase("Lord Krishna")){
            imageView.setImageResource(R.drawable.krishna);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity2.this,KrishnaActivity.class));
                }
            });
        } if (s.equalsIgnoreCase("Lord Brahma")){
            imageView.setImageResource(R.drawable.brahma);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity2.this,BramhaActivity.class));
                }
            });
        }

                 if (s.equalsIgnoreCase("Lord Vishnu")){
                    imageView.setImageResource(R.drawable.vishnu);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(MainActivity2.this,VishnuActivity.class));
                        }
                    });
                }
                 if (s.equalsIgnoreCase("Goddess Lakshmi")){
                    imageView.setImageResource(R.drawable.lakshmi);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(MainActivity2.this,LakshmiActivity.class));
                        }
                    });
                }
                 if (s.equalsIgnoreCase("Goddess Saraswati")){
                    imageView.setImageResource(R.drawable.saraswati);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(MainActivity2.this,SaraswatiActivity.class));
                        }
                    });
                } if (s.equalsIgnoreCase("Goddess Kali")){
                    imageView.setImageResource(R.drawable.kali);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(MainActivity2.this,KaliActivity.class));
                        }
                    });
                } if (s.equalsIgnoreCase("Goddess Durga")){
                    imageView.setImageResource(R.drawable.durga);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(MainActivity2.this,DurgaActivity.class));
                        }
                    });
                } if (s.equalsIgnoreCase("Goddess Gayatri")){
                    imageView.setImageResource(R.drawable.gayatri);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(MainActivity2.this,GayatriActivity.class));
                        }
                    });
                }
        if (s.equalsIgnoreCase("Kubera Dhana Prapti Mantra")){
            imageView.setImageResource(R.drawable.kuber);
            String flag="kd";
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity2.this,OtherMantraActivity.class);
                    intent.putExtra("flag",flag);
                    startActivity(intent);
                }
            });
        }

        if (s.equalsIgnoreCase("Laxmi Kuber Mantra")) {
            imageView.setImageResource(R.drawable.kuber);
            String flag = "lk";
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity2.this, OtherMantraActivity.class);
                    intent.putExtra("flag", flag);
                    startActivity(intent);
                }
            });
        }
            if (s.equalsIgnoreCase("The Bija Mantra of Goddess Sarawati")) {
                imageView.setImageResource(R.drawable.vidya);
                String flag = "bm";
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity2.this, OtherMantraActivity.class);
                        intent.putExtra("flag", flag);
                        startActivity(intent);
                    }
                });
            }
                if (s.equalsIgnoreCase("Vidya Mantra")){
                    imageView.setImageResource(R.drawable.vidya);
                    String flag="vm";
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent=new Intent(MainActivity2.this,OtherMantraActivity.class);
                            intent.putExtra("flag",flag);
                            startActivity(intent);
                        }
                    });
        }
        if (s.equalsIgnoreCase("Katyayani Mantra")){
            imageView.setImageResource(R.drawable.wed);
            String flag="km";
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity2.this,OtherMantraActivity.class);
                    intent.putExtra("flag",flag);
                    startActivity(intent);
                }
            });
        }
        if (s.equalsIgnoreCase("Parvati Mantra for delayed Marriages")){
            imageView.setImageResource(R.drawable.wed);
            String flag="pm";
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity2.this,OtherMantraActivity.class);
                    intent.putExtra("flag",flag);
                    startActivity(intent);
                }
            });
        }
        if (s.equalsIgnoreCase("Surya Mantra for delayed Marriages")){
            imageView.setImageResource(R.drawable.wed);
            String flag="sm";
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity2.this,OtherMantraActivity.class);
                    intent.putExtra("flag",flag);
                    startActivity(intent);
                }
            });
        } if (s.equalsIgnoreCase("Vivah Hetu Mantra1")){
            imageView.setImageResource(R.drawable.wed);
            String flag="vhm";
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity2.this,OtherMantraActivity.class);
                    intent.putExtra("flag",flag);
                    startActivity(intent);
                }
            });
        } if (s.equalsIgnoreCase("Vivah Hetu Mantra2")){
            imageView.setImageResource(R.drawable.wed);
            String flag="vhhm";
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity2.this,OtherMantraActivity.class);
                    intent.putExtra("flag",flag);
                    startActivity(intent);
                }
            });
        }
        if (s.equalsIgnoreCase("Shiva Parvati Mantra for happy married life")){
            imageView.setImageResource(R.drawable.wed);
            String flag="spm";
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity2.this,OtherMantraActivity.class);
                    intent.putExtra("flag",flag);
                    startActivity(intent);
                }
            });
        }
        if (s.equalsIgnoreCase("Chhath Puja Mantra")){
            imageView.setImageResource(R.drawable.chhath);
            String flag="cpm";
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity2.this,OtherMantraActivity.class);
                    intent.putExtra("flag",flag);
                    startActivity(intent);
                }
            });
        }
        if (s.equalsIgnoreCase("Surya Dev Mantra")){
            imageView.setImageResource(R.drawable.chhath);
            String flag="sdm";
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity2.this,OtherMantraActivity.class);
                    intent.putExtra("flag",flag);
                    startActivity(intent);
                }
            });
        }
        if (s.equalsIgnoreCase("Suryadev Aradhana Mantra")){
            imageView.setImageResource(R.drawable.chhath);
            String flag="sam";
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity2.this,OtherMantraActivity.class);
                    intent.putExtra("flag",flag);
                    startActivity(intent);
                }
            });
        }
        if (s.equalsIgnoreCase("Maa Parvati Mantra")){
            imageView.setImageResource(R.drawable.karwas);
            String flag="mpm";
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity2.this,OtherMantraActivity.class);
                    intent.putExtra("flag",flag);
                    startActivity(intent);
                }
            });
        }
        if (s.equalsIgnoreCase("Lord Shiva Mantra")){
            imageView.setImageResource(R.drawable.karwas);
            String flag="lsm";
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity2.this,OtherMantraActivity.class);
                    intent.putExtra("flag",flag);
                    startActivity(intent);
                }
            });
        }
        if (s.equalsIgnoreCase("Lord Kartikeya Mantra")){
            imageView.setImageResource(R.drawable.karwas);
            String flag="lkm";
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity2.this,OtherMantraActivity.class);
                    intent.putExtra("flag",flag);
                    startActivity(intent);
                }
            });
        }
        if (s.equalsIgnoreCase("Lord Ganesha Mantra")){
            imageView.setImageResource(R.drawable.karwas);
            String flag="lgm";
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity2.this,OtherMantraActivity.class);
                    intent.putExtra("flag",flag);
                    startActivity(intent);
                }
            });
        }
        if (s.equalsIgnoreCase("Shri Chandrama Mantra")){
            imageView.setImageResource(R.drawable.karwas);
            String flag="scm";
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity2.this,OtherMantraActivity.class);
                    intent.putExtra("flag",flag);
                    startActivity(intent);
                }
            });
        }
        if (s.equalsIgnoreCase("Shani Dev")){
            imageView.setImageResource(R.drawable.shani_dev);
            String flag="shani";
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity2.this,ShaniActivity.class);
                    intent.putExtra("flag",flag);
                    startActivity(intent);
                }
            });
        }
        if (s.equalsIgnoreCase("Goddess Santoshi")){
            imageView.setImageResource(R.drawable.santoshi);
            String flag="santoshi";
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity2.this,SantoshiActivity.class);
                    intent.putExtra("flag",flag);
                    startActivity(intent);
                }
            });
        }
    }
}