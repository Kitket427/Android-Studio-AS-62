package com.example.memory;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.*;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity {

    private static int ROW_COUNT = -1; //переменная для начала строки
    private static int COL_COUNT = -1; //переменная для начала колонки
    private Context context;
    private Drawable backImage; //статическое изображение
    private int [] [] cards; //матрица изображений
    private List<Drawable> images;
    private Card firstCard; //1-я карта, которую выбрал пользователь
    private Card seconedCard; // 2-я карта, которую выбрал пользователь
    private ButtonListener buttonListener;


    private static Object lock = new Object();

    int turns;
    private TableLayout mainTable;
    private UpdateCardsHandler handler; //обновление обработчика карт

    @Override
    protected void onCreate(Bundle savedInstanceState) { //игровое поле
        super.onCreate(savedInstanceState); //cохраняем состояние приложения
        handler = new UpdateCardsHandler();

        loadImages();
        setContentView(R.layout.activity_main);//передаем ресурс разметки графического интерфейса
        backImage =  getResources().getDrawable(R.drawable.icon); //рубашка карт

        buttonListener = new ButtonListener();
        mainTable = (TableLayout)findViewById(R.id.TableLayout03);
        context  = mainTable.getContext();

        Spinner s = (Spinner) findViewById(R.id.Spinner01); // выпадающий список
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        s.setOnItemSelectedListener(new OnItemSelectedListener(){

            @Override
            //выпадающий список
            public void onItemSelected(android.widget.AdapterView<?> arg0,View arg1, int pos, long arg3)
            {
                ((Spinner) findViewById(R.id.Spinner01)).setSelection(0); //офомрляем меню выбора
                int x,y;
                switch (pos) {
                    case 1:
                        x=4;y=4;
                        break;
                    case 2:
                        x=4;y=5;
                        break;

                    default:
                        return;
                }
                newGame(x,y);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub \\заглушка метода
            }
        });
    }

    private void newGame(int c, int r) { //начало новой игры
        ROW_COUNT = r; //строка
        COL_COUNT = c; //столбец
        cards = new int [COL_COUNT] [ROW_COUNT];
        mainTable.removeView(findViewById(R.id.TableRow01)); //обращаемся к элементами activity_main
        TableRow tr = ((TableRow)findViewById(R.id.TableRow03));
        tr.removeAllViews();
        mainTable = new TableLayout(context);
        tr.addView(mainTable);
        for (int y = 0; y < ROW_COUNT; y++) {
            mainTable.addView(createRow(y)); //добавление виджетов
        }
        firstCard=null;
        loadCards();
        turns=0;
        ((TextView)findViewById(R.id.tv1)).setText("Tries: " + turns);
    }

    private void loadImages() { //функиция загрузки картинок
        images = new ArrayList<Drawable>();
        images.add(getResources().getDrawable(R.drawable.card1));
        images.add(getResources().getDrawable(R.drawable.card2));
        images.add(getResources().getDrawable(R.drawable.card3));
        images.add(getResources().getDrawable(R.drawable.card4));
        images.add(getResources().getDrawable(R.drawable.card5));
        images.add(getResources().getDrawable(R.drawable.card6));
        images.add(getResources().getDrawable(R.drawable.card7));
        images.add(getResources().getDrawable(R.drawable.card8));
        images.add(getResources().getDrawable(R.drawable.card9));
        images.add(getResources().getDrawable(R.drawable.card10));
        images.add(getResources().getDrawable(R.drawable.card11));
        images.add(getResources().getDrawable(R.drawable.card12));
        images.add(getResources().getDrawable(R.drawable.card13));
        images.add(getResources().getDrawable(R.drawable.card14));
        images.add(getResources().getDrawable(R.drawable.card15));
        images.add(getResources().getDrawable(R.drawable.card16));
        images.add(getResources().getDrawable(R.drawable.card17));
        images.add(getResources().getDrawable(R.drawable.card18));
        images.add(getResources().getDrawable(R.drawable.card19));
        images.add(getResources().getDrawable(R.drawable.card20));
        images.add(getResources().getDrawable(R.drawable.card21));

    }

    private void loadCards(){ //загружаем карты
        try{
            int size = ROW_COUNT*COL_COUNT;
            Log.i("loadCards()","size=" + size);
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                list.add(new Integer(i));
            }
            Random r = new Random();
            for(int i=size-1;i>=0;i--){ //присваниваем ячейке номер
                int t=0;
                if(i>0){
                    t = r.nextInt(i);
                }
                t=list.remove(t).intValue();
                cards[i%COL_COUNT][i/COL_COUNT]=t%(size/2);
                Log.i("loadCards()", "card["+(i%COL_COUNT)+
                        "]["+(i/COL_COUNT)+"]=" + cards[i%COL_COUNT][i/COL_COUNT]);
            }
        }
        catch (Exception e) {
            Log.e("loadCards()", e+"");
        }
    }

    private TableRow createRow(int y){ //создание строки
        TableRow row = new TableRow(context); //выделяем память
        row.setHorizontalGravity(Gravity.CENTER);
        for (int x = 0; x < COL_COUNT; x++) {
            row.addView(createImageButton(x,y));
        }
        return row;
    }

    private View createImageButton(int x, int y){ // картинки
        Button button = new Button(context);
        button.setBackgroundDrawable(backImage);
        button.setId(400*x+y);
        button.setOnClickListener(buttonListener);
        return button;
    }

    class ButtonListener implements OnClickListener { // нажатия
        @Override
        public void onClick(View v) {
            synchronized (lock) {
                if(firstCard!=null && seconedCard != null){
                    return;
                }
                int id = v.getId();
                int x = id/400;
                int y = id%50;
                turnCard((Button)v,x,y);
            }
        }

        private void turnCard(Button button,int x, int y) { //поворот карты
            button.setBackgroundDrawable(images.get(cards[x][y]));
            if(firstCard==null){
                firstCard = new Card(button,x,y);

            }
            else{
                if(firstCard.x == x && firstCard.y == y){
                    return; //пользователь нажал ту же карту
                }
                seconedCard = new Card(button,x,y);
                turns++;
                ((TextView)findViewById(R.id.tv1)).setText("Tries: "+turns);


                TimerTask tt = new TimerTask() {

                    @Override
                    public void run() {
                        try{
                            synchronized (lock) {
                                handler.sendEmptyMessage(0);
                            }
                        }
                        catch (Exception e) {
                            Log.e("E1", e.getMessage());
                        }
                    }
                };
                Timer t = new Timer(false);
                t.schedule(tt, 1300);
            }
        }
    }

    class UpdateCardsHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            synchronized (lock) {
                checkCards();
            }
        }
        public void checkCards(){ //пользователь проверят карты
            if(cards[seconedCard.x][seconedCard.y] == cards[firstCard.x][firstCard.y]){ //если картинки совпали
                firstCard.button.setVisibility(View.INVISIBLE); //карты становятся невидимы
                seconedCard.button.setVisibility(View.INVISIBLE);
            }
            else {
                seconedCard.button.setBackgroundDrawable(backImage); //иначе пользователь видит рубашуи карт
                firstCard.button.setBackgroundDrawable(backImage);

            }
            //приравниваем выбор к нулю, что бы пользователь снова задавал значения
            firstCard=null;
            seconedCard=null;
        }
    }
}