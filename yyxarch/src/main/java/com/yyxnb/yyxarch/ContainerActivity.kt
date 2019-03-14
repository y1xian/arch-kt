package com.yyxnb.yyxarch

import android.os.Bundle
import android.view.WindowManager
import com.yyxnb.yyxarch.base.BaseActivity
import com.yyxnb.yyxarch.base.BaseFragment
import com.yyxnb.yyxarch.common.AppConfig


/**
 * Description: 盛装Fragment的一个容器(代理)Activity
 * 普通界面只需要编写Fragment,使用此Activity盛装,这样就不需要每个界面都在AndroidManifest中注册一遍
 *
 * @author : yyx
 * @date ：2018/6/9
 */
class ContainerActivity : BaseActivity() {

    override fun initLayoutResID(): Int {
        return 0
    }

    override fun initView(savedInstanceState: Bundle?) {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        super.initView(savedInstanceState)
        if (null == savedInstanceState) {

            try {
                if (null == intent) {
                    throw RuntimeException("you must provide a page info to display")
                }
                val fragmentName = intent.getStringExtra(AppConfig.FRAGMENT)
                if (null == fragmentName || "" == fragmentName) {
                    throw IllegalArgumentException("can not find page fragmentName")
                }
                val fragmentClass = Class.forName(fragmentName)
                val fragment = fragmentClass.newInstance() as BaseFragment
                val args = intent.getBundleExtra(AppConfig.BUNDLE)
                val requestCode = intent.getIntExtra(AppConfig.REQUEST_CODE, REQUEST_CODE_INVALID)
                if (null != args) {
                    fragment.arguments = args
                }
                if (requestCode == REQUEST_CODE_INVALID) {
                    startFragment(fragment)
                } else {
                    startFragmentForResult(fragment, requestCode)
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

}
