package com.gzfgeh.nbapp.Present;

import com.gzfgeh.nbapp.Bean.DataBean;
import com.gzfgeh.nbapp.Bean.ResultBean;
import com.gzfgeh.nbapp.Model.NewsListModel;
import com.gzfgeh.nbapp.Utils.RxSubUtils;
import com.gzfgeh.nbapp.View.NewsListView;

import java.util.List;

import javax.inject.Inject;

/**
 * Description:
 * Created by guzhenfu on 2016/11/2 20:04.
 */

public class NewsListPresenter extends BasePresenter<NewsListView> {
    @Inject
    NewsListModel newsListModel;

    @Inject
    public NewsListPresenter() {}

    public void getListData(String type, int page){
        mCompositeSubscription.add(newsListModel.getNewsList(type,page)
                .subscribe(new RxSubUtils<List<ResultBean>>(mCompositeSubscription) {
                    @Override
                    protected void _onNext(List<ResultBean> dataBeen) {
                        getView().getListData(dataBeen);
                    }
                }));
    }
}
