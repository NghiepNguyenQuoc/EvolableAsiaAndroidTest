package com.nghiepnguyen.evolableasiaandroidtest.interfaces;

import com.nghiepnguyen.evolableasiaandroidtest.model.CommonErrorModel;

/**
 * Created by Nghiep Nguyen on 30-Sep-17.
 */

public interface ICallBack {
    public void onSuccess(Object data);

    public void onFailure(CommonErrorModel error);

    public void onCompleted();
}
