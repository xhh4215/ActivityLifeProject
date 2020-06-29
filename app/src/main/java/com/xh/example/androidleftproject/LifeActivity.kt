package com.xh.example.androidleftproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_life.*

/****
 * @author 栾桂明
 * @date 2020 6 30
 * @use 学习activity的生命周期和启动模式
 *
 * 1 activity正常启动的生命周期为：   onCreate()   onStart()    onResume()
 * 2 activity正常启动之后回到桌面的生命周期：   onCreate()  onStart()   onResume()   onPause()   onStop()
 * 3 activity正常启动之后回到桌面点击图片在进入activity的生命周期： onCreate()  onStart() onResume() onPause() onStop() onRestart() onStart() onResume()
 * 4 activity运行的时候点击back键 执行的生命周期 ：onPause()  onStop()  onDestory()
 * 5 从A  activity 跳转到 B activity 执行的生命周期方法
 *   A   onCreate()  onStart()   onResume()  onPause()    B   onCreate() onStart()  onResume()   A onStop()
 *
 */
class LifeActivity : AppCompatActivity() {

    private val TAG = "LifeActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContentView(R.layout.activity_life)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")

    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.d(TAG, "onNewIntent")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")

    }

    /***
     * 在Activity异常终止的时候进行数据的保存
     */
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d(TAG, "onSaveInstanceState 保存数据  ${activitylife.text}")
        outState.putString("data", activitylife.text.toString())
    }

    /***
     * 在异常终止之后重新启动恢复数据
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState 恢复数据")

        activitylife.text = savedInstanceState.getString("data")
    }

    /****
     * 因为在启动一个新的activity的时候这个onpause方法是会先点用的之后
     * 才会执行 新的activity的生命周期方法 显示出来，因此onpause中不能作重量级的操作
     */
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

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")

    }
}