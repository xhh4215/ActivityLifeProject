package com.xh.example.androidleftproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_start_model.*

/*****
 * @author 栾桂明
 * @date 2020年 6月 30日
 * @use 学习activity的启动模式
 *
 * 启动模式的概念
 *
 * standard：标准启动模式  系统默认的启动模式 每次启动都会创建一个实例
 * 在这种启动模式下 谁启动了当前的activity 当前的activity就运行在启动他的activity所在的栈中
 *
 * singleTop：栈定复用模式 这种模式下如果activity 在栈顶那么activity不会被重新创建
 * 同时他的onNewIntent()会被回调 取出当前的请求信息，如果不再栈顶 则会重新创建
 *
 * singleTask：栈内复用模式 这是一种单例模式 在这种情况下 只要Activity在一个栈中存在，那么多次启动就
 * 不会在创建实例，系统会调用onNewIntent()方法，具体一点 以singleTask启动一个Activity 首先会寻找是不是
 * 存在他想要的任务栈，如果不存在则创建一个栈 创建当前Activity的实例 压入栈中，如果存在想要的任务栈，那就看
 * 栈中是否存在该Activity的实例 存在就将Activity调到栈顶 调用他的onNewIntent()方法，不存就创建实例压入栈中
 * 包含cleartop效果  将他之前的Activity全部出栈
 *
 * singleinstance：单例模式 这是一种加强版的singleTask，他除了具有singleTask的特性外，还加强了一点 就是他只能
 * 单独的位于一个任务栈中
 *
 *
 * 设置启动模式
 *
 *
 * 1 通过为配置文件中的对应的Activity指定 launchModel 指定对应的启动模式
 * 2 在代码中通过为intent设置FLAG实现指定启动模式
 * 备注： 2 的优先级高于1
 * 两种启动模式的缺点  1 第一种无法设置 FLAG_ACTIVITY_CLEAR_TOP
 *                  2  无法设置  singleinstance启动模式
 *
 *
 * Activity的FLAG
 *
 * FLAG_ACTIVITY_NEW_TASK 这个标记是为Activity指定singleTask启动模式的
 *
 * FLAG_ACTIVITY_SINGLE_TOP 这个标记是为Activity指定singleTop启动模式的
 *
 * FLAG_ACTIVITY_CLEAR_TOP 这个标记是在启动Activity的时候他的同一个栈中的在他之上的Activity都会出栈
 *
 */
class StartModelActivity : AppCompatActivity() {
    private val TAG = "StartModelActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_model)
        Log.d(TAG, "onCreate")
        finishBtn.setOnClickListener {
            finish()
        }
        singleTaskBtn.setOnClickListener {
            Intent(this@StartModelActivity, StartModelActivity::class.java)
                .apply {
                    this.putExtra("time",System.currentTimeMillis())
                    startActivity(this)
                }
        }
        intentBtn.setOnClickListener {
            Intent("com.example.start_activity").
            apply {
                this.addCategory("com.example.startactivity.category1")
                this.addCategory("com.example.startactivity.category2")
                this.addCategory("com.example.startactivity.category3")
                startActivity(this)
            }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")

    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.d(TAG, "onNewIntent ${intent.getLongExtra("time",0L)}")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")

    }

}