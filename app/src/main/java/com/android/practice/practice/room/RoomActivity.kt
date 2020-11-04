package com.android.practice.practice.room

import android.os.Bundle
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R
import io.reactivex.CompletableObserver
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_room.*

class RoomActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        initToolbar()
        title = "Posts with Room"
        val adapter = PostsAdapter()
        posts_recyclerView.adapter = adapter

        val postsDatabase = PostsDatabase.DatabaseBuilder.getDatabase(this)

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
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onComplete() {
                    }

                    override fun onError(e: Throwable) {
                    }

                })
        }

        getButton.setOnClickListener {
            postsDatabase.postDao().getPosts()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<List<Post>> {

                    override fun onSuccess(posts: List<Post>) {
                        adapter.setList(posts)
                        adapter.notifyDataSetChanged()
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onError(e: Throwable) {
                    }
                })
        }
    }
}