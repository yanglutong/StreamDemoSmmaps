package com.example.location.Import;

import android.content.Context;

import com.example.location.Base.BasePresenter;
import com.example.location.Base.BaseView;
import com.example.location.Utils.BillObject;

import java.util.List;


public class ExcelView {
    interface View extends BaseView<ExcelPresenter> {//更新

        void finishs();

        void QueryShow();
    }

    interface ExcelPresenter extends BasePresenter {//使用

        void finish();

        void Querys(List<BillObject> billObjectList, Context context);
    }
}
