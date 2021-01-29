package com.example.marveldatabase.utils

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

class RetrofitCallAdapter<R> : CallAdapter<R, ResultValue<R>> {
    override fun adapt(call: Call<R>): ResultValue<R> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun responseType(): Type {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}