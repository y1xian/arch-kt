package com.yyxnb.yyxarch.common

import android.graphics.Color
import com.yyxnb.yyxarch.AppUtils
import com.yyxnb.yyxarch.R
import com.yyxnb.yyxarch.interfaces.BarStyle
import com.yyxnb.yyxarch.utils.StatusBarUtils
import java.io.Serializable
import java.util.*

/**
 * Description: 相关配置属性
 *
 * @author : yyx
 * @date ：2018/6/13
 */
object AppConfig : Serializable {

    const val FRAGMENT = "FRAGMENT"
    const val BUNDLE = "BUNDLE"
    const val REQUEST_CODE = "REQUEST_CODE"

    /**
     * 重连次数
     */
    var retryMaxTime: Int = 3
    /**
     * 重连间隔时间 ms
     */
    var retryDelay: Long = 3000
    /**
     * 是否侧滑 fragment
     */
    var swipeBackEnabled: Boolean = true
    /**
     * 状态栏透明
     */
    var statusBarTranslucent: Boolean = true
    /**
     * 状态栏文字颜色
     */
    var statusBarStyle = BarStyle.LightContent
    /**
     * 状态栏是否隐藏
     */
    var statusBarHidden: Boolean = false
    /**
     * 状态栏颜色
     */
    var statusBarColor: Int = StatusBarUtils.fetchContextColor(AppUtils.context, R.attr.colorPrimaryDark)
    /**
     * 如果状态栏处于白色且状态栏文字也处于白色，避免看不见
     */
    var shouldAdjustForWhiteStatusBar: Int = Color.parseColor("#4A4A4A")
    /**
     * 虚拟键背景颜色
     */
    var navigationBarColor: Int = Color.TRANSPARENT
    /**
     * 虚拟键颜色
     */
    var navigationBarStyle = BarStyle.DarkContent

}
