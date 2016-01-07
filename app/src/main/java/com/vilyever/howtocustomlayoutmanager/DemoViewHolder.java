package com.vilyever.howtocustomlayoutmanager;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * DemoViewHolder
 * HowToCustomLayoutManager <com.vilyever.howtocustomlayoutmanager>
 * Created by vilyever on 2016/1/7.
 * Feature:
 * 示例ViewHolder，简单展示一个TextView显示不同文字和背景色
 */
public class DemoViewHolder extends RecyclerView.ViewHolder {
    /**
     * this的便捷访问
     */
    final DemoViewHolder self = this;

    /**
     * 文字标签，用于展示文字和背景色
     * 可以通过getter{@link #getTitleLabel()}直接在adapter中获取
     */
    private TextView titleLabel;
    public TextView getTitleLabel() { if (titleLabel == null) { titleLabel = (TextView) self.itemView.findViewById(R.id.titleLabel); } return titleLabel; }

    /* #Constructors */
    public DemoViewHolder(View itemView) {
        super(itemView);
    }
    
    /* #Overrides */    
    
    /* #Accessors */     
     
    /* #Delegates */     
     
    /* #Private Methods */    
    
    /* #Public Methods */

    /**
     * 刷新此ViewHolder
     * 纵然{@link #titleLabel} 控件可以通过getter{@link #getTitleLabel()}可以直接在外部获取
     * 通过{@link Datasource}数据接口可使此ViewHolder专注于自己的业务逻辑，而非在adapter中任意更改
     * @param datasource 数据源
     */
    public void reload(@NonNull Datasource datasource) {
        self.getTitleLabel().setText(datasource.gainTitle(self));
        self.getTitleLabel().setBackgroundColor(datasource.gainBackgroundColor(self));
    }

    /**
     * {@link DemoViewHolder} 便捷构造，adapter无需关心ViewHolder的layout文件是什么
     * @param parent itemView的父view
     * @return {@link DemoViewHolder}实例
     */
    public static DemoViewHolder newInstance(ViewGroup parent) {
        Class currentClass = new Object() { }.getClass().getEnclosingClass(); // 获取当前class，免除每次攥写ViewHolder都要改名获取当前ViewHolder类型的麻烦
        return ViewHolderCreater.CreateInstance(currentClass, parent, R.layout.demo_view_holder);
    }

    /* #Classes */

    /* #Interfaces */

    /**
     * 数据接口，更新此ViewHolder只需要提供以下数据
     */
    public interface Datasource {
        String gainTitle(DemoViewHolder viewHolder);
        int gainBackgroundColor(DemoViewHolder viewHolder);
    }
     
    /* #Annotations @interface */    
    
    /* #Enums */
}