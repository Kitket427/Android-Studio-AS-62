package com.example.laba1;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Collections;

public class GridAdapter extends BaseAdapter {
    private Context mContext;
    private Integer mCols, mRows;
    private ArrayList<String> arrPict; // ������ ��������
    private String PictureCollection; // ������� ������ ��������
    private Resources mRes; // ������� ����������
    private static enum Status {CELL_OPEN, CELL_CLOSE, CELL_DELETE};
    private ArrayList<Status> arrStatus; // ��������� �����

    public GridAdapter(Context context, int cols, int rows) {
        mContext = context;
        mCols = cols;
        mRows = rows;
        arrPict = new ArrayList<String>();
        arrStatus = new ArrayList<Status>();

        // ���� ���������� ������� ���, ����� �� ����� ������� �� ��������
        PictureCollection = "img";

        // �������� ��� ������� ����������
        mRes = mContext.getResources();

        // ����� ����������� ������ arrPict
        makePictArray();

        // ����� ��������������� ���� ������� ������ CELL_CLOSE
        closeAllCells();
    }

    private void makePictArray() {
        // ������� ������
        arrPict.clear();
        // ���������
        for (int i = 0; i < ((mCols * mRows) / 2); i++) {
            arrPict.add(PictureCollection + Integer.toString(i));
            arrPict.add(PictureCollection + Integer.toString(i));
        }
        // ������������
        Collections.shuffle(arrPict);
    }

    private void closeAllCells() {
        arrStatus.clear();
        for (int i = 0; i < mCols * mRows; i++)
            arrStatus.add(Status.CELL_CLOSE);
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
        ImageView view; // ���������� � ��� ����� ��������

        if (convertView == null) {
            view = new ImageView(mContext);
            view.setLayoutParams(new ViewGroup.LayoutParams(250, 200));
        }
        else
            view = (ImageView) convertView;

        switch (arrStatus.get(position)) {
            case CELL_OPEN:
                // �������� ������������� ������� ��� ��������, ������� ��������� � arrPict �� ������� position
                Integer drawableId = mRes.getIdentifier(arrPict.get(position), "drawable", mContext.getPackageName());
                view.setImageResource(drawableId);
                break;
            case CELL_CLOSE:
                view.setImageResource(R.drawable.close);
                break;
            default:
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
    }

    public void openCell(int position) {
        if (arrStatus.get(position) != Status.CELL_DELETE)
            arrStatus.set(position, Status.CELL_OPEN);
        notifyDataSetChanged();
    }

    public boolean checkGameOver() {
        return arrStatus.indexOf(Status.CELL_CLOSE) < 0;
    }

    public void restartLevel() {
        closeAllCells();   // ���������� ��������� �����
        makePictArray();   // ���������� ����� ��������� �����������
        notifyDataSetChanged();  // ��������� GridView
    }
}
