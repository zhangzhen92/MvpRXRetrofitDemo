/*
 * Copyright 2016 Freelander
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jun.elephant.ui.login;

import android.content.Context;

import com.jun.elephant.entity.TokenEntity;
import com.jun.elephant.entity.user.UserInfoEntity;
import com.jun.elephant.mvpframe.BaseModel;
import com.jun.elephant.mvpframe.BasePresenter;
import com.jun.elephant.mvpframe.BaseView;

import rx.Observable;

/**
 * Created by Jun on 2016/9/19.
 * @see LoginActivity
 * @see LoginModel
 * @see LoginPresenter
 * ？Presenter需要管理M和V，那么什么时候加入依赖呢
 * V只需要依赖P就可以了
 * 在V的onCreate方法中:
 * 1、创建Presenter对象
 * 2、调用Presenter对象的setMV(M,V)
 *    V 时this
 *    P和M通过泛型反射的方式创建的对象
 */

public interface LoginContract {

    interface Model extends BaseModel {
        Observable<TokenEntity> getLoginToken(Context context, String userName, String loginToken);

        Observable<UserInfoEntity> login();
    }

    interface View extends BaseView {
        void onLoginSuccess(UserInfoEntity userInfoEntity);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void login(Context context, String userName, String loginToken);
    }
}
