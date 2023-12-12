package com.example.myapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {
    private final Context mContext;
    private final Integer mCols;
    private final Integer mRows;

    private final ArrayList<String> arrPict; // массив картинок
    private final String PictureCollection; // Префикс набора картинок
    private final Resources mRes; // Ресурсы приложени

    private enum Status {CELL_OPEN, CELL_CLOSE, CELL_DELETE}

    private ArrayList<Status> arrStatus; // состояние ячеек

    public GridAdapter(Context context, int cols, int rows) {
        mContext = context;
        mCols = cols;
        mRows = rows;
        arrStatus = new ArrayList<Status>();
        arrPict = new ArrayList<String>();
        PictureCollection = "greek";
        // Получаем все ресурсы приложения
        mRes = mContext.getResources();
        // Метод заполняющий массив vecPict
        makePictArray();
        closeAllCells();
    }

    private void closeAllCells() {
        arrStatus.clear();
        for (int i = 0; i < mCols * mRows; i++)
            arrStatus.add(Status.CELL_CLOSE);
    }

    private void makePictArray() {
        // очищаем вектор
        arrPict.clear();
        // добавляем
        for (int i = 0; i < ((mCols * mRows) / 2); i++) {
            arrPict.add(PictureCollection + i);
            arrPict.add(PictureCollection + i);
        }
        // перемешиваем
        Collections.shuffle(arrPict);
    }

    @Override
    public int getCount() {
        return mCols * mRows;
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

        ImageView view; // выводиться у нас будет картинка

        if (convertView == null)
            view = new ImageView(mContext);
        else
            view = (ImageView) convertView;

        if (Objects.requireNonNull(arrStatus.get(position)) == Status.CELL_OPEN) {// Получаем идентификатор ресурса для картинки,
            // которая находится в векторе vecPict на позиции position
            Integer drawableId = mRes.getIdentifier(arrPict.get(position), "drawable", mContext.getPackageName());
            view.setImageResource(drawableId);
        } else if (arrStatus.get(position) == Status.CELL_CLOSE) {
            view.setImageResource(R.drawable.close);
        } else {
            view.setImageResource(R.drawable.none);
        }


        return view;
    }

    public void checkOpenCells() {
        int first = arrStatus.indexOf(Status.CELL_OPEN);
        int second = arrStatus.lastIndexOf(Status.CELL_OPEN);
        if (first == second)
            return;
        if (arrPict.get(first).equals(arrPict.get(second))) {
            arrStatus.set(first, Status.CELL_DELETE);
            arrStatus.set(second, Status.CELL_DELETE);
        } else {
            arrStatus.set(first, Status.CELL_CLOSE);
            arrStatus.set(second, Status.CELL_CLOSE);
        }
        return;
    }

    public boolean openCell(int position) {
        if (arrStatus.get(position) == Status.CELL_DELETE
                || arrStatus.get(position) == Status.CELL_OPEN)
            return false;

        if (arrStatus.get(position) != Status.CELL_DELETE)
            arrStatus.set(position, Status.CELL_OPEN);

        notifyDataSetChanged();
        return true;
    }

    public boolean checkGameOver() {
        if (arrStatus.indexOf(Status.CELL_CLOSE) < 0)
            return true;
        return false;


    }


}