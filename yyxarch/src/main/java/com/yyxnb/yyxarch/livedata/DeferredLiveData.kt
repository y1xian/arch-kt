package com.yyxnb.yyxarch.livedata

import android.arch.lifecycle.LiveData
import com.yyxnb.yyxarch.ext.tryCatch
import com.yyxnb.yyxarch.http.exception.ApiException
import com.yyxnb.yyxarch.utils.log.LogUtils
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * @author yyx
 * @date 2017/10/21
 */

internal class DeferredLiveData<T>(private val deferred: Deferred<T>) : LiveData<T>() {

    private val mScope: CoroutineScope by lazy {
        CoroutineScope(SupervisorJob() + Dispatchers.Main)
    }

    override fun onActive() {
        super.onActive()

        mScope.launch {
            val time = measureTimeMillis {

                tryCatch({
                    postValue(deferred.await())
                }, {
                    LogUtils.e(ApiException.handleException(it).message)
                })

            }
            println("Completed in $time ms")
        }

    }

    override fun onInactive() {
        super.onInactive()
        mScope.cancel()
    }

}
