package com.android.practice.practice.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.CompletableObserver
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_room.*

class RoomActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        initToolbar()
        title = "Posts with Room"
        val adapter = PostsAdapter()
        posts_recyclerView.adapter = adapter

        val postsDatabase = PostsDatabase.getDatabase(this)

        insertButton.setOnClickListener {
            postsDatabase.postDao().insertPost(
                Post(
                    2,
                    editTextTitle.editableText.toString(),
                    editTextBody.editableText.toString()
                )
            )
                .subscribeOn(Schedulers.computation())
                .subscribe(object : CompletableObserver {
                    override fun onSubscribe(d: Disposable?) {
                        TODO("Not yet implemented")
                    }

                    override fun onComplete() {
                        TODO("Not yet implemented")
                    }

                    override fun onError(e: Throwable?) {
                        TODO("Not yet implemented")
                    }

                })
        }

        getButton.setOnClickListener {
            postsDatabase.postDao().getPosts()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<List<Post>> {
                    override fun onSubscribe(d: Disposable?) {
                        TODO("Not yet implemented")
                    }

                    override fun onSuccess(posts: List<Post>) {
                        adapter.setList(posts)
                        adapter.notifyDataSetChanged()
                    }

                    override fun onError(e: Throwable?) {
                        TODO("Not yet implemented")
                    }

                })
        }
    }
}