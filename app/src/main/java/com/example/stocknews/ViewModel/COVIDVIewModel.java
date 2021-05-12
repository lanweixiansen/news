package com.example.stocknews.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.stocknews.Bean.COVIDBean;
import com.example.stocknews.Repository.Repository;

import java.util.List;

public class COVIDVIewModel extends AndroidViewModel {
  private MutableLiveData<List<COVIDBean.NewslistDTO>> mLiveData;
  private final Repository mAlertRepository = new Repository(getApplication());

  public COVIDVIewModel(@NonNull Application application) {
    super(application);
  }

  public MutableLiveData<List<COVIDBean.NewslistDTO>> getLiveData() {
    if (mLiveData == null){
      mLiveData = new MutableLiveData<>();
    }
    return mLiveData;
  }

  public void requestData(){
    mLiveData = mAlertRepository.getCOVID();

  }




}
